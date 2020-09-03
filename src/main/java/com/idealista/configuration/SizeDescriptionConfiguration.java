package com.idealista.configuration;

import com.google.common.collect.ImmutableMap;
import com.idealista.application.model.Typology;
import com.idealista.application.service.scorer.sizedescriptioncalculator.SizeDescriptionCalculator;
import com.idealista.application.service.scorer.sizedescriptioncalculator.SizeDescriptionChaletCalculator;
import com.idealista.application.service.scorer.sizedescriptioncalculator.SizeDescriptionDefaultCalculator;
import com.idealista.application.service.scorer.sizedescriptioncalculator.SizeDescriptionFlatCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class SizeDescriptionConfiguration {

    @Bean
    public Map<Typology, SizeDescriptionCalculator> sizeDescriptionBeans() {
        return ImmutableMap.<Typology, SizeDescriptionCalculator>builder()
                .put(Typology.CHALET, new SizeDescriptionChaletCalculator())
                .put(Typology.FLAT, new SizeDescriptionFlatCalculator())
                .put(Typology.GARAGE, new SizeDescriptionDefaultCalculator())
                .put(Typology.DEFAULT, new SizeDescriptionDefaultCalculator())
                .build();
    }
}
