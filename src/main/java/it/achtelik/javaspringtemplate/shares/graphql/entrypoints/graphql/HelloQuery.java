package it.achtelik.javaspringtemplate.shares.graphql.entrypoints.graphql;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class HelloQuery implements GraphQLQueryResolver {

    public Mono<String> hello() {
        return Mono.just("Hello world");
    }
}
