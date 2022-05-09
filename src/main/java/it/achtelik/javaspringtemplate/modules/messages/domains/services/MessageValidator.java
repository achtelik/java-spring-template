package it.achtelik.javaspringtemplate.modules.messages.domains.services;

import it.achtelik.javaspringtemplate.modules.messages.domains.models.Message;
import it.achtelik.javaspringtemplate.shares.exceptionhandling.domains.models.ApplicationClientException;
import org.apache.commons.lang3.StringUtils;

public class MessageValidator {
    public void validate(Message message) {
        if (StringUtils.isEmpty(message.content())) {
            throw new ApplicationClientException("An empty message content isn't allowed!");
        }
        if (StringUtils.isEmpty(message.channel())) {
            throw new ApplicationClientException("An empty message channel isn't allowed!");
        }
    }
}
