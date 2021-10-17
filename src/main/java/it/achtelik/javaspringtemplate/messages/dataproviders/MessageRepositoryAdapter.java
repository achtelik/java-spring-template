package it.achtelik.javaspringtemplate.messages.dataproviders;

import it.achtelik.javaspringtemplate.messages.domain.Message;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MessageRepositoryAdapter {
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
