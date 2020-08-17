package com.idealista.infrastructure.persistence.adapter;

import com.idealista.infrastructure.persistence.entity.TopWordEntity;
import com.idealista.infrastructure.persistence.repository.TopWordRepositoryJPA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TopWordRepositoryAdapterTest {

    @Mock
    private TopWordRepositoryJPA topWordRepositoryJPA;

    @InjectMocks
    private TopWordRepositoryAdapter topWordRepositoryAdapter;

    @Test
    public void shouldReTurnTopWords() {
        //GIVEN
        String hello = "hello";
        String world = "world";
        TopWordEntity topWordEntityHello = new TopWordEntity(1, hello);
        TopWordEntity topWordEntityWorld = new TopWordEntity(2, world);
        List<String> expectedTopWordsString = Arrays.asList(hello, world);
        List<TopWordEntity> topWordEntityList = Arrays.asList(topWordEntityHello, topWordEntityWorld);
        when(topWordRepositoryJPA.findAll()).thenReturn(topWordEntityList);

        //WHEN
        List<String> topWords = topWordRepositoryAdapter.findAll();

        //THEN
        verify(topWordRepositoryJPA).findAll();
        assertEquals(expectedTopWordsString, topWords);
    }

}