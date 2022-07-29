package electro.by.gecko.vitrine.service.product;

import electro.by.gecko.vitrine.controller.FrontController;
import electro.by.gecko.vitrine.entity.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class ProductModelAssembler implements RepresentationModelAssembler<Product, EntityModel<Product>> {
    @Override
    public EntityModel<Product> toModel(Product product) {
        return EntityModel.of(product,
                linkTo(methodOn(FrontController.class).one(product.getId())).withSelfRel(),
                linkTo(methodOn(FrontController.class).all("", "", Optional.of(0), Optional.of(999999), "", PageRequest.of(0, 4))).withRel("products"));
    }
    public EntityModel<Product> toModel(Product product, Pageable pageable) {
        return EntityModel.of(product,
                linkTo(methodOn(FrontController.class).one(product.getId())).withSelfRel(),
                linkTo(methodOn(FrontController.class).all("", "", Optional.of(0), Optional.of(999999), "", pageable)).withRel("products"));
    }
}
