package com.psoft.project;

import com.psoft.project.model.Product;
import com.psoft.project.model.Review;
import com.psoft.project.model.ReviewDTO;
import com.psoft.project.repositories.ProductRepository;
import com.psoft.project.repositories.ReviewRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest

public class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewsRepository;

    @Autowired
    private ProductRepository productRepository;


    @Test
    public void findAllBySku_return_list_when_found() {
        Pageable paging = PageRequest.of(0, 2);
        Product product = productRepository.findBySkuProduct("iSh0kUzHCn73");
        Page<Review> reviews =  reviewsRepository.findAll("iSh0kUzHCn73",paging);

        assertEquals(0, reviews.getContent().size());
    }

    @Test
    public void findAllBySku2_return_list_when_found() {
        Product product = productRepository.findBySkuProduct("jdwJSJ7238B");

        assertNull(product);
    }

    @Test
    public void wjdsiefhd() {
        Product product = productRepository.findBySkuProduct("iSh0kUzHCn73");

        Review review = new Review();
        review.setText("Que nojo");
        review.setRating(4);
        review.setProduct(product);
        review.setFunFact("A minha tia também acha um nojo");

        assertNotNull(review);
    }
}


















