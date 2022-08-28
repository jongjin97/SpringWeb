package shop.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import shop.dto.RegisterRequest;
import shop.dto.User;
import shop.entity.UserDomain;

import java.util.List;

public interface UserService extends UserDetailsService {
    String save(RegisterRequest registerRequest);
    List<User> findAll();
    User findByEmail(String email);
}
