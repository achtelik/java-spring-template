package it.achtelik.javaspringtemplate.messages.entrypoints.rest;

import it.achtelik.javaspringtemplate.messages.domain.models.Message;
import org.springframework.stereotype.Component;

@Component
class MessageGetDtoMapper {

    public MessageGetResultDto toResultDto(Message message) {
        return new MessageGetResultDto(message.uuid(), message.contentEncoded(), message.createdAt(),
                message.creatorUuid(), message.modifiedAt(), message.modifierUuid());
    }
}
