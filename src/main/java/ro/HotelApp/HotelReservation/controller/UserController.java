package ro.HotelApp.HotelReservation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.HotelApp.HotelReservation.DTO.UserLocationRequest;
import ro.HotelApp.HotelReservation.model.Hotel;
import ro.HotelApp.HotelReservation.service.implementation.HotelService;

import java.util.List;

@RestController
public class UserController {

    private final HotelService hotelService;

    public UserController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getHotelsByLocation(
            @RequestParam("latitude") double latitude,
            @RequestParam("longitude") double longitude,
            @RequestParam("radius") double radius) {

        List<Hotel> hotels = hotelService.findHotelsWithinCoordinates(latitude, longitude, radius);
        return ResponseEntity.ok(hotels);
    }

    @PostMapping("")
    public ResponseEntity<List<Hotel>> locationUpdate(@RequestBody UserLocationRequest userLocationRequest) {

        double userLatitude = userLocationRequest.getLatitude();
        double userLongitude = userLocationRequest.getLongitude();
        double radius = userLocationRequest.getRadius();

        List<Hotel> hotels = hotelService.findHotelsWithinCoordinates(userLatitude, userLongitude, radius);
        return ResponseEntity.ok(hotels);
    }
}
