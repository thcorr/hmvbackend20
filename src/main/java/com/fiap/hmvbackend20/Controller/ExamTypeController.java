package com.fiap.hmvbackend20.Controller;

import com.fiap.hmvbackend20.DTO.ExamTypeDTO;
import com.fiap.hmvbackend20.Entities.ExamType;
import com.fiap.hmvbackend20.Service.ExamTypeService;
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
@RequestMapping("/api/v1/examtype")
public class ExamTypeController {

    private ExamTypeService examTypeService;

    public ExamTypeController(ExamTypeService examTypeService){
        this.examTypeService = examTypeService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllExamTypes(@PageableDefault(page = 0, size = 10, sort = "examTypeId", direction = Sort.Direction.ASC) Pageable pageable){
        Page<ExamType> examTypePage =  examTypeService.findAllExamTypes(pageable);
        if(examTypePage.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No exam types found.");
        }else{
            return ResponseEntity.status(HttpStatus.FOUND).body(examTypePage);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getExamTypeById(@PathVariable(name = "id") Long examTypeId){
        Optional<ExamType> examTypeInDb = examTypeService.findExamTypeById(examTypeId);

        if(!examTypeInDb.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No exam types found.");
        }else{
            return ResponseEntity.status(HttpStatus.FOUND).body(examTypeInDb.get());
        }
    }

    @PostMapping
    public ResponseEntity<Object> createExamType(@RequestBody ExamTypeDTO dto){

        try{
            ExamType newExamType = examTypeService.create(dto.transform());
            return ResponseEntity.status(HttpStatus.CREATED).body(newExamType);

        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateExamTypeById(@PathVariable(name = "id") Long examTypeId,
                                                 @RequestBody ExamTypeDTO dto){
        try{
            Optional<ExamType> examTypeInDb = examTypeService.findExamTypeById(examTypeId);
            if(examTypeInDb.isPresent()){
                ExamType updatedExamType = examTypeService.update(examTypeId, dto.transform());
                return ResponseEntity.status(HttpStatus.OK).body(updatedExamType);

            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exam type not found");
            }

        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteExamTypeById(@PathVariable(name = "id") Long examTypeId){
        try{
            Optional<ExamType> examTypeInDb = examTypeService.findExamTypeById(examTypeId);
            if(examTypeInDb.isPresent()){
                examTypeService.deleteById(examTypeId);
                return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully: " + examTypeInDb.get().getExamName());
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exam type not found.");
            }

        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());
        }
    }

}
