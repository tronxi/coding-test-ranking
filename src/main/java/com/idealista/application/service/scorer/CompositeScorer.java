package com.idealista.application.service.scorer;

import com.idealista.application.model.Ad;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CompositeScorer implements Scorer {

    private final Set<Scorer> scorerSet = new HashSet<>();

    public CompositeScorer add(Scorer scorer) {
        scorerSet.add(scorer);
        return this;
    }
    @Override
    public Integer calculate(Ad ad) {
        return scorerSet.stream()
                .map(scorer -> scorer.calculate(ad))
                .reduce(Integer::sum)
                .orElse(0);
    }
}
