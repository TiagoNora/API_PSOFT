package com.psoft.project.repositories;

import com.psoft.project.model.Product;
import com.psoft.project.model.ProductCatalog;
import com.psoft.project.model.ProductDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,String> {
    @Query("select sku as sku, name as name from Product ")
    Page<ProductCatalog> findAllCatalog(Pageable paging);

    @Query("select sku as sku, name as name, description as description from Product where sku = :sku")
    ProductDetails findBySku(@Param("sku") String sku);

    @Query("select f from Product f where f.sku = :sku")
    Product findBySkuProduct(@Param("sku") String sku);

    @Query("select f from Product f where f.sku like %:nameOrSku% or f.name like %:nameOrSku%")
    Page<Product> findByNameOrSku(@Param("nameOrSku") String nameOrSku, Pageable paging);
}
