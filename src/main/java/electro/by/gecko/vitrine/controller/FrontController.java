package electro.by.gecko.vitrine.controller;

import electro.by.gecko.vitrine.entity.Product;
import electro.by.gecko.vitrine.service.product.ProductModelAssembler;
import electro.by.gecko.vitrine.service.product.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class FrontController {
    private final ProductService productService;
    private final ProductModelAssembler modelAssembler;

    public FrontController(@Qualifier("productDAOService") ProductService productService, ProductModelAssembler modelAssembler) {
        this.productService = productService;
        this.modelAssembler = modelAssembler;
    }

    /**
     * List of All Product with optional parameter
     * @param name        Filter by name on all products if required
     * @param description Filter by description on all products if required
     * @param minPrice    Filter by minimum price on all products if required
     * @param maxPrice    Filter by maximum price on all products if required
     * @param brand       Filter by brand on all products if required
     * @param page        Current page if required
     * @return List of Products
     */
    @GetMapping("/products")
    public CollectionModel<EntityModel<Product>> all(String name, String description, Optional<Integer> minPrice, Optional<Integer> maxPrice, String brand, Pageable page) {
        int localMin = (minPrice.isEmpty())? 0: minPrice.get();
        int localMax = (maxPrice.isEmpty())? 999999: maxPrice.get();
        if(null == name) name = "";
        if(null == description) description = "";
        if(null == brand) brand = "";

        List<EntityModel<Product>> products = StreamSupport.stream(productService.findByFilter(name, description, localMin, localMax, brand, page).spliterator(), false)
                .map((product) -> modelAssembler.toModel(product, page)).toList();
        return CollectionModel.of(products, linkTo(methodOn(FrontController.class).all(name, description, minPrice, maxPrice, brand, page)).withSelfRel());
    }

    /**
     * Get One Product
     * @param id Product's ID
     * @return The product with the ID given on parameter
     */
    @GetMapping("/products/{id}")
    public EntityModel<Product> one(@PathVariable Long id) {
        Product product = productService.findById(id);
        return modelAssembler.toModel(product);
    }
}

