package electro.by.gecko.vitrine.repository;

import electro.by.gecko.vitrine.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductDAO extends PagingAndSortingRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE " +
            "UPPER(p.name) LIKE CONCAT('%', UPPER(?1),'%') and " +
            "UPPER(p.description) LIKE CONCAT('%', UPPER(?2),'%') and " +
            "p.price >= ?3 and p.price <= ?4 and "+
            "UPPER(p.brand) LIKE CONCAT('%', UPPER(?5),'%')")
    List<Product> findFilter(String name, String description, int minPrice, int maxPrice, String brand, Pageable pageable);

}
