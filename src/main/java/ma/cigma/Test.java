package ma.cigma;

import ma.cigma.dao.DaoImpl;
import ma.cigma.dao.IDao;
import ma.cigma.service.model.Identite;
import ma.cigma.service.model.Personne;

public class Test {
	static IDao dao = new DaoImpl();

	static void savePersonne(String nom, String prenom, String cin) {
		dao.save(new Personne(nom, prenom, new Identite(cin)));
	}

	public static void main(String[] args) {
		savePersonne("nom_petrsonne_1", "prenom_personne_1", "A236");
		savePersonne("nom_petrsonne_2", "prenom_personne_2", "B1236");
//		dao.remove(4l);
//
//		Personne p = dao.getById(6l);
//		System.out.println("la CIN est :" + p.getIdentite().getCin());
	}

}
