package com.github.matheusmv.apihotel.utils.builders;

import com.github.matheusmv.apihotel.domain.Profile;
import com.github.matheusmv.apihotel.domain.User;

import java.time.Instant;

public class ProfileBuilder {

    private Long id;
    private String firstName;
    private String lastName;
    private String photoUrl;
    private Instant createdAt;
    private Instant updatedAt;
    private User user;

    public ProfileBuilder() {
        this.id = 1L;
        this.firstName = "undefined";
        this.lastName = "undefined";
        this.photoUrl = "undefined";
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
        this.user = new User();
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

    public ProfileBuilder createdAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public ProfileBuilder updatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public ProfileBuilder user(User user) {
        this.user = user;
        return this;
    }

    public Profile build() {
        var profile = new Profile(firstName, lastName);

        profile.setId(user.getId());
        profile.setPhotoUrl(photoUrl);
        profile.setCreatedAt(createdAt);
        profile.setUpdatedAt(updatedAt);
        profile.setUser(user);

        return profile;
    }
}
