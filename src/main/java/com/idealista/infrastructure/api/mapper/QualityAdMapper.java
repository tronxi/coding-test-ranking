package com.idealista.infrastructure.api.mapper;

import com.idealista.application.model.Ad;
import com.idealista.application.model.Picture;
import com.idealista.application.model.Score;
import com.idealista.infrastructure.api.model.QualityAd;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QualityAdMapper {

    public List<QualityAd> toQuality(List<Ad> adList) {
        return adList.stream()
                .map(this::toQuality)
                .collect(Collectors.toList());
    }

    private QualityAd toQuality(Ad ad) {
        return QualityAd.builder()
                .id(ad.getId())
                .typology(ad.getTypology().name())
                .description(ad.getDescription())
                .pictureUrls(mapPictureUrls(ad.getPictures()))
                .houseSize(ad.getHouseSize())
                .gardenSize(ad.getGardenSize())
                .score(ad.getScore().getValue())
                .irrelevantSince(ad.getIrrelevantSince())
                .build();
    }

    private List<String> mapPictureUrls(List<Picture> pictureList) {
        return pictureList.stream()
                .map(Picture::getUrl)
                .collect(Collectors.toList());
    }
}
