package it.achtelik.javaspringtemplate.modules.messages.entrypoints.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import it.achtelik.javaspringtemplate.modules.messages.applications.services.MessageAppService;
import it.achtelik.javaspringtemplate.modules.messages.domains.models.Message;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;


@RestController
@RequestMapping(MessageRestController.API_PATH)
public class MessageRestController {
    public static final String API_PATH = "/v1/messages";

    private final MessageAppService messageAppService;
    private final MessagePutDtoMapper messagePutDtoMapper;
    private final MessageGetDtoMapper messageGetDtoMapper;

    public MessageRestController(MessageAppService messageAppService, MessagePutDtoMapper messagePutDtoMapper,
                                 MessageGetDtoMapper messageGetDtoMapper) {
        this.messageAppService = messageAppService;
        this.messagePutDtoMapper = messagePutDtoMapper;
        this.messageGetDtoMapper = messageGetDtoMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Create a new message.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Message created.",
                            content = @Content(schema = @Schema(implementation = MessagePutResultDto.class)))}
    )
    public Mono<MessagePutResultDto> putMessage(@RequestBody MessagePutDto messagePutDto, ServerHttpRequest request) {
        Mono<Message> result = messageAppService.create(messagePutDtoMapper
                .toMessage(messagePutDto, request.getRemoteAddress().getHostString()));
        return result.flatMap(message -> Mono.just(messagePutDtoMapper.toResultDto(message)));
    }

    @GetMapping()
    @Operation(summary = "Load messages by parameters.", description = "This is the super feature search for messages.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Message created.",
                            content = @Content(schema = @Schema(implementation = MessageGetResultDto.class)))}
    )
    public Flux<MessageGetResultDto> getMessage(@RequestParam(required = false) String channel,
                                                @RequestParam(required = false) String content,
                                                @RequestParam(required = false) Instant createdAtMin,
                                                @RequestParam(required = false) Instant createdAtMax,
                                                @RequestParam(required = false, defaultValue = "0") String offset,
                                                @RequestParam(required = false, defaultValue = "10") Integer limit,
                                                @RequestParam(required = false) String sort) {
        Flux<Message> results = messageAppService.findAll();
        return results.flatMap(message -> Flux.just(messageGetDtoMapper.toResultDto(message)));
    }
}
