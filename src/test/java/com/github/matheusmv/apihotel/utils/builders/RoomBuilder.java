package com.github.matheusmv.apihotel.utils.builders;

import com.github.matheusmv.apihotel.domain.Accommodation;
import com.github.matheusmv.apihotel.domain.Room;
import com.github.matheusmv.apihotel.domain.enums.RoomCategory;
import com.github.matheusmv.apihotel.domain.enums.RoomStatus;

import java.util.HashSet;
import java.util.Set;

public class RoomBuilder {

    private Long id;
    private RoomCategory category;
    private RoomStatus status;
    private Double cost;
    private Set<Accommodation> accommodations;

    public RoomBuilder() {
        this.id = 1L;
        this.category = RoomCategory.STANDARD;
        this.status = RoomStatus.AVAILABLE;
        this.cost = 150.30;
        this.accommodations = new HashSet<>();
    }

    public RoomBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public RoomBuilder category(RoomCategory category) {
        this.category = category;
        return this;
    }

    public RoomBuilder status(RoomStatus status) {
        this.status = status;
        return this;
    }

    public RoomBuilder cost(Double cost) {
        this.cost = cost;
        return this;
    }

    public RoomBuilder accommodations(Set<Accommodation> accommodations) {
        this.accommodations = accommodations;
        return this;
    }

    public Room build() {
        var room = new Room(category, status, cost);

        room.setId(id);
        room.setAccommodations(accommodations);

        return room;
    }
}
