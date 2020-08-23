package com.idealista.infrastructure.factory;

import com.idealista.application.model.Typology;
import com.idealista.application.port.secondary.CompleteAdCalculatorFactory;
import com.idealista.application.service.scorer.completeAdCalculator.CompleteAdCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.stereotype.Component;

import static com.idealista.application.service.scorer.completeAdCalculator.CompleteAdCalculator.COMPLETE_AD_NAME;

@Component
@RequiredArgsConstructor
public class CompleteAdCalculatorFactoryAdapter implements CompleteAdCalculatorFactory {

    private final BeanFactory beanFactory;

    @Override
    public CompleteAdCalculator getCalculator(Typology typology) {
        try {
            return getCalculatorBeanByTypology(typology);
        } catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            return getCalculatorBeanByTypology(Typology.DEFAULT);
        }
    }

    private CompleteAdCalculator getCalculatorBeanByTypology(Typology typology) {
        return beanFactory.getBean(COMPLETE_AD_NAME + typology.name(), CompleteAdCalculator.class);
    }
}
