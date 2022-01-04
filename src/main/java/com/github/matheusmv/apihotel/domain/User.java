package com.github.matheusmv.apihotel.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String email;

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String password;

    @Column(columnDefinition = "boolean default true")
    private Boolean locked;

    @Column(columnDefinition = "boolean default false")
    private Boolean enabled;

    @Column(columnDefinition = "datetime default now()")
    private Instant createdAt;

    @Column(columnDefinition = "datetime default now()")
    private Instant updatedAt;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Profile profile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Accommodation> accommodations = new ArrayList<>();

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.locked = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
