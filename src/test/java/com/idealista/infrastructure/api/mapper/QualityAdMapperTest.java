package com.idealista.infrastructure.api.mapper;

import com.idealista.application.model.Ad;
import com.idealista.application.model.Typology;
import com.idealista.infrastructure.api.model.QualityAd;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.idealista.util.TestUtil.getAdWithTypology;
import static com.idealista.util.TestUtil.getQualityAdWithTypology;
import static org.junit.Assert.assertEquals;

public class QualityAdMapperTest {

    private final QualityAdMapper  qualityAdMapper = new QualityAdMapper();

    @Test
    public void shouldMapToQuality() {
        //GIVEN
        Ad ad = getAdWithTypology(Typology.CHALET);
        QualityAd qualityAd = getQualityAdWithTypology("CHALET");
        List<Ad> adList = Arrays.asList(ad);
        List<QualityAd> expectedQualityAdList = Arrays.asList(qualityAd);

        //WHEN
        List<QualityAd> qualityAdList = qualityAdMapper.toQuality(adList);

        //THEN
        assertEquals(expectedQualityAdList, qualityAdList);
    }

}