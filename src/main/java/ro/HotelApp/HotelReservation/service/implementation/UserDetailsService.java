package ro.HotelApp.HotelReservation.service.implementation;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.HotelApp.HotelReservation.model.CustomUserDetails;
import ro.HotelApp.HotelReservation.model.User;
import ro.HotelApp.HotelReservation.repository.UserRepository;
import ro.HotelApp.HotelReservation.service.IUserDetailsService;

@Service
public class UserDetailsService implements IUserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new CustomUserDetails(user);
    }

}
