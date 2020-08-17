package com.idealista.application.service.scorer.completeAdCalculator;

import com.idealista.application.model.Typology;
import com.idealista.application.service.scorer.sizeDescriptionCalculator.SizeDescriptionFlatCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CompleteAdCalculatorFactoryTest {

    @Mock
    private CompleteAdFlatCalculator completeAdFlatCalculator;

    @Mock
    private CompleteAdChaletCalculator completeAdChaletCalculator;

    @Mock
    private CompleteAdGarageCalculator completeAdGarageCalculator;

    @Mock
    private CompleteAdDefaultCalculator completeAdDefaultCalculator;

    @InjectMocks CompleteAdCalculatorFactory completeAdCalculatorFactory;

    @Test
    public void shouldReturnDefaultCalculator() {
        //WHEN
        CompleteAdCalculator completeAdCalculator
                = completeAdCalculatorFactory.getCalculator(Typology.DEFAULT);

        //THEN
        assertTrue(completeAdCalculator instanceof CompleteAdDefaultCalculator);

    }

    @Test
    public void shouldReturnFlatCalculator() {
        //WHEN
        CompleteAdCalculator completeAdCalculator
                = completeAdCalculatorFactory.getCalculator(Typology.FLAT);

        //THEN
        assertTrue(completeAdCalculator instanceof CompleteAdFlatCalculator);

    }

}