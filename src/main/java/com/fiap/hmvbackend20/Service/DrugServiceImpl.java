package com.fiap.hmvbackend20.Service;

import com.fiap.hmvbackend20.Entities.Drug;
import com.fiap.hmvbackend20.Repositories.DrugRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DrugServiceImpl implements DrugService{

    private DrugRepository drugRepository;

    public DrugServiceImpl(DrugRepository drugRepository){
        this.drugRepository = drugRepository;
    }

    @Override
    public Page<Drug> findAllDrugs(Pageable pageable) {
        return drugRepository.findAll(pageable);
    }

    @Override
    public Optional<Drug> findDrugById(Long drugId) {
        return drugRepository.findById(drugId);
    }

    @Override
    public Drug create(Drug newDrug) {
        return drugRepository.save(newDrug);
    }

    @Override
    public Drug update(Long drugId, Drug newDrugDetails) {

        Drug drugInDb = drugRepository.findById(drugId).get();
        drugInDb.setDrugName(newDrugDetails.getDrugName());
        return drugRepository.save(drugInDb);
    }

    @Override
    public void deleteById(Long drugId) {
        drugRepository.deleteById(drugId);
    }
}
