package com.idealista.application.service.scorer.sizeDescriptionCalculator;

import com.idealista.application.model.Ad;

public abstract class SizeDescriptionCalculator {

    private final int MIN_LIMIT = 20;
    private final int MAX_LIMIT = 50;

    private final String BLANK = " ";

    public abstract Integer calculate(Ad ad);

    protected int lengthDescription(String description) {
        return description.split(BLANK).length;
    }

    protected boolean descriptionLengthIsGreaterThanMaxLimit(String description) {
        return lengthDescription(description) >= MAX_LIMIT;
    }

    protected boolean descriptionLengthIsBetweenLimits(String description) {
        return lengthDescription(description) >= MIN_LIMIT
                && lengthDescription(description) < MAX_LIMIT;
    }
}
