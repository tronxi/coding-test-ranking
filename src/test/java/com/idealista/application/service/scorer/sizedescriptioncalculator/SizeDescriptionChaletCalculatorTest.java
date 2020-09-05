package com.idealista.application.service.scorer.sizedescriptioncalculator;

import com.idealista.application.model.Ad;
import com.idealista.application.model.Typology;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.idealista.util.TestUtil.getAdWithDescription;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SizeDescriptionChaletCalculatorTest {

    @Mock
    private SizeDescriptionCalculatorFactory sizeDescriptionCalculatorFactory;

    @InjectMocks
    private SizeDescriptionChaletCalculator sizeDescriptionChaletCalculator;

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

    @Test
    public void shouldRegisterChalet() {
        //WHEN
        sizeDescriptionChaletCalculator.register();
        //THEN
        verify(sizeDescriptionCalculatorFactory).register(Typology.CHALET, sizeDescriptionChaletCalculator);
    }

}