package com.riwi.SpringBootAssessment.domain.repositories;

import com.riwi.SpringBootAssessment.domain.model.entities.PalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PalletRepository extends JpaRepository<PalletEntity, Long> {

}
