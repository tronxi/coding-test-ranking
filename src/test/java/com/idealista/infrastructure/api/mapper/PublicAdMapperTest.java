package com.idealista.infrastructure.api.mapper;

import com.idealista.application.model.Ad;
import com.idealista.application.model.Typology;
import com.idealista.infrastructure.api.model.PublicAd;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.idealista.util.TestUtil.getAdWithTypology;
import static com.idealista.util.TestUtil.getPublicAdWithTypology;
import static org.junit.Assert.*;

public class PublicAdMapperTest {

    private final PublicAdMapper publicAdMapper = new PublicAdMapper();

    @Test
    public void shouldMapToPublicAd() {
        //GIVEN
        Ad ad = getAdWithTypology(Typology.CHALET);
        PublicAd publicAd = getPublicAdWithTypology("CHALET");
        List<Ad> adList = Arrays.asList(ad);
        List<PublicAd> expectedPublicAdList = Arrays.asList(publicAd);

        //WHEN
        List<PublicAd> publicAdList = publicAdMapper.toPublicAd(adList);

        //THEN
        assertEquals(expectedPublicAdList, publicAdList);
    }

}