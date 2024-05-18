package ro.HotelApp.HotelReservation.controller;

import org.springframework.web.bind.annotation.*;
import ro.HotelApp.HotelReservation.model.User;
import ro.HotelApp.HotelReservation.service.implementation.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        userService.save(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        // Authentication logic will be handled by Spring Security
        return "User logged in successfully!";
    }
}
