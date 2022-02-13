package com.fiap.hmvbackend20.Service;

import com.fiap.hmvbackend20.Entities.Drug;
import com.fiap.hmvbackend20.Entities.ExamType;
import com.fiap.hmvbackend20.Repositories.ExamTypeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExamTypeServiceImpl implements ExamTypeService{

    private ExamTypeRepository examTypeRepository;

    public ExamTypeServiceImpl(ExamTypeRepository examTypeRepository){
        this.examTypeRepository = examTypeRepository;
    }


    @Override
    public Page<ExamType> findAllExamTypes(Pageable pageable) {
        return examTypeRepository.findAll(pageable);
    }

    @Override
    public Optional<ExamType> findExamTypeById(Long examTypeId) {
        return examTypeRepository.findById(examTypeId);
    }

    @Override
    public ExamType create(ExamType newExamType) {
        return examTypeRepository.save(newExamType);
    }

    @Override
    public ExamType update(Long examTypeId, ExamType newExamTypeDetails) {
        ExamType examTypeInDb = examTypeRepository.findById(examTypeId).get();
        examTypeInDb.setExamName(newExamTypeDetails.getExamName());
        return examTypeRepository.save(examTypeInDb);
    }

    @Override
    public void deleteById(Long examTypeId) {
        examTypeRepository.deleteById(examTypeId);
    }
}
