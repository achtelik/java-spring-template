package it.achtelik.javaspringtemplate.modules.messages.entrypoints.rest;

import it.achtelik.javaspringtemplate.modules.messages.domain.models.Message;
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

    public MessagePutResultDto toResultDto(Message message) {
        return new MessagePutResultDto(message.uuid());
    }
}
