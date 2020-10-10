package com.idealista.infrastructure.api.graphql;

import com.idealista.application.port.primary.FindRelevantAd;
import com.idealista.infrastructure.api.mapper.PublicAdMapper;
import com.idealista.infrastructure.api.model.PublicAd;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Transactional
public class PublicAdQuery implements GraphQLQueryResolver {

    private final FindRelevantAd findRelevantAd;
    private final PublicAdMapper publicAdMapper;

    public List<PublicAd> publicAd() {
        return publicAdMapper.toPublicAd(findRelevantAd.findOrderByScoreDesc());
    }
}
