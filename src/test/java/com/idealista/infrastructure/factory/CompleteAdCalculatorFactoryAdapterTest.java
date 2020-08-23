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

import static com.idealista.application.service.scorer.completeAdCalculator.CompleteAdCalculator.COMPLETE_AD_NAME;
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
        Typology typology = Typology.FLAT;
        when(beanFactory.getBean(COMPLETE_AD_NAME + typology.name(), CompleteAdCalculator.class))
                .thenReturn(completeAdFlatCalculator);
        //WHEN
        CompleteAdCalculator completeAdCalculator =
                completeAdCalculatorFactoryAdapter.getCalculator(typology);
        //THEN
        assertTrue(completeAdCalculator instanceof CompleteAdFlatCalculator);
    }

    @Test
    public void shouldReturnCompleteAdDefaultCalculator() {
        //GIVEN
        Typology typology = Typology.GARAGE;
        when(beanFactory.getBean(COMPLETE_AD_NAME + typology.name(), CompleteAdCalculator.class))
                .thenThrow(new NoSuchBeanDefinitionException(""));
        when(beanFactory.getBean(COMPLETE_AD_NAME + Typology.DEFAULT.name(), CompleteAdCalculator.class))
                .thenReturn(completeAdDefaultCalculator);
        //WHEN
        CompleteAdCalculator completeAdCalculator =
                completeAdCalculatorFactoryAdapter.getCalculator(typology);
        //THEN
        assertTrue(completeAdCalculator instanceof CompleteAdDefaultCalculator);
    }

}