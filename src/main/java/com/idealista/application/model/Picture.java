package com.idealista.application.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Picture {

    Integer id;
    String url;
    String quality;

    public boolean isHD() {
        String HD_QUALITY = "HD";
        return this.quality.equals(HD_QUALITY);
    }
}
