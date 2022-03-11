package it.achtelik.javaspringtemplate.modules.messages.domains.services;

import it.achtelik.javaspringtemplate.modules.messages.domains.adapters.IMessageRepositoryAdapter;
import it.achtelik.javaspringtemplate.modules.messages.domains.models.Message;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MessageService {
    private final IMessageRepositoryAdapter messageRepositoryAdapter;

    public MessageService(IMessageRepositoryAdapter messageRepositoryAdapter) {
        this.messageRepositoryAdapter = messageRepositoryAdapter;
    }

    public Mono<Message> save(Message message) {
        return messageRepositoryAdapter.save(message);
    }

    public Flux<Message> findAll() {
        return messageRepositoryAdapter.findAll();
    }
}
