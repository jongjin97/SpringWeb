package shop.service.implement;

import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import shop.config.Role;
import shop.dto.RegisterRequest;
import shop.dto.User;
import shop.entity.UserDomain;
import shop.jpa.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;
    @MockBean(name = "userRepository")
    private UserRepository userRepository;

    @Test
    void loadUserByUsername() {
        UserDomain userDomain = getUserDomain();
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

        grantedAuthorityList.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        given(userRepository.findByEmail(userDomain.getEmail())).willReturn(userDomain);


        UserDetails userDetails = userService.loadUserByUsername(userDomain.getEmail());

        assertEquals(userDetails.getUsername(), userDomain.getEmail());
        assertEquals(userDetails.getPassword(), userDomain.getPassword());
        assertEquals(userDetails.getAuthorities().stream().iterator().next(), grantedAuthorityList.iterator().next());

    }

    @Test
    void save() {
        RegisterRequest registerRequest = getRegisterRequest();
        UserDomain userDomain = getUserDomain();

        given(userRepository.findByEmail(registerRequest.getEmail())).willReturn(null);
        when(userRepository.save(any(UserDomain.class))).then(AdditionalAnswers.returnsFirstArg());

        String email = userService.save(registerRequest);

        assertEquals(email, getUserDomain().getEmail());
    }

    @Test
    void findAll() {
        List<UserDomain> list = new ArrayList<>();
        list.add(getUserDomain());

        given(userRepository.findAll()).willReturn(list);

        List<User> userList = userService.findAll();

        assertEquals(userList.size(), list.size());
        assertEquals(userList.get(0).getEmail(), list.get(0).getEmail());
    }

    @Test
    void findByEmail() {
        UserDomain userDomain = getUserDomain();

        given(userRepository.findByEmail(userDomain.getEmail())).willReturn(userDomain);

        User user = userService.findByEmail(userDomain.getEmail());

        assertEquals(user.getEmail(), userDomain.getEmail());
    }

    @Test
    void deleteUser() {
        doAnswer(invocation -> {
            String email = invocation.getArgument(0);

            assertEquals(email, "test@test.com");

            return null;
        }).when(userRepository).deleteByEmail(anyString());

        userService.deleteUser(getUserDomain().getEmail());

        verify(userRepository).deleteByEmail(getUserDomain().getEmail());
    }

    RegisterRequest getRegisterRequest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("test@test.com");
        registerRequest.setName("test");
        registerRequest.setPassword("test");
        registerRequest.setConfirm("test");

        return registerRequest;
    }

    UserDomain getUserDomain(){
        UserDomain userDomain = new UserDomain();
        userDomain.setId(1);
        userDomain.setEmail("test@test.com");
        userDomain.setName("test");
        userDomain.setPassword("test");

        return userDomain;
    }
}