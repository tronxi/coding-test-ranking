package com.idealista.infrastructure.persistence.mapper;

import com.google.common.base.Enums;
import com.idealista.application.model.Ad;
import com.idealista.application.model.Score;
import com.idealista.application.model.Typology;
import com.idealista.infrastructure.persistence.entity.AdEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AdMapper {

    private final PictureMapper pictureMapper;

    public List<Ad> toDomain(List<AdEntity> adEntityList) {
        return adEntityList.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    private Ad toDomain(AdEntity adEntity) {
        return Ad.builder()
                .id(adEntity.getId())
                .description(adEntity.getDescription())
                .typology(mapTypology(adEntity.getTypology()))
                .pictures(pictureMapper.toDomain(adEntity.getPictures()))
                .houseSize(adEntity.getHouseSize())
                .gardenSize(adEntity.getGardenSize())
                .score(adEntity.getScore() == null ? new Score(0) : new Score(adEntity.getScore()))
                .irrelevantSince(adEntity.getIrrelevantSince())
                .build();
    }

    private Typology mapTypology(String typology) {
        return Enums.getIfPresent(Typology.class, typology).or(Typology.DEFAULT);
    }

    public AdEntity toEntity(Ad ad) {
        return AdEntity.builder()
                .id(ad.getId())
                .typology(ad.getTypology().name())
                .description(ad.getDescription())
                .pictures(pictureMapper.toEntity(ad.getPictures()))
                .houseSize(ad.getHouseSize())
                .gardenSize(ad.getGardenSize())
                .score(ad.getScore().getValue())
                .irrelevantSince(ad.getIrrelevantSince())
                .build();
    }
}
