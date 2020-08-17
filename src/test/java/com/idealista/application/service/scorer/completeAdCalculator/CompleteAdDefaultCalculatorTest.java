package com.idealista.application.service.scorer.completeAdCalculator;

import com.idealista.application.model.Ad;
import org.junit.Test;

import static com.idealista.util.TestUtil.getEmptyAd;
import static org.junit.Assert.*;

public class CompleteAdDefaultCalculatorTest {

    private final CompleteAdDefaultCalculator completeAdDefaultCalculator = new CompleteAdDefaultCalculator();

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

}