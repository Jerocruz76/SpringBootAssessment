package com.riwi.SpringBootAssessment.domain.repositories;

import com.riwi.SpringBootAssessment.domain.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    public Optional<UserEntity> findByEmail(String email);
}
