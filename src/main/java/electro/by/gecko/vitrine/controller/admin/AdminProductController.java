package electro.by.gecko.vitrine.controller.admin;

import electro.by.gecko.vitrine.entity.Product;
import electro.by.gecko.vitrine.service.product.ProductDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping(path = "/admin/products")
public class AdminProductController {

    private final ProductDAOService productDAOService;

    @Autowired
    public AdminProductController(ProductDAOService productDAOService) {
        this.productDAOService = productDAOService;
    }

    @GetMapping(path = "/list")
    public String list(Model model) {

        model.addAttribute("products", productDAOService.findAll());

        return "admin/products/list";
    }

    @GetMapping(path = "/new")
    public String formCreate(Model model) {
        model.addAttribute("product", new Product());

        return "admin/products/new";
    }

    @GetMapping(path = "/{id}")
    public String formEdit(Model model, @PathVariable Long id) {
        model.addAttribute("product", productDAOService.findById(id));

        return "admin/products/edit";
    }

    @PostMapping
    public String save(Product product) {
        if (product.getId() == null) {
            product.setAddedDate(LocalDate.now());
        }

        productDAOService.save(product);

        return "redirect:/admin/products/list";
    }
}
