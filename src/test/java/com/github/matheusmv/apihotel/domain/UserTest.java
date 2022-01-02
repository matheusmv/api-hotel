package com.github.matheusmv.apihotel.domain;

import com.github.matheusmv.apihotel.utils.builders.UserBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.time.LocalDateTime;

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
        var createdAt = LocalDateTime.now();
        var updatedAt = LocalDateTime.now();

        var user = new UserBuilder()
                .id(id)
                .email(email)
                .password(password)
                .locked(locked)
                .enabled(enabled)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();

        assertAll("tests for User entity",
                () -> assertDoesNotThrow((ThrowingSupplier<User>) User::new),
                () -> assertDoesNotThrow(() -> new User(id, email, password, locked, enabled, createdAt, updatedAt)),
                () -> assertThat(id, is(equalTo(user.getId()))),
                () -> assertThat(email, is(equalTo(user.getEmail()))),
                () -> assertThat(password, is(equalTo(user.getPassword()))),
                () -> assertThat(locked, is(equalTo(user.getLocked()))),
                () -> assertThat(enabled, is(equalTo(user.getEnabled()))),
                () -> assertThat(createdAt, is(equalTo(user.getCreatedAt()))),
                () -> assertThat(updatedAt, is(equalTo(user.getUpdatedAt())))
        );
    }
}
