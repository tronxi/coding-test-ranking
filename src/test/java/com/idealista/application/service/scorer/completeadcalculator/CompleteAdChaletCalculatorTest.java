package com.idealista.application.service.scorer.completeadcalculator;

import com.idealista.application.model.Ad;
import com.idealista.application.model.Typology;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.idealista.util.TestUtil.getCompleteChaletAd;
import static com.idealista.util.TestUtil.getEmptyAd;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CompleteAdChaletCalculatorTest {

    @Mock
    private CompleteAdCalculatorFactory completeAdCalculatorFactory;

    @InjectMocks
    private CompleteAdChaletCalculator completeAdChaletCalculator;

    @Test
    public void shouldReturnCompleteScoreWhenAdIsComplete() {
        //GIVEN
        Ad ad = getCompleteChaletAd();
        Integer expectedScore = 40;

        //WHEN
        Integer score = completeAdChaletCalculator.calculate(ad);

        //THEN
        assertEquals(expectedScore, score);
    }

    @Test
    public void shouldReturnZeroWhenAdIsIncomplete() {
        //GIVEN
        Ad ad = getEmptyAd();
        Integer expectedScore = 0;

        //WHEN
        Integer score = completeAdChaletCalculator.calculate(ad);

        //THEN
        assertEquals(expectedScore, score);
    }

    @Test
    public void shouldRegisterChalet() {
        //WHEN
        completeAdChaletCalculator.register();
        //THEN
        verify(completeAdCalculatorFactory).register(Typology.CHALET, completeAdChaletCalculator);
    }

}