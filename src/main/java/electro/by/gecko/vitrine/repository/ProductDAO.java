package electro.by.gecko.vitrine.repository;

import electro.by.gecko.vitrine.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Product, Long> {
}
