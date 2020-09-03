package com.idealista.application.service.scorer;

import com.idealista.application.model.Ad;
import com.idealista.application.model.Typology;
import com.idealista.application.service.scorer.completeadcalculator.CompleteAdCalculator;
import com.idealista.application.service.scorer.completeadcalculator.CompleteAdCalculatorFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompleteAdScorer implements Scorer {

    private final CompleteAdCalculatorFactory completeAdCalculatorFactory;

    @Override
    public Integer calculate(Ad ad) {
        return getCalculator(ad.getTypology()).calculate(ad);
    }

    private CompleteAdCalculator getCalculator(Typology typology) {
        return completeAdCalculatorFactory.getCalculator(typology);
    }
}
