package com.idealista.configuration;

import com.idealista.application.service.scorer.CompositeScorer;
import com.idealista.application.service.scorer.Scorer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class ScorerCompositeConfiguration {

    @Value("${scorer.bean.names:}")
    private List<String> scorerBeanNames;

    private final BeanFactory beanFactory;

    @Bean
    public Scorer scorerComposite() {
        CompositeScorer compositeScorer = new CompositeScorer();

        scorerBeanNames.forEach(beanName -> addBean(compositeScorer, beanName));

        return compositeScorer;
    }

    private void addBean(CompositeScorer scorer, String beanName) {
        try {
            scorer.add(beanFactory.getBean(beanName, Scorer.class));
        } catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            log.warn(noSuchBeanDefinitionException.toString());
        }
    }
}
