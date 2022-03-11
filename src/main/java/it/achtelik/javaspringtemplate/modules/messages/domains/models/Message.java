package it.achtelik.javaspringtemplate.modules.messages.domains.models;

import java.time.Instant;

public record Message(String uuid, String channel, String content, boolean hide,
                      Instant createdAt, String creatorUuid, String creatorIp,
                      Instant modifiedAt, String modifierUuid, String modifierIp) {
}
