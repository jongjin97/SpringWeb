package shop.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.entity.CartDomain;

import java.util.List;

public interface CartRepository extends JpaRepository<CartDomain, Long> {
    List<CartDomain> findByUserEmail(String email);
    void deleteById(long id);
}
