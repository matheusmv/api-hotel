package com.github.matheusmv.apihotel.utils.builders;

import com.github.matheusmv.apihotel.domain.Accommodation;
import com.github.matheusmv.apihotel.domain.RoomService;

import java.time.Instant;

public class RoomServiceBuilder {

    private Long id;
    private String description;
    private Double cost;
    private Instant requestDate;
    private Accommodation accommodation;

    public RoomServiceBuilder() {
        this.id = 1L;
        this.description = "undefined";
        this.cost = 50.25;
        this.requestDate = Instant.now();
        this.accommodation = new Accommodation();
    }

    public RoomServiceBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public RoomServiceBuilder description(String description) {
        this.description = description;
        return this;
    }

    public RoomServiceBuilder cost(Double cost) {
        this.cost = cost;
        return this;
    }

    public RoomServiceBuilder requestDate(Instant requestDate) {
        this.requestDate = requestDate;
        return this;
    }

    public RoomServiceBuilder accommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
        return this;
    }

    public RoomService build() {
        var roomService = new RoomService(description, cost, requestDate);

        roomService.setId(id);
        roomService.setAccommodation(accommodation);

        return roomService;
    }
}
