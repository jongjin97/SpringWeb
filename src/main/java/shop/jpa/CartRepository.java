package shop.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.entity.CartDomain;

public interface CartRepository extends JpaRepository<CartDomain, Long> {
}
