//package shop.jpa;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.transaction.annotation.Transactional;
//import shop.dto.Product;
//import shop.entity.ProductDomain;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class ProductRepositoryTest {
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Test
//    @Transactional
//    void save(){
//        ProductDomain productDomain = getProductDomain();
//
//        ProductDomain savedProduct = productRepository.save(productDomain);
//        assertNotNull(savedProduct);
//    }
//
//    @Test
//    @Transactional
//    void findAllByCategory() {
//        ProductDomain productDomain = getProductDomain();
//
//        productRepository.save(getProductDomain());
//        productRepository.save(getProductDomain());
//        List<ProductDomain> productDomainList = productRepository.findAllByCategory(productDomain.getCategory());
//
//        assertEquals(productDomainList.size(), 2);
//    }
//
//    @Test
//    @Transactional
//    void findByName() {
//        ProductDomain productDomain = getProductDomain();
//
//        productRepository.save(productDomain);
//        ProductDomain resultProduct = productRepository.findByName(productDomain.getName());
//
//        assertEquals(productDomain.getName(), resultProduct.getName());
//    }
//
//    @Test
//    @Transactional
//    void removeByName() {
//        ProductDomain productDomain = getProductDomain();
//
//        ProductDomain savedProduct = productRepository.save(productDomain);
//        assertNotNull(savedProduct);
//
//        productRepository.removeByName(productDomain.getName());
//        ProductDomain findProduct = productRepository.findByName(productDomain.getName());
//
//        assertNull(findProduct);
//    }
//
//    ProductDomain getProductDomain(){
//        Product product = Product.builder()
//                .name("name")
//                .category("category")
//                .file_name("file_name")
//                .file_path("file_path")
//                .price(10000)
//                .content("content")
//                .qty(1)
//                .build();
//        ProductDomain productDomain = new ProductDomain(product);
//        return  productDomain;
//    }
//}