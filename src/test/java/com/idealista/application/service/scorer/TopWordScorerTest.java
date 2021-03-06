package com.idealista.application.service.scorer;

import com.idealista.application.model.Ad;
import com.idealista.application.port.secondary.TopWordRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static com.idealista.util.TestUtil.getAdWithDescription;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TopWordScorerTest {

    @Mock
    private TopWordRepository topWordRepository;

    @InjectMocks
    private TopWordScorer topWordScorer;

    @Test
    public void shouldCalculateTopWordsScore() {
        //GIVEN
        List<String> topWords = Arrays.asList("word1", "Word2");
        String description = "word1, word2. word1 Word2";
        int expectedScore = 20;
        Ad ad = getAdWithDescription(description);

        when(topWordRepository.findAll()).thenReturn(topWords);

        //WHEN
        int score = topWordScorer.calculate(ad);

        //THEN
        assertEquals(expectedScore, score);
    }

    @Test
    public void shouldReturnZeroWhenNoMatches() {
        //GIVEN
        List<String> topWords = Arrays.asList("word", "Word");
        String description = "word1, word2. word1 Word2";
        int expectedScore = 0;
        Ad ad = getAdWithDescription(description);

        when(topWordRepository.findAll()).thenReturn(topWords);

        //WHEN
        int score = topWordScorer.calculate(ad);

        //THEN
        assertEquals(expectedScore, score);
    }

    @Test
    public void shouldReturnZeroWhenDescriptionIsEmpty() {
        //GIVEN
        List<String> topWords = Arrays.asList("word", "Word");
        String description = "";
        int expectedScore = 0;
        Ad ad = getAdWithDescription(description);

        when(topWordRepository.findAll()).thenReturn(topWords);

        //WHEN
        int score = topWordScorer.calculate(ad);

        //THEN
        assertEquals(expectedScore, score);
    }

}