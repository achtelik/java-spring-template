package it.achtelik.javaspringtemplate.messages.inadapters;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("messages")
public class MessageController {

    @PutMapping()
    public Mono<String> putMessage(@RequestBody MessagePutDto messagePutDto) {
        return Mono.just(messagePutDto.contentEncoded());
    }
}
