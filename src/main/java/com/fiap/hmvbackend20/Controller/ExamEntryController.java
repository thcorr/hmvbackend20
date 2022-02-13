package com.fiap.hmvbackend20.Controller;

import com.fiap.hmvbackend20.DTO.ExamEntryDTO;
import com.fiap.hmvbackend20.DTO.ExamTypeDTO;
import com.fiap.hmvbackend20.Entities.Drug;
import com.fiap.hmvbackend20.Entities.ExamEntry;
import com.fiap.hmvbackend20.Entities.ExamType;
import com.fiap.hmvbackend20.Entities.UserDetails;
import com.fiap.hmvbackend20.Service.ExamEntryService;
import com.fiap.hmvbackend20.Service.ExamTypeService;
import com.fiap.hmvbackend20.Service.UserDetailsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("/api/v1/examentry")
public class ExamEntryController {

    private ExamEntryService examEntryService;
    private UserDetailsService userDetailsService;
    private ExamTypeService examTypeService;

    public ExamEntryController(ExamEntryService examEntryService, UserDetailsService userDetailsService, ExamTypeService examTypeService){
        this.examEntryService = examEntryService;
        this.userDetailsService = userDetailsService;
        this.examTypeService = examTypeService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllExamEntries(@PageableDefault(page = 0, size = 10, sort = "examEntryId", direction = Sort.Direction.ASC) Pageable pageable){
        Page<ExamEntry> examEntryPage =  examEntryService.findAllExamEntries(pageable);
        if(examEntryPage.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No exam entries found.");
        }else{
            return ResponseEntity.status(HttpStatus.FOUND).body(examEntryPage);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getExamEntryById(@PathVariable(name = "id") Long examEntryId){
        Optional<ExamEntry> examEntryInDb = examEntryService.findExamEntryById(examEntryId);

        if(!examEntryInDb.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No exam entry found.");
        }else{
            return ResponseEntity.status(HttpStatus.FOUND).body(examEntryInDb.get());
        }
    }

    @PostMapping
    public ResponseEntity<Object> createExamEntry(@RequestBody ExamEntryDTO dto){

        try{
            Optional<UserDetails> userDetails = userDetailsService.findUserDetailsById(dto.getPatientId());
            Optional<ExamType> examType = examTypeService.findExamTypeById(dto.getExamTypeId());

            if(!userDetails.isPresent()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
            }

            if(!examType.isPresent()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exam type not found");
            }

            ExamEntry examEntry = dto.transform();
            examEntry.setPatient(userDetails.get());
            examEntry.setExamType(examType.get());

            ExamEntry newExamEntry = examEntryService.create(examEntry);
            return ResponseEntity.status(HttpStatus.CREATED).body(newExamEntry);

        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateExamEntryById(@PathVariable(name = "id") Long examEntryId,
                                                     @RequestBody ExamEntryDTO dto){
        try{
            Optional<ExamEntry> examEntryInDb = examEntryService.findExamEntryById(examEntryId);
            if(examEntryInDb.isPresent()){

                Optional<UserDetails> userDetails = userDetailsService.findUserDetailsById(dto.getPatientId());
                Optional<ExamType> examType = examTypeService.findExamTypeById(dto.getExamTypeId());

                if(!userDetails.isPresent()){
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
                }

                if(!examType.isPresent()){
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exam type not found");
                }

                ExamEntry newDetailsExamEntry = dto.transform();
                newDetailsExamEntry.setPatient(userDetails.get());
                newDetailsExamEntry.setExamType(examType.get());

                ExamEntry updatedExamEntry = examEntryService.update(examEntryId,newDetailsExamEntry );
                return ResponseEntity.status(HttpStatus.OK).body(updatedExamEntry);

            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exam entry not found");
            }

        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteExamEntryById(@PathVariable(name = "id") Long examEntryId){
        try{
            Optional<ExamEntry> examEntryInDb = examEntryService.findExamEntryById(examEntryId);
            if(examEntryInDb.isPresent()){
                examEntryService.deleteById(examEntryId);
                return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully: " + examEntryInDb.get().getExamEntryId());
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exam entry not found.");
            }

        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());
        }
    }

}
