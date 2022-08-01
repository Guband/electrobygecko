package electro.by.gecko.vitrine.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/admin")
public class AdminHomeController {

    /**
     * Index of Back-office
     * @return A redirection to Product List
     */
    @GetMapping
    public String home() {
        return "redirect:/admin/products";
    }
}
