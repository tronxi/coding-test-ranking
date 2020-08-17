package com.idealista.application.port.primary;

import com.idealista.application.model.Ad;

import java.util.List;

public interface FindRelevantAd {
    List<Ad> findOrderByScoreDesc();
}
