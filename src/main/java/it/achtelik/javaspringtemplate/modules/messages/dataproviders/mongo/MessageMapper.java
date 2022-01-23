package it.achtelik.javaspringtemplate.modules.messages.dataproviders.mongo;

import it.achtelik.javaspringtemplate.modules.messages.domain.models.Message;
import org.springframework.stereotype.Component;

@Component
class MessageMapper {

    public Message toMessage(MessageDocument document) {
        return new Message(document.uuid(), document.channel(), document.content(), document.hide(), document.createdAt(),
                document.creatorUuid(), document.creatorIp(), document.modifiedAt(), document.modifierUuid(),
                document.modifierIp());
    }

    public MessageDocument toMessageDocument(Message message) {
        return new MessageDocument(message.uuid(), message.channel(), message.content(), message.hide(), message.createdAt(),
                message.creatorUuid(), message.creatorIp(), message.modifiedAt(), message.modifierUuid(),
                message.modifierIp());
    }
}
