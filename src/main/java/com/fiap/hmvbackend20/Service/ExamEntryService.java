package com.fiap.hmvbackend20.Service;

import com.fiap.hmvbackend20.Entities.ExamEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ExamEntryService {
    Page<ExamEntry> findAllExamEntries(Pageable pageable);
    Optional<ExamEntry> findExamEntryById(Long examEntryId);
    ExamEntry create(ExamEntry examEntry);
    ExamEntry update(Long examEntryId, ExamEntry newDetailsExamEntry);
    void deleteById(Long examEntryId);
}
