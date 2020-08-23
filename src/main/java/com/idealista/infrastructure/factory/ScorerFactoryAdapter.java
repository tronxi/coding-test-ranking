package com.idealista.infrastructure.factory;

import com.idealista.application.port.secondary.ScorerFactory;
import com.idealista.application.service.scorer.Scorer;
import com.idealista.application.service.scorer.CompositeScorer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ScorerFactoryAdapter implements ScorerFactory {

    @Value("${scorer.bean.names}")
    private List<String> scorerBeanNames;

    private final BeanFactory beanFactory;

    private final CompositeScorer compositeScorer;


    @Override
    public Scorer createScorer() {
        scorerBeanNames.forEach(this::addBean);
        return compositeScorer;
    }

    private void addBean(String beanName) {
        try {
            compositeScorer.add(beanFactory.getBean(beanName, Scorer.class));
        } catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            log.warn(noSuchBeanDefinitionException.toString());
        }
    }
}
