package com.idealista.application.service.scorer.sizeDescriptionCalculator;

import com.idealista.application.model.Ad;
import org.springframework.stereotype.Component;

import static com.idealista.application.service.scorer.sizeDescriptionCalculator.SizeDescriptionCalculator.SIZE_DESCRIPTION_NAME;

@Component(SIZE_DESCRIPTION_NAME + "DEFAULT")
public class SizeDescriptionDefaultCalculator extends SizeDescriptionCalculator {
    @Override
    public Integer calculate(Ad ad) {
        return 0;
    }
}
