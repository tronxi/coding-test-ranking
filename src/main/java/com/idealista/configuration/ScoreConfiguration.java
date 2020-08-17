package com.idealista.configuration;

import com.idealista.application.service.scorer.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class ScoreConfiguration {

    private final PictureScorer pictureScore;
    private final DescriptionTextScorer descriptionTextScore;
    private final SizeDescriptionScorer sizeDescriptionScorer;
    private final TopWordScorer topWordScorer;
    private final CompleteAdScorer completeAdScorer;

    @Bean(name = "all")
    public List<Scorer> scoreList() {
        return Arrays.asList(pictureScore, descriptionTextScore, sizeDescriptionScorer, topWordScorer, completeAdScorer);
    }

    @Bean(name = "onlyPicture")
    public List<Scorer> scoreListOnlyPicture() {
        return Arrays.asList(pictureScore);
    }
}
