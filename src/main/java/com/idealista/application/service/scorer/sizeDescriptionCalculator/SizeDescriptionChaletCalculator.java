package com.idealista.application.service.scorer.sizeDescriptionCalculator;

import com.idealista.application.model.Ad;
import org.springframework.stereotype.Component;

import static com.idealista.application.service.scorer.sizeDescriptionCalculator.SizeDescriptionCalculator.SIZE_DESCRIPTION_NAME;

@Component(SIZE_DESCRIPTION_NAME + "CHALET")
public class SizeDescriptionChaletCalculator extends SizeDescriptionCalculator {

    private final Integer GREATER_THAN_MAX_SCORE = 20;
    private final Integer ZERO_SCORE = 0;

    @Override
    public Integer calculate(Ad ad) {
        if (descriptionLengthIsGreaterThanMaxLimit(ad.getDescription())) {
            return GREATER_THAN_MAX_SCORE;
        } else {
            return ZERO_SCORE;
        }
    }

}
