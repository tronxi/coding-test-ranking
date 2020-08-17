package com.idealista.infrastructure.persistence.mapper;

import com.idealista.application.model.Picture;
import com.idealista.infrastructure.persistence.entity.PictureEntity;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.idealista.util.TestUtil.getPicture;
import static com.idealista.util.TestUtil.getPictureEntity;
import static org.junit.Assert.*;

public class PictureMapperTest {

    private final PictureMapper pictureMapper = new PictureMapper();

    @Test
    public void shouldMapToDomain() {
        //GIVEN
        PictureEntity pictureEntity = getPictureEntity();
        Picture picture = getPicture();
        List<Picture> expectedPictureList = Arrays.asList(picture);
        List<PictureEntity> pictureEntityList = Arrays.asList(pictureEntity);

        //WHEN
        List<Picture> pictureList = pictureMapper.toDomain(pictureEntityList);

        //THEN
        assertEquals(expectedPictureList, pictureList);
    }

    @Test
    public void shouldMapToEntity() {
        //GIVEN
        PictureEntity pictureEntity = getPictureEntity();
        Picture picture = getPicture();
        List<Picture> pictureList = Arrays.asList(picture);
        List<PictureEntity> expectedPictureEntityList = Arrays.asList(pictureEntity);

        //WHEN
        List<PictureEntity> pictureEntityList = pictureMapper.toEntity(pictureList);

        //THEN
        assertEquals(expectedPictureEntityList, pictureEntityList);
    }

}