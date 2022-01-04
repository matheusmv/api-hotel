package com.github.matheusmv.apihotel.usecases.room;

import com.github.matheusmv.apihotel.domain.Room;
import com.github.matheusmv.apihotel.domain.enums.RoomCategory;
import com.github.matheusmv.apihotel.domain.enums.RoomStatus;
import com.github.matheusmv.apihotel.repositories.RoomRepository;
import com.github.matheusmv.apihotel.usecases.room.impl.CreateARoomUseCase;
import com.github.matheusmv.apihotel.utils.builders.RoomBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateARoomUseCaseTest {

    @Mock
    private RoomRepository roomRepository;

    @Autowired
    @InjectMocks
    private CreateARoomUseCase createARoomUseCase;

    private Room room;
    private final Long id = 1L;
    private final String category = "STANDARD";
    private final String status = "AVAILABLE";
    private final Double cost = 80.00;

    @BeforeEach
    void setUp() {
        room = new RoomBuilder()
                .id(id)
                .category(RoomCategory.valueOf(category))
                .status(RoomStatus.valueOf(status))
                .cost(cost)
                .build();
    }

    @AfterEach
    public void tearDown() {
        room = null;
    }

    @Test
    void givenRoomToSaveShouldReturnSavedRoom() {
        when(roomRepository.save(any())).thenReturn(room);
        var newRoomDTO = createARoomUseCase.execute(category, status, cost);

        verify(roomRepository, times(1)).save(any());
        assertAll("test Room Creation",
                () -> assertNotNull(newRoomDTO),
                () -> assertThat(id, is(equalTo(newRoomDTO.id()))),
                () -> assertThat(RoomCategory.valueOf(category), is(equalTo(newRoomDTO.category()))),
                () -> assertThat(RoomStatus.valueOf(status), is(equalTo(newRoomDTO.status()))),
                () -> assertThat(cost, is(equalTo(newRoomDTO.cost())))
        );
    }
}
