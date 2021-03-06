package it.achtelik.javaspringtemplate.modules.messages.dataproviders.mongo;

import it.achtelik.javaspringtemplate.modules.messages.domains.adapters.IMessageRepositoryAdapter;
import it.achtelik.javaspringtemplate.modules.messages.domains.models.Message;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MessageRepositoryAdapter implements IMessageRepositoryAdapter {
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public MessageRepositoryAdapter(MessageRepository messageRepository, MessageMapper messageMapper) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
    }

    public Mono<Message> save(Message message) {
        return messageRepository.save(messageMapper.toMessageDocument(message))
                .flatMap(messageDocument -> Mono.just(messageMapper.toMessage(messageDocument)));
    }

    public Flux<Message> findAll() {
        return messageRepository.findAll().flatMap(messageDocument -> Flux.just(messageMapper.toMessage(messageDocument)));
    }
}
