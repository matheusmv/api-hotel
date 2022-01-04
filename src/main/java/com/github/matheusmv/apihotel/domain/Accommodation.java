package com.github.matheusmv.apihotel.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "accommodations")
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "datetime default now()")
    private Instant checkIn;

    @Column(columnDefinition = "datetime default now()")
    private Instant checkOut;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "accommodation_room",
            joinColumns = @JoinColumn(name = "accommodation_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    private Set<Room> rooms = new HashSet<>();

    public Accommodation() {

    }

    public Accommodation(Long id, Instant checkIn, Instant checkOut) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Instant checkIn) {
        this.checkIn = checkIn;
    }

    public Instant getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Instant checkOut) {
        this.checkOut = checkOut;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accommodation that = (Accommodation) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
