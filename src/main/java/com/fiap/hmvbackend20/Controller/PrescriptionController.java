package com.fiap.hmvbackend20.Controller;

import com.fiap.hmvbackend20.DTO.ExamEntryDTO;
import com.fiap.hmvbackend20.DTO.PrescriptionDTO;
import com.fiap.hmvbackend20.Entities.*;
import com.fiap.hmvbackend20.Service.DrugService;
import com.fiap.hmvbackend20.Service.PrescriptionService;
import com.fiap.hmvbackend20.Service.UserDetailsService;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.User;
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
@RequestMapping("/api/v1/prescription")
public class PrescriptionController {

    private PrescriptionService prescriptionService;
    private UserDetailsService userDetailsService;
    private DrugService drugService;

    public PrescriptionController (PrescriptionService prescriptionService, UserDetailsService userDetailsService, DrugService drugService){
        this.prescriptionService = prescriptionService;
        this.userDetailsService = userDetailsService;
        this.drugService = drugService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllPrescriptionEntries(@PageableDefault(page = 0, size = 10, sort = "prescriptionId", direction = Sort.Direction.ASC) Pageable pageable){
        Page<Prescription> prescriptionPage =  prescriptionService.findAllPrescriptions(pageable);
        if(prescriptionPage.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No prescriptions found.");
        }else{
            return ResponseEntity.status(HttpStatus.FOUND).body(prescriptionPage);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getPrescriptionById(@PathVariable(name = "id") Long prescriptionId){
        Optional<Prescription> prescriptionInDb = prescriptionService.findPrescriptionById(prescriptionId);

        if(!prescriptionInDb.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No prescriptions found.");
        }else{
            return ResponseEntity.status(HttpStatus.FOUND).body(prescriptionInDb.get());
        }
    }

    @PostMapping
    public ResponseEntity<Object> createPrescription(@RequestBody PrescriptionDTO dto){

        try{
            Optional<UserDetails> userDetails = userDetailsService.findUserDetailsById(dto.getPatientId());
            Optional<Drug> drug = drugService.findDrugById(dto.getDrugId());

            if(!userDetails.isPresent()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
            }

            if(!drug.isPresent()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Drug not found");
            }

            Prescription newPrescriptionDetails = dto.transform();
            newPrescriptionDetails.setPatient(userDetails.get());
            newPrescriptionDetails.setDrug(drug.get());

            Prescription newPrescription = prescriptionService.create(newPrescriptionDetails);
            return ResponseEntity.status(HttpStatus.CREATED).body(newPrescription);

        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePrescription(@PathVariable(name = "id") Long prescriptionId,
                                                      @RequestBody PrescriptionDTO dto){
        try{
            Optional<Prescription> prescriptionInDb = prescriptionService.findPrescriptionById(prescriptionId);
            if(prescriptionInDb.isPresent()){

                Optional<UserDetails> userDetails = userDetailsService.findUserDetailsById(dto.getPatientId());
                Optional<Drug> drug = drugService.findDrugById(dto.getDrugId());

                if(!userDetails.isPresent()){
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
                }

                if(!drug.isPresent()){
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Drug not found");
                }

                Prescription newDetailsPrescription = dto.transform();
                newDetailsPrescription.setPatient(userDetails.get());
                newDetailsPrescription.setDrug(drug.get());

                Prescription updatedPrescription = prescriptionService.update(prescriptionId,newDetailsPrescription );
                return ResponseEntity.status(HttpStatus.OK).body(updatedPrescription);

            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prescription not found");
            }

        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deletePrescriptionById(@PathVariable(name = "id") Long prescriptionId){
        try{
            Optional<Prescription> prescriptionInDb = prescriptionService.findPrescriptionById(prescriptionId);
            if(prescriptionInDb.isPresent()){
                prescriptionService.deleteById(prescriptionId);
                return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully: " + prescriptionInDb.get().getPrescriptionId());
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prescription not found.");
            }

        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());
        }
    }
}
