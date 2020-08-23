package com.idealista.application.service.scorer.completeAdCalculator;

import com.idealista.application.model.Ad;
import org.springframework.stereotype.Component;

import static com.idealista.application.service.scorer.completeAdCalculator.CompleteAdCalculator.COMPLETE_AD_NAME;

@Component(COMPLETE_AD_NAME  + "DEFAULT")
public class CompleteAdDefaultCalculator extends CompleteAdCalculator {

    @Override
    protected boolean isCompleted(Ad ad) {
        return false;
    }
}
