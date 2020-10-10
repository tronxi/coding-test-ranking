package com.idealista.infrastructure.api.graphql;

import com.idealista.application.port.primary.FindIrrelevantAd;
import com.idealista.infrastructure.api.mapper.QualityAdMapper;
import com.idealista.infrastructure.api.model.QualityAd;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Transactional
public class QualityAdQuality implements GraphQLQueryResolver {

    private final FindIrrelevantAd findIrrelevantAd;
    private final QualityAdMapper qualityAdMapper;


    public List<QualityAd> qualityAd() {
        return qualityAdMapper.toQuality(findIrrelevantAd.find());
    }
}
