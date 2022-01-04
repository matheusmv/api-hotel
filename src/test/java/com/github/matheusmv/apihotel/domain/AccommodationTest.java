package com.github.matheusmv.apihotel.domain;

import com.github.matheusmv.apihotel.domain.enums.AccommodationStatus;
import com.github.matheusmv.apihotel.domain.enums.RoomCategory;
import com.github.matheusmv.apihotel.domain.enums.RoomStatus;
import com.github.matheusmv.apihotel.utils.builders.AccommodationBuilder;
import com.github.matheusmv.apihotel.utils.builders.RoomBuilder;
import com.github.matheusmv.apihotel.utils.builders.RoomServiceBuilder;
import com.github.matheusmv.apihotel.utils.builders.UserBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AccommodationTest {

    @Test
    void testAccommodationDefaultInstantiation() {
        var id = 1L;
        var status = AccommodationStatus.CONFIRMED;
        var checkIn = Instant.now();
        var checkOut = Instant.now().plus(Duration.ofDays(2));
        var rooms = Set.of(
                new RoomBuilder().id(1L).category(RoomCategory.STANDARD).status(RoomStatus.AVAILABLE).cost(100.00).build(),
                new RoomBuilder().id(2L).category(RoomCategory.STANDARD).status(RoomStatus.AVAILABLE).cost(90.00).build()
        );
        var roomServices = List.of(
                new RoomServiceBuilder().id(1L).description("food").cost(25.0).build()
        );
        var user = new UserBuilder().build();

        var accommodation = new AccommodationBuilder()
                .id(id)
                .status(status)
                .checkIn(checkIn)
                .checkOut(checkOut)
                .rooms(rooms)
                .roomServices(roomServices)
                .user(user)
                .build();

        assertAll("tests for Accommodation entity",
                () -> assertDoesNotThrow((ThrowingSupplier<Accommodation>) Accommodation::new),
                () -> assertDoesNotThrow(() -> {
                    var acc = new Accommodation(status, checkIn, checkOut);
                    acc.setId(id);
                    acc.getRooms().addAll(rooms);
                    acc.getRoomServices().addAll(roomServices);
                    acc.setUser(user);
                }),
                () -> assertThat(id, is(equalTo(accommodation.getId()))),
                () -> assertThat(status, is(equalTo(accommodation.getStatus()))),
                () -> assertThat(checkIn, is(equalTo(accommodation.getCheckIn()))),
                () -> assertThat(checkOut, is(equalTo(accommodation.getCheckOut()))),
                () -> assertThat(rooms, is(equalTo(accommodation.getRooms()))),
                () -> assertThat(roomServices, is(equalTo(accommodation.getRoomServices()))),
                () -> assertThat(user, is(equalTo(accommodation.getUser())))
        );
    }
}
