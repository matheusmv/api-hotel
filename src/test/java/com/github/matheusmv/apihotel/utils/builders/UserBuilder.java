package com.github.matheusmv.apihotel.utils.builders;

import com.github.matheusmv.apihotel.domain.User;

import java.time.LocalDateTime;

public class UserBuilder {

    private Long id;
    private String email;
    private String password;
    private Boolean locked;
    private Boolean enabled;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserBuilder() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
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

    public UserBuilder createdAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public UserBuilder updatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public User build() {
        return new User(id, email, password, locked, enabled, createdAt, updatedAt);
    }
}
