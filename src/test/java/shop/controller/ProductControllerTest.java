//package shop.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Import;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;
//import shop.config.SecurityConfig;
//import shop.dto.Product;
//import shop.service.implement.ProductServiceImpl;
//import shop.service.implement.UserServiceImpl;
//
//import java.awt.*;
//import java.io.File;
//import java.nio.charset.StandardCharsets;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(ProductController.class)
//@AutoConfigureMockMvc
//class ProductControllerTest {
//
//    @MockBean
//    private ProductServiceImpl productService;
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private UserServiceImpl userService;
//
//    @Test
//    void addProductView() throws Exception {
//        mockMvc.perform(get("/product/addProduct"))
//                .andExpect(status().isOk())
//                .andExpect(model().attributeExists("product"))
//                .andDo(print());
//    }
//
//    @Test
//    void addProduct() throws Exception {
////        Product product = getProduct();
////
////        MockMultipartFile file =
////                new MockMultipartFile(
////                        "file",
////                        "test contract.pdf",
////                        MediaType.APPLICATION_PDF_VALUE,
////                        "<<pdf data>>".getBytes(StandardCharsets.UTF_8));
////        ObjectMapper objectMapper = new ObjectMapper();
////
////        mockMvc.perform(post("/product/addProduct"))
////                .andExpect((ResultMatcher) multipart("/product/addProduct/").file(file).accept(MediaType.APPLICATION_JSON))
////                .andExpect(status().isOk())
////                .andDo(print());
//    }
//
//    @Test
//    void fileUpload() {
//    }
//
//    @Test
//    void productView() throws Exception {
//        mockMvc.perform(get("/product/ProductView").param("category", "top"))
//                .andExpect(model().attributeExists("list"))
//                .andExpect(status().isOk())
//                .andDo(print());
//    }
//
//    @Test
//    void productDetail() throws Exception {
//        Product product = getProduct();
//
//        given(productService.findByProductName("name")).willReturn(product);
//
//        mockMvc.perform(get("/product/detail").param("name", "name"))
//                .andExpect(model().attributeExists("product"))
//                .andExpect(status().isOk())
//                .andDo(print());
//    }
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
//}