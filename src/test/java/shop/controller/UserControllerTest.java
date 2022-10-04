package shop.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import shop.dto.RegisterRequest;
import shop.dto.User;
import shop.service.UserService;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void 로그인페이지_접속() throws Exception {
        mockMvc.perform(get("/user/login"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("LoginUser"))
                .andDo(print());
    }

    @Test
    public void 회원가입페이지_접속() throws Exception{
        mockMvc.perform(get("/user/register"))
                .andExpect(model().attributeExists("registerRequest"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}