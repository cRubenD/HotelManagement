package ro.HotelApp.HotelReservation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Room {
    @Id
    private int roomNumber;
    /**
     * Type: 1 - single-room
     * 2 - double-room
     * 3 - suite-room
     * 4 - matrimonial-room
     */
    private int type;
    private double price;
    private boolean isAvailable;

    public boolean getisAvailable() {
        return isAvailable;
    }

    public void setisAvailable(boolean available) {
        isAvailable = available;
    }

}
