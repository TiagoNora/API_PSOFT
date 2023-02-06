package com.psoft.project.controllers;

import com.psoft.project.model.AggregateRating;
import com.psoft.project.model.Product;
import com.psoft.project.model.ProductCatalog;
import com.psoft.project.model.ProductDetails;
import com.psoft.project.repositories.ProductRepository;
import com.psoft.project.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Tag(name = "Products", description = "Endpoints for getting information about the products")
@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @Operation(summary = "Gets all products")
    @GetMapping
    List<ProductCatalog> findAllToCatalog(@RequestParam Integer pageNo, @RequestParam Integer pageSize){
        return service.findAllCatalog(pageNo,pageSize);
    }
    @Operation(summary = "Gets the product with the given sku")
    @GetMapping(value = "/{sku}")
    public ProductDetails findBySku(@PathVariable("sku") String sku){
        ProductDetails productDetails = service.findBySku(sku);
        return productDetails;
    }
    @Operation(summary = "Gets products that contain the given string")
    @GetMapping(value = "/search/{nameOrSku}")
    public List<ProductDetails> findByNameOrSku(@PathVariable("nameOrSku") String nameOrSku,@RequestParam Integer pageNo, @RequestParam Integer pageSize){
        List<ProductDetails> productDetails = service.findByNameOrSku(nameOrSku,pageNo,pageSize);
        return productDetails;
    }

    @Operation(summary = "Gets the rating of the given sku")
    @GetMapping(value = "/{sku}/rating")
    public AggregateRating findAggregateRatingBySku(@PathVariable("sku") String sku){
        AggregateRating aggregateRating = service.findAllRates(sku);
        return aggregateRating;
    }

}











