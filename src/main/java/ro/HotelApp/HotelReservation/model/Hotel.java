package ro.HotelApp.HotelReservation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
public class Hotel {

    @Id
//    @SequenceGenerator(
//            name = "hotel_sequence",
//            allocationSize =  1
//    )
//    @GeneratedValue(
//            generator = "hotel_sequence",
//            strategy = GenerationType.SEQUENCE
//    )
    private Long id;
    @NotBlank(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Latitude cannot be null")
    private double latitude;
    @NotNull(message = "Longitude cannot be null")
    private double longitude;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Room> rooms = new ArrayList<>();

}
