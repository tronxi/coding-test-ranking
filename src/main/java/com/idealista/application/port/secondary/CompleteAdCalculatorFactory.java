package com.idealista.application.port.secondary;

import com.idealista.application.model.Typology;
import com.idealista.application.service.scorer.completeAdCalculator.CompleteAdCalculator;

public interface CompleteAdCalculatorFactory {
    CompleteAdCalculator getCalculator(Typology typology);
}
