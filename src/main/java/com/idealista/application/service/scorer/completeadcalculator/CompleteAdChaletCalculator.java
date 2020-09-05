package com.idealista.application.service.scorer.completeadcalculator;

import com.idealista.application.model.Ad;
import com.idealista.application.model.Typology;
import org.springframework.stereotype.Component;

@Component
public class CompleteAdChaletCalculator extends CompleteAdCalculator {

    @Override
    public void register() {
        completeAdCalculatorFactory.register(Typology.CHALET, this);
    }

    @Override
    protected boolean isCompleted(Ad ad) {
        return hasDescription(ad.getDescription()) && hasAtLeastOnePicture(ad.getPictures())
                && hasHouseSize(ad.getHouseSize()) && hasGardenSize(ad.getGardenSize());
    }
}
