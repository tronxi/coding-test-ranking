package com.idealista.infrastructure.api.rest.controller;

import com.idealista.application.model.Ad;
import com.idealista.application.port.primary.CalculateScore;
import com.idealista.application.port.primary.FindIrrelevantAd;
import com.idealista.application.port.primary.FindRelevantAd;
import com.idealista.infrastructure.api.mapper.PublicAdMapper;
import com.idealista.infrastructure.api.mapper.QualityAdMapper;
import com.idealista.infrastructure.api.model.PublicAd;
import com.idealista.infrastructure.api.model.QualityAd;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.idealista.util.TestUtil.getEmptyAd;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AdsControllerTest {

    @Mock
    private CalculateScore calculateScore;
    @Mock
    private FindIrrelevantAd findIrrelevantAd;
    @Mock
    private FindRelevantAd findRelevantAd;
    @Mock
    private QualityAdMapper qualityAdMapper;
    @Mock
    private PublicAdMapper publicAdMapper;

    @InjectMocks
    private AdsController adsController;

    @Test
    public void shouldGetQualityAd() {
        //GIVEN
        Ad ad = getEmptyAd();
        List<Ad> adList = Arrays.asList(ad);
        List<QualityAd> qualityAdList = Collections.emptyList();
        when(findIrrelevantAd.find()).thenReturn(adList);
        when(qualityAdMapper.toQuality(adList)).thenReturn(qualityAdList);
        //WHEN
        ResponseEntity<List<QualityAd>> response = adsController.qualityListing();

        //THEN
        verify(findIrrelevantAd).find();
        verify(qualityAdMapper).toQuality(adList);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(response.getBody(), qualityAdList);
    }

    @Test
    public void shouldGetPublicAd() {
        //GIVEN
        Ad ad = getEmptyAd();
        List<Ad> adList = Arrays.asList(ad);
        List<PublicAd> publicAdList = Collections.emptyList();
        when(findRelevantAd.findOrderByScoreDesc()).thenReturn(adList);
        when(publicAdMapper.toPublicAd(adList)).thenReturn(publicAdList);
        //WHEN
        ResponseEntity<List<PublicAd>> response = adsController.publicListing();

        //THEN
        verify(findRelevantAd).findOrderByScoreDesc();
        verify(publicAdMapper).toPublicAd(adList);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(response.getBody(), publicAdList);
    }

    @Test
    public void shouldCalculateScore() {
        //WHEN
        ResponseEntity<Void> response = adsController.calculateScore();

        //THEN
        verify(calculateScore).calculate();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }



}