package com.psoft.project;

import com.psoft.project.model.Product;
import com.psoft.project.model.ProductCatalog;
import com.psoft.project.model.ProductDetails;
import com.psoft.project.repositories.ProductRepository;
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
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository products;

    @Test
    public void findAll_return_list_when_found() {
        List<Product> found = products.findAll();

        assertNotNull(found);
        assertEquals(10, found.size());
    }

    @Test
    public void findBySku_return_product_when_found() {
        Product found = products.findBySkuProduct("cBKhdYE37I64");

        assertNotNull(found);
        assertEquals("cBKhdYE37I64", found.getSku());
    }

    @Test
    public void findBySku_return_not_found() {
        Product found = products.findBySkuProduct("Test-notExist");

        assertNull(found);
    }
    @Test
    public void findByProductCatalog_return_list_when_found() {
        Pageable paging = PageRequest.of(0, 2);
        Page<ProductCatalog> found = products.findAllCatalog(paging);

        assertNotNull(found.getContent());
        assertEquals(10, found.getContent().size());

    }

    @Test
    public void findBySkuOrName_return_list_when_found() {
        Pageable paging = PageRequest.of(0, 2);
        Page<Product> found = products.findByNameOrSku("c",paging);

        assertNotNull(found.getContent());
        assertEquals(2, found.getContent().size());

    }
    @Test
    public void findBySkuDetails_return_list_when_found() {
        ProductDetails found = products.findBySku("cBKhdYE37I64");

        assertNotNull(found);
    }
}
