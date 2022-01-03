package com.github.matheusmv.apihotel.domain;

import com.github.matheusmv.apihotel.utils.builders.AccommodationBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.time.Duration;
import java.time.Instant;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AccommodationTest {

    @Test
    void testAccommodationDefaultInstantiation() {
        var id = 1L;
        var checkIn = Instant.now();
        var checkOut = Instant.now().plus(Duration.ofDays(2));

        var accommodation = new AccommodationBuilder()
                .id(id)
                .checkIn(checkIn)
                .checkOut(checkOut)
                .build();

        assertAll("tests for Accommodation entity",
                () -> assertDoesNotThrow((ThrowingSupplier<Accommodation>) Accommodation::new),
                () -> assertDoesNotThrow(() -> new Accommodation(id, checkIn, checkOut)),
                () -> assertThat(id, is(equalTo(accommodation.getId()))),
                () -> assertThat(checkIn, is(equalTo(accommodation.getCheckIn()))),
                () -> assertThat(checkOut, is(equalTo(accommodation.getCheckOut())))
        );
    }
}
