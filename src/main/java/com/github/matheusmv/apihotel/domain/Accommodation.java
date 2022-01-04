package com.github.matheusmv.apihotel.domain;

import com.github.matheusmv.apihotel.domain.enums.AccommodationStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "accommodations")
@NoArgsConstructor
@Getter
@Setter
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(20)", nullable = false)
    private AccommodationStatus status;

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

    @OneToMany(
            mappedBy = "accommodation",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<RoomService> roomServices = new ArrayList<>();

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    private User user;

    public Accommodation(Long id, AccommodationStatus status, Instant checkIn, Instant checkOut) {
        this.id = id;
        this.status = status;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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
