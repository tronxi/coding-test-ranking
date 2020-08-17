package com.idealista.application.port.secondary;

import java.util.List;

public interface TopWordRepository {

    List<String> findAll();
}
