package com.idealista.application.model;

import lombok.Value;

import static com.idealista.application.model.AdConstant.IRRELEVANT_SCORE;

@Value
public class Score {

    Integer value;

    public Score(Integer value) {
        this.value = adaptScoreInRange(value);
    }

    public boolean isIrrelevant() {
        return value < IRRELEVANT_SCORE;
    }

    private Integer adaptScoreInRange(Integer value) {
        int min_limit = 0;
        int max_limit = 100;

        if (value < min_limit) {
            return min_limit;
        } else if (value > max_limit) {
            return max_limit;
        }
        return value;
    }
}
