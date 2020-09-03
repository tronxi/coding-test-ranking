package com.idealista.application.service.scorer.completeadcalculator;

import com.idealista.application.model.Ad;
import org.springframework.stereotype.Component;

@Component
public class CompleteAdDefaultCalculator extends CompleteAdCalculator {

    @Override
    protected boolean isCompleted(Ad ad) {
        return false;
    }
}
