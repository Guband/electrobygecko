package electro.by.gecko.vitrine.service.product;

import electro.by.gecko.vitrine.controller.FrontController;
import electro.by.gecko.vitrine.dto.ProductDTO;
import electro.by.gecko.vitrine.entity.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;


import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class ProductModelAssembler implements RepresentationModelAssembler<Product, ProductDTO> {
    @Override
    public ProductDTO toModel(Product entity) {
        ProductDTO dto = new ProductDTO(entity.getId(), entity.getName(), entity.getDescription(), entity.getBrand(), entity.getImage(), entity.getPrice(), entity.getAddedDate());
        dto.add(linkTo(methodOn(FrontController.class).one(entity.getId())).withSelfRel());
        dto.add(linkTo(methodOn(FrontController.class).all("", Optional.of(0), Optional.of(999999), "", PageRequest.of(0, 20))).withRel("products"));
        return dto;
    }
}
