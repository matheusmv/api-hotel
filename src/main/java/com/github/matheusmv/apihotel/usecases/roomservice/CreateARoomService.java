package com.github.matheusmv.apihotel.usecases.roomservice;

import com.github.matheusmv.apihotel.dto.RoomServiceDTO;

import java.time.Instant;

public interface CreateARoomService {

    RoomServiceDTO execute(String description, Double cost, Instant requestDate, Long accommodationId);
}
