package com.psoft.project.controllers;

import com.psoft.project.model.ChangeStatus;
import com.psoft.project.model.Review;
import com.psoft.project.model.ReviewUser;
import com.psoft.project.services.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Moderator", description = "Endpoints for managing reviews")
@RequestMapping("/moderator")
@RestController
public class ModeratorController {
    @Autowired
    ReviewService service;
    @Operation(summary = "Get all pending reviews")
    @GetMapping(value = "/reviews")
    List<ReviewUser> findAllReviewsPending(@RequestParam Integer pageNo, @RequestParam Integer pageSize){
        return service.findAllReviewsPending(pageNo,pageSize);
    }
    @Operation(summary = "Change the status of the review")
    @PutMapping(value = "/review/{idReview}")
    public ResponseEntity<Review> changeStatus(@PathVariable("idReview") final int idReview, @RequestBody final ChangeStatus resource){
        final var review = service.changeStatus(idReview,resource);
        return ResponseEntity.ok().body(review);
    }
}
