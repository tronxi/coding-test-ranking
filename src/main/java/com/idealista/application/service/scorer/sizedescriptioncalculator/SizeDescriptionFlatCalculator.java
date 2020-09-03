package com.idealista.application.service.scorer.sizedescriptioncalculator;

import com.idealista.application.model.Ad;
import org.springframework.stereotype.Component;

@Component
public class SizeDescriptionFlatCalculator extends SizeDescriptionCalculator {

    private final Integer IN_LIMITS_SCORE = 10;
    private final Integer GREATER_THAN_MAX_SCORE = 30;
    private final Integer ZERO_SCORE = 0;

    @Override
    public Integer calculate(Ad ad) {
        if (descriptionLengthIsBetweenLimits(ad.getDescription())) {
            return IN_LIMITS_SCORE;
        } else if (descriptionLengthIsGreaterThanMaxLimit(ad.getDescription())) {
            return GREATER_THAN_MAX_SCORE;
        } else {
            return ZERO_SCORE;
        }
    }
}
