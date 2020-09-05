package com.idealista.application.service.scorer.completeadcalculator;

import com.idealista.application.model.Ad;
import com.idealista.application.model.Typology;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.idealista.util.TestUtil.getCompleteFlatAd;
import static com.idealista.util.TestUtil.getEmptyAd;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CompleteAdFlatCalculatorTest {

    @Mock
    private CompleteAdCalculatorFactory completeAdCalculatorFactory;

    @InjectMocks
    private CompleteAdFlatCalculator completeAdFlatCalculator;

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

    @Test
    public void shouldRegisterFlat() {
        //WHEN
        completeAdFlatCalculator.register();
        //THEN
        verify(completeAdCalculatorFactory).register(Typology.FLAT, completeAdFlatCalculator);
    }

}