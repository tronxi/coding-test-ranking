package com.idealista.application.service.scorer.completeAdCalculator;

import com.idealista.application.model.Ad;
import org.junit.Test;

import static com.idealista.util.TestUtil.getCompleteFlatAd;
import static com.idealista.util.TestUtil.getEmptyAd;
import static org.junit.Assert.assertEquals;

public class CompleteAdFlatCalculatorTest {

    private final CompleteAdFlatCalculator completeAdFlatCalculator = new CompleteAdFlatCalculator();

    @Test
    public void shouldReturnCompleteScoreWhenAdIsComplete() {
        //GIVEN
        Ad ad = getCompleteFlatAd();
        Integer expectedScore = 40;

        //WHEN
        Integer score = completeAdFlatCalculator.calculate(ad);

        //THEN
        assertEquals(expectedScore, score);
    }

    @Test
    public void shouldReturnZeroWhenAdIsIncomplete() {
        //GIVEN
        Ad ad = getEmptyAd();
        Integer expectedScore = 0;

        //WHEN
        Integer score = completeAdFlatCalculator.calculate(ad);

        //THEN
        assertEquals(expectedScore, score);
    }

}