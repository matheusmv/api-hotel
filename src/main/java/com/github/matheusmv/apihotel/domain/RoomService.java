package com.github.matheusmv.apihotel.domain;

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

    public RoomService() {

    }

    public RoomService(Long id, String description, Double cost, Instant requestDate) {
        this.id = id;
        this.description = description;
        this.cost = cost;
        this.requestDate = requestDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Instant getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Instant requestDate) {
        this.requestDate = requestDate;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
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
