package electro.by.gecko.vitrine.service.product;


import electro.by.gecko.vitrine.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {
    Product findById(Long id);
    Product save(Product product);
    void deleteById(Long id);

    Iterable<Product> findAll();

    Page<Product> findByFilter(String search, int minPrice, int maxPrice, String brand, Pageable page);

}
