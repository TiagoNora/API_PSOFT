package com.psoft.project.services;

import com.psoft.project.model.*;
import com.psoft.project.repositories.ProductRepository;
import com.psoft.project.repositories.ReviewRepository;
import com.psoft.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public Review create(final ReviewDTO resource,String sku) throws IOException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        User user = userRepository.findUserByUsername(username);
        if (user==null){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        }
        Product product = productRepository.findBySkuProduct(sku);
        if (product == null){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found");
        }
        if (resource.getRating() == 0.0f){
            resource.setRating(0);
        }
        else if (resource.getText() == null){
            resource.setText("");
        }
        else if (resource.getRating() == 0.0f && resource.getText() == null){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid rating");
        }
        else if (resource.getRating() < 0 || resource.getRating() > 5){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Rating must have values between 0 and 5");
        }
        Review reviewDTO = new Review(resource.getText(), resource.getRating());
        reviewDTO.setProduct(product);
        reviewDTO.setUser(user);
        return repository.save(reviewDTO);
    }

    public Product findAllReviews(String sku,Integer pageNo,Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Product product = productRepository.findBySkuProduct(sku);
        if (product == null){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found ");
        }
        Page<Review> review =  repository.findAll(sku,paging);
        List<Review> reviews = review.getContent();

        product.setReviews(reviews);
        return product;
    }

    public void deleteById(int idReview){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        User user = userRepository.findUserByUsername(username);
        Review review = repository.findByIdReview(idReview);
        if (review == null){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Review Not Found ");
        }
        if (review.getVotes().isEmpty() && user.getId() == review.getUser().getId()){
            repository.delete(review);
        }
        else{
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Review does not belong to the user ");
        }

    }

    public List<ReviewUser> findAllReviewsPending(Integer pageNo,Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Review> review = repository.findAllPending(paging);
        List<Review> reviews = review.getContent();
        List<ReviewUser> reviewsPending = new ArrayList<>();
        for (int i = 0; i< reviews.size();i++){
            int id = reviews.get(i).getId();
            String sku = reviews.get(i).getProduct().getSku();
            String status = reviews.get(i).getStatus();
            String text = reviews.get(i).getText();
            float rating = reviews.get(i).getRating();
            int totalVotes = reviews.get(i).getTotalVotes();
            int upVotes = reviews.get(i).getUpVotes();
            int downVotes  = reviews.get(i).getDownVotes();
            Date creationDateTime = reviews.get(i).getCreationDateTime();
            String funFact = reviews.get(i).getFunFact();
            ReviewUser reviewUser = new ReviewUser(id,sku,status,text,rating,totalVotes,upVotes,downVotes,creationDateTime,funFact);
            reviewsPending.add(reviewUser);
        }
        return reviewsPending;
    }

    public Review changeStatus(int idReview, ChangeStatus resource) {
        Review review = repository.findByIdReview(idReview);
        if (review == null){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Review Not Found ");
        }
        String status;
        if (resource.getApproved()){
            status = "APPROVED";
        }
        else {
            status = "REJECTED";
        }
        review.setStatus(status);
        repository.save(review);
        Review review1 = repository.findByIdReview(idReview);
        return review1;
    }

    public List<ReviewUser> findAllReviewsByUser(Integer pageNo,Integer pageSize) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        User user = userRepository.findUserByUsername(username);
        if (user==null){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        }
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Review> review= repository.findAllReviewsByUser(user.getId(),paging);
        List<Review> reviews = review.getContent();
        List<ReviewUser> reviewsUser = new ArrayList<>();
        for (int i = 0; i< reviews.size();i++){
            int id = reviews.get(i).getId();
            String sku = reviews.get(i).getProduct().getSku();
            String status = reviews.get(i).getStatus();
            String text = reviews.get(i).getText();
            float rating = reviews.get(i).getRating();
            int totalVotes = reviews.get(i).getTotalVotes();
            int upVotes = reviews.get(i).getUpVotes();
            int downVotes  = reviews.get(i).getDownVotes();
            Date creationDateTime = reviews.get(i).getCreationDateTime();
            String funFact = reviews.get(i).getFunFact();
            ReviewUser reviewUser = new ReviewUser(id,sku,status,text,rating,totalVotes,upVotes,downVotes,creationDateTime,funFact);
            reviewsUser.add(reviewUser);
        }
        return reviewsUser;
    }
}
