package electro.by.gecko.vitrine;

import electro.by.gecko.vitrine.entity.Product;
import electro.by.gecko.vitrine.repository.ProductDAO;
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
    private final ProductDAO productDAO;

    @Override
    public void run(String... args) {
        userService.createUser("admin", "admin");
        productDAO.save(new Product("Machine à laver", "Ajoutez du linge en cours de cycle, en toute simplicité !\n", "Bosh", 500, "images/machine_a_laver.jpg"));
        productDAO.save(new Product("Machine à laver", "Lavez votre linge !", "Liverpool", 500, "images/machine_a_laver_avec_hublot.jpg"));
        productDAO.save(new Product("Machine à laver", "Lavez encore mieux votre linge !", "Samsung", 500, "images/machine_a_laver_avec_hublot_2.jpg"));
        productDAO.save(new Product("Réfrigérateur", "Il bénéficie de la technologie \"Twin POEI System\" qui gère indépendamment le réfrigérateur et le congélateur pour un taux d'humidité parfait.", "Laden", 500, "images/refrigerateur.jpg"));
        productDAO.save(new Product("Réfrigérateur à glaçons", "Des glaçons quand vous voulez ! Conserve également vos aliments.", "Laden", 500, "images/refrigerateur_glacons.jpg"));
        productDAO.save(new Product("Réfrigérateur rouge", "Un réfrigérateur rouge qui aura toute sa place dans votre cuisine. Disponible en 18 coloris.", "LG", 500, "images/refrigerateur_rouge.jpg"));
        productDAO.save(new Product("Four", "Une cuisson toujours réussie !", "Samsung", 500, "images/four.jpg"));
        productDAO.save(new Product("Lave-vaisselle", "Lavez votre vaisselle en toute simplicité !", "Bosch", 500, "images/lave_vaisselle.jpg"));
        productDAO.save(new Product("Lave-vaisselle ", "Des assiettes aussi éblouissantes qu'une éclipse totale de soleil !", "Samsung", 500, "images/lave_vaisselle_2.jpg"));
        productDAO.save(new Product("Lave-vaisselle", "Ne laisse pas de tâches sur votre vaisselle !", "Laden", 500, "images/lave_vaisselle_industriel.jpg"));
        productDAO.save(new Product("Aspirateur Roomba", "Aspire tout !", "LG", 500, "images/roomba.jpg"));
        productDAO.save(new Product("Grille-pain", "Pour un pain chaud et croustillant !", "LG", 500, "images/grille_pain_simple.jpg"));
        productDAO.save(new Product("Grille-pain", "Un vrai grille-pain !", "Samsung", 500, "images/grille_pain_smeg.jpg"));
        productDAO.save(new Product("Grille-pain", "Des toasts quand vous voulez.", "Laden", 500, "images/grille_pain_magimix.jpg"));

        userService.findAll().forEach( (user -> logger.info("{}", user)) );
        productDAO.findAll().forEach( (product -> logger.info("{}", product)) );
    }
}
