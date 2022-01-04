package com.github.matheusmv.apihotel.utils.builders;

import com.github.matheusmv.apihotel.domain.Accommodation;
import com.github.matheusmv.apihotel.domain.Room;
import com.github.matheusmv.apihotel.domain.RoomService;
import com.github.matheusmv.apihotel.domain.User;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AccommodationBuilder {

    private Long id;
    private Instant checkIn;
    private Instant checkOut;
    private Set<Room> rooms;
    private List<RoomService> roomServices;
    private User user;

    public AccommodationBuilder() {
        this.id = 1L;
        this.checkIn = Instant.now();
        this.checkOut = Instant.now().plus(Duration.ofDays(7));
        this.rooms = new HashSet<>();
        this.roomServices = new ArrayList<>();
        this.user = new User();
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

    public AccommodationBuilder roomServices(List<RoomService> roomServices) {
        this.roomServices = roomServices;
        return this;
    }

    public AccommodationBuilder user(User user) {
        this.user = user;
        return this;
    }

    public Accommodation build() {
        var accommodation = new Accommodation(id, checkIn, checkOut);

        accommodation.setRooms(rooms);
        accommodation.setRoomServices(roomServices);
        accommodation.setUser(user);

        return accommodation;
    }
}
