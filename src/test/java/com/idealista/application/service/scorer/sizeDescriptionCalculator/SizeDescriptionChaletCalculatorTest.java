package com.idealista.application.service.scorer.sizeDescriptionCalculator;

import com.idealista.application.model.Ad;
import org.junit.Test;

import static com.idealista.util.TestUtil.getAdWithDescription;
import static org.junit.Assert.assertEquals;

public class SizeDescriptionChaletCalculatorTest {

    private final SizeDescriptionChaletCalculator sizeDescriptionChaletCalculator = new SizeDescriptionChaletCalculator();

    @Test
    public void shouldReturnZeroWhenDescriptionLengthIsLessThanMaxLimit() {

        //GIVEN
        String emptyDescription = "";
        Integer zeroScore = 0;
        Ad ad = getAdWithDescription(emptyDescription);

        //WHEN
        Integer score = sizeDescriptionChaletCalculator.calculate(ad);

        //THEN
        assertEquals(zeroScore, score);
    }

    @Test
    public void shouldReturnGreaterScoreWhenDescriptionLengthIsGreaterThanMaxLimit() {

        //GIVEN
        Integer greaterThanMaxScore = 20;
        String greaterThanMaxDescription = "a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a";
        Ad ad = getAdWithDescription(greaterThanMaxDescription);

        //WHEN
        Integer score = sizeDescriptionChaletCalculator.calculate(ad);

        //THEN
        assertEquals(greaterThanMaxScore, score);
    }

}