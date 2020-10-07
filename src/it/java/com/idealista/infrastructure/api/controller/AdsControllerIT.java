package java.com.idealista.infrastructure.api.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@TestPropertySource(locations = "classpath:application-test.yml")
@ActiveProfiles("test")
public class AdsControllerIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void test() {
        this.webTestClient
                .get()
                .uri("ads/quality")
                .exchange()
                .expectStatus().isOk();
    }
}
