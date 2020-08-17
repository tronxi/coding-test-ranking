package com.idealista.application.service.scorer.sizeDescriptionCalculator;

import com.idealista.application.model.Ad;
import org.springframework.stereotype.Component;

@Component
public class SizeDescriptionDefaultCalculator extends SizeDescriptionCalculator {
    @Override
    public Integer calculate(Ad ad) {
        return 0;
    }
}
