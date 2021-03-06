package com.idealista.infrastructure.persistence.mapper;

import com.idealista.application.model.Ad;
import com.idealista.application.model.Typology;
import com.idealista.infrastructure.persistence.entity.AdEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.idealista.util.TestUtil.getAdEntityWithTypology;
import static com.idealista.util.TestUtil.getAdWithTypology;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AdMapperTest {

    @Mock
    private PictureMapper pictureMapper;

    @InjectMocks
    private AdMapper adMapper;

    @Test
    public void shouldMapToDomain() {
        //GIVEN
        AdEntity adEntity = getAdEntityWithTypology("CHALET");
        List<AdEntity> adEntityList = Arrays.asList(adEntity);
        Ad ad = getAdWithTypology(Typology.CHALET);
        List<Ad> expectList = Arrays.asList(ad);
        when(pictureMapper.toDomain(adEntity.getPictures())).thenReturn(Collections.emptyList());

        //WHEN
        List<Ad> adList = adMapper.toDomain(adEntityList);

        //THEN
        assertEquals(expectList, adList);
    }

    @Test
    public void shouldMapToDomainWithDefaultTypology() {
        //GIVEN
        AdEntity adEntity = getAdEntityWithTypology("df");
        List<AdEntity> adEntityList = Arrays.asList(adEntity);
        Ad ad = getAdWithTypology(Typology.DEFAULT);
        List<Ad> expectList = Arrays.asList(ad);
        when(pictureMapper.toDomain(adEntity.getPictures())).thenReturn(Collections.emptyList());

        //WHEN
        List<Ad> adList = adMapper.toDomain(adEntityList);

        //THEN
        assertEquals(expectList, adList);
    }

    @Test
    public void shouldMapToEntity() {
        //GIVEN
        AdEntity expectedAdEntity = getAdEntityWithTypology("CHALET");
        Ad ad = getAdWithTypology(Typology.CHALET);
        when(pictureMapper.toEntity(ad.getPictures())).thenReturn(Collections.emptyList());

        //WHEN
        AdEntity adEntity = adMapper.toEntity(ad);

        //THEN
        assertEquals(expectedAdEntity, adEntity);
    }

}