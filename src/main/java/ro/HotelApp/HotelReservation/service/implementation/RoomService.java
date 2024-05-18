package ro.HotelApp.HotelReservation.service.implementation;

import org.springframework.stereotype.Service;
import ro.HotelApp.HotelReservation.model.Room;
import ro.HotelApp.HotelReservation.repository.RoomRepository;
import ro.HotelApp.HotelReservation.service.IRoomService;

import java.util.List;

@Service
public class RoomService implements IRoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    @Override
    public void createRooms(List<Room> rooms) {
        roomRepository.saveAll(rooms);
    }

    @Override
    public void updateRoom(int roomNumber, Room room) {
        Room roomDTO = roomRepository.findById(roomNumber).orElseThrow(
                () -> new IllegalStateException(String.format("Room with number %d does not exist", roomNumber)));

        roomDTO.setRoomNumber(room.getRoomNumber());
        roomDTO.setType(room.getType());
        roomDTO.setPrice(room.getPrice());
        roomDTO.setisAvailable(room.getisAvailable());

        roomRepository.save(roomDTO);
    }

    @Override
    public void deleteRoom(int roomNumber) {
        boolean room = roomRepository.existsById(roomNumber);
        if (!room) {
            throw new IllegalStateException(String.format("Room with number %d does not exist", roomNumber));
        }
        roomRepository.deleteById(roomNumber);
    }
}

