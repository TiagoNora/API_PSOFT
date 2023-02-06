package com.psoft.project.services;

import com.psoft.project.model.*;
import com.psoft.project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService  {
    @Autowired
    ProductRepository repository;

    public List<ProductCatalog> findAllCatalog(Integer pageNo,Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Product> pagedResult = repository.findAll(paging);
        List<ProductCatalog> products = new ArrayList<>();
        for (int i = 0; i < pagedResult.getContent().size(); i++){
            String sku = pagedResult.getContent().get(i).getSku();
            String name = pagedResult.getContent().get(i).getName();
            ProductCatalog product = new ProductCatalog(sku,name);
            products.add(product);
        }
        return products;
    }

    public ProductDetails findBySku(String sku){
        Product product = repository.findBySkuProduct(sku);
        if (product == null){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found ");
        }
        ProductDetails productDetails = new ProductDetails(product.getSku(), product.getName(), product.getDescription(),product.getImages());
        return productDetails;
    }
    public List<ProductDetails> findByNameOrSku(String nameOrSku,Integer pageNo,Integer pageSize){
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Product> productPage = repository.findByNameOrSku(nameOrSku,paging);
        List<Product> product = productPage.getContent();
        List<ProductDetails> lista = new ArrayList<>();
        for(int i=0 ; i < product.size() ; i++){
            ProductDetails productDetails = new ProductDetails(product.get(i).getSku(), product.get(i).getName(), product.get(i).getDescription(),product.get(i).getImages());
            lista.add(productDetails);
        }
        return lista;
    }

    public void addImage(String fileName,String sku){
        Product product = repository.findBySkuProduct(sku);
        if (product == null){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found ");
        }
        product.addImages(fileName);
        repository.save(product);
    }

    public AggregateRating findAllRates(String sku){
        Product product = repository.findBySkuProduct(sku);
        if (product == null){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found");
        }
        List<Review> list = product.getReviews();

        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        float soma = 0;
        float average;
        float frequency0;
        float frequency1;
        float frequency2;
        float frequency3;
        float frequency4;
        float frequency5;

        for(int i = 0 ; i < list.size() ; i++){
           float rating = list.get(i).getRating();
           if (rating >= 0 && rating < 0.5){
               count0++;
           }
           else if (rating >= 0.5 && rating < 1.5){
               count1++;
           }
           else if (rating >= 1.5 && rating < 2.5){
               count2++;
           }
           else if (rating >= 2.5 && rating < 3.5){
               count3++;
           }
           else if (rating >= 3.5 && rating < 4.5){
               count4++;
           }
           else if (rating >= 4.5 && rating <= 5){
               count5++;
           }
           soma += rating;
        }

        frequency0 = ((float) count0) / list.size() * 100;
        frequency1 = ((float) count1) / list.size() * 100;
        frequency2 = ((float) count2) / list.size() * 100;
        frequency3 = ((float) count3) / list.size() * 100;
        frequency4 = ((float) count4) / list.size() * 100;
        frequency5 = ((float) count5) / list.size() * 100;

        average = soma / list.size();

        AggregateRating aggregateRating = new AggregateRating(sku, average, count0, count1, count2, count3, count4, count5, frequency0, frequency1, frequency2, frequency3, frequency4, frequency5);

        return aggregateRating;
    }
}
