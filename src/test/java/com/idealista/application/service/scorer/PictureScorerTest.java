package com.idealista.application.service.scorer;

import com.idealista.application.model.Ad;
import org.junit.Test;

import java.util.Arrays;

import static com.idealista.util.TestUtil.*;
import static org.junit.Assert.assertEquals;

public class PictureScorerTest {

    private final String HD_QUALITY = "HD";
    private final String SD_QUALITY = "SD";

    private final PictureScorer pictureScore = new PictureScorer();

    @Test
    public void shouldReturnNegativeWhenPictureIsEmpty() {
        //GIVEN
        Integer emptyScore = -10;
        Ad ad = getEmptyAd();

        //WHEN
        Integer score = pictureScore.calculate(ad);

        //THEN
        assertEquals(emptyScore, score);

    }

    @Test
    public void shouldReturnHDScoreWhenPictureIsHD() {
        //GIVEN
        Integer hdScore = 20;
        Ad ad = getAdWithPictures(Arrays.asList(getPicture(HD_QUALITY)));

        //WHEN
        Integer score = pictureScore.calculate(ad);

        //THEN
        assertEquals(hdScore, score);

    }

    @Test
    public void shouldReturnSDScoreWhenPictureIsSD() {
        //GIVEN
        Integer sdScore = 10;
        Ad ad = getAdWithPictures(Arrays.asList(getPicture(SD_QUALITY)));

        //WHEN
        Integer score = pictureScore.calculate(ad);

        //THEN
        assertEquals(sdScore, score);

    }

    @Test
    public void shouldReturnBothScoreWhenAdHaveBothPictures() {
        //GIVEN
        Integer bothScore = 30;
        Ad ad = getAdWithPictures(Arrays.asList(getPicture(HD_QUALITY), getPicture(SD_QUALITY)));

        //WHEN
        Integer score = pictureScore.calculate(ad);

        //THEN
        assertEquals(bothScore, score);

    }


}