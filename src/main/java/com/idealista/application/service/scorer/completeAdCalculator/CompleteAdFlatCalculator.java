package com.idealista.application.service.scorer.completeAdCalculator;

import com.idealista.application.model.Ad;
import org.springframework.stereotype.Component;

@Component("COMPLETE_AD_FLAT")
public class CompleteAdFlatCalculator extends CompleteAdCalculator {

    @Override
    protected boolean isCompleted(Ad ad) {
        return hasDescription(ad.getDescription()) && hasAtLeastOnePicture(ad.getPictures())
                && hasHouseSize(ad.getHouseSize());
    }
}
