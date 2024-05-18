package ro.HotelApp.HotelReservation.service;

import ro.HotelApp.HotelReservation.model.Hotel;

import java.util.List;

public interface IHotelService {
    List<Hotel> getHotels();
    void createHotels( List<Hotel> hotels);
    void updateHotel(Long id, Hotel hotel);
    void deleteHotel(Long id);

    List<Hotel> findHotelsWithinCoordinates(double userLatitude, double userLongitude, double radius);
}
