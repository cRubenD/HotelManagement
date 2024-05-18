package ro.HotelApp.HotelReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.HotelApp.HotelReservation.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
