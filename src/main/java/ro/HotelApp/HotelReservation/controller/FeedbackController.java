package ro.HotelApp.HotelReservation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.HotelApp.HotelReservation.repository.FeedbackRepository;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {
    // TO DO
    private final FeedbackRepository feedbackRepository;

    public FeedbackController(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }
}
