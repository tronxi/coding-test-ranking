package com.idealista.infrastructure.api.graphql;

import com.idealista.application.port.primary.CalculateScore;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;

@Controller
@RequiredArgsConstructor
@Transactional
public class PublicAdMutation implements GraphQLMutationResolver {

    private final CalculateScore calculateScore;

    public void calculate() {
        this.calculateScore.calculate();
    }
}
