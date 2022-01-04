package com.github.matheusmv.apihotel.usecases.roomservice.impl;

import com.github.matheusmv.apihotel.domain.RoomService;
import com.github.matheusmv.apihotel.dto.RoomServiceDTO;
import com.github.matheusmv.apihotel.repositories.AccommodationRepository;
import com.github.matheusmv.apihotel.repositories.RoomServiceRepository;
import com.github.matheusmv.apihotel.usecases.exceptions.ResourceNotFoundException;
import com.github.matheusmv.apihotel.usecases.roomservice.CreateARoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class CreateARoomServiceUseCase implements CreateARoomService {

    private final AccommodationRepository accommodationRepository;
    private final RoomServiceRepository roomServiceRepository;

    @Autowired
    public CreateARoomServiceUseCase(
            AccommodationRepository accommodationRepository,
            RoomServiceRepository roomServiceRepository
    ) {
        this.accommodationRepository = accommodationRepository;
        this.roomServiceRepository = roomServiceRepository;
    }

    @Override
    public RoomServiceDTO execute(String description, Double cost, Instant requestDate, Long accommodationId) {
        // TODO: validate input -> description, cost, requestDate, accommodationId

        return accommodationRepository.findById(accommodationId)
                .map(accommodation -> {
                    var newRoomService = new RoomService(description, cost, requestDate);
                    newRoomService.setAccommodation(accommodation);
                    return roomServiceRepository.save(newRoomService);
                })
                .map(RoomServiceDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Accommodation with id ::%d:: not found.", accommodationId))
                );
    }
}
