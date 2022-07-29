package electro.by.gecko.vitrine.service.product;


import electro.by.gecko.vitrine.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;

public interface ProductService {
    Product findById(Long id)throws EntityNotFoundException;
    Product save(Product product);
    void deleteById(Long id) throws EntityNotFoundException;

    Iterable<Product> findAll();

    Iterable<Product> findByFilter(String name, String description, int minPrice, int maxPrice, String brand, Pageable page);

    Page<Product> findPage(Pageable page);
}
