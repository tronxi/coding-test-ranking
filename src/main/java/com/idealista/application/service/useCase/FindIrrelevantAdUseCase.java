package com.idealista.application.service.useCase;

import com.idealista.application.model.Ad;
import com.idealista.application.port.primary.FindIrrelevantAd;
import com.idealista.application.port.secondary.AdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.idealista.application.model.AdConstant.IRRELEVANT_SCORE;

@Service
@RequiredArgsConstructor
public class FindIrrelevantAdUseCase implements FindIrrelevantAd {

    private final AdRepository adRepository;

    @Override
    public List<Ad> find() {
        return adRepository.findByScoreIsLessThan(IRRELEVANT_SCORE);
    }
}

