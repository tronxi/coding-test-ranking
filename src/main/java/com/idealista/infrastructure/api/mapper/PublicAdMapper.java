package com.idealista.infrastructure.api.mapper;

import com.idealista.application.model.Ad;
import com.idealista.application.model.Picture;
import com.idealista.infrastructure.api.model.PublicAd;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PublicAdMapper {
    public List<PublicAd> toPublicAd(List<Ad> adList) {
        return adList.stream()
                .map(this::toPublicAd)
                .collect(Collectors.toList());
    }

    private PublicAd toPublicAd(Ad ad) {
        return PublicAd.builder()
                .id(ad.getId())
                .typology(ad.getTypology().name())
                .description(ad.getDescription())
                .pictureUrls(mapPictureUrls(ad.getPictures()))
                .houseSize(ad.getHouseSize())
                .gardenSize(ad.getGardenSize())
                .build();
    }

    private List<String> mapPictureUrls(List<Picture> pictureList) {
        return pictureList.stream()
                .map(Picture::getUrl)
                .collect(Collectors.toList());
    }
}
