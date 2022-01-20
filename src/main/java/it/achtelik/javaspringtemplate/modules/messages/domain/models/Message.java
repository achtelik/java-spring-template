package it.achtelik.javaspringtemplate.modules.messages.domain.models;

import java.time.Instant;

public record Message(String uuid, String contentEncoded, boolean hide,
                      Instant createdAt, String creatorUuid, String creatorIp,
                      Instant modifiedAt, String modifierUuid, String modifierIp) {
}