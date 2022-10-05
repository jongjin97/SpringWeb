package shop.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import shop.dto.Product;
import shop.entity.ProductDomain;
import shop.jpa.ProductRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    Product product;
    Product product2;

    @BeforeEach
    void setUp(){
        product = new Product();
        product.setFile_name("test");
        product.setFile_path("test");
        product.setCategory("test");
        product.setName("test");

        product2 = new Product();
        product2.setFile_name("test2");
        product2.setFile_path("test2");
        product2.setCategory("test2");
        product2.setName("test2");
    }

    @Test
    @Transactional
    void remove() {
        productService.save(product);

        productService.remove(product.getName());
        ProductDomain productTmp = productRepository.findByName(product.getName());

        assertNull(productTmp);
    }

    @Test
    void findAll() {
        List<Product> list = productService.findAll();

        assertNotNull(list);
        assertNotEquals(list.size(), 0);
    }

    @Test
    @Transactional
    void save() {
        productService.save(product);

        Product productTest = productService.findByProductName(product.getName());

        assertNotNull(productTest);
    }

    @Test
    @Transactional
    void findByProductName() {
        productService.save(product);

        Product productTest = productService.findByProductName(product.getName());

        assertNotNull(productTest);
        assertEquals(productTest.getName(), product.getName());
    }

    @Test
    @Transactional
    void findByCategory() {
        productService.save(product);
        productService.save(product2);

        List<Product> productList = productService.findByCategory("test");

        assertNotNull(productList);
        assertNotEquals(productList.size(), 0);
    }
}