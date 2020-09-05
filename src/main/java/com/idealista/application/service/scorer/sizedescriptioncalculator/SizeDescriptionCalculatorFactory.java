package com.idealista.application.service.scorer.sizedescriptioncalculator;

import com.idealista.application.model.Typology;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class SizeDescriptionCalculatorFactory {

    private final Map<Typology, SizeDescriptionCalculator> sizeDescriptionCalculatorMapper = new HashMap<>();

    public SizeDescriptionCalculator getCalculator(Typology typology) {
        return Optional.of(typology)
                .map(sizeDescriptionCalculatorMapper::get)
                .orElse(sizeDescriptionCalculatorMapper.get(Typology.DEFAULT));
    }

    public void register (Typology typology, SizeDescriptionCalculator sizeDescriptionCalculator) {
        sizeDescriptionCalculatorMapper.put(typology, sizeDescriptionCalculator);
    }
}
