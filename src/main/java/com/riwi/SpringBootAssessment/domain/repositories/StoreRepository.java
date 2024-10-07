package com.riwi.SpringBootAssessment.domain.repositories;

import com.riwi.SpringBootAssessment.domain.model.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
