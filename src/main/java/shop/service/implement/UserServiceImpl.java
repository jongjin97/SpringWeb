package shop.service.implement;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.entity.UserDomain;
import shop.dto.RegisterRequest;
import shop.exception.DuplicateMemberException;
import shop.exception.EmailNotFoundException;
import shop.jpa.UserRepository;
import shop.config.Role;
import shop.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws EmailNotFoundException{
        UserDomain userDomain = userRepository.findByEmail(email);
        List<GrantedAuthority> authorities = new ArrayList<>();

        if("kakao1302@naver.com".equals(email))
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        else
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));

        if(userDomain == null) throw new EmailNotFoundException("NOT Found account.");

        return new User(userDomain.getEmail(), userDomain.getPassword(), authorities);
    }

    @Override
    @Transactional
    public String save(RegisterRequest registerRequest) {
        ModelMapper modelMapper = new ModelMapper();
        UserDomain userDomain = modelMapper.map(registerRequest, UserDomain.class);

        UserDomain user = userRepository.findByEmail(registerRequest.getEmail());
        if(user != null) throw new DuplicateMemberException("아이디 중복");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userDomain.setPassword(passwordEncoder.encode(userDomain.getPassword()));

        return userRepository.save(userDomain).getEmail();
    }

    @Override
    public List<shop.dto.User> findAll() {
        List<UserDomain> list = userRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<shop.dto.User> result = list.stream().map(
                userDomain -> modelMapper.map(userDomain, shop.dto.User.class)).collect(Collectors.toList());

        return result;
    }

    @Override
    public shop.dto.User findByEmail(String email) {
        UserDomain userDomain = userRepository.findByEmail(email);
        ModelMapper modelMapper = new ModelMapper();
        shop.dto.User user = modelMapper.map(userDomain, shop.dto.User.class);
        return user;
    }

    @Override
    @Transactional
    public void deleteUser(String email) {
        userRepository.deleteByEmail(email);
    }
}
