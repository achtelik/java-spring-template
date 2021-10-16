package it.achtelik.javaspringtemplate.messages.entrypoints;

import java.time.Instant;

record MessageGetResultDto(String uuid, String contentEncoded, Instant createdAt, String creatorUuid,
                           Instant modifiedAt, String modifierUuid) {
}
