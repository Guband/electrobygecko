package electro.by.gecko.vitrine.service.product;

import electro.by.gecko.vitrine.entity.Product;
import electro.by.gecko.vitrine.exception.ProductNotFoundException;
import electro.by.gecko.vitrine.repository.ProductDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ProductDAOService implements ProductService{
    private final ProductDAO productDAO;

    public ProductDAOService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public Product findById(Long id) throws EntityNotFoundException {
        return productDAO.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public Product save(Product product) {
        return productDAO.save(product);
    }

    @Override
    public void deleteById(Long id) throws EntityNotFoundException {
        productDAO.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        productDAO.deleteById(id);
    }

    @Override
    public Iterable<Product> findAll() {
        return productDAO.findAll();
    }

    public Page<Product> findPage(Pageable page) {
        return productDAO.findAll(page);
    }

    @Override
    public Iterable<Product> findByFilter(String name, String description, int minPrice, int maxPrice, String brand, Pageable page) {
        return productDAO.findFilter(name, description, minPrice, maxPrice, brand, page);
    }
}
