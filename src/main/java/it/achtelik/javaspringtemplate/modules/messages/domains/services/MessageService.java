package it.achtelik.javaspringtemplate.modules.messages.domains.services;

import it.achtelik.javaspringtemplate.modules.messages.domains.adapters.IMessageRepositoryAdapter;
import it.achtelik.javaspringtemplate.modules.messages.domains.models.Message;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MessageService {
    private final IMessageRepositoryAdapter messageRepositoryAdapter;
    private final MessageValidator messageValidator;

    public MessageService(IMessageRepositoryAdapter messageRepositoryAdapter, MessageValidator messageValidator) {
        this.messageRepositoryAdapter = messageRepositoryAdapter;
        this.messageValidator = messageValidator;
    }

    public Mono<Message> create(Message message) {
        messageValidator.validate(message);
        return messageRepositoryAdapter.save(message);
    }

    public Flux<Message> findAll() {
        return messageRepositoryAdapter.findAll();
    }
}
