package com.idealista.application.service.scorer;

import com.idealista.application.model.Ad;
import com.idealista.application.model.Typology;
import com.idealista.application.service.scorer.sizeDescriptionCalculator.SizeDescriptionCalculator;
import com.idealista.application.service.scorer.sizeDescriptionCalculator.SizeDescriptionCalculatorFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SizeDescriptionScorer implements Scorer {

    private final SizeDescriptionCalculatorFactory sizeDescriptionCalculatorFactory;

    @Override
    public Integer calculate(Ad ad) {
        return getCalculator(ad.getTypology()).calculate(ad);
    }

    private SizeDescriptionCalculator getCalculator(Typology typology) {
        return sizeDescriptionCalculatorFactory.getCalculator(typology);
    }
}
