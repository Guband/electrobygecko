package electro.by.gecko.vitrine.controller;

import electro.by.gecko.vitrine.dto.ProductDTO;
import electro.by.gecko.vitrine.service.product.ProductDTOService;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class FrontController {
    private final ProductDTOService productService;

    public FrontController(ProductDTOService productService) {
        this.productService = productService;
    }

    /**
     * List of All Product with optional parameter
     * @param search      Search on product's name, description or brand on all products if required
     * @param minPrice    Filter by minimum price on all products if required
     * @param maxPrice    Filter by maximum price on all products if required
     * @param brand       Filter by brand on all products if required
     * @param page        Current page if required
     * @return List of Products
     */
    @GetMapping("/products")
    public ResponseEntity all(String search, Optional<Integer> minPrice, Optional<Integer> maxPrice, String brand, Pageable page) {
        int localMin = (minPrice.isEmpty())? 0: minPrice.get();
        int localMax = (maxPrice.isEmpty())? 999999: maxPrice.get();
        if(null == search) search = "";
        if(null == brand) brand = "";

        CollectionModel<ProductDTO> productDTOS = productService.findAll(search, localMin, localMax, brand, page);

        if(null == productDTOS) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(productDTOS);
    }

    /**
     * Get One Product
     * @param id Product's ID
     * @return The product with the ID given on parameter
     */
    @GetMapping("/products/{id}")
    public ResponseEntity one(@PathVariable Long id) {
        ProductDTO dto = productService.findOne(id);
        if(null == dto) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }
}

