package electro.by.gecko.vitrine;

import electro.by.gecko.vitrine.faker.Faker;
import electro.by.gecko.vitrine.service.product.ProductDAOService;
import electro.by.gecko.vitrine.service.user.UserService;
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
    private final ProductDAOService productDAOService;

    @Override
    public void run(String... args) {
        userService.createUser("admin", "admin");

        for (int i = 0; i < 200; i++) {
            productDAOService.save(Faker.createRandomProduct());
        }

        userService.findAll().forEach( (user -> logger.info("{}", user)) );
        productDAOService.findAll().forEach( (product -> logger.info("{}", product)) );
    }
}
