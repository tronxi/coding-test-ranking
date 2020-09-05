package com.idealista.application.service.scorer.completeadcalculator;

import com.idealista.application.model.Ad;
import com.idealista.application.model.Typology;
import org.springframework.stereotype.Component;

@Component
public class CompleteAdGarageCalculator extends CompleteAdCalculator {

    @Override
    public void register() {
        completeAdCalculatorFactory.register(Typology.GARAGE, this);
    }

    @Override
    protected boolean isCompleted(Ad ad) {
        return hasAtLeastOnePicture(ad.getPictures());
    }
}
