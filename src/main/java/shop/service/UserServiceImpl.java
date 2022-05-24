package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.domain.UserDomain;
import shop.dto.RegisterRequest;
import shop.exception.EmailNotFoundException;
import shop.jpa.UserRepository;
import shop.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws EmailNotFoundException{
        UserDomain userDomain = userRepository.findByEmail(email);

        if(userDomain == null) throw new EmailNotFoundException("NOT Found account.");

        return (UserDetails) userDomain;
    }

    @Override
    @Transactional
    public String save(RegisterRequest registerRequest) {
        UserDomain userDomain = registerRequest.toEntity();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userDomain.setPassword(passwordEncoder.encode(userDomain.getPassword()));

        return userRepository.save(userDomain).getEmail();
    }
}
