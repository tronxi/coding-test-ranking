package com.idealista.application.service.scorer.completeadcalculator;

import com.idealista.application.model.Ad;
import com.idealista.application.model.Typology;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.idealista.util.TestUtil.getCompleteGarageAd;
import static com.idealista.util.TestUtil.getEmptyAd;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CompleteAdGarageCalculatorTest {

    @Mock
    private CompleteAdCalculatorFactory completeAdCalculatorFactory;

    @InjectMocks
    private CompleteAdGarageCalculator completeAdGarageCalculator;

    @Test
    public void shouldReturnCompleteScoreWhenAdIsComplete() {
        //GIVEN
        Ad ad = getCompleteGarageAd();
        Integer expectedScore = 40;

        //WHEN
        Integer score = completeAdGarageCalculator.calculate(ad);

        //THEN
        assertEquals(expectedScore, score);
    }

    @Test
    public void shouldReturnZeroWhenAdIsIncomplete() {
        //GIVEN
        Ad ad = getEmptyAd();
        Integer expectedScore = 0;

        //WHEN
        Integer score = completeAdGarageCalculator.calculate(ad);

        //THEN
        assertEquals(expectedScore, score);
    }

    @Test
    public void shouldRegisterGarage() {
        //WHEN
        completeAdGarageCalculator.register();
        //THEN
        verify(completeAdCalculatorFactory).register(Typology.GARAGE, completeAdGarageCalculator);
    }

}