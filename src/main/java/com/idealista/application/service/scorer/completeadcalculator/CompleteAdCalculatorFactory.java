package com.idealista.application.service.scorer.completeadcalculator;

import com.idealista.application.model.Typology;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class CompleteAdCalculatorFactory {

    private final Map<Typology, CompleteAdCalculator> completeAdBeanNames;

    public CompleteAdCalculator getCalculator(Typology typology) {
        return completeAdBeanNames.get(typology);
    }
}
