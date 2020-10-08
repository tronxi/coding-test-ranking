package com.idealista.infrastructure.persistence.adapter;

import com.idealista.application.model.Ad;
import com.idealista.infrastructure.persistence.entity.AdEntity;
import com.idealista.infrastructure.persistence.mapper.AdMapper;
import com.idealista.infrastructure.persistence.repository.AdRepositoryJPA;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static com.idealista.application.model.AdConstant.IRRELEVANT_SCORE;
import static com.idealista.util.TestUtil.getAdEntity;
import static com.idealista.util.TestUtil.getEmptyAd;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AdRepositoryAdapterTest {

    @Mock
    private AdRepositoryJPA adRepositoryJPA;
    @Mock
    private AdMapper adMapper;
    @InjectMocks
    private AdRepositoryAdapter adRepositoryAdapter;

    @Test
    public void shouldFindAll() {
        //GIVEN
        AdEntity adEntity = getAdEntity();
        List<AdEntity> adEntityList = Arrays.asList(adEntity);
        when(adRepositoryJPA.findAll()).thenReturn(adEntityList);

        //WHEN
        adRepositoryAdapter.findAll();

        //THEN
        verify(adRepositoryJPA).findAll();
        verify(adMapper).toDomain(adEntityList);
    }

    @Test
    public void shouldFindByScoreGreaterThanIrrelevantScore() {
        //GIVEN
        AdEntity adEntity = getAdEntity();
        List<AdEntity> adEntityList = Arrays.asList(adEntity);
        when(adRepositoryJPA.findByScoreIsGreaterThanEqualOrderByScoreDesc(IRRELEVANT_SCORE)).thenReturn(adEntityList);

        //WHEN
        adRepositoryAdapter.findByScoreIsGreaterThanEqualOrderByScoreDesc(IRRELEVANT_SCORE);

        //THEN
        verify(adRepositoryJPA).findByScoreIsGreaterThanEqualOrderByScoreDesc(IRRELEVANT_SCORE);
        verify(adMapper).toDomain(adEntityList);
    }

    @Test
    public void shouldFindByScoreLessThanIrrelevantScore() {
        //GIVEN
        AdEntity adEntity = getAdEntity();
        List<AdEntity> adEntityList = Arrays.asList(adEntity);
        when(adRepositoryJPA.findByScoreIsLessThan(IRRELEVANT_SCORE)).thenReturn(adEntityList);

        //WHEN
        adRepositoryAdapter.findByScoreIsLessThan(IRRELEVANT_SCORE);

        //THEN
        verify(adRepositoryJPA).findByScoreIsLessThan(IRRELEVANT_SCORE);
        verify(adMapper).toDomain(adEntityList);
    }

    @Test
    public void shouldUpdateAd() {
        //GIVEN
        Ad ad = getEmptyAd();
        AdEntity adEntity = getAdEntity();
        when(adMapper.toEntity(ad)).thenReturn(adEntity);
        //WHEN
        adRepositoryAdapter.update(ad);

        //THEN
        verify(adRepositoryJPA).save(adEntity);
        verify(adMapper).toEntity(ad);
    }

}