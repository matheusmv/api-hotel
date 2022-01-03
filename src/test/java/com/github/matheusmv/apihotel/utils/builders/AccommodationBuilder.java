package com.github.matheusmv.apihotel.utils.builders;

import com.github.matheusmv.apihotel.domain.Accommodation;

import java.time.Duration;
import java.time.Instant;

public class AccommodationBuilder {

    private Long id;
    private Instant checkIn;
    private Instant checkOut;

    public AccommodationBuilder() {
        this.id = 1L;
        this.checkIn = Instant.now();
        this.checkOut = Instant.now().plus(Duration.ofDays(7));
    }

    public AccommodationBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public AccommodationBuilder checkIn(Instant checkIn) {
        this.checkIn = checkIn;
        return this;
    }

    public AccommodationBuilder checkOut(Instant checkOut) {
        this.checkOut = checkOut;
        return this;
    }

    public Accommodation build() {
        return new Accommodation(id, checkIn, checkOut);
    }
}
