package it.achtelik.javaspringtemplate.shares.graphql.applications.services;

import graphql.schema.DataFetchingEnvironment;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class GraphQLSubscriptionResolver implements graphql.kickstart.tools.GraphQLSubscriptionResolver {
    Publisher<Integer> hello(DataFetchingEnvironment env) {
        return Flux.range(0, 100).delayElements(Duration.ofSeconds(1));
    }
}

