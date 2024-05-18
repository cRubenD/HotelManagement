package ro.HotelApp.HotelReservation.service;

import ro.HotelApp.HotelReservation.model.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> getReservations();

    void createReservation(Reservation reservation);

    void updateReservation(Long id, Reservation reservation);

    void deleteReservation(Long id);
}
