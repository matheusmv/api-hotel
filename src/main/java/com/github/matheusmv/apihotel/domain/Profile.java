package com.github.matheusmv.apihotel.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "profiles")
@NoArgsConstructor
@Getter
@Setter
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String firstName;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String lastName;

    @Column(columnDefinition = "varchar(100)")
    private String photoUrl;

    @Column(columnDefinition = "datetime default now()")
    private Instant createdAt;

    @Column(columnDefinition = "datetime default now()")
    private Instant updatedAt;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    private User user;

    public Profile(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return id.equals(profile.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
