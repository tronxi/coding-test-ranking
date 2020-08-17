package com.idealista.application.service.scorer;

import com.idealista.application.model.Ad;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class DescriptionTextScorer implements Scorer {

    private final Integer EMPTY_SCORE = 0;
    private final Integer COMPLETE_SCORE = 5;

    @Override
    public Integer calculate(Ad ad) {
        return StringUtils.isBlank(ad.getDescription()) ? EMPTY_SCORE : COMPLETE_SCORE;
    }
}
