package com.idealista.application.service.usecase;

import com.idealista.application.model.Ad;
import com.idealista.application.port.secondary.AdRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static com.idealista.application.model.AdConstant.IRRELEVANT_SCORE;
import static com.idealista.util.TestUtil.getAdWithScore;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FindRelevantAdUseCaseTest {

    @Mock
    private AdRepository adRepository;

    @InjectMocks
    private FindRelevantAdUseCase findRelevantAdUseCase;

    @Test
    public void shouldReturnOrderedRelevantAds() {
        //GIVEN
        Ad adWithScore = getAdWithScore(60);

        List<Ad> expectedAdList = Arrays.asList(adWithScore);

        when(adRepository.findByScoreIsGreaterThanEqualOrderByScoreDesc(IRRELEVANT_SCORE))
                .thenReturn(expectedAdList);
        //WHEN
        List<Ad> orderAdList = findRelevantAdUseCase.findOrderByScoreDesc();

        //THEN
        verify(adRepository).findByScoreIsGreaterThanEqualOrderByScoreDesc(IRRELEVANT_SCORE);
        assertEquals(expectedAdList, orderAdList);
    }

}