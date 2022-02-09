package it.achtelik.javaspringtemplate.modules.messages.entrypoints.rest;

import it.achtelik.javaspringtemplate.modules.messages.adapters.IMessageRepositoryAdapter;
import it.achtelik.javaspringtemplate.modules.messages.domain.models.Message;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/v1/messages")
public class MessageRestController {

    private final IMessageRepositoryAdapter messageRepositoryAdapter;
    private final MessagePutDtoMapper messagePutDtoMapper;
    private final MessageGetDtoMapper messageGetDtoMapper;

    public MessageRestController(IMessageRepositoryAdapter messageRepositoryAdapter, MessagePutDtoMapper messagePutDtoMapper,
                                 MessageGetDtoMapper messageGetDtoMapper) {
        this.messageRepositoryAdapter = messageRepositoryAdapter;
        this.messagePutDtoMapper = messagePutDtoMapper;
        this.messageGetDtoMapper = messageGetDtoMapper;
    }

    @PutMapping()
    public Mono<MessagePutResultDto> putMessage(@RequestBody MessagePutDto messagePutDto, ServerHttpRequest request) {
        Mono<Message> result = messageRepositoryAdapter.save(messagePutDtoMapper
                .toMessage(messagePutDto, request.getRemoteAddress().getHostString()));
        return result.flatMap(message -> Mono.just(messagePutDtoMapper.toResultDto(message)));
    }

    @GetMapping()
    public Flux<MessageGetResultDto> getMessage() {
        Flux<Message> results = messageRepositoryAdapter.findAll();
        return results.flatMap(message -> Flux.just(messageGetDtoMapper.toResultDto(message)));
    }
}
