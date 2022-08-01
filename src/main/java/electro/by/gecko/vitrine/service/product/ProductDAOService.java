package electro.by.gecko.vitrine.service.product;

import electro.by.gecko.vitrine.entity.Product;
import electro.by.gecko.vitrine.repository.ProductDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ProductDAOService implements ProductService {
    private final ProductDAO productDAO;

    public ProductDAOService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public Product findById(Long id) {
        return productDAO.findById(id).orElse(null); //Throw(() -> new ProductNotFoundException(id));
    }

    @Override
    public Product save(Product product) {
        return productDAO.save(product);
    }

    @Override
    public void deleteById(Long id) {
        if(null != productDAO.findById(id).orElse(null))  //.orElseThrow(() -> new ProductNotFoundException(id));
            productDAO.deleteById(id);
    }

    @Override
    public Iterable<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Page<Product> findByFilter(String search, int minPrice, int maxPrice, String brand, Pageable page) {
        return productDAO.findFilter(search, minPrice, maxPrice, brand, page);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productDAO.findAll(pageable);
    }
}
