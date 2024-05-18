package ro.HotelApp.HotelReservation.service.implementation;

import org.springframework.stereotype.Service;
import ro.HotelApp.HotelReservation.model.Reservation;
import ro.HotelApp.HotelReservation.model.Room;
import ro.HotelApp.HotelReservation.repository.ReservationRepository;
import ro.HotelApp.HotelReservation.repository.RoomRepository;
import ro.HotelApp.HotelReservation.service.IReservationService;

import java.util.List;

@Service
public class ReservationService implements IReservationService {
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    public ReservationService(ReservationRepository reservationRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public void createReservation(Reservation reservation) {
        reservationRepository.save(reservation);
        Room room = roomRepository.findById(reservation.getRoom().getRoomNumber())
                .orElseThrow(() -> new RuntimeException("Room not found"));
        room.setisAvailable(false);
        roomRepository.save(room);
    }

    @Override
    public void updateReservation(Long id, Reservation reservation) {
        // to do
    }

    @Override
    public void deleteReservation(Long id) {
        // to do
    }
}
