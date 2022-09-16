package shop.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.entity.OrderDomain;
import shop.entity.ProductDomain;

@Repository
public interface OrderRepository extends JpaRepository<OrderDomain, Long> {

}
