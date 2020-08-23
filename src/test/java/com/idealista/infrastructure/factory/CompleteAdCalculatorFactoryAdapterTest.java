package com.idealista.infrastructure.factory;

import com.idealista.application.model.Typology;
import com.idealista.application.service.scorer.completeAdCalculator.CompleteAdCalculator;
import com.idealista.application.service.scorer.completeAdCalculator.CompleteAdDefaultCalculator;
import com.idealista.application.service.scorer.completeAdCalculator.CompleteAdFlatCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CompleteAdCalculatorFactoryAdapterTest {

    @Mock
    private BeanFactory beanFactory;

    @Mock
    private CompleteAdFlatCalculator completeAdFlatCalculator;

    @Mock
    private CompleteAdDefaultCalculator completeAdDefaultCalculator;

    @InjectMocks
    private CompleteAdCalculatorFactoryAdapter completeAdCalculatorFactoryAdapter;

    @Test
    public void shouldReturnCompleteAdFlatCalculator() {
        //GIVEN
        when(beanFactory.getBean("COMPLETE_AD_FLAT", CompleteAdCalculator.class))
                .thenReturn(completeAdFlatCalculator);
        //WHEN
        CompleteAdCalculator completeAdCalculator =
                completeAdCalculatorFactoryAdapter.getCalculator(Typology.FLAT);
        //THEN
        assertTrue(completeAdCalculator instanceof CompleteAdFlatCalculator);
    }

    @Test
    public void shouldReturnCompleteAdDefaultCalculator() {
        //GIVEN
        when(beanFactory.getBean("COMPLETE_AD_GARAGE", CompleteAdCalculator.class))
                .thenThrow(new NoSuchBeanDefinitionException(""));
        when(beanFactory.getBean("COMPLETE_AD_DEFAULT", CompleteAdCalculator.class))
                .thenReturn(completeAdDefaultCalculator);
        //WHEN
        CompleteAdCalculator completeAdCalculator =
                completeAdCalculatorFactoryAdapter.getCalculator(Typology.GARAGE);
        //THEN
        assertTrue(completeAdCalculator instanceof CompleteAdDefaultCalculator);
    }

}