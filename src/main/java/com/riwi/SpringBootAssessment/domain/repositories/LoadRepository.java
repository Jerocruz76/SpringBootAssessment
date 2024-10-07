package com.riwi.SpringBootAssessment.domain.repositories;

import com.riwi.SpringBootAssessment.domain.model.entities.LoadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoadRepository extends JpaRepository<LoadEntity, Long> {
}
