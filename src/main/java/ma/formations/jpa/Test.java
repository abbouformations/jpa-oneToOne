package ma.formations.jpa;

import ma.formations.jpa.dao.DaoImpl;
import ma.formations.jpa.dao.IDao;
import ma.formations.jpa.service.model.Adresse;
import ma.formations.jpa.service.model.Personne;

public class Test {

    static IDao dao = new DaoImpl();

    public static void save(String nom, String prenom, String rue, String ville, String codePostal) {
        dao.save(Personne.builder().nom(nom).prenom(prenom).adresse(
                Adresse.builder().rue(rue).ville(ville).codePostal(codePostal).build()).build());
    }

    public static void main(String[] args) {
        //Ajouter des personnes avec leurs adresses
        save("Alami", "Mohamed", "Tetouan", "Rabat", "10000");
        save("Sahnani", "Salim", "Ouahda", "Rabat", "10000");
        save("Ahmadi", "Imad", "Al Farah", "Oujda", "12500");
        save("Boukhari", "Hanan", "Annasrn", "Agadir", "18000");

        //Consulter la liste des personnes
        dao.getAll().forEach(System.out::println);

        //Consulter une personne par son nom
        dao.getByName("Alami").forEach(System.out::println);

        //Supprimer toutes les personnes qui habitent à Rabat
        dao.getAll().stream().
                filter(p -> p.getAdresse().getVille().equalsIgnoreCase("rabat")).
                forEach(p -> dao.remove(p.getId()));

        //Modifier l'adresse d'une personne donnée
        dao.getByName("Ahmadi").forEach(p -> {
            p.getAdresse().setRue("Al Farah 2");
            p.getAdresse().setVille("Nador");
            dao.save(p);
        });
    }
}
