package com.github.matheusmv.apihotel.domain;

import com.github.matheusmv.apihotel.domain.enums.RoomCategory;
import com.github.matheusmv.apihotel.domain.enums.RoomStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "rooms")
@NoArgsConstructor
@Getter
@Setter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(20)", nullable = false)
    private RoomCategory category;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(20)", nullable = false)
    private RoomStatus status;

    @Column(nullable = false)
    private Double cost;

    @ManyToMany(mappedBy = "rooms")
    private Set<Accommodation> accommodations = new HashSet<>();

    public Room(RoomCategory category, RoomStatus status, Double cost) {
        this.category = category;
        this.status = status;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id.equals(room.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
