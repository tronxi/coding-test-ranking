package com.idealista.application.service.scorer.completeadcalculator;

import com.idealista.application.model.Typology;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class CompleteAdCalculatorFactory {

    private final Map<Typology, CompleteAdCalculator> completeAdCalculatorMapper = new HashMap<>();

    public CompleteAdCalculator getCalculator(Typology typology) {
        return Optional.of(typology)
                .map(completeAdCalculatorMapper::get)
                .orElse(completeAdCalculatorMapper.get(Typology.DEFAULT));
    }

    public void register(Typology typology, CompleteAdCalculator completeAdCalculator) {
        completeAdCalculatorMapper.put(typology, completeAdCalculator);
    }
}
