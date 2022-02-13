package com.fiap.hmvbackend20.Service;

import com.fiap.hmvbackend20.Entities.Drug;
import com.fiap.hmvbackend20.Entities.ExamType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ExamTypeService {
    Page<ExamType> findAllExamTypes(Pageable pageable);
    Optional<ExamType> findExamTypeById(Long examTypeId);
    ExamType create(ExamType newExamType);
    ExamType update(Long examTypeId, ExamType newExamTypeDetails);
    void deleteById(Long examTypeId);

}
