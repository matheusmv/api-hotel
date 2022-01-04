package com.github.matheusmv.apihotel.domain;

import com.github.matheusmv.apihotel.domain.enums.RoomCategory;
import com.github.matheusmv.apihotel.domain.enums.RoomStatus;
import com.github.matheusmv.apihotel.utils.builders.AccommodationBuilder;
import com.github.matheusmv.apihotel.utils.builders.RoomBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RoomTest {

    @Test
    void testRoomDefaultInstantiation() {
        var id = 1L;
        var category = RoomCategory.STANDARD;
        var status = RoomStatus.AVAILABLE;
        var cost = 170.00;
        var accommodations = Set.of(
                new AccommodationBuilder().id(1L).build(),
                new AccommodationBuilder().id(2L).build()
        );

        var room = new RoomBuilder()
                .id(id)
                .category(category)
                .status(status)
                .cost(cost)
                .accommodations(accommodations)
                .build();

        assertAll("tests for Room entity",
                () -> assertDoesNotThrow((ThrowingSupplier<Room>) Room::new),
                () -> assertDoesNotThrow(() -> new Room(id, category, status, cost).setAccommodations(accommodations)),
                () -> assertThat(id, is(equalTo(room.getId()))),
                () -> assertThat(category, is(equalTo(room.getCategory()))),
                () -> assertThat(status, is(equalTo(room.getStatus()))),
                () -> assertThat(cost, is(equalTo(room.getCost()))),
                () -> assertThat(accommodations, is(equalTo(room.getAccommodations())))
        );
    }
}
