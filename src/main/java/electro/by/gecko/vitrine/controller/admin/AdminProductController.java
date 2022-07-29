package electro.by.gecko.vitrine.controller.admin;

import electro.by.gecko.vitrine.entity.Product;
import electro.by.gecko.vitrine.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping(path = "/admin/products")
public class AdminProductController {

    private final ProductDAO productDAO;

    @Autowired
    public AdminProductController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @GetMapping(path = "/list")
    public String list(Model model) {

        List<Product> productsUnique = (ArrayList<Product>) productDAO.findAll();

        ArrayList<Product> products = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i < 150; i++) {
            int randomIndex = random.nextInt(productsUnique.size());

            products.add(productsUnique.get(randomIndex));
        }

        model.addAttribute("products", products);

        return "admin/products/list";
    }

    @GetMapping(path = "/new")
    public String formNew(Model model) {
        model.addAttribute("product", new Product());

        return "admin/products/new";
    }

    @PostMapping(path = "/save")
    public String save(Product product) {
        product.setAddedDate(LocalDate.now());
        productDAO.save(product);

        return "redirect:/admin/products/list";
    }
}
