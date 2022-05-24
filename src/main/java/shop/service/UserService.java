package shop.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import shop.dto.RegisterRequest;

public interface UserService extends UserDetailsService {
    String save(RegisterRequest registerRequest);
}
