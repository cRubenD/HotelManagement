package ro.HotelApp.HotelReservation.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Feedback {
    @Id
    @SequenceGenerator(
            name = "feedback_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "feedback_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long feedbackId;
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Hotel hotel;
    private String comment;
    private float rating;
}
