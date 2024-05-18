package ro.HotelApp.HotelReservation.DTO;

import lombok.Data;

@Data
public class UserLocationRequest {
    private double latitude;
    private double longitude;
    /**
     * Radius will be sent in km!
     */
    private double radius;
}
