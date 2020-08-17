package com.idealista.infrastructure.persistence.repository;

import com.idealista.infrastructure.persistence.entity.AdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdRepositoryJPA extends JpaRepository<AdEntity, Integer> {
    List<AdEntity> findByScoreIsLessThan(Integer irrelevantScore);
    List<AdEntity> findByScoreIsGreaterThanEqualOrderByScoreDesc(Integer irrelevantScore);
}
