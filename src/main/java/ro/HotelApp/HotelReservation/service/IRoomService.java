package ro.HotelApp.HotelReservation.service;

import ro.HotelApp.HotelReservation.model.Room;

import java.util.List;

public interface IRoomService {

    List<Room> getRooms();
    void createRooms( List<Room> rooms);
    void updateRoom(int roomNumber, Room room);
    void deleteRoom(int roomNumber);
}
