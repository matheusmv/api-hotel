package com.github.matheusmv.apihotel.domain;

import com.github.matheusmv.apihotel.utils.builders.ProfileBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.time.Instant;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ProfileTest {

    @Test
    void testProfileDefaultInstantiation() {
        var id = 1L;
        var firstName = "first name";
        var lastName = "last name";
        var photoUrl = "http://photos.com/0SdAskaf254zaFa4";
        var createdAt = Instant.now();
        var updatedAt = Instant.now();

        var profile = new ProfileBuilder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .photoUrl(photoUrl)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();

        assertAll("tests for Profile entity",
                () -> assertDoesNotThrow((ThrowingSupplier<Profile>) Profile::new),
                () -> assertDoesNotThrow(() -> new Profile(id, firstName, lastName, photoUrl, createdAt, updatedAt)),
                () -> assertThat(id, is(equalTo(profile.getId()))),
                () -> assertThat(firstName, is(equalTo(profile.getFirstName()))),
                () -> assertThat(lastName, is(equalTo(profile.getLastName()))),
                () -> assertThat(photoUrl, is(equalTo(profile.getPhotoUrl()))),
                () -> assertThat(createdAt, is(equalTo(profile.getCreatedAt()))),
                () -> assertThat(updatedAt, is(equalTo(profile.getUpdatedAt())))
        );
    }
}
