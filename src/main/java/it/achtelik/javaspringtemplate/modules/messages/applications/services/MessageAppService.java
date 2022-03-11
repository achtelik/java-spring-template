package it.achtelik.javaspringtemplate.modules.messages.applications.services;

import it.achtelik.javaspringtemplate.modules.messages.domains.adapters.IMessageRepositoryAdapter;
import it.achtelik.javaspringtemplate.modules.messages.domains.services.MessageService;
import it.achtelik.javaspringtemplate.modules.messages.domains.services.MessageValidator;
import org.springframework.stereotype.Service;

@Service
public class MessageAppService extends MessageService {
    public MessageAppService(IMessageRepositoryAdapter messageRepositoryAdapter, MessageValidator messageValidator) {
        super(messageRepositoryAdapter, messageValidator);
    }
}
