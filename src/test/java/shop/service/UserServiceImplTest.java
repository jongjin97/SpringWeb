package shop.service;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import shop.config.SecurityConfig;
import shop.domain.UserDomain;
import shop.dto.RegisterRequest;
import shop.exception.EmailNotFoundException;
import shop.jpa.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@Import({UserServiceImpl.class, UserRepository.class})
class UserServiceImplTest {

    @MockBean
    UserRepository userRepository;

    @Autowired
    UserServiceImpl userService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    @DisplayName("조회")
    void loadUserByUsername(){

    }

    @Test
    @DisplayName("저장 후 조회회")
    void save() {
        //given
        Mockito.when(userRepository.findByEmail("kakao1302@naver.com"))
                .thenReturn(new UserDomain("kakao1302@naver.com", "윤종진", "123qwe"));

        userRepository.save(new UserDomain("kakao1302@naver.com", "윤종진", "123qwe"));
        UserDomain userDomain = userRepository.findByEmail("kakao1302@naver.com");

        Assertions.assertEquals(userDomain.getEmail(), "kakao1302@naver.com");
        Assertions.assertEquals(userDomain.getName(), "윤종진");
        Assertions.assertEquals(userDomain.getPassword(), "123qwe");

    }
}