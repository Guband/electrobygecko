package electro.by.gecko.vitrine;

import electro.by.gecko.vitrine.entity.Product;
import electro.by.gecko.vitrine.repository.ProductDAO;
import electro.by.gecko.vitrine.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VitrineInitializer implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(VitrineInitializer.class);

    @Autowired
    private final UserService userService;

    @Autowired
    private final ProductDAO productDAO;

    @Override
    public void run(String... args) {
        userService.createUser("admin", "admin");
        productDAO.save(new Product("Machine à Laver", "Ajoutez du linge en cours de cycle, en toute simplicité !\n", "Bosh", 500));
        productDAO.save(new Product("Réfrigérateur", "Il bénéficie de la technologie \"Twin POEI System\" qui gère indépendamment le réfrigérateur et le congélateur pour un taux d'humidité parfait.", "Laden", 500));
        productDAO.save(new Product("Four", "Une cuisson toujours réussie !", "Samsung", 500));

        userService.findAll().forEach( (user -> logger.info("{}", user)) );
        productDAO.findAll().forEach( (product -> logger.info("{}", product)) );
    }
}
