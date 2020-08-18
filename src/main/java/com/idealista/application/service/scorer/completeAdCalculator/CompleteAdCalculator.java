package com.idealista.application.service.scorer.completeAdCalculator;

import com.idealista.application.model.Ad;
import com.idealista.application.model.Picture;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public abstract class CompleteAdCalculator {

    private final Integer COMPLETE_SCORE = 40;
    private final Integer INCOMPLETE_SCORE = 0;

    public Integer calculate(Ad ad) {
        return isCompleted(ad) ? COMPLETE_SCORE : INCOMPLETE_SCORE;
    }

    protected abstract boolean isCompleted(Ad ad);

    protected boolean hasDescription(String description) {
        return StringUtils.isNotBlank(description);
    }

    protected boolean hasAtLeastOnePicture(List<Picture> pictureList) {
        return !pictureList.isEmpty();
    }

    protected boolean hasHouseSize(Integer houseSize) {
        return houseSize != null;
    }

    protected boolean hasGardenSize(Integer gardenSize) {
        return gardenSize != null;
    }
}