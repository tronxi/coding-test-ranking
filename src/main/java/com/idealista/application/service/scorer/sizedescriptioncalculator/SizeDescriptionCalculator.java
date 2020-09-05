package com.idealista.application.service.scorer.sizedescriptioncalculator;

import com.idealista.application.model.Ad;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class SizeDescriptionCalculator {

    @Autowired
    protected SizeDescriptionCalculatorFactory sizeDescriptionCalculatorFactory;

    private final int MIN_LIMIT = 20;
    private final int MAX_LIMIT = 50;

    @PostConstruct
    public abstract void register();

    public abstract Integer calculate(Ad ad);

    protected int lengthDescription(String description) {
        String punctuationMarkExpresion = "[.,]";
        String empty = "";
        String blank = " ";
        return description
                .replaceAll(punctuationMarkExpresion, empty)
                .split(blank)
                .length;
    }

    protected boolean descriptionLengthIsGreaterThanMaxLimit(String description) {
        return lengthDescription(description) >= MAX_LIMIT;
    }

    protected boolean descriptionLengthIsBetweenLimits(String description) {
        return lengthDescription(description) >= MIN_LIMIT
                && lengthDescription(description) < MAX_LIMIT;
    }
}
