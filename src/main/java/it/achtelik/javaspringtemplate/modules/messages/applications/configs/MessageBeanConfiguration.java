package it.achtelik.javaspringtemplate.modules.messages.applications.configs;

import it.achtelik.javaspringtemplate.modules.messages.domains.services.MessageValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageBeanConfiguration {

    @Bean
    public MessageValidator messageValidator() {
        return new MessageValidator();
    }
}
