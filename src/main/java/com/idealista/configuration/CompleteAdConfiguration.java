package com.idealista.configuration;

import com.google.common.collect.ImmutableMap;
import com.idealista.application.model.Typology;
import com.idealista.application.service.scorer.completeadcalculator.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class CompleteAdConfiguration {

    @Bean
    public Map<Typology, CompleteAdCalculator> completeAdBeans() {
        return ImmutableMap.<Typology, CompleteAdCalculator>builder()
                .put(Typology.CHALET, new CompleteAdChaletCalculator())
                .put(Typology.FLAT, new CompleteAdFlatCalculator())
                .put(Typology.GARAGE, new CompleteAdGarageCalculator())
                .put(Typology.DEFAULT, new CompleteAdDefaultCalculator())
                .build();
    }
}
