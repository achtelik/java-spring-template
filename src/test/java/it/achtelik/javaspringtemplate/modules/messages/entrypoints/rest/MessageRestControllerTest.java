package it.achtelik.javaspringtemplate.modules.messages.entrypoints.rest;

import it.achtelik.javaspringtemplate.modules.messages.dataproviders.mongo.MessageRepositoryAdapter;
import it.achtelik.javaspringtemplate.modules.messages.domains.models.Message;
import it.achtelik.javaspringtemplate.test.basics.AbstractBaseContainerTest;
import it.achtelik.javaspringtemplate.test.testdata.MessageTestdataBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageRestControllerTest extends AbstractBaseContainerTest {

    @Autowired
    protected MessageRepositoryAdapter messageRepositoryAdapter;

    protected MessageTestdataBuilder messageTestdataBuilder = new MessageTestdataBuilder();

    @Test
    void putMessage() {
    }

    @Test
    void getMessage() {
        var savedMessage = messageRepositoryAdapter.save(messageTestdataBuilder.build()).block();

        var result = webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder.path(MessageRestController.API_PATH)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Message.class)
                .returnResult();
        Assertions.assertEquals(savedMessage.uuid(), result.getResponseBody().get(0).uuid());
        Assertions.assertEquals(1, result.getResponseBody().size());
    }
}