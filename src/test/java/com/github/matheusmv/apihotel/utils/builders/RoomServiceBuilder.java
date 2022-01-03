package com.github.matheusmv.apihotel.utils.builders;

import com.github.matheusmv.apihotel.domain.RoomService;

import java.time.Instant;

public class RoomServiceBuilder {

    private Long id;
    private String description;
    private Double cost;
    private Instant requestDate;

    public RoomServiceBuilder() {
        this.id = 1L;
        this.description = "undefined";
        this.cost = 50.25;
        this.requestDate = Instant.now();
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

    public RoomService build() {
        return new RoomService(id, description, cost, requestDate);
    }
}
