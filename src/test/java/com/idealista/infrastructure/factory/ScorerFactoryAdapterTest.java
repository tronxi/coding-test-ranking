package com.idealista.infrastructure.factory;

import com.idealista.application.service.scorer.CompositeScorer;
import com.idealista.application.service.scorer.PictureScorer;
import com.idealista.application.service.scorer.Scorer;
import com.idealista.application.service.scorer.completeAdCalculator.CompleteAdCalculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.test.util.ReflectionTestUtils;


import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ScorerFactoryAdapterTest {

    @Mock
    private BeanFactory beanFactory;

    @Mock
    private CompositeScorer compositeScorer;

    @InjectMocks
    private ScorerFactoryAdapter scorerFactoryAdapter;

    @Mock
    private PictureScorer pictureScorer;

    private final List<String> scorerBeanNames = Arrays.asList("name");

    @Before
    public void setup() {
        ReflectionTestUtils.setField(scorerFactoryAdapter, "scorerBeanNames", scorerBeanNames);
    }

    @Test
    public void shouldCallBeanFactoryWithScorerBeanNames() {
        //GIVEN
        when(beanFactory.getBean(scorerBeanNames.get(0), Scorer.class))
                .thenReturn(pictureScorer);
        //WHEN
        Scorer scorer = scorerFactoryAdapter.createScorer();

        //THEN
        verify(beanFactory).getBean(scorerBeanNames.get(0), Scorer.class);
    }

}