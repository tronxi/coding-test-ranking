package com.idealista.application.service.scorer;

import com.idealista.application.model.Ad;
import com.idealista.application.port.secondary.TopWordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TopWordScorer implements Scorer {

    private final TopWordRepository topWordRepository;

    @Override
    public Integer calculate(Ad ad) {
        List<String> topWords = formatTopWordsToLowerCase(topWordRepository.findAll());
        int repeats = countRepeats(ad.getDescription(), topWords);
        return calculateScoreByRepeat(repeats);
    }

    private List<String> formatTopWordsToLowerCase(List<String> topWords) {
        return topWords.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    private Integer countRepeats(String description, List<String> topWords) {
        List<String> words = splitDescriptionInWords(description);
        return topWords.stream()
                .map(topWord -> countTopWordOccurrencesInDescriptionWords(words, topWord))
                .reduce(Integer::sum)
                .orElse(0);
    }

    private int countTopWordOccurrencesInDescriptionWords(List<String> descriptionWords, String topWord) {
        return (int) descriptionWords.stream()
                .filter(word -> word.equals(topWord))
                .count();
    }

    private List<String> splitDescriptionInWords(String description) {
        String punctuationMarkExpresion = "[.,]";
        String empty = "";
        String blank = " ";

        return Arrays.asList(description.toLowerCase()
                .replaceAll(punctuationMarkExpresion, empty)
                .split(blank));
    }

    private int calculateScoreByRepeat(int repeats) {
        int repeatScore = 5;
        return repeats * repeatScore;
    }
}
