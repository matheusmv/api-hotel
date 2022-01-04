package com.github.matheusmv.apihotel.repositories;

import com.github.matheusmv.apihotel.domain.Accommodation;
import com.github.matheusmv.apihotel.domain.RoomService;
import com.github.matheusmv.apihotel.utils.builders.AccommodationBuilder;
import com.github.matheusmv.apihotel.utils.builders.RoomServiceBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Instant;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class RoomServiceRepositoryTest {

    @Autowired
    private RoomServiceRepository roomServiceRepository;

    private Accommodation accommodation;

    private RoomService roomService;
    private final Long id = 1L;
    private final String description = "food";
    private final Double cost = 80.00;
    private final Instant requestDate = Instant.now();

    @BeforeEach
    public void setUp() {
        accommodation = new AccommodationBuilder().id(id).build();
        roomService = new RoomServiceBuilder()
                .id(id)
                .description(description)
                .cost(cost)
                .requestDate(requestDate)
                .accommodation(accommodation)
                .build();
    }

    @AfterEach
    public void tearDown() {
        roomServiceRepository.deleteAll();
        roomService = null;
        accommodation = null;
    }

    @Test
    void mustNotBeNull() {
        assertNotNull(roomServiceRepository);
    }

    @Test
    void givenRoomServiceToSaveShouldReturnSavedRoomService() {
        roomServiceRepository.save(roomService);
        var savedRoomService = roomServiceRepository.findById(roomService.getId()).orElse(null);

        assertAll("test RoomServiceRepository save result",
                () -> assertNotNull(savedRoomService),
                () -> assertThat(id, is(equalTo(Objects.requireNonNull(savedRoomService).getId()))),
                () -> assertThat(description, is(equalTo(Objects.requireNonNull(savedRoomService).getDescription()))),
                () -> assertThat(cost, is(equalTo(Objects.requireNonNull(savedRoomService).getCost()))),
                () -> assertThat(requestDate, is(equalTo(Objects.requireNonNull(savedRoomService).getRequestDate())))
        );
    }
}
