package shop.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import shop.service.ProductService;
import shop.service.UserService;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class ProductControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductService productService;
    @MockBean
    private UserService userService;

    @Test
    void addProductView() throws Exception {
        mockMvc.perform(get("/product/addProduct"))
                .andExpect(model().attributeExists("product"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void productView() throws Exception {
        mockMvc.perform(get("/product/ProductView").param("category", "top"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void productDetail() throws Exception {
        mockMvc.perform(get("/product/detail").param("name", "test"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}