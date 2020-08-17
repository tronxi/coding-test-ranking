package com.idealista.application.port.secondary;

import com.idealista.application.model.Ad;

import java.util.List;

public interface AdRepository {
    List<Ad> findAll();

    List<Ad> findByScoreIsGreaterThanEqualOrderByScoreDesc(Integer irrelevantScore);

    List<Ad> findByScoreIsLessThan(Integer irrelevantScore);

    void update(Ad ad);
}
