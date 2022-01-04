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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "room_services")
@NoArgsConstructor
@Getter
@Setter
public class RoomService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String description;

    @Column(nullable = false)
    private Double cost;

    @Column(columnDefinition = "datetime default now()")
    private Instant requestDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Accommodation accommodation;

    public RoomService(String description, Double cost, Instant requestDate) {
        this.description = description;
        this.cost = cost;
        this.requestDate = requestDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomService that = (RoomService) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
