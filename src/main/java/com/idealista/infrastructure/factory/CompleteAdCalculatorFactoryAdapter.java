package com.idealista.infrastructure.factory;

import com.idealista.application.model.Typology;
import com.idealista.application.port.secondary.CompleteAdCalculatorFactory;
import com.idealista.application.service.scorer.completeAdCalculator.CompleteAdCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompleteAdCalculatorFactoryAdapter implements CompleteAdCalculatorFactory {

    private final BeanFactory beanFactory;

    @Override
    public CompleteAdCalculator getCalculator(Typology typology) {
        try {
            return beanFactory.getBean("COMPLETE_AD_" + typology.name(), CompleteAdCalculator.class);
        } catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            return beanFactory.getBean("COMPLETE_AD_DEFAULT", CompleteAdCalculator.class);
        }
    }
}
