package com.idealista.application.service.scorer.completeAdCalculator;

import com.google.common.collect.ImmutableMap;
import com.idealista.application.model.Typology;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

import static com.idealista.application.model.Typology.*;

@Component
@RequiredArgsConstructor
public class CompleteAdCalculatorFactory {

    private final CompleteAdFlatCalculator completeAdFlatCalculator;
    private final CompleteAdChaletCalculator completeAdChaletCalculator;
    private final CompleteAdGarageCalculator completeAdGarageCalculator;
    private final CompleteAdDefaultCalculator completeAdDefaultCalculator;

    public CompleteAdCalculator getCalculator(Typology typology) {
        final Map<Typology, CompleteAdCalculator> SCORER_MAP
                = new ImmutableMap.Builder<Typology, CompleteAdCalculator>()
                .put(FLAT, completeAdFlatCalculator)
                .put(CHALET, completeAdChaletCalculator)
                .put(GARAGE, completeAdGarageCalculator)
                .build();

        return Optional.of(typology)
                .map(SCORER_MAP::get)
                .orElse(completeAdDefaultCalculator);
    }
}
