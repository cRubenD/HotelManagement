package ro.HotelApp.HotelReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.HotelApp.HotelReservation.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
