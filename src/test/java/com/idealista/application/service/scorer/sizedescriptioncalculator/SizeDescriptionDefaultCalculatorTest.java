package com.idealista.application.service.scorer.sizedescriptioncalculator;

import com.idealista.application.model.Ad;
import com.idealista.application.model.Typology;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.idealista.util.TestUtil.getEmptyAd;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SizeDescriptionDefaultCalculatorTest {

    @Mock
    private SizeDescriptionCalculatorFactory sizeDescriptionCalculatorFactory;

    @InjectMocks
    private SizeDescriptionDefaultCalculator sizeDefaultScorer;

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

    @Test
    public void shouldRegisterDefault() {
        //WHEN
        sizeDefaultScorer.register();
        //THEN
        verify(sizeDescriptionCalculatorFactory).register(Typology.DEFAULT, sizeDefaultScorer);
    }

}