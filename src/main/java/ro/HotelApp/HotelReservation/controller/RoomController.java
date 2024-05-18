package ro.HotelApp.HotelReservation.controller;

import org.springframework.web.bind.annotation.*;
import ro.HotelApp.HotelReservation.model.Room;
import ro.HotelApp.HotelReservation.service.implementation.RoomService;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getRooms() {
        return roomService.getRooms();
    }

    @PostMapping
    public void createRoom(@RequestBody List<Room> rooms) {
        roomService.createRooms(rooms);
    }


}
