package com.fiap.hmvbackend20.Service;

import com.fiap.hmvbackend20.Entities.ExamEntry;
import com.fiap.hmvbackend20.Entities.Prescription;
import com.fiap.hmvbackend20.Repositories.PrescriptionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrescriptionServiceImpl implements PrescriptionService{

    PrescriptionRepository prescriptionRepository;

    public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository){
        this.prescriptionRepository = prescriptionRepository;
    }


    @Override
    public Page<Prescription> findAllPrescriptions(Pageable pageable) {
        return prescriptionRepository.findAll(pageable);
    }

    @Override
    public Optional<Prescription> findPrescriptionById(Long prescriptionId) {
        return prescriptionRepository.findById(prescriptionId);
    }

    @Override
    public Prescription create(Prescription prescriptionId) {
        return prescriptionRepository.save(prescriptionId);
    }

    @Override
    public Prescription update(Long prescriptionId, Prescription newDetailsPrescription) {
        Prescription prescriptionInDb = prescriptionRepository.findById(prescriptionId).get();
        prescriptionInDb.setPrescription(newDetailsPrescription.getPrescription());
        prescriptionInDb.setPatient(newDetailsPrescription.getPatient());
        prescriptionInDb.setPrescriptionDate(newDetailsPrescription.getPrescriptionDate());
        prescriptionInDb.setDrug(newDetailsPrescription.getDrug());
        return prescriptionRepository.save(prescriptionInDb);
    }

    @Override
    public void deleteById(Long prescriptionId) {

        prescriptionRepository.deleteById(prescriptionId);

    }
}
