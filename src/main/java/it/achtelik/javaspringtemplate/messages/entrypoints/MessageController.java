package it.achtelik.javaspringtemplate.messages.entrypoints;

import it.achtelik.javaspringtemplate.messages.dataproviders.MessageRepositoryAdapter;
import it.achtelik.javaspringtemplate.messages.domain.Message;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("messages")
public class MessageController {

    private final MessageRepositoryAdapter messageRepositoryAdapter;
    private final MessagePutDtoMapper messagePutDtoMapper;

    public MessageController(MessageRepositoryAdapter messageRepositoryAdapter, MessagePutDtoMapper messagePutDtoMapper) {
        this.messageRepositoryAdapter = messageRepositoryAdapter;
        this.messagePutDtoMapper = messagePutDtoMapper;
    }

    @PutMapping()
    public Mono<Message> putMessage(@RequestBody MessagePutDto messagePutDto, HttpServletRequest request) {
        return messageRepositoryAdapter.save(messagePutDtoMapper.toMessage(messagePutDto, request.getRemoteAddr()));
    }

    @GetMapping()
    public Flux<Message> getMessage() {
        return messageRepositoryAdapter.findAll();
    }
}
