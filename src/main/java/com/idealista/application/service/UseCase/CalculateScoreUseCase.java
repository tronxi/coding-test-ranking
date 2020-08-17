package com.idealista.application.service.UseCase;

import com.idealista.application.model.Ad;
import com.idealista.application.model.Score;
import com.idealista.application.port.primary.CalculateScore;
import com.idealista.application.port.secondary.AdRepository;
import com.idealista.application.service.scorer.Scorer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculateScoreUseCase implements CalculateScore {

    @Qualifier("all")
    private final List<Scorer> scorer;

    private final AdRepository adRepository;

    @Override
    public void calculate() {
        List<Ad> adList = adRepository.findAll();
        adList.forEach(this::updateAdd);
    }

    private void updateAdd(Ad ad) {
        Ad scoredAd = updateScore(ad);
        updateIrrelevantDate(scoredAd);
    }

    private Ad updateScore(Ad ad) {
        Integer score = calculateScore(ad);
        Ad scoredAd = ad.toBuilder()
                .score(new Score(score))
                .build();
        adRepository.update(scoredAd);
        return scoredAd;
    }

    private Integer calculateScore(Ad ad) {
        return scorer.stream()
                .map(scorer -> scorer.calculate(ad))
                .reduce(Integer::sum)
                .orElse(0);
    }

    private void updateIrrelevantDate(Ad scoredAd) {
        if (scoredAd.isIrrelevant()) {
            markIrrelevant(scoredAd);
        }
    }

    private void markIrrelevant(Ad scoredAd) {
        Ad irrelevantAd = scoredAd.toBuilder()
                .irrelevantSince(Date.from(Instant.now()))
                .build();
        adRepository.update(irrelevantAd);
    }
}
