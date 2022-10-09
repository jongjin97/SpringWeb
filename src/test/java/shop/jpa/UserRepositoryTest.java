package shop.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import shop.entity.UserDomain;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    void save(){
        UserDomain userDomain = getUserDomain();

        UserDomain savedUser = userRepository.save(userDomain);

        assertEquals(userDomain.getEmail(), savedUser.getEmail());
    }

    @Test
    @Transactional
    void findByEmail() {
        UserDomain userDomain = getUserDomain();

        UserDomain savedUser = userRepository.save(userDomain);
        UserDomain findUser = userRepository.findByEmail(userDomain.getEmail());

        assertNotNull(findUser);
        assertEquals(userDomain.getEmail(), findUser.getEmail());
    }

    @Test
    @Transactional
    void deleteByEmail() {
        UserDomain userDomain = getUserDomain();

        UserDomain savedUser = userRepository.save(userDomain);
        UserDomain findUser = userRepository.findByEmail(userDomain.getEmail());

        assertNotNull(findUser);

        userRepository.deleteByEmail(userDomain.getEmail());
        findUser = userRepository.findByEmail(userDomain.getEmail());

        assertNull(findUser);
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