package com.fiap.hmvbackend20.DTO;

import com.fiap.hmvbackend20.Entities.Prescription;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PrescriptionDTO {
    String prescription;
    LocalDate prescriptionDate;
    Long patientId;
    Long drugId;

    public Prescription transform(){
        return new Prescription(prescription, prescriptionDate);
    }

}
