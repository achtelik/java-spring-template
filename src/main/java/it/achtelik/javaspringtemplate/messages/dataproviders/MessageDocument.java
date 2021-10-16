package it.achtelik.javaspringtemplate.messages.dataproviders;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
record MessageDocument(
        @Id String uuid, String contentEncoded, boolean hide,
        Instant createdAt, String creatorUuid, String creatorIp,
        Instant modifiedAt, String modifierUuid, String modifierIp) {
}

