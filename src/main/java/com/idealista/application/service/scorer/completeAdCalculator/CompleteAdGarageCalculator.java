package com.idealista.application.service.scorer.completeAdCalculator;

import com.idealista.application.model.Ad;
import org.springframework.stereotype.Component;

@Component
public class CompleteAdGarageCalculator extends CompleteAdCalculator {

    @Override
    protected boolean isCompleted(Ad ad) {
        return hasAtLeastOnePicture(ad.getPictures());
    }
}
