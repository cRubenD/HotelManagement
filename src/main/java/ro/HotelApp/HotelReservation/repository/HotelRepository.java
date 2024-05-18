package ro.HotelApp.HotelReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.HotelApp.HotelReservation.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
