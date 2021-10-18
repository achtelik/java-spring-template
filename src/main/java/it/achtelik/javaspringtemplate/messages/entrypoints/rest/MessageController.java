package it.achtelik.javaspringtemplate.messages.entrypoints.rest;

import it.achtelik.javaspringtemplate.messages.domain.services.IMessageRepositoryAdapter;
import it.achtelik.javaspringtemplate.messages.domain.models.Message;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("messages")
public class MessageController {

    private final IMessageRepositoryAdapter messageRepositoryAdapter;
    private final MessagePutDtoMapper messagePutDtoMapper;
    private final MessageGetDtoMapper messageGetDtoMapper;

    public MessageController(IMessageRepositoryAdapter messageRepositoryAdapter, MessagePutDtoMapper messagePutDtoMapper,
                             MessageGetDtoMapper messageGetDtoMapper) {
        this.messageRepositoryAdapter = messageRepositoryAdapter;
        this.messagePutDtoMapper = messagePutDtoMapper;
        this.messageGetDtoMapper = messageGetDtoMapper;
    }

    @PutMapping()
    public Mono<MessagePutResultDto> putMessage(@RequestBody MessagePutDto messagePutDto, HttpServletRequest request) {
        Mono<Message> result = messageRepositoryAdapter.save(messagePutDtoMapper
                .toMessage(messagePutDto, request.getRemoteAddr()));
        return result.flatMap(message -> Mono.just(messagePutDtoMapper.toResultDto(message)));
    }

    @GetMapping()
    public Flux<MessageGetResultDto> getMessage() {
        Flux<Message> results = messageRepositoryAdapter.findAll();
        return results.flatMap(message -> Flux.just(messageGetDtoMapper.toResultDto(message)));
    }
}
