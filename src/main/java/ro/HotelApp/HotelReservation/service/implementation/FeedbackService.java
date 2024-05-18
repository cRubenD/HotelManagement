package ro.HotelApp.HotelReservation.service.implementation;

import org.springframework.stereotype.Service;
import ro.HotelApp.HotelReservation.repository.FeedbackRepository;
import ro.HotelApp.HotelReservation.service.IFeedbackService;

@Service
public class FeedbackService implements IFeedbackService {
    // TO DO
    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }
}
