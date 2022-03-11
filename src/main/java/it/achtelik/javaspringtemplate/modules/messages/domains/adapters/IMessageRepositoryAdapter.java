package it.achtelik.javaspringtemplate.modules.messages.domains.adapters;

import it.achtelik.javaspringtemplate.modules.messages.domains.models.Message;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMessageRepositoryAdapter {
    Mono<Message> save(Message message);

    Flux<Message> findAll();
}
