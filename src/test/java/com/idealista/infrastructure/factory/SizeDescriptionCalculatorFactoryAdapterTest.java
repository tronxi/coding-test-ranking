package com.idealista.infrastructure.factory;

import com.idealista.application.model.Typology;
import com.idealista.application.service.scorer.completeAdCalculator.CompleteAdCalculator;
import com.idealista.application.service.scorer.completeAdCalculator.CompleteAdDefaultCalculator;
import com.idealista.application.service.scorer.completeAdCalculator.CompleteAdFlatCalculator;
import com.idealista.application.service.scorer.sizeDescriptionCalculator.SizeDescriptionCalculator;
import com.idealista.application.service.scorer.sizeDescriptionCalculator.SizeDescriptionDefaultCalculator;
import com.idealista.application.service.scorer.sizeDescriptionCalculator.SizeDescriptionFlatCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import static com.idealista.application.service.scorer.sizeDescriptionCalculator.SizeDescriptionCalculator.SIZE_DESCRIPTION_NAME;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SizeDescriptionCalculatorFactoryAdapterTest {

    @Mock
    private BeanFactory beanFactory;

    @Mock
    private SizeDescriptionFlatCalculator sizeDescriptionFlatCalculator;

    @Mock
    private SizeDescriptionDefaultCalculator sizeDescriptionDefaultCalculator;

    @InjectMocks
    private SizeDescriptionCalculatorFactoryAdapter sizeDescriptionCalculatorFactoryAdapter;

    @Test
    public void shouldReturnCompleteAdFlatCalculator() {
        //GIVEN
        Typology typology = Typology.FLAT;
        when(beanFactory.getBean(SIZE_DESCRIPTION_NAME + typology.name(), SizeDescriptionCalculator.class))
                .thenReturn(sizeDescriptionFlatCalculator);
        //WHEN
        SizeDescriptionCalculator sizeDescriptionCalculator =
                sizeDescriptionCalculatorFactoryAdapter.getCalculator(typology);
        //THEN
        assertTrue(sizeDescriptionCalculator instanceof SizeDescriptionFlatCalculator);
    }

    @Test
    public void shouldReturnCompleteAdDefaultCalculator() {
        //GIVEN
        Typology typology = Typology.GARAGE;
        when(beanFactory.getBean(SIZE_DESCRIPTION_NAME + typology.name(), SizeDescriptionCalculator.class))
                .thenThrow(new NoSuchBeanDefinitionException(""));
        when(beanFactory.getBean(SIZE_DESCRIPTION_NAME + Typology.DEFAULT.name(), SizeDescriptionCalculator.class))
                .thenReturn(sizeDescriptionDefaultCalculator);
        //WHEN
        SizeDescriptionCalculator sizeDescriptionCalculator =
                sizeDescriptionCalculatorFactoryAdapter.getCalculator(typology);
        //THEN
        assertTrue(sizeDescriptionCalculator instanceof SizeDescriptionDefaultCalculator);
    }

}