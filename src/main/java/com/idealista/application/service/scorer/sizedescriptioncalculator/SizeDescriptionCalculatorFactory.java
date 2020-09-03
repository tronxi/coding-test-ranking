package com.idealista.application.service.scorer.sizedescriptioncalculator;

import com.idealista.application.model.Typology;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class SizeDescriptionCalculatorFactory {

    private final Map<Typology, SizeDescriptionCalculator> sizeDescriptionBeans;

    public SizeDescriptionCalculator getCalculator(Typology typology) {
        return sizeDescriptionBeans.get(typology);
    }
}
