package com.idealista.util;

import com.idealista.application.model.Ad;
import com.idealista.application.model.Picture;
import com.idealista.application.model.Score;
import com.idealista.application.model.Typology;
import com.idealista.infrastructure.api.model.PublicAd;
import com.idealista.infrastructure.api.model.QualityAd;
import com.idealista.infrastructure.persistence.entity.AdEntity;
import com.idealista.infrastructure.persistence.entity.PictureEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestUtil {

    private final static Integer ID = 1;
    private final static Integer SCORE = 0;
    private final static String URL = "url";
    private final static Integer GARDEN_SIZE = 100;
    private final static Integer HOUSE_SIZE = 100;
    private final static String HD_QUALITY = "HD";
    private final static String DESCRIPTION = "description";

    public static PublicAd getPublicAdWithTypology(String typology) {
        return PublicAd.builder()
                .id(ID)
                .typology(typology)
                .pictureUrls(Collections.emptyList())
                .build();

    }

    public static QualityAd getQualityAdWithTypology(String typology) {
        return QualityAd.builder()
                .id(ID)
                .score(SCORE)
                .typology(typology)
                .pictureUrls(Collections.emptyList())
                .build();

    }

    public static Ad getAdWithTypology(Typology typology) {
        return Ad.builder()
                .id(ID)
                .score(new Score(SCORE))
                .typology(typology)
                .pictures(Collections.emptyList())
                .build();
    }

    public static Ad getAdWithDescription(String description) {
        return Ad.builder()
                .score(new Score(SCORE))
                .description(description)
                .pictures(Collections.emptyList())
                .build();
    }

    public static Ad getEmptyAd() {
        return Ad.builder()
                .score(new Score(SCORE))
                .pictures(Collections.emptyList())
                .build();
    }

    public static Ad getAdWithPictures(List<Picture> pictureList) {
        return Ad.builder()
                .score(new Score(SCORE))
                .pictures(pictureList)
                .build();
    }

    public static Picture getPicture(String quality) {
        return Picture.builder()
                .quality(quality)
                .build();
    }

    public static Ad getCompleteChaletAd() {
        return Ad.builder()
                .description(DESCRIPTION)
                .score(new Score(SCORE))
                .pictures(Arrays.asList(getPicture(HD_QUALITY)))
                .houseSize(HOUSE_SIZE)
                .gardenSize(GARDEN_SIZE)
                .build();
    }

    public static Ad getCompleteFlatAd() {
        return Ad.builder()
                .description(DESCRIPTION)
                .score(new Score(SCORE))
                .pictures(Arrays.asList(getPicture(HD_QUALITY)))
                .houseSize(HOUSE_SIZE)
                .build();
    }

    public static Ad getCompleteGarageAd() {
        return Ad.builder()
                .score(new Score(SCORE))
                .pictures(Arrays.asList(getPicture(HD_QUALITY)))
                .build();
    }

    public static Ad getAdWithScore(Integer score) {
        return Ad.builder()
                .score(new Score(score))
                .pictures(Collections.emptyList())
                .build();
    }

    public static AdEntity getAdEntity() {
        return AdEntity.builder()
                .id(ID)
                .score(SCORE)
                .pictures(Collections.emptyList())
                .build();
    }

    public static AdEntity getAdEntityWithTypology(String typology) {
        return AdEntity.builder()
                .id(ID)
                .score(SCORE)
                .typology(typology)
                .pictures(Collections.emptyList())
                .build();
    }

    public static PictureEntity getPictureEntity() {
        return PictureEntity.builder()
                .id(ID)
                .quality(HD_QUALITY)
                .url(URL)
                .build();
    }

    public static Picture getPicture() {
        return Picture.builder()
                .id(ID)
                .quality(HD_QUALITY)
                .url(URL)
                .build();
    }
}
