package shop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.parameters.P;
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

    @MockBean
    private ProductRepository productRepository;
    @MockBean
    private ProductService productService;

    @Test
    @Transactional
    void remove() {
        Product product = new Product();
        product.setName("test");
        productService.save(product);

        productService.remove(product.getName());
        verify(productService).remove(product.getName());
    }

    @Test
    void findAll() {
        List<Product> domainList = new ArrayList<>();
        domainList.add(new Product());
        domainList.add(new Product());

        given(productService.findAll()).willReturn(domainList);
        List<Product> testResult = productService.findAll();

        assertEquals(productService.findAll(), testResult);
        assertEquals(productService.findAll().size(), 2);
    }

    @Test
    void save() {
        Product product = new Product();
        productService.save(product);

        verify(productService).save(product);
    }

    @Test
    void findByProductName() {
        Product product = new Product();
        product.setName("test");

        given(productService.findByProductName("test")).willReturn(product);
        Product testResult = productService.findByProductName("test");

        assertEquals(productService.findByProductName("test"), testResult);
        assertEquals(productService.findByProductName("test").getName(), "test");
    }

    @Test
    void findByCategory() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product());
        productList.add(new Product());

        given(productService.findByCategory("test")).willReturn(productList);
        List<Product> testResult = productService.findByCategory("test");

        assertEquals(productService.findByCategory("test"), testResult);

    }
}