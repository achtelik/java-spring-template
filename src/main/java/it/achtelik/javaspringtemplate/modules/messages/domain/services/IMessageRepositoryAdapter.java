package it.achtelik.javaspringtemplate.modules.messages.domain.services;

import it.achtelik.javaspringtemplate.modules.messages.domain.models.Message;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMessageRepositoryAdapter {
    Mono<Message> save(Message message);

    Flux<Message> findAll();
}
