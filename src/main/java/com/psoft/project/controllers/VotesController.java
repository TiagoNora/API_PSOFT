package com.psoft.project.controllers;

import com.psoft.project.model.*;
import com.psoft.project.services.ReviewService;
import com.psoft.project.services.VoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Tag(name = "Votes", description = "Endpoints for managing votes")
@RequestMapping("/votes")
@RestController
public class VotesController {
    @Autowired
    VoteService service;
    @Operation(summary = "Make a vote in a review")
    @PostMapping(value = "/{idReview}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Vote> create(@RequestBody final VoteDTO resource, @PathVariable("idReview") final int idReview) throws IOException {
        final var vote = service.create(resource,idReview);
        return ResponseEntity.ok().body(vote);
    }
    @Operation(summary = "Get all reviews order by total votes ")
    @GetMapping(value = "/{sku}")
    Product findAllReviews(@PathVariable("sku") final String sku,@RequestParam Integer pageNo, @RequestParam Integer pageSize){
        return service.findAllReviewsWithVotes(sku,pageNo,pageSize);
    }
}
