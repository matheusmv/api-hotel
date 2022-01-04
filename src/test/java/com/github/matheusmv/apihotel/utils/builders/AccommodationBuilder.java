package com.github.matheusmv.apihotel.utils.builders;

import com.github.matheusmv.apihotel.domain.Accommodation;
import com.github.matheusmv.apihotel.domain.Room;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class AccommodationBuilder {

    private Long id;
    private Instant checkIn;
    private Instant checkOut;
    private Set<Room> rooms;

    public AccommodationBuilder() {
        this.id = 1L;
        this.checkIn = Instant.now();
        this.checkOut = Instant.now().plus(Duration.ofDays(7));
        this.rooms = new HashSet<>();
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

    public AccommodationBuilder rooms(Set<Room> rooms) {
        this.rooms = rooms;
        return this;
    }

    public Accommodation build() {
        var accommodation = new Accommodation(id, checkIn, checkOut);

        accommodation.setRooms(rooms);

        return accommodation;
    }
}
