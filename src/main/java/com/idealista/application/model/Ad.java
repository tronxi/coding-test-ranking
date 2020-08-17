package com.idealista.application.model;

import lombok.Builder;
import lombok.Value;

import java.util.Date;
import java.util.List;

@Value
@Builder(toBuilder = true)
public class Ad {
    Integer id;
    Typology typology;
    String description;
    List<Picture> pictures;
    Integer houseSize;
    Integer gardenSize;
    Score score;
    Date irrelevantSince;

    public boolean isIrrelevant() {
        return this.score.isIrrelevant();
    }
}
