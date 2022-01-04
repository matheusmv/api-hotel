package com.github.matheusmv.apihotel.usecases.room;

import com.github.matheusmv.apihotel.dto.RoomDTO;

public interface CreateARoom {

    RoomDTO execute(String category, String status, Double cost);
}
