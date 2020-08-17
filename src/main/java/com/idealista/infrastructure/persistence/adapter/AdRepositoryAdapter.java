package com.idealista.infrastructure.persistence.adapter;

import com.idealista.application.model.Ad;
import com.idealista.application.port.secondary.AdRepository;
import com.idealista.infrastructure.persistence.entity.AdEntity;
import com.idealista.infrastructure.persistence.mapper.AdMapper;
import com.idealista.infrastructure.persistence.repository.AdRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AdRepositoryAdapter implements AdRepository {

    private final AdRepositoryJPA adRepositoryJPA;
    private final AdMapper adMapper;

    @Override
    public List<Ad> findAll() {
        List<AdEntity> adEntityList = adRepositoryJPA.findAll();
        return adMapper.toDomain(adEntityList);
    }

    @Override
    public List<Ad> findByScoreIsGreaterThanEqualOrderByScoreDesc(Integer irrelevantScore) {
        List<AdEntity> adEntityList = adRepositoryJPA.findByScoreIsGreaterThanEqualOrderByScoreDesc(irrelevantScore);
        return adMapper.toDomain(adEntityList);
    }

    @Override
    public List<Ad> findByScoreIsLessThan(Integer irrelevantScore) {
        List<AdEntity> adEntityList = adRepositoryJPA.findByScoreIsLessThan(irrelevantScore);
        return adMapper.toDomain(adEntityList);
    }

    @Override
    public void update(Ad ad) {
        adRepositoryJPA.save(adMapper.toEntity(ad));
    }

}
