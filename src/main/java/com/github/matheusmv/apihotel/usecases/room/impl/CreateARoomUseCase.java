package com.github.matheusmv.apihotel.usecases.room.impl;

import com.github.matheusmv.apihotel.domain.Room;
import com.github.matheusmv.apihotel.domain.enums.RoomCategory;
import com.github.matheusmv.apihotel.domain.enums.RoomStatus;
import com.github.matheusmv.apihotel.dto.RoomDTO;
import com.github.matheusmv.apihotel.repositories.RoomRepository;
import com.github.matheusmv.apihotel.usecases.room.CreateARoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateARoomUseCase implements CreateARoom {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public RoomDTO execute(String category, String status, Double cost) {
        // TODO: validate input -> category, status, cost

        var roomCategory = RoomCategory.valueOf(category);
        var roomStatus = RoomStatus.valueOf(status);

        var newRoom = roomRepository.save(new Room(roomCategory, roomStatus, cost));

        return new RoomDTO(newRoom);
    }
}
