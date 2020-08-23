package com.idealista.infrastructure.factory;

import com.idealista.application.model.Typology;
import com.idealista.application.port.secondary.SizeDescriptionCalculatorFactory;
import com.idealista.application.service.scorer.sizeDescriptionCalculator.SizeDescriptionCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SizeDescriptionCalculatorFactoryAdapter implements SizeDescriptionCalculatorFactory {

    private final BeanFactory beanFactory;

    @Override
    public SizeDescriptionCalculator getCalculator(Typology typology) {
        try {
            return beanFactory.getBean("SIZE_DESCRIPTION_" + typology.name(), SizeDescriptionCalculator.class);
        } catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            return beanFactory.getBean("SIZE_DESCRIPTION_DEFAULT", SizeDescriptionCalculator.class);
        }
    }
}
