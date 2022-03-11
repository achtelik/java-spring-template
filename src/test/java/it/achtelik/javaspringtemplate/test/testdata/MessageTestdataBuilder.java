package it.achtelik.javaspringtemplate.test.testdata;

import it.achtelik.javaspringtemplate.modules.messages.domains.models.Message;

import java.time.Instant;
import java.util.UUID;

public class MessageTestdataBuilder {

    private String channel = "testchannel";
    private String content = "testcontent";
    private Instant createdAt = Instant.parse("2022-04-02T12:23:03Z");
    private Instant modifiedAt = Instant.parse("2022-04-02T15:23:03Z");

    public MessageTestdataBuilder setChannel(String channel) {
        this.channel = channel;
        return this;
    }

    public MessageTestdataBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    public MessageTestdataBuilder setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public MessageTestdataBuilder setModifiedAt(Instant modifiedAt) {
        this.modifiedAt = modifiedAt;
        return this;
    }

    public Message build() {
        return new Message(UUID.randomUUID().toString(), channel, content, false, createdAt, "",
                "", modifiedAt, "", "");
    }
}
