package org.example.config;

import graphql.analysis.MaxQueryComplexityInstrumentation;
import graphql.analysis.MaxQueryDepthInstrumentation;
import graphql.execution.instrumentation.ChainedInstrumentation;
import graphql.execution.instrumentation.Instrumentation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class GraphQLConfig {
    @Bean
    public Instrumentation graphQLInstrumentation() {

        return new ChainedInstrumentation(
                List.of(
                        new MaxQueryDepthInstrumentation(4),
                        new MaxQueryComplexityInstrumentation(200)
                )
        );
    }
}
