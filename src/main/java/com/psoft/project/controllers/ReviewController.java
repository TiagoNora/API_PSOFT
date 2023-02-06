package com.psoft.project.controllers;


import com.psoft.project.model.*;
import com.psoft.project.services.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
@Tag(name = "Reviews", description = "Endpoints for managing reviews")
@RequestMapping("/reviews")
@RestController
public class ReviewController {

    @Autowired
    ReviewService service;
    @Operation(summary = "Create a review")
    @PostMapping(value = "/{sku}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Review> create(@RequestBody final ReviewDTO resource, @PathVariable("sku") final String sku) throws IOException {
        final var review = service.create(resource,sku);
        return ResponseEntity.ok().body(review);
    }
    @Operation(summary = "Get product with reviews approved")
    @GetMapping(value = "/{sku}")
    Product findAllReviews(@PathVariable("sku") final String sku,@RequestParam Integer pageNo, @RequestParam Integer pageSize){
        return service.findAllReviews(sku,pageNo,pageSize);
    }
    @Operation(summary = "Delete a review")
    @DeleteMapping(value = "/{idReview}")
    public ResponseEntity<Review> delete(@PathVariable("idReview") final int id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @Operation(summary = "Gets all reviews that the user made")
    @GetMapping(value = "/user")
    List<ReviewUser> findAllReviewsByUser(@RequestParam Integer pageNo, @RequestParam Integer pageSize){
        return service.findAllReviewsByUser(pageNo,pageSize);
    }
}
