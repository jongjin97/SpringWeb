package shop.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;
import shop.dto.RegisterRequest;
import shop.dto.User;
import shop.entity.UserDomain;
import shop.exception.DuplicateMemberException;
import shop.jpa.UserRepository;
import shop.service.implement.UserServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;

    private ModelMapper modelMapper;
    private RegisterRequest registerRequest;
    @BeforeEach
    void setUp(){
        modelMapper = new ModelMapper();
        registerRequest = new RegisterRequest();
        registerRequest.setEmail("test@test.com");
        registerRequest.setName("test");
        registerRequest.setPassword("test");
        registerRequest.setConfirm("test");
    }

    @Test
    @Transactional
    void save() {
        UserDomain userDomain = modelMapper.map(registerRequest, UserDomain.class);
        given(userRepository.save(userDomain)).willReturn(userDomain);
        UserDomain result = userRepository.save(userDomain);

        assertEquals(result.getEmail(), userDomain.getEmail());
        verify(userRepository).save(userDomain);
    }

    @Test
    @Transactional
    void duplicate(){
        UserDomain userDomain = modelMapper.map(registerRequest, UserDomain.class);

        assertThrows(DuplicateMemberException.class, () -> {
            given(userRepository.findByEmail(userDomain.getEmail())).willReturn(userDomain);
            userService.save(registerRequest);
        });
    }

    @Test
    void findAll() {
        assertEquals(userRepository.findAll().size(), 0);

        UserDomain userDomain = modelMapper.map(registerRequest, UserDomain.class);

        List<UserDomain> list = Arrays.asList(new UserDomain());
        given(userRepository.findAll()).willReturn(list);

        assertEquals(userRepository.findAll().size(), 1);
    }

    @Test
    void findByEmail() {
        UserDomain userDomain = modelMapper.map(registerRequest, UserDomain.class);

        given(userRepository.findByEmail(userDomain.getEmail())).willReturn(userDomain);

        assertEquals(userRepository.findByEmail(userDomain.getEmail()), userDomain);
    }

    @Test
    void deleteUser() {
        UserDomain userDomain = modelMapper.map(registerRequest, UserDomain.class);
        UserDomain userDomain1 = new UserDomain();
        UserDomain userDomain2 = new UserDomain();

        userDomain1.setEmail("abc");
        userDomain2.setEmail("abcd");

        List<UserDomain> list = new ArrayList<>();
        list.add(userDomain);
        list.add(userDomain1);
        list.add(userDomain2);

        given(userRepository.findAll()).willReturn(list);
        assertEquals(userRepository.findAll().size(), 3);

        userRepository.deleteByEmail(userDomain.getEmail());

        verify(userRepository).deleteByEmail(userDomain.getEmail());
    }
}