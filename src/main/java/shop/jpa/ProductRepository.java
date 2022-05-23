package shop.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.domain.ProductDomain;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductDomain, Long> {
    public List<ProductDomain> findAllByCategory(String category);
    public ProductDomain findByName(String name);
}
