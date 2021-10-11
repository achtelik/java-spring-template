package it.achtelik.javaspringtemplate.message.inadapters;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController("messages")
public class MessageController {

    @PutMapping()
    public Mono<String> putMessage(@RequestBody MessagePutDto messagePutDto) {
        return Mono.just(messagePutDto.contentEncoded());
    }
}
