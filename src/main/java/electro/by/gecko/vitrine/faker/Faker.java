package electro.by.gecko.vitrine.faker;

import electro.by.gecko.vitrine.entity.Product;

public class Faker { // 10,000.00
    private static final String[] TYPE = {"Machine à laver", "Réfrigérateur", "Four", "Lave-vaisselle", "Aspirateur Roomba", "Grille-pain"};
    private static final String[][] IMAGES = {
        { "images/machine_a_laver.jpg","images/machine_a_laver_avec_hublot.jpg","images/machine_a_laver_avec_hublot_2.jpg",},
        { "images/refrigerateur.jpg","images/refrigerateur_glacons.jpg","images/refrigerateur_rouge.jpg",},
        { "images/four.jpg","images/four.jpg","images/four.jpg",},
        { "images/lave_vaisselle.jpg", "images/lave_vaisselle_2.jpg", "images/lave_vaisselle_industriel.jpg", },
        { "images/roomba.jpg", "images/roomba.jpg", "images/roomba.jpg", },
        { "images/grille_pain_simple.jpg", "images/grille_pain_smeg.jpg", "images/grille_pain_magimix.jpg",}
    };

    private static final String[] BRAND = {"Bosh","Liverpool","Samsung","Laden","LG",};

    private static final String[][] DESCRIPTION = {
        {
                "Ajoutez du linge en cours de cycle, en toute simplicité !\n",
                "Lavez votre linge !",
                "Lavez encore mieux votre linge !",
        },
        {
            "Il bénéficie de la technologie \"Twin POEI System\" qui gère indépendamment le réfrigérateur et le congélateur pour un taux d'humidité parfait.",
            "Des glaçons quand vous voulez ! Conserve également vos aliments.",
            "Un réfrigérateur rouge qui aura toute sa place dans votre cuisine. Disponible en 18 coloris.",
        },
        {
            "Une cuisson toujours réussie !",
            "Une cuisson toujours réussie !",
            "Une cuisson toujours réussie !",
        },
        {
            "Lavez votre vaisselle en toute simplicité !",
            "Des assiettes aussi éblouissantes qu'une éclipse totale de soleil !",
            "Ne laisse pas de tâches sur votre vaisselle !",
        },
        {
            "Aspire tout !",
            "Aspire tout !",
            "Aspire tout !",
        },
        {
            "Pour un pain chaud et croustillant !",
            "Un vrai grille-pain !",
            "Des toasts quand vous voulez.",
        }
    };
    public static Product createRandomProduct() {
        int type = (int) Math.round(Math.random() * 5);
        int brand = (int) Math.round(Math.random() * 4);
        int value = (int) Math.round(Math.random() * 2);

        return new Product(TYPE[type], DESCRIPTION[type][value], BRAND[brand], (int)Math.round(Math.random() * 10000), IMAGES[type][value]);
    }
}
