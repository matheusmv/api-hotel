package com.github.matheusmv.apihotel.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class RoomServiceRepositoryTest {

    @Autowired
    private RoomServiceRepository roomServiceRepository;

    @Test
    void mustNotBeNull() {
        assertNotNull(roomServiceRepository);
    }
}
