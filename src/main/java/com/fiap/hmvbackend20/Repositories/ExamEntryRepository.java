package com.fiap.hmvbackend20.Repositories;

import com.fiap.hmvbackend20.Entities.ExamEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamEntryRepository extends JpaRepository<ExamEntry, Long> {
}
