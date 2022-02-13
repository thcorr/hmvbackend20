package com.fiap.hmvbackend20.Service;

import com.fiap.hmvbackend20.Entities.Drug;
import com.fiap.hmvbackend20.Entities.ExamEntry;
import com.fiap.hmvbackend20.Repositories.ExamEntryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExamEntryServiceImpl implements ExamEntryService {

    private ExamEntryRepository examEntryRepository;

    public ExamEntryServiceImpl(ExamEntryRepository examEntryRepository){
        this.examEntryRepository = examEntryRepository;
    }

    @Override
    public Page<ExamEntry> findAllExamEntries(Pageable pageable) {
        return examEntryRepository.findAll(pageable);
    }

    @Override
    public Optional<ExamEntry> findExamEntryById(Long examEntryId) {
        return examEntryRepository.findById(examEntryId);
    }

    @Override
    public ExamEntry create(ExamEntry examEntry) {
        return examEntryRepository.save(examEntry);
    }

    @Override
    public ExamEntry update(Long examEntryId, ExamEntry newDetailsExamEntry) {
        ExamEntry examEntryInDb = examEntryRepository.findById(examEntryId).get();
        examEntryInDb.setExamType(newDetailsExamEntry.getExamType());
        examEntryInDb.setPatient(newDetailsExamEntry.getPatient());
        examEntryInDb.setExamDateTime(newDetailsExamEntry.getExamDateTime());
        examEntryInDb.setExamResult(newDetailsExamEntry.getExamResult());
        return examEntryRepository.save(examEntryInDb);
    }

    @Override
    public void deleteById(Long examEntryId) {
        examEntryRepository.deleteById(examEntryId);
    }


}
