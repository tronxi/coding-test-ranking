package com.idealista.application.service.scorer.completeAdCalculator;

import com.idealista.application.model.Ad;
import org.springframework.stereotype.Component;

import static com.idealista.application.service.scorer.completeAdCalculator.CompleteAdCalculator.COMPLETE_AD_NAME;

@Component(COMPLETE_AD_NAME  + "FLAT")
public class CompleteAdFlatCalculator extends CompleteAdCalculator {

    @Override
    protected boolean isCompleted(Ad ad) {
        return hasDescription(ad.getDescription()) && hasAtLeastOnePicture(ad.getPictures())
                && hasHouseSize(ad.getHouseSize());
    }
}
