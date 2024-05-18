package ro.HotelApp.HotelReservation.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table
@Data
public class Reservation {

    @Id
    @SequenceGenerator(
            name = "reservation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "reservation_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    @ManyToOne
    @JoinColumn(name = "room_number", nullable = false)
    private Room room;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
}
