package it.achtelik.javaspringtemplate.modules.messages.entrypoints.rest;

import it.achtelik.javaspringtemplate.shares.time.domains.services.TimeService;
import it.achtelik.javaspringtemplate.modules.messages.domains.models.Message;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
class MessagePutDtoMapper {

    private final TimeService timeService;

    public MessagePutDtoMapper(TimeService timeService) {
        this.timeService = timeService;
    }

    public Message toMessage(MessagePutDto dto, String userIp) {
        var cleanedChannel = StringUtils.isNotEmpty(dto.channel()) ? Jsoup.clean(dto.channel(), Safelist.none()) : "";
        //var cleanedContent = StringUtils.isNotEmpty(dto.content()) ? Jsoup.clean(dto.content(), Safelist.none()) : "";
        return new Message(UUID.randomUUID().toString(), cleanedChannel, dto.content(),
                false, timeService.now(),
                "", userIp, Instant.now(), "",
                userIp);
    }

    public MessagePutResultDto toResultDto(Message message) {
        return new MessagePutResultDto(message.uuid());
    }
}
