package ro.HotelApp.HotelReservation.service;

import ro.HotelApp.HotelReservation.model.User;

public interface IUserService {
    void save(User user);

    User findByUsername(String username);
}
