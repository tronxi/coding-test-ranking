package com.idealista.application.service.scorer.completeadcalculator;

import com.idealista.application.model.Typology;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class CompleteAdCalculatorFactoryTest {

    private final CompleteAdCalculatorFactory completeAdCalculatorFactory
            = new CompleteAdCalculatorFactory();

    @Test
    public void shouldGetDefaultCalculator() {
        //GIVEN
        CompleteAdCalculator completeAdChaletCalculator = new CompleteAdChaletCalculator();
        CompleteAdCalculator completeAdDefaultCalculator = new CompleteAdDefaultCalculator();

        completeAdCalculatorFactory.register(Typology.DEFAULT, completeAdChaletCalculator);
        completeAdCalculatorFactory.register(Typology.DEFAULT, completeAdDefaultCalculator);
        //WHEN
        CompleteAdCalculator completeAdCalculator =
                completeAdCalculatorFactory.getCalculator(Typology.DEFAULT);

        //THEN
        assertTrue(completeAdCalculator instanceof CompleteAdDefaultCalculator);
    }

}