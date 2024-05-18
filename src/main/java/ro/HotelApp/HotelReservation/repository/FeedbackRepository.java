package ro.HotelApp.HotelReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.HotelApp.HotelReservation.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
