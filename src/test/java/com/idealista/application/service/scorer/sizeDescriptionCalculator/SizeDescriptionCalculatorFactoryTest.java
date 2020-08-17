package com.idealista.application.service.scorer.sizeDescriptionCalculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.idealista.application.model.Typology.DEFAULT;
import static com.idealista.application.model.Typology.FLAT;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class SizeDescriptionCalculatorFactoryTest {

    @Mock
    private SizeDescriptionFlatCalculator sizeDescriptionFlatCalculator;

    @Mock
    private SizeDescriptionChaletCalculator sizeDescriptionChaletCalculator;

    @Mock
    private SizeDescriptionDefaultCalculator sizeDescriptionDefaultCalculator;

    @InjectMocks
    private SizeDescriptionCalculatorFactory sizeDescriptionCalculatorFactory;

    @Test
    public void shouldReturnDefaultCalculator() {
        //WHEN
        SizeDescriptionCalculator sizeDescriptionCalculator
                = sizeDescriptionCalculatorFactory.getCalculator(DEFAULT);

        //THEN
        assertTrue(sizeDescriptionCalculator instanceof SizeDescriptionDefaultCalculator);
    }

    @Test
    public void shouldReturnFlatCalculator() {
        //WHEN
        SizeDescriptionCalculator sizeDescriptionCalculator
                = sizeDescriptionCalculatorFactory.getCalculator(FLAT);

        //THEN
        assertTrue(sizeDescriptionCalculator instanceof SizeDescriptionFlatCalculator);
    }

}