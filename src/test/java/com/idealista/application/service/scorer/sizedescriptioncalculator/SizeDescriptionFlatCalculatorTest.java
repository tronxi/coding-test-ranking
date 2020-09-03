package com.idealista.application.service.scorer.sizedescriptioncalculator;

import com.idealista.application.model.Ad;
import org.junit.Test;

import static com.idealista.util.TestUtil.getAdWithDescription;
import static org.junit.Assert.assertEquals;


public class SizeDescriptionFlatCalculatorTest {


    private final SizeDescriptionFlatCalculator sizeDescriptionFlatCalculator
            = new SizeDescriptionFlatCalculator();

    @Test
    public void shouldReturnZeroWhenDescriptionLengthIsLessThanMinLimit() {
        //GIVEN
        Integer zeroScore = 0;
        String emptyDescription = "";
        Ad ad = getAdWithDescription(emptyDescription);

        //WHEN
        Integer score = sizeDescriptionFlatCalculator.calculate(ad);

        //THEN
        assertEquals(zeroScore, score);
    }

    @Test
    public void shouldReturnInLimitsScoreWhenDescriptionLengthIsInLimits() {
        //GIVEN
        Integer inLimitsScore = 10;
        String inLimitsDescription = "a a a a a a a a a a a a a a a a a a a a";
        Ad ad = getAdWithDescription(inLimitsDescription);

        //WHEN
        Integer score = sizeDescriptionFlatCalculator.calculate(ad);

        //THEN
        assertEquals(inLimitsScore, score);
    }

    @Test
    public void shouldReturnGreaterScoreWhenDescriptionLengthIsGreaterThanMaxLimit() {
        //GIVEN
        Integer greaterThanMaxScore = 30;
        String greaterThanMaxDescription = "a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a";
        Ad ad = getAdWithDescription(greaterThanMaxDescription);

        //WHEN
        Integer score = sizeDescriptionFlatCalculator.calculate(ad);

        //THEN
        assertEquals(greaterThanMaxScore, score);
    }
}