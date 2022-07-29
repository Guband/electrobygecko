package electro.by.gecko.vitrine.repository;

import electro.by.gecko.vitrine.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductDAO extends PagingAndSortingRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE (" +
            "UPPER(p.name) LIKE CONCAT('%', UPPER(?1),'%') OR " +
            "UPPER(p.description) LIKE CONCAT('%', UPPER(?1),'%') OR " +
            "UPPER(p.brand) LIKE CONCAT('%', UPPER(?1),'%') ) AND " +
            "p.price >= ?2 AND p.price <= ?3 AND "+
            "UPPER(p.brand) LIKE CONCAT('%', UPPER(?4),'%')")
    Page<Product> findFilter(String search, int minPrice, int maxPrice, String brand, Pageable pageable);

}
