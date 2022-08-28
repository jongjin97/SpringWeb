package shop.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.entity.ProductDomain;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductDomain, Long> {
    List<ProductDomain> findAllByCategory(String category);
    ProductDomain findByName(String name);
    void removeByName(String name);
}
