package com.idealista.application.port.secondary;

import com.idealista.application.service.scorer.Scorer;

public interface ScorerFactory {

    Scorer createScorer();
}
