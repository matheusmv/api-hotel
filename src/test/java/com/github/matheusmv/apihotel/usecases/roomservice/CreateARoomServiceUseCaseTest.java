package com.github.matheusmv.apihotel.usecases.roomservice;

import com.github.matheusmv.apihotel.domain.Accommodation;
import com.github.matheusmv.apihotel.domain.RoomService;
import com.github.matheusmv.apihotel.repositories.AccommodationRepository;
import com.github.matheusmv.apihotel.repositories.RoomServiceRepository;
import com.github.matheusmv.apihotel.usecases.exceptions.ResourceNotFoundException;
import com.github.matheusmv.apihotel.usecases.roomservice.impl.CreateARoomServiceUseCase;
import com.github.matheusmv.apihotel.utils.builders.AccommodationBuilder;
import com.github.matheusmv.apihotel.utils.builders.RoomServiceBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateARoomServiceUseCaseTest {

    @Mock
    private AccommodationRepository accommodationRepository;
    @Mock
    private RoomServiceRepository roomServiceRepository;

    @Autowired
    @InjectMocks
    private CreateARoomServiceUseCase createARoomServiceUseCase;

    private Accommodation accommodation;

    private RoomService roomService;
    private final Long INVALID_ID = 100L;
    private final Long id = 1L;
    private final String description = "food";
    private final Double cost = 80.00;
    private final Instant requestDate = Instant.now();

    @BeforeEach
    void setUp() {
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
        roomService = null;
        accommodation = null;
    }

    @Test
    void givenRoomServiceToSaveShouldReturnSavedRoomService() {
        when(accommodationRepository.findById(any())).thenReturn(Optional.ofNullable(accommodation));
        when(roomServiceRepository.save(any())).thenReturn(roomService);
        var newRoomServiceDTO = createARoomServiceUseCase.execute(description, cost, requestDate, id);

        verify(accommodationRepository, times(1)).findById(any());
        verify(roomServiceRepository, times(1)).save(any());
        assertAll("test RoomService Creation",
                () -> assertNotNull(newRoomServiceDTO),
                () -> assertThat(id, is(equalTo(newRoomServiceDTO.id()))),
                () -> assertThat(description, is(equalTo(newRoomServiceDTO.description()))),
                () -> assertThat(cost, is(equalTo(newRoomServiceDTO.cost()))),
                () -> assertThat(requestDate, is(equalTo(newRoomServiceDTO.requestDate())))
        );
    }

    @Test
    void givenRoomServiceWithInvalidAccommodationIdToSaveShouldThrowResourceNotFoundException() {
        when(accommodationRepository.findById(INVALID_ID)).thenReturn(Optional.empty());
        assertThrows(
                ResourceNotFoundException.class,
                () -> createARoomServiceUseCase.execute(description, cost, requestDate, INVALID_ID)
        );
    }
}
