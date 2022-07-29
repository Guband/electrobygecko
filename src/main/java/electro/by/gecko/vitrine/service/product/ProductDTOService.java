package electro.by.gecko.vitrine.service.product;

import electro.by.gecko.vitrine.dto.ProductDTO;
import electro.by.gecko.vitrine.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;

@Service
public class ProductDTOService {
    private final ProductService daoService;

    private final ProductModelAssembler modelAssembler;

    private final PagedResourcesAssembler<Product> pagedResourcesAssembler;

    public ProductDTOService(ProductDAOService daoService, ProductModelAssembler modelAssembler, PagedResourcesAssembler<Product> pagedResourcesAssembler) {
        this.daoService = daoService;
        this.modelAssembler = modelAssembler;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    public CollectionModel<ProductDTO> findAll(String search, Integer minPrice, Integer maxPrice, String brand, Pageable pageable) {
        Page<Product> productPage = daoService.findByFilter(search, minPrice, maxPrice, brand, pageable);
        if(null != productPage)
            return pagedResourcesAssembler.toModel(productPage, modelAssembler);
        return null;
    }

    public ProductDTO findOne(Long id) {
        Product product = daoService.findById(id);
        if(null != product)
            return modelAssembler.toModel(product);
        return null;
    }
}
