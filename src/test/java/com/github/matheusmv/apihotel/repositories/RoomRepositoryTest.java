package com.github.matheusmv.apihotel.repositories;

import com.github.matheusmv.apihotel.domain.Room;
import com.github.matheusmv.apihotel.domain.enums.RoomCategory;
import com.github.matheusmv.apihotel.domain.enums.RoomStatus;
import com.github.matheusmv.apihotel.utils.builders.RoomBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class RoomRepositoryTest {

    @Autowired
    private RoomRepository roomRepository;

    private Room room;
    private final Long id = 1L;
    private final RoomCategory category = RoomCategory.STANDARD;
    private final RoomStatus status = RoomStatus.AVAILABLE;
    private final Double cost = 80.00;

    @BeforeEach
    public void setUp() {
        room = new RoomBuilder()
                .id(id)
                .category(category)
                .status(status)
                .cost(cost)
                .build();
    }

    @AfterEach
    public void tearDown() {
        roomRepository.deleteAll();
        room = null;
    }

    @Test
    void mustNotBeNull() {
        assertNotNull(roomRepository);
    }

    @Test
    void givenRoomToSaveShouldReturnSavedRoom() {
        roomRepository.save(room);
        var savedRoom = roomRepository.findById(room.getId()).orElse(null);

        assertAll("test RoomRepository save result",
                () -> assertNotNull(savedRoom),
                () -> assertThat(id, is(equalTo(Objects.requireNonNull(savedRoom).getId()))),
                () -> assertThat(category, is(equalTo(Objects.requireNonNull(savedRoom).getCategory()))),
                () -> assertThat(status, is(equalTo(Objects.requireNonNull(savedRoom).getStatus()))),
                () -> assertThat(cost, is(equalTo(Objects.requireNonNull(savedRoom).getCost())))
        );
    }
}
