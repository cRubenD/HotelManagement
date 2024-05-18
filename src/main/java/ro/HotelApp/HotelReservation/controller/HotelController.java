package ro.HotelApp.HotelReservation.controller;

import org.springframework.web.bind.annotation.*;
import ro.HotelApp.HotelReservation.model.Hotel;
import ro.HotelApp.HotelReservation.service.implementation.HotelService;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<Hotel> getHotels() {
        return hotelService.getHotels();
    }

    @PostMapping
    public void createHotel(@RequestBody List<Hotel> hotels) {
        hotelService.createHotels(hotels);
    }

    @PutMapping(path = "{id}")
    public void updateHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
        hotelService.updateHotel(id, hotel);
    }

    @DeleteMapping(path = "{id}")
    public void deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
    }
}

