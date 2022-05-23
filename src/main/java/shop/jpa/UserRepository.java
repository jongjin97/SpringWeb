package shop.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.domain.UserDomain;

@Repository
public interface UserRepository extends JpaRepository<UserDomain, Long> {
    public UserDomain findByEmail(String email);
}
