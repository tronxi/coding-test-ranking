package com.idealista.infrastructure.persistence.repository;

import com.idealista.infrastructure.persistence.entity.TopWordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopWordRepositoryJPA extends JpaRepository<TopWordEntity, Integer> {
}
