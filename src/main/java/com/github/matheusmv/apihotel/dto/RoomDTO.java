package com.github.matheusmv.apihotel.dto;

import com.github.matheusmv.apihotel.domain.Room;
import com.github.matheusmv.apihotel.domain.enums.RoomCategory;
import com.github.matheusmv.apihotel.domain.enums.RoomStatus;

public record RoomDTO(
        Long id,
        RoomCategory category,
        RoomStatus status,
        Double cost
) {
    public RoomDTO(Room room) {
        this(room.getId(), room.getCategory(), room.getStatus(), room.getCost());
    }

    public Room toEntity() {
        var room = new Room(category, status, cost);

        room.setId(id);

        return room;
    }
}
