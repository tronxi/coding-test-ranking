package com.idealista.application.service.scorer;

import com.idealista.application.model.Ad;
import com.idealista.application.service.scorer.sizedescriptioncalculator.SizeDescriptionCalculatorFactory;
import com.idealista.application.service.scorer.sizedescriptioncalculator.SizeDescriptionFlatCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.idealista.application.model.Typology.FLAT;
import static com.idealista.util.TestUtil.getAdWithTypology;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
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