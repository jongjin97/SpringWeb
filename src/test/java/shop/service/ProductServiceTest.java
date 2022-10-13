//package shop.service;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.AdditionalAnswers;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import shop.dto.Product;
//import shop.entity.ProductDomain;
//import shop.entity.UserDomain;
//import shop.jpa.ProductRepository;
//import shop.service.implement.ProductServiceImpl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//class ProductServiceTest {
//
//    @MockBean
//    private ProductRepository productRepository;
//    @Autowired
//    private ProductServiceImpl productService;
//
//    @Test
//    void remove() {
//        Product product = getProduct();
//        ProductDomain productDomain = getProductDomain();
//
//
//        productService.remove(product.getName());
//
//        verify(productRepository).removeByName(anyString());
//    }
//
//    @Test
//    void findAll() {
//        Product product = getProduct();
//        ProductDomain productDomain = getProductDomain();
//        List<ProductDomain> productDomainList = new ArrayList<>();
//        productDomainList.add(productDomain);
//        productDomainList.add(productDomain);
//
//        given(productRepository.findAll()).willReturn(productDomainList);
//
//        List<Product> findProductList = productService.findAll();
//
//        assertEquals(productDomainList.size(), findProductList.size());
//    }
//
//    @Test
//    void save() {
//        Product product = getProduct();
//        ProductDomain productDomain = getProductDomain();
//
//        when(productRepository.save(productDomain)).then(AdditionalAnswers.returnsFirstArg());
//
//        productService.save(product);
//
//        verify(productRepository, times(1)).save(any(ProductDomain.class));
//    }
//
//    @Test
//    void findByProductName() {
//        Product product = getProduct();
//        ProductDomain productDomain = getProductDomain();
//        given(productRepository.findByName(product.getName())).willReturn(productDomain);
//
//        Product findProduct = productService.findByProductName(product.getName());
//
//        assertEquals(product.getName(), findProduct.getName());
//    }
//
//    @Test
//    void findByCategory() {
//        Product product = getProduct();
//        ProductDomain productDomain = getProductDomain();
//        List<ProductDomain> productDomainList = new ArrayList<>();
//        productDomainList.add(productDomain);
//        productDomainList.add(productDomain);
//
//        given(productRepository.findAllByCategory(product.getCategory())).willReturn(productDomainList);
//
//        List<Product> findProductList = productService.findByCategory(product.getCategory());
//
//        assertEquals(productDomainList.size(), findProductList.size());
//    }
//
//    Product getProduct(){
//        Product product = Product.builder()
//                .id(1)
//                .name("name")
//                .category("category")
//                .file_name("file_name")
//                .file_path("file_path")
//                .price(10000)
//                .content("content")
//                .qty(1)
//                .build();
//
//        return product;
//    }
//
//    ProductDomain getProductDomain(){
//        return new ProductDomain(getProduct());
//    }
//}