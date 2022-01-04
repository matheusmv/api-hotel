package com.github.matheusmv.apihotel.repositories;

import com.github.matheusmv.apihotel.domain.RoomService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomServiceRepository extends JpaRepository<RoomService, Long> {

}
