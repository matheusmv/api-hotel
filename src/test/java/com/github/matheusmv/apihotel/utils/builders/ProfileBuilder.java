package com.github.matheusmv.apihotel.utils.builders;

import com.github.matheusmv.apihotel.domain.Profile;

import java.time.LocalDateTime;

public class ProfileBuilder {

    private Long id;
    private String firstName;
    private String lastName;
    private String photoUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProfileBuilder() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public ProfileBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public ProfileBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ProfileBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ProfileBuilder photoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    public ProfileBuilder createdAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public ProfileBuilder updatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Profile build() {
        return new Profile(id, firstName, lastName, photoUrl, createdAt, updatedAt);
    }
}
