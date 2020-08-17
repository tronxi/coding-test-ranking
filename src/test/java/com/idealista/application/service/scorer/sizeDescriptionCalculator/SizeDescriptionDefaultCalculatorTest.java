package com.idealista.application.service.scorer.sizeDescriptionCalculator;

import com.idealista.application.model.Ad;
import org.junit.Test;

import static com.idealista.util.TestUtil.getEmptyAd;
import static org.junit.Assert.assertEquals;

public class SizeDescriptionDefaultCalculatorTest {

    private final SizeDescriptionDefaultCalculator sizeDefaultScorer = new SizeDescriptionDefaultCalculator();

    @Test
    public void shouldReturnZero() {

        //GIVEN
        Integer zeroScore = 0;
        Ad ad = getEmptyAd();

        //WHEN
        Integer score = sizeDefaultScorer.calculate(ad);

        //THEN
        assertEquals(zeroScore, score);
    }

}