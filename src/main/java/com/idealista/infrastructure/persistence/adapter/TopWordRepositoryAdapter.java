package com.idealista.infrastructure.persistence.adapter;

import com.idealista.application.port.secondary.TopWordRepository;
import com.idealista.infrastructure.persistence.entity.TopWordEntity;
import com.idealista.infrastructure.persistence.repository.TopWordRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TopWordRepositoryAdapter implements TopWordRepository {

    private final TopWordRepositoryJPA topWordRepositoryJPA;

    @Override
    public List<String> findAll() {
        return topWordRepositoryJPA.findAll()
                .stream()
                .map(TopWordEntity::getWord)
                .collect(Collectors.toList());
    }
}
