package com.idealista.application.service.scorer.completeadcalculator;

import com.idealista.application.model.Ad;
import com.idealista.application.model.Typology;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.idealista.util.TestUtil.getEmptyAd;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CompleteAdDefaultCalculatorTest {

    @Mock
    private CompleteAdCalculatorFactory completeAdCalculatorFactory;

    @InjectMocks
    private CompleteAdDefaultCalculator completeAdDefaultCalculator;

    @Test
    public void shouldReturnZero() {
        //GIVEN
        Ad ad = getEmptyAd();
        Integer expectedScorer = 0;

        //WHEN
        Integer score = completeAdDefaultCalculator.calculate(ad);

        //THEN
        assertEquals(expectedScorer, score);
    }

    @Test
    public void shouldRegisterDefault() {
        //WHEN
        completeAdDefaultCalculator.register();
        //THEN
        verify(completeAdCalculatorFactory).register(Typology.DEFAULT, completeAdDefaultCalculator);
    }

}