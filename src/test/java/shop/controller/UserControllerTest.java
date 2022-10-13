//package shop.controller;
//
//import com.google.gson.Gson;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import shop.dto.RegisterRequest;
//import shop.service.implement.UserServiceImpl;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(UserController.class)
//@AutoConfigureMockMvc
//class UserControllerTest {
//
//    @MockBean
//    private UserServiceImpl userService;
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    @DisplayName("로그인 사이트 접속 성공")
//    void login() throws Exception {
//        mockMvc.perform(get("/user/login"))
//                .andExpect(model().attributeExists("LoginUser"))
//                .andExpect(status().isOk())
//                .andDo(print());
//    }
//
//    @Test
//    @DisplayName("회원가입 사이트 접속 성공")
//    void registerview() throws Exception {
//        mockMvc.perform(get("/user/register"))
//                .andExpect(model().attributeExists("registerRequest"))
//                .andExpect(status().isOk())
//                .andDo(print());
//    }
//
//    @Test
//    @DisplayName("회원 가입 성공")
//    void registeruser() throws Exception {
//        RegisterRequest registerRequest = new RegisterRequest();
//        registerRequest.setEmail("test@test.com");
//        registerRequest.setName("test");
//        registerRequest.setPassword("test");
//        registerRequest.setConfirm("test");
//
//        given(userService.save(registerRequest)).willReturn(registerRequest.getEmail());
//
//        mockMvc.perform(post("/user/register").flashAttr("registerRequest", registerRequest))
//                .andExpect(status().is3xxRedirection())
//                .andDo(print());
//
//        assertEquals(userService.save(registerRequest), registerRequest.getEmail());
//    }
//
//    @Test
//    @DisplayName("회원 가입 비밀번호 일치 하지 않음")
//    void registeConfirmPasswrod() throws Exception {
//        RegisterRequest registerRequest = new RegisterRequest();
//        registerRequest.setEmail("test@test.com");
//        registerRequest.setName("test");
//        registerRequest.setPassword("test1");
//        registerRequest.setConfirm("test2");
//
//        mockMvc.perform(post("/user/register").flashAttr("registerRequest", registerRequest))
//                .andExpect(status().isOk())
//                .andExpect(view().name("register"))
//                .andDo(print());
//    }
//
//}