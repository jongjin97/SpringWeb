package shop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import shop.domain.UserDomain;
import shop.jpa.UserRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@Import({UserServiceImpl.class, UserRepository.class})
class UserServiceImplTest {

    @MockBean
    UserRepository userRepository;

    @Autowired
    UserServiceImpl userService;

    @Test
    void loadUserByUsername() {
    }

    @Test
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