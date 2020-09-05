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
public class SizeDescriptionFlatCalculatorTest {

    @Mock
    private SizeDescriptionCalculatorFactory sizeDescriptionCalculatorFactory;

    @InjectMocks
    private SizeDescriptionFlatCalculator sizeDescriptionFlatCalculator;

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

    @Test
    public void shouldRegisterFlat() {
        //WHEN
        sizeDescriptionFlatCalculator.register();
        //THEN
        verify(sizeDescriptionCalculatorFactory).register(Typology.FLAT, sizeDescriptionFlatCalculator);
    }
}