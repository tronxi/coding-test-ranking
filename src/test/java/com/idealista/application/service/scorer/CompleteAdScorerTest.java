package com.idealista.application.service.scorer;

import com.idealista.application.model.Ad;
import com.idealista.application.service.scorer.completeadcalculator.CompleteAdCalculatorFactory;
import com.idealista.application.service.scorer.completeadcalculator.CompleteAdFlatCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.idealista.application.model.Typology.FLAT;
import static com.idealista.util.TestUtil.getAdWithTypology;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CompleteAdScorerTest {

    @Mock
    private CompleteAdCalculatorFactory completeAdCalculatorFactory;

    @Mock
    private CompleteAdFlatCalculator completeAdFlatCalculator;

    @InjectMocks
    private CompleteAdScorer completeAdScorer;

    @Test
    public void shouldCallCalculator() {
        //GIVEN
        Ad ad = getAdWithTypology(FLAT);
        Integer expected_score = 20;
        when(completeAdCalculatorFactory.getCalculator(FLAT)).thenReturn(completeAdFlatCalculator);
        when(completeAdFlatCalculator.calculate(ad)).thenReturn(expected_score);

        //WHEN
        Integer score = completeAdScorer.calculate(ad);

        //THEN
        verify(completeAdFlatCalculator).calculate(ad);
        assertEquals(expected_score, score);
    }

}