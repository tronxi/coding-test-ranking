package com.idealista.application.service.scorer.sizedescriptioncalculator;

import com.idealista.application.model.Typology;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SizeDescriptionCalculatorFactoryTest {

    private final SizeDescriptionCalculatorFactory sizeDescriptionCalculatorFactory
            = new SizeDescriptionCalculatorFactory();

    @Test
    public void shouldGetDefaultCalculator() {
        //GIVEN
        SizeDescriptionCalculator sizeDescriptionChaletCalculator = new SizeDescriptionChaletCalculator();
        SizeDescriptionCalculator sizeDescriptionDefaultCalculator = new SizeDescriptionDefaultCalculator();

        sizeDescriptionCalculatorFactory.register(Typology.DEFAULT, sizeDescriptionChaletCalculator);
        sizeDescriptionCalculatorFactory.register(Typology.DEFAULT, sizeDescriptionDefaultCalculator);
        //WHEN
        SizeDescriptionCalculator sizeDescriptionCalculator =
                sizeDescriptionCalculatorFactory.getCalculator(Typology.DEFAULT);

        //THEN
        assertTrue(sizeDescriptionCalculator instanceof SizeDescriptionDefaultCalculator);
    }

}