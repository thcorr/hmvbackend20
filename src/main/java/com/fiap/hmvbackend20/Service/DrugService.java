package com.fiap.hmvbackend20.Service;

import com.fiap.hmvbackend20.Entities.Drug;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DrugService {
    Page<Drug> findAllDrugs(Pageable pageable);
    Optional<Drug> findDrugById(Long drugId);
    Drug create(Drug newDrug);
    Drug update(Long drugId, Drug newDrugDetails);
    void deleteById(Long drugId);
}
