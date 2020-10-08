package com.idealista.infrastructure.api.controller;

import com.idealista.infrastructure.api.model.PublicAd;
import com.idealista.infrastructure.api.model.QualityAd;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class AdsControllerIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @Sql(scripts = "/database/clean.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/database/ads.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void ShouldReturnLessThan40IT() {
        this.webTestClient
                .get()
                .uri("ads/quality")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(QualityAd.class)
                .value(this::assertQualityAds);
    }

    private void assertQualityAds(List<QualityAd> qualityAdList) {
        assertEquals(6, qualityAdList.size());
    }

    @Test
    @Sql(scripts = "/database/clean.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/database/ads.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void shouldReturnPublicAdsIT() {
        this.webTestClient
                .get()
                .uri("ads/public")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(PublicAd.class)
                .value(this::assertPublicAds);
    }

    private void assertPublicAds(List<PublicAd> publicAdList) {
        assertEquals(2, publicAdList.size());
    }

    @Test
    @Sql(scripts = "/database/clean.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/database/unscoredAds.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void shouldCalculateAdsIT() {
        this.webTestClient
                .put()
                .uri("ads/score")
                .exchange()
                .expectStatus().isOk();

        this.webTestClient
                .get()
                .uri("ads/quality")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(QualityAd.class)
                .value(this::assertQualityAdsCalculated);

        this.webTestClient
                .get()
                .uri("ads/public")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(PublicAd.class)
                .value(this::assertPublicAdsCalculated);
    }

    private void assertQualityAdsCalculated(List<QualityAd> qualityAdList) {
        List<Integer> expectedOrderedIds = Arrays.asList(1, 3, 7, 8);

        List<Integer> actualOrderedIds = qualityAdList.stream()
                .map(QualityAd::getId)
                .collect(Collectors.toList());

        assertEquals(4, qualityAdList.size());
        assertEquals(expectedOrderedIds, actualOrderedIds);
    }

    private void assertPublicAdsCalculated(List<PublicAd> publicAdList) {
        List<Integer> expectedOrderedIds = Arrays.asList(9, 2, 4, 5, 6);

        List<Integer> actualOrderedIds = publicAdList.stream()
                .map(PublicAd::getId)
                .collect(Collectors.toList());

        assertEquals(5, publicAdList.size());
        assertEquals(expectedOrderedIds, actualOrderedIds);
    }
}
