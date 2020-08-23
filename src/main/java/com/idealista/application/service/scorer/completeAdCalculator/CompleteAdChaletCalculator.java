package com.idealista.application.service.scorer.completeAdCalculator;

import com.idealista.application.model.Ad;
import org.springframework.stereotype.Component;

import static com.idealista.application.service.scorer.completeAdCalculator.CompleteAdCalculator.COMPLETE_AD_NAME;

@Component(COMPLETE_AD_NAME  + "CHALET")
public class CompleteAdChaletCalculator extends CompleteAdCalculator {

    @Override
    protected boolean isCompleted(Ad ad) {
        return hasDescription(ad.getDescription()) && hasAtLeastOnePicture(ad.getPictures())
                && hasHouseSize(ad.getHouseSize()) && hasGardenSize(ad.getGardenSize());
    }
}
