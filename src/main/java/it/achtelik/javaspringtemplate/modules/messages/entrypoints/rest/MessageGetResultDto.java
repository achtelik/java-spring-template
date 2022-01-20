package it.achtelik.javaspringtemplate.modules.messages.entrypoints.rest;

import java.time.Instant;

record MessageGetResultDto(String uuid, String contentEncoded, Instant createdAt, String creatorUuid,
                           Instant modifiedAt, String modifierUuid) {
}
