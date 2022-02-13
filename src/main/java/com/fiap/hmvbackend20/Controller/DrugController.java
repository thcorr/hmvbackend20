package com.fiap.hmvbackend20.Controller;

import com.fiap.hmvbackend20.DTO.DrugDTO;
import com.fiap.hmvbackend20.Entities.Drug;
import com.fiap.hmvbackend20.Service.DrugService;
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
@RequestMapping("/api/v1/drug")
public class DrugController {

    private DrugService drugService;

    public DrugController(DrugService drugService){
        this.drugService = drugService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllDrugs(@PageableDefault(page = 0, size = 10, sort = "drugId", direction = Sort.Direction.ASC) Pageable pageable){
        Page<Drug> drugPage =  drugService.findAllDrugs(pageable);
        if(drugPage.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No drugs found.");
        }else{
            return ResponseEntity.status(HttpStatus.FOUND).body(drugPage);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getDrugById(@PathVariable(name = "id") Long drugId){
        Optional<Drug> drugInDb = drugService.findDrugById(drugId);

        if(!drugInDb.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No drugs found.");
        }else{
            return ResponseEntity.status(HttpStatus.FOUND).body(drugInDb.get());
        }
    }

    @PostMapping
    public ResponseEntity<Object> createDrug(@RequestBody DrugDTO dto){

        try{
            Drug newDrug = drugService.create(dto.transform());
            return ResponseEntity.status(HttpStatus.CREATED).body(newDrug);

        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDrugById(@PathVariable(name = "id") Long drugId,
                                                 @RequestBody DrugDTO dto){
        try{
            Optional<Drug> drugInDb = drugService.findDrugById(drugId);
            if(drugInDb.isPresent()){
                Drug updatedDrug = drugService.update(drugId, dto.transform());
                return ResponseEntity.status(HttpStatus.OK).body(updatedDrug);

            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Drug not found");
            }

        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteDrugById(@PathVariable(name = "id") Long drugId){
        try{
            Optional<Drug> drugInDb = drugService.findDrugById(drugId);
            if(drugInDb.isPresent()){
                drugService.deleteById(drugId);
                return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully: " + drugInDb.get().getDrugName());
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Drug not found.");
            }

        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());
        }
    }

}
