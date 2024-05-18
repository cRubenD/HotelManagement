package ro.HotelApp.HotelReservation.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface IUserDetailsService {
    UserDetails loadUserByUsername(String username);
}
