package ro.HotelApp.HotelReservation.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.engine.internal.Cascade;

import java.util.List;

@Entity
@Table
@Data
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "user_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private String username;
    private String password;
    private String role; // USER or ADMIN

    @OneToMany(cascade = CascadeType.ALL)
    private List<Reservation> reservations;
}
