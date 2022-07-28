package electro.by.gecko.vitrine.repository;

import electro.by.gecko.vitrine.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDAO extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
