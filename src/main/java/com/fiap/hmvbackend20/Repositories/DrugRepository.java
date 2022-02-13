package com.fiap.hmvbackend20.Repositories;

import com.fiap.hmvbackend20.Entities.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Long> {
}
