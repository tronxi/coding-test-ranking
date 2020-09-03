package com.idealista.application.service.usecase;

import com.idealista.application.model.Ad;
import com.idealista.application.port.primary.FindRelevantAd;
import com.idealista.application.port.secondary.AdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.idealista.application.model.AdConstant.IRRELEVANT_SCORE;

@Service
@RequiredArgsConstructor
public class FindRelevantAdUseCase implements FindRelevantAd {

    private final AdRepository adRepository;

    @Override
    public List<Ad> findOrderByScoreDesc() {
        return adRepository.findByScoreIsGreaterThanEqualOrderByScoreDesc(IRRELEVANT_SCORE);
    }

}
