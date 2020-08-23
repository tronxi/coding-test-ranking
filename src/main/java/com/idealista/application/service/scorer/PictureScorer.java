package com.idealista.application.service.scorer;

import com.idealista.application.model.Ad;
import org.springframework.stereotype.Component;

@Component
public class PictureScorer implements Scorer {

    private final int HD_SCORE = 20;
    private final int SD_SCORE = 10;
    private final int EMPTY_SCORE = -10;

    @Override
    public Integer calculate(Ad ad) {
        return ad.getPictures().stream()
                .map(picture -> picture.isHD() ? HD_SCORE : SD_SCORE)
                .reduce(Integer::sum)
                .orElse(EMPTY_SCORE);
    }
}
