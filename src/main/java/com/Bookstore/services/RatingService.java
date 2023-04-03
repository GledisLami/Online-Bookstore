package com.Bookstore.services;

import com.Bookstore.entities.Rating;
import com.Bookstore.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public Rating getRatingById(Long id) {
        return ratingRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Rating not found with id " + id));
    }

    public List<Rating> getRatingsByBookId(Long bookId) {
        return ratingRepository.findByBookId(bookId);
    }

    public void createRating(Rating rating) {
        ratingRepository.save(rating);
    }

    @Transactional
    public void updateRating(Long id, Rating ratingDetails) {
        Rating rating = getRatingById(id);

        rating.setRating(ratingDetails.getRating());
        rating.setComment(ratingDetails.getComment());
    }

    public void deleteRating(Long id) {
        Rating rating = getRatingById(id);
        ratingRepository.delete(rating);
    }
}

