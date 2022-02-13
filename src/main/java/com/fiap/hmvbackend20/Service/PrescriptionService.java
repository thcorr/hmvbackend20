package com.fiap.hmvbackend20.Service;

import com.fiap.hmvbackend20.Entities.ExamEntry;
import com.fiap.hmvbackend20.Entities.Prescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PrescriptionService {

    Page<Prescription> findAllPrescriptions(Pageable pageable);
    Optional<Prescription> findPrescriptionById(Long prescriptionId);
    Prescription create(Prescription prescriptionId);
    Prescription update(Long prescriptionId, Prescription newDetailsPrescription);
    void deleteById(Long prescriptionId);

}
