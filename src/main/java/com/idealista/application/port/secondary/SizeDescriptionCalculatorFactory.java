package com.idealista.application.port.secondary;

import com.idealista.application.model.Typology;
import com.idealista.application.service.scorer.sizeDescriptionCalculator.SizeDescriptionCalculator;

public interface SizeDescriptionCalculatorFactory {
    SizeDescriptionCalculator getCalculator(Typology typology);
}
