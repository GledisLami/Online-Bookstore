package com.Bookstore.controllers;

import com.Bookstore.entities.Rating;
import com.Bookstore.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping
    public List<Rating> getAllRatings() {
        return ratingService.getAllRatings();
    }

    @GetMapping("/{id}")
    public Rating getRatingById(@PathVariable Long id) {
        return ratingService.getRatingById(id);
    }

    @GetMapping("/book/{bookId}")
    public List<Rating> getRatingsByBookId(@PathVariable Long bookId) {
        return ratingService.getRatingsByBookId(bookId);
    }

    @PostMapping
    public void createRating(@RequestBody Rating rating) {
        ratingService.createRating(rating);
    }

    @PutMapping("/{id}")
    public void updateRating(@PathVariable Long id, @RequestBody Rating ratingDetails) {
        ratingService.updateRating(id, ratingDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteRating(@PathVariable Long id) {
        ratingService.deleteRating(id);
    }
}
