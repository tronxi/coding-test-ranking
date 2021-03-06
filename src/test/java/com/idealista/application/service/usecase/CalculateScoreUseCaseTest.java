package com.idealista.application.service.usecase;

import com.idealista.application.model.Ad;
import com.idealista.application.port.secondary.AdRepository;
import com.idealista.application.service.scorer.Scorer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static com.idealista.util.TestUtil.getEmptyAd;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculateScoreUseCaseTest {
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
        when(adRepository.findAll()).thenReturn(adList);

        //WHEN
        calculateScoreUseCase.calculate();

        //THEN
        verify(adRepository, times(adList.size())).update(getEmptyAd());
    }

}