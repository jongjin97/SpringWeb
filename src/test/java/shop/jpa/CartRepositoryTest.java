package shop.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import shop.entity.CartDomain;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartRepositoryTest {

    @Autowired
    private CartRepository cartRepository;

    @Test
    @Transactional
    void save(){
        CartDomain cartDomain = getCartDomain();
        CartDomain savedCartDomain = cartRepository.save(cartDomain);

        assertNotNull(savedCartDomain);
        assertEquals(cartDomain.getProductId(), savedCartDomain.getProductId());

    }

    @Test
    @Transactional
    void findByUserEmail() {
        CartDomain cartDomain = getCartDomain();
        cartRepository.save(cartDomain);

        List<CartDomain> findCartDomain = cartRepository.findByUserEmail(cartDomain.getUserEmail());

        assertEquals(findCartDomain.size(), 1);
    }

    @Test
    @Transactional
    void deleteById() {
        CartDomain cartDomain = getCartDomain();
        CartDomain savedCartDomain = cartRepository.save(cartDomain);

        assertNotNull(savedCartDomain);

        cartRepository.deleteById(savedCartDomain.getId());

        Optional<CartDomain> findCartDomain = cartRepository.findById(cartDomain.getId());
        assertEquals(true, findCartDomain.isEmpty());

    }

    CartDomain getCartDomain(){
        CartDomain cartDomain = new CartDomain();
        cartDomain.setProductId(5);
        cartDomain.setProductCategory("category");
        cartDomain.setProductName("Pname");
        cartDomain.setProduct_Price(10000);
        cartDomain.setProductQty(10);
        cartDomain.setUserId(1);
        cartDomain.setUserEmail("test@test.com");
        cartDomain.setUserName("Uname");
        cartDomain.setFilePath("filePath");
        return cartDomain;
    }
}