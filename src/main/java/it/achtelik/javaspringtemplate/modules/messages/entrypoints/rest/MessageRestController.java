package it.achtelik.javaspringtemplate.modules.messages.entrypoints.rest;

import it.achtelik.javaspringtemplate.modules.messages.applications.services.MessageAppService;
import it.achtelik.javaspringtemplate.modules.messages.domains.adapters.IMessageRepositoryAdapter;
import it.achtelik.javaspringtemplate.modules.messages.domains.models.Message;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/v1/messages")
public class MessageRestController {

    private final MessageAppService messageAppService;
    private final MessagePutDtoMapper messagePutDtoMapper;
    private final MessageGetDtoMapper messageGetDtoMapper;

    public MessageRestController(MessageAppService messageAppService, MessagePutDtoMapper messagePutDtoMapper,
                                 MessageGetDtoMapper messageGetDtoMapper) {
        this.messageAppService = messageAppService;
        this.messagePutDtoMapper = messagePutDtoMapper;
        this.messageGetDtoMapper = messageGetDtoMapper;
    }

    @PutMapping()
    public Mono<MessagePutResultDto> putMessage(@RequestBody MessagePutDto messagePutDto, ServerHttpRequest request) {
        Mono<Message> result = messageAppService.save(messagePutDtoMapper
                .toMessage(messagePutDto, request.getRemoteAddress().getHostString()));
        return result.flatMap(message -> Mono.just(messagePutDtoMapper.toResultDto(message)));
    }

    @GetMapping()
    public Flux<MessageGetResultDto> getMessage() {
        Flux<Message> results = messageAppService.findAll();
        return results.flatMap(message -> Flux.just(messageGetDtoMapper.toResultDto(message)));
    }
}
