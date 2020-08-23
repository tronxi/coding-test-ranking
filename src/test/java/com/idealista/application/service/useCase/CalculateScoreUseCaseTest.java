package com.idealista.application.service.useCase;

import com.idealista.application.model.Ad;
import com.idealista.application.port.secondary.AdRepository;
import com.idealista.application.port.secondary.ScorerFactory;
import com.idealista.application.service.scorer.Scorer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static com.idealista.util.TestUtil.getEmptyAd;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculateScoreUseCaseTest {

    @Mock
    private ScorerFactory scorerFactory;

    @Mock
    private AdRepository adRepository;

    @Mock
    private Scorer scorer;

    @InjectMocks
    private CalculateScoreUseCase calculateScoreUseCase;

    @Test
    public void shouldUpdateAllAds() {
        //GIVEN
        List<Ad> adList = Arrays.asList(getEmptyAd());
        when(scorerFactory.createScorer()).thenReturn(scorer);
        when(adRepository.findAll()).thenReturn(adList);

        //WHEN
        calculateScoreUseCase.calculate();

        //THEN
        verify(adRepository, times(1)).update(getEmptyAd());
    }

}