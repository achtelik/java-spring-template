package it.achtelik.javaspringtemplate.commons.time.domain.services;

import java.time.Instant;

public class TimeService {

    public Instant now() {
        return Instant.now();
    }
}
