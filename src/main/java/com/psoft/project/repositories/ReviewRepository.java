package com.psoft.project.repositories;

import com.psoft.project.model.ProductCatalog;
import com.psoft.project.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query("select f from Review f where f.product.sku = :sku and f.status = 'APPROVED' order by f.creationDateTime desc ")
    Page<Review> findAll(@Param("sku") String sku, Pageable paging);
    @Query("select f from Review f where f.product.sku = :sku and f.status = 'APPROVED' order by f.upVotes desc ,f.creationDateTime desc ")
    Page<Review> findAllWithVotes(@Param("sku") String sku,Pageable paging);

    @Query("select f from Review f where f.id = :idReview")
    Review findByIdReview(@Param("idReview") int idReview);

    @Query("select f from Review f where f.status = 'PENDING'")
    Page<Review> findAllPending(Pageable paging);
    @Modifying
    @Query("update Review f set f.status = :status where f.id = :idReview")
    void updateApprovedOrRejected(@Param("idReview") int idReview,@Param("status") String status);

    @Query("select f from Review f where f.user.id = :idUser")
    Page<Review> findAllReviewsByUser(@Param("idUser") int idUser,Pageable paging);
}
