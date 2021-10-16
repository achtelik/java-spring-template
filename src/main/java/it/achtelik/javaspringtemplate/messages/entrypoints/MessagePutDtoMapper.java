package it.achtelik.javaspringtemplate.messages.entrypoints;

import it.achtelik.javaspringtemplate.messages.domain.Message;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
class MessagePutDtoMapper {

    public Message toMessage(MessagePutDto dto, String userIp) {
        return new Message(UUID.randomUUID().toString(), dto.contentEncoded(), false, Instant.now(),
                "", userIp, Instant.now(), "",
                userIp);
    }
}
