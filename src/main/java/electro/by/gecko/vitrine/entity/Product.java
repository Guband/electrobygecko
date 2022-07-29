package electro.by.gecko.vitrine.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DecimalFormat;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name, description, brand, image;

    private int price;

    private LocalDate addedDate;

    public Product(String name, String description, String brand, int price, String image) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.image = image;
        this.addedDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return String.format("Product( id: %d, name: %s, description: %s, brand: %s, price: %d)", this.id, this.name, this.description, this.brand, this.price);
    }

    public String displayPrice() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        return String.format("%s €", decimalFormat.format(price / 100.));
    }
}
