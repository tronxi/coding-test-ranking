package com.idealista.configuration;

import com.idealista.application.service.scorer.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ScoreConfiguration {

    private final PictureScorer pictureScore;
    private final DescriptionTextScorer descriptionTextScore;
    private final SizeDescriptionScorer sizeDescriptionScorer;
    private final TopWordScorer topWordScorer;
    private final CompleteAdScorer completeAdScorer;

    @Bean(name = "all")
    public Scorer scorerComposite() {
        ScorerComposite scorerComposite = new ScorerComposite();
        scorerComposite
                .add(pictureScore)
                .add(descriptionTextScore)
                .add(sizeDescriptionScorer)
                .add(topWordScorer)
                .add(completeAdScorer);
        return scorerComposite;
    }

    @Bean(name = "onlyPicture")
    public Scorer scorerComposite1() {
        ScorerComposite scorerComposite = new ScorerComposite();
        scorerComposite
                .add(pictureScore);
        return scorerComposite;
    }
}
