package com.idealista.application.service.scorer.completeadcalculator;

import com.idealista.application.model.Ad;
import org.junit.Test;

import static com.idealista.util.TestUtil.getCompleteChaletAd;
import static com.idealista.util.TestUtil.getEmptyAd;
import static org.junit.Assert.*;

public class CompleteAdChaletCalculatorTest {

    private final CompleteAdChaletCalculator completeAdChaletCalculator = new CompleteAdChaletCalculator();

    @Test
    public void shouldReturnCompleteScoreWhenAdIsComplete() {
        //GIVEN
        Ad ad = getCompleteChaletAd();
        Integer expectedScore = 40;

        //WHEN
        Integer score = completeAdChaletCalculator.calculate(ad);

        //THEN
        assertEquals(expectedScore, score);
    }

    @Test
    public void shouldReturnZeroWhenAdIsIncomplete() {
        //GIVEN
        Ad ad = getEmptyAd();
        Integer expectedScore = 0;

        //WHEN
        Integer score = completeAdChaletCalculator.calculate(ad);

        //THEN
        assertEquals(expectedScore, score);
    }

}