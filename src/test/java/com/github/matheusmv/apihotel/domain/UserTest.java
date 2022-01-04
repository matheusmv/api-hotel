package com.github.matheusmv.apihotel.domain;

import com.github.matheusmv.apihotel.utils.builders.AccommodationBuilder;
import com.github.matheusmv.apihotel.utils.builders.ProfileBuilder;
import com.github.matheusmv.apihotel.utils.builders.UserBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.time.Instant;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class UserTest {

    @Test
    void testUserDefaultInstantiation() {
        var id = 1L;
        var email = "user@email.com";
        var password = "password";
        var locked = true;
        var enabled = false;
        var createdAt = Instant.now();
        var updatedAt = Instant.now();
        var profile = new ProfileBuilder().build();
        var accommodations = List.of(
                new AccommodationBuilder().id(1L).build(),
                new AccommodationBuilder().id(2L).build(),
                new AccommodationBuilder().id(3L).build()
        );

        var user = new UserBuilder()
                .id(id)
                .email(email)
                .password(password)
                .locked(locked)
                .enabled(enabled)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .profile(profile)
                .accommodations(accommodations)
                .build();

        assertAll("tests for User entity",
                () -> assertDoesNotThrow((ThrowingSupplier<User>) User::new),
                () -> assertDoesNotThrow(() -> {
                    var usr = new User(id, email, password);
                    usr.setLocked(locked);
                    usr.setEnabled(enabled);
                    usr.setCreatedAt(createdAt);
                    usr.setUpdatedAt(updatedAt);
                    usr.setProfile(profile);
                    usr.getAccommodations().addAll(accommodations);
                }),
                () -> assertThat(id, is(equalTo(user.getId()))),
                () -> assertThat(email, is(equalTo(user.getEmail()))),
                () -> assertThat(password, is(equalTo(user.getPassword()))),
                () -> assertThat(locked, is(equalTo(user.getLocked()))),
                () -> assertThat(enabled, is(equalTo(user.getEnabled()))),
                () -> assertThat(createdAt, is(equalTo(user.getCreatedAt()))),
                () -> assertThat(updatedAt, is(equalTo(user.getUpdatedAt()))),
                () -> assertThat(profile, is(equalTo(user.getProfile()))),
                () -> assertThat(accommodations, is(equalTo(user.getAccommodations())))
        );
    }
}
