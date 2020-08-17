package com.idealista.application.model;

import org.junit.Test;

import static com.idealista.util.TestUtil.getAdWithScore;
import static org.junit.Assert.*;

public class AdTest {

    @Test
    public void scoreShouldBeMinLimitWhenIsNegative() {
        //GIVEN
        Integer expectedScore = 0;
        //WHEN
        Ad ad = getAdWithScore(-5);

        //THEN
        assertEquals(expectedScore, ad.getScore().getValue());
    }

    @Test
    public void scoreShouldBeMaxLimitWhenIsGreaterThanMaxLimit() {
        //GIVEN
        Integer expectedScore = 100;
        //WHEN
        Ad ad = getAdWithScore(101);

        //THEN
        assertEquals(expectedScore, ad.getScore().getValue());
    }

}