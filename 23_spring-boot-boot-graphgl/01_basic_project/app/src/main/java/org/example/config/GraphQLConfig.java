package org.example.config;

import graphql.analysis.MaxQueryDepthInstrumentation;
import graphql.execution.instrumentation.Instrumentation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GraphQLConfig {
    @Bean
    public Instrumentation instrumentation() {
        return new MaxQueryDepthInstrumentation(3);
    }
}
