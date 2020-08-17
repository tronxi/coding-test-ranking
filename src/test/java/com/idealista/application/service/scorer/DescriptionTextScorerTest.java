package com.idealista.application.service.scorer;

import com.idealista.application.model.Ad;
import org.junit.Test;

import static com.idealista.util.TestUtil.getAdWithDescription;
import static org.junit.Assert.assertEquals;

public class DescriptionTextScorerTest {

    private final Integer EMPTY_SCORE = 0;
    private final Integer COMPLETE_SCORE = 5;

    private final DescriptionTextScorer descriptionTextScore = new DescriptionTextScorer();

    @Test
    public void shouldReturnZeroWhenDescriptionIsNull() {
        //GIVEN
        Ad ad = getAdWithDescription(null);

        //WHEN
        Integer score = descriptionTextScore.calculate(ad);

        //THEN
        assertEquals(EMPTY_SCORE, score);
    }

    @Test
    public void shouldReturnZeroWhenDescriptionIsEmpty() {
        //GIVEN
        Ad ad = getAdWithDescription("");

        //WHEN
        Integer score = descriptionTextScore.calculate(ad);

        //THEN
        assertEquals(EMPTY_SCORE, score);
    }

    @Test
    public void shouldReturnZeroWhenDescriptionIsBlank() {
        //GIVEN
        Ad ad = getAdWithDescription(" ");

        //WHEN
        Integer score = descriptionTextScore.calculate(ad);

        //THEN
        assertEquals(EMPTY_SCORE, score);
    }

    @Test
    public void shouldReturnCompleteScoreWhenDescriptionIsComplete() {
        //GIVEN
        Ad ad = getAdWithDescription("description");

        //WHEN
        Integer score = descriptionTextScore.calculate(ad);

        //THEN
        assertEquals(COMPLETE_SCORE, score);
    }

}