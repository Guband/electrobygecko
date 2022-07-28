package electro.by.gecko.vitrine.repository;

import electro.by.gecko.vitrine.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Long> {
}
