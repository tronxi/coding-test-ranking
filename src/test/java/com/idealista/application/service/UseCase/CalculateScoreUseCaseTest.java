package com.idealista.application.service.UseCase;

import com.idealista.application.model.Ad;
import com.idealista.application.port.secondary.AdRepository;
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
    private List<Scorer> scorerList;

    @Mock
    private AdRepository adRepository;

    @InjectMocks
    private CalculateScoreUseCase calculateScoreUseCase;

    @Test
    public void shouldUpdateAllAds() {
        //GIVEN
        List<Ad> adList = Arrays.asList(getEmptyAd());
        when(adRepository.findAll()).thenReturn(adList);

        //WHEN
        calculateScoreUseCase.calculate();

        //THEN
        verify(adRepository, times(1)).update(getEmptyAd());
    }

}