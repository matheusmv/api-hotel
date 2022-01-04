package com.github.matheusmv.apihotel.domain;

import com.github.matheusmv.apihotel.utils.builders.AccommodationBuilder;
import com.github.matheusmv.apihotel.utils.builders.RoomServiceBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.time.Instant;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RoomServiceTest {

    @Test
    void testRoomServiceDefaultInstantiation() {
        var id = 1L;
        var description = "food";
        var cost = 30.0;
        var requestDate = Instant.now();
        var accommodation = new AccommodationBuilder().build();

        var roomService = new RoomServiceBuilder()
                .id(id)
                .description(description)
                .cost(cost)
                .requestDate(requestDate)
                .accommodation(accommodation)
                .build();

        assertAll("tests for RoomService entity",
                () -> assertDoesNotThrow((ThrowingSupplier<RoomService>) RoomService::new),
                () -> assertDoesNotThrow(() -> {
                    var rs = new RoomService(id, description, cost, requestDate);
                    rs.setAccommodation(accommodation);
                }),
                () -> assertThat(id, is(equalTo(roomService.getId()))),
                () -> assertThat(description, is(equalTo(roomService.getDescription()))),
                () -> assertThat(cost, is(equalTo(roomService.getCost()))),
                () -> assertThat(requestDate, is(equalTo(roomService.getRequestDate()))),
                () -> assertThat(accommodation, is(equalTo(roomService.getAccommodation())))
        );
    }
}
