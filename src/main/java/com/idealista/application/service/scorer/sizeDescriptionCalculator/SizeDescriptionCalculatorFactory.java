package com.idealista.application.service.scorer.sizeDescriptionCalculator;

import com.google.common.collect.ImmutableMap;
import com.idealista.application.model.Typology;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

import static com.idealista.application.model.Typology.CHALET;
import static com.idealista.application.model.Typology.FLAT;

@Component
@RequiredArgsConstructor
public class SizeDescriptionCalculatorFactory {

    private final SizeDescriptionFlatCalculator sizeDescriptionFlatCalculator;
    private final SizeDescriptionChaletCalculator sizeDescriptionChaletCalculator;
    private final SizeDescriptionDefaultCalculator sizeDescriptionDefaultCalculator;

    public SizeDescriptionCalculator getCalculator(Typology typology) {
        final Map<Typology, SizeDescriptionCalculator> SCORER_MAP = new ImmutableMap.Builder<Typology, SizeDescriptionCalculator>()
                .put(FLAT, sizeDescriptionFlatCalculator)
                .put(CHALET, sizeDescriptionChaletCalculator)
                .build();

        return Optional.of(typology)
                .map(SCORER_MAP::get)
                .orElse(sizeDescriptionDefaultCalculator);
    }
}
