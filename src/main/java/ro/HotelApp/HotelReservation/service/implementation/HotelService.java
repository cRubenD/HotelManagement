package ro.HotelApp.HotelReservation.service.implementation;

import org.springframework.stereotype.Service;
import ro.HotelApp.HotelReservation.model.Hotel;
import ro.HotelApp.HotelReservation.repository.HotelRepository;
import ro.HotelApp.HotelReservation.service.IHotelService;

import javax.crypto.MacSpi;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService implements IHotelService {
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public void createHotels(List<Hotel> hotels) {
        hotelRepository.saveAll(hotels);
    }

    @Override
    public void updateHotel(Long id, Hotel hotel) {
        Hotel hotelDTO = hotelRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("Hotel with id %d does not exist", id)));

        hotelDTO.setId(hotel.getId());
        hotelDTO.setName(hotel.getName());
        hotelDTO.setLatitude(hotel.getLatitude());
        hotelDTO.setLongitude(hotel.getLongitude());
        hotelDTO.setRooms(hotel.getRooms());

        hotelRepository.save(hotelDTO);
    }

    @Override
    public void deleteHotel(Long id) {
        boolean hotel = hotelRepository.existsById(id);
        if (!hotel) {
            throw new IllegalStateException(String.format("Hotel with id %d does not exist", id));
        }
        hotelRepository.deleteById(id);
    }

    @Override
    public List<Hotel> findHotelsWithinCoordinates(double userLatitude, double userLongitude, double radius) {
        List<Hotel> hotels = hotelRepository.findAll();

        return hotels.stream().filter(hotel -> {
            double distance = calculateDistance(userLatitude, userLongitude, hotel.getLatitude(), hotel.getLongitude());
            //System.out.println(distance);
            return distance <= radius;
        }).toList();
    }

    /**
     * Haversine formala: finding the shortest distance between 2 points on a sphere
     */
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final double Average_Earth_Meridional_Radius = 6367.5;

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return Average_Earth_Meridional_Radius * c;
    }

}
