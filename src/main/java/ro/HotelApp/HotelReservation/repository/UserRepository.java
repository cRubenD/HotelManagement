package ro.HotelApp.HotelReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.HotelApp.HotelReservation.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
