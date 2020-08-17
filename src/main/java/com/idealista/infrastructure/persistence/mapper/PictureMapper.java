package com.idealista.infrastructure.persistence.mapper;

import com.idealista.application.model.Picture;
import com.idealista.infrastructure.persistence.entity.PictureEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PictureMapper {

    public List<Picture> toDomain(List<PictureEntity> pictureEntityList) {
        return pictureEntityList.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public List<PictureEntity> toEntity(List<Picture> pictureList) {
        return pictureList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    private PictureEntity toEntity(Picture picture) {
        return PictureEntity.builder()
                .id(picture.getId())
                .url(picture.getUrl())
                .quality(picture.getQuality())
                .build();
    }

    private Picture toDomain(PictureEntity pictureEntity) {
        return Picture.builder()
                .id(pictureEntity.getId())
                .quality(pictureEntity.getQuality())
                .url(pictureEntity.getUrl())
                .build();
    }
}
