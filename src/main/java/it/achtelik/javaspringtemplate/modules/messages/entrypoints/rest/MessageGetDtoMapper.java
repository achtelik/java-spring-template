package it.achtelik.javaspringtemplate.modules.messages.entrypoints.rest;

import it.achtelik.javaspringtemplate.modules.messages.domains.models.Message;
import org.springframework.stereotype.Component;

@Component
class MessageGetDtoMapper {

    public MessageGetResultDto toResultDto(Message message) {
        return new MessageGetResultDto(message.uuid(), message.content(), message.createdAt(),
                message.creatorUuid(), message.modifiedAt(), message.modifierUuid());
    }
}
