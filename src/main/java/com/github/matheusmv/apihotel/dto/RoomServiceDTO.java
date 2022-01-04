package com.github.matheusmv.apihotel.dto;

import com.github.matheusmv.apihotel.domain.RoomService;

import java.time.Instant;

public record RoomServiceDTO(
        Long id,
        String description,
        Double cost,
        Instant requestDate
) {
    public RoomServiceDTO(RoomService roomService) {
        this(roomService.getId(), roomService.getDescription(), roomService.getCost(), roomService.getRequestDate());
    }

    public RoomService toEntity() {
        var roomService = new RoomService(description, cost, requestDate);

        roomService.setId(id);

        return roomService;
    }
}
