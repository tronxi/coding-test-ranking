package com.idealista.infrastructure.api.controller;

import com.idealista.infrastructure.api.model.PublicAd;
import com.idealista.infrastructure.api.model.QualityAd;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@TestPropertySource(locations = "classpath:application-it.yml")
@ActiveProfiles("it")
@RunWith(SpringRunner.class)
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
    @Sql(scripts = "/database/unscoredAds.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void shouldReturnEmptyQualityAdsIT() {
        this.webTestClient
                .get()
                .uri("ads/quality")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(QualityAd.class)
                .value(this::assertEmptyQualityAds);
    }

    private void assertEmptyQualityAds(List<QualityAd> qualityAdList) {
        assertEquals(0, qualityAdList.size());
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
}
