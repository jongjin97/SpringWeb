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
        System.out.println("email = " + email);
        UserDomain userDomain = userRepository.findByEmail(email);
        List<GrantedAuthority> authorities = new ArrayList<>();

        if("admin".equals(email))
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        else
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));

        if(userDomain == null) throw new EmailNotFoundException("NOT Found account.");

        return new User(userDomain.getEmail(), userDomain.getPassword(), authorities);
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
