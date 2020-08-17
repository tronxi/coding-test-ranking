package com.idealista.infrastructure.api.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class PublicAd {

    private Integer id;
    private String typology;
    private String description;
    private List<String> pictureUrls;
    private Integer houseSize;
    private Integer gardenSize;

}
