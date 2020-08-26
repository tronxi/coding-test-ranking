package com.idealista.configuration;

import com.google.common.collect.ImmutableMap;
import com.idealista.application.model.Typology;
import com.idealista.application.service.scorer.sizeDescriptionCalculator.SizeDescriptionCalculator;
import com.idealista.application.service.scorer.sizeDescriptionCalculator.SizeDescriptionChaletCalculator;
import com.idealista.application.service.scorer.sizeDescriptionCalculator.SizeDescriptionDefaultCalculator;
import com.idealista.application.service.scorer.sizeDescriptionCalculator.SizeDescriptionFlatCalculator;
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
