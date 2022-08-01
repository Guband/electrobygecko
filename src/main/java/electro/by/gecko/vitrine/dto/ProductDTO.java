package electro.by.gecko.vitrine.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

/**
 * Data transfer object for expose Product to outside the application
 */
@Getter
@Setter
@AllArgsConstructor
public class ProductDTO extends RepresentationModel<ProductDTO> {
    private long id;

    private String name, description, brand, image;

    private int price;

    private LocalDate addedDate;
}
