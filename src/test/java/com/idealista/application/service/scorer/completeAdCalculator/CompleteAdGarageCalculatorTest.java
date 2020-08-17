package com.idealista.application.service.scorer.completeAdCalculator;

import com.idealista.application.model.Ad;
import org.junit.Test;

import static com.idealista.util.TestUtil.*;
import static org.junit.Assert.*;

public class CompleteAdGarageCalculatorTest {

    private final CompleteAdGarageCalculator completeAdGarageCalculator = new CompleteAdGarageCalculator();

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

}