package com.idealista.infrastructure.api.controller;

import com.idealista.application.model.Ad;
import com.idealista.application.port.primary.CalculateScore;
import com.idealista.application.port.primary.FindRelevantAd;
import com.idealista.application.port.primary.FindIrrelevantAd;
import com.idealista.infrastructure.api.mapper.PublicAdMapper;
import com.idealista.infrastructure.api.mapper.QualityAdMapper;
import com.idealista.infrastructure.api.model.PublicAd;
import com.idealista.infrastructure.api.model.QualityAd;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ads")
@RequiredArgsConstructor
public class AdsController {

    private final CalculateScore calculateScore;
    private final FindIrrelevantAd findIrrelevantAd;
    private final FindRelevantAd findRelevantAd;

    private final QualityAdMapper qualityAdMapper;
    private final PublicAdMapper publicAdMapper;

    @GetMapping("/quality")
    public ResponseEntity<List<QualityAd>> qualityListing() {
        List<Ad> adList = findIrrelevantAd.find();
        return ResponseEntity.ok().body(qualityAdMapper.toQuality(adList));
    }

    @GetMapping("/public")
    public ResponseEntity<List<PublicAd>> publicListing() {
        List<Ad> adList = findRelevantAd.findOrderByScoreDesc();
        return ResponseEntity.ok().body(publicAdMapper.toPublicAd(adList));
    }

    @PutMapping("/score")
    public ResponseEntity<Void> calculateScore() {
        calculateScore.calculate();
        return ResponseEntity.ok().build();
    }
}
