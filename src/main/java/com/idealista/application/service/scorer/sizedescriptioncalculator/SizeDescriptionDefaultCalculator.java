package com.idealista.application.service.scorer.sizedescriptioncalculator;

import com.idealista.application.model.Ad;
import com.idealista.application.model.Typology;
import org.springframework.stereotype.Component;

@Component
public class SizeDescriptionDefaultCalculator extends SizeDescriptionCalculator {

    @Override
    public void register() {
        sizeDescriptionCalculatorFactory.register(Typology.DEFAULT, this);
    }

    @Override
    public Integer calculate(Ad ad) {
        return 0;
    }
}
