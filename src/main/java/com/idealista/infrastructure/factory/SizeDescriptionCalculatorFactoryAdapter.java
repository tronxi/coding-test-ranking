package com.idealista.infrastructure.factory;

import com.idealista.application.model.Typology;
import com.idealista.application.port.secondary.SizeDescriptionCalculatorFactory;
import com.idealista.application.service.scorer.sizeDescriptionCalculator.SizeDescriptionCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.stereotype.Component;

import static com.idealista.application.service.scorer.sizeDescriptionCalculator.SizeDescriptionCalculator.SIZE_DESCRIPTION_NAME;

@Component
@RequiredArgsConstructor
public class SizeDescriptionCalculatorFactoryAdapter implements SizeDescriptionCalculatorFactory {

    private final BeanFactory beanFactory;

    @Override
    public SizeDescriptionCalculator getCalculator(Typology typology) {
        try {
            return getCalculatorBeanByTypology(typology);
        } catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            return getCalculatorBeanByTypology(Typology.DEFAULT);
        }
    }

    private SizeDescriptionCalculator getCalculatorBeanByTypology(Typology typology) {
        return beanFactory.getBean(SIZE_DESCRIPTION_NAME + typology.name(), SizeDescriptionCalculator.class);
    }
}
