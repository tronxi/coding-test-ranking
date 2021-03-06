package com.idealista.application.service.usecase;

import com.idealista.application.model.Ad;
import com.idealista.application.port.secondary.AdRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static com.idealista.application.model.AdConstant.IRRELEVANT_SCORE;
import static com.idealista.util.TestUtil.getEmptyAd;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindIrrelevantAdUseCaseTest {

    @Mock
    private AdRepository adRepository;

    @InjectMocks
    private FindIrrelevantAdUseCase findIrrelevantAdUseCase;

    @Test
    public void a() {
        //GIVEN
        List<Ad> adList = Arrays.asList(getEmptyAd());
        when(adRepository.findByScoreIsLessThan(IRRELEVANT_SCORE)).thenReturn(adList);

        //WHEN
        List<Ad> irrelevantAd = findIrrelevantAdUseCase.find();

        //THEN
        verify(adRepository).findByScoreIsLessThan(IRRELEVANT_SCORE);
        assertEquals(adList, irrelevantAd);
    }

}