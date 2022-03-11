package it.achtelik.javaspringtemplate.shares.time.domains.services;

import java.time.Instant;

public class TimeService {

    public Instant now() {
        return Instant.now();
    }
}
