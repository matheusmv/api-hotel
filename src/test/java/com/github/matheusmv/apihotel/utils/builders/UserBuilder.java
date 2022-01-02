package com.github.matheusmv.apihotel.utils.builders;

import com.github.matheusmv.apihotel.domain.Profile;
import com.github.matheusmv.apihotel.domain.User;

import java.time.Instant;

public class UserBuilder {

    private Long id;
    private String email;
    private String password;
    private Boolean locked;
    private Boolean enabled;
    private Instant createdAt;
    private Instant updatedAt;
    private Profile profile;

    public UserBuilder() {
        this.id = 1L;
        this.email = "undefined";
        this.password = "undefined";
        this.locked = true;
        this.enabled = false;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
        this.profile = new Profile();
    }

    public UserBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder locked(Boolean locked) {
        this.locked = locked;
        return this;
    }

    public UserBuilder enabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public UserBuilder createdAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public UserBuilder updatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public UserBuilder profile(Profile profile) {
        this.profile = profile;
        return this;
    }

    public User build() {
        var user = new User(id, email, password, locked, enabled, createdAt, updatedAt);

        user.setProfile(profile);

        return user;
    }
}
