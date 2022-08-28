package shop.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.entity.UserDomain;

@Repository
public interface UserRepository extends JpaRepository<UserDomain, Long> {
    UserDomain findByEmail(String email);
}
