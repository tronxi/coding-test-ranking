package com.idealista.application.service.scorer;

import com.idealista.application.model.Ad;
import com.idealista.application.service.scorer.sizeDescriptionCalculator.SizeDescriptionCalculatorFactory;
import com.idealista.application.service.scorer.sizeDescriptionCalculator.SizeDescriptionFlatCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.idealista.application.model.Typology.FLAT;
import static com.idealista.util.TestUtil.getAdWithTypology;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SizeDescriptionScorerTest {

    @Mock
    private SizeDescriptionCalculatorFactory sizeDescriptionCalculatorFactory;

    @Mock
    private SizeDescriptionFlatCalculator sizeDescriptionFlatCalculator;

    @InjectMocks
    private SizeDescriptionScorer sizeDescriptionScorer;

    @Test
    public void shouldCallCalculator() {
        //GIVEN
        Integer expectedScore = 20;
        Ad ad = getAdWithTypology(FLAT);
        when(sizeDescriptionCalculatorFactory.getCalculator(FLAT)).thenReturn(sizeDescriptionFlatCalculator);
        when(sizeDescriptionFlatCalculator.calculate(ad)).thenReturn(expectedScore);

        //WHEN
        Integer score = sizeDescriptionScorer.calculate(ad);

        //THEN
        verify(sizeDescriptionFlatCalculator).calculate(ad);
        assertEquals(score, score);
    }

}