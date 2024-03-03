package ma.cigma.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import ma.cigma.service.model.Personne;

public class DaoImpl implements IDao {
	private EntityManager session;
	private static final Logger log = Logger.getLogger("DaoImpl");

	@Override
	public void save(Personne p) {
		try {
			session = SessionBuilder.getSessionfactory().createEntityManager();
			EntityTransaction tx = session.getTransaction();
			tx.begin();
			/*
			 * merge : pour insérer ou modifier. persist : pour insérer.
			 * 
			 * session.persist vs session.merge : - persist permet d'ajouter un
			 * objet et son résultat est void. - merge permet de fusionner
			 * l'objet en paramètre avec celui au niveau de la base de données
			 * et attacher l'objet résultat à la session.
			 */
			session.merge(p);
			tx.commit();
			log.info("Personne ajouté avec succés");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("erreur dans save()",e);

		} finally {
			session.close();
		}
	}

	@Override
	public void remove(Long id) {
		try {
			session = SessionBuilder.getSessionfactory().createEntityManager();
			EntityTransaction tx = session.getTransaction();
			tx.begin();
			/*
			 * find() : permet d'attacher un objet à la session.
			 */
			Personne p = session.find(Personne.class, id);
			if (p != null)
				session.remove(p);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			log.error("erreur dans remove()", e);
		} finally {
			session.close();
		}

	}

	@Override
	public List<Personne> getAll() {
		List<Personne> result = null;
		try {
			session = SessionBuilder.getSessionfactory().createEntityManager();
			/*
			 * le language JPQL : JPA Query Language.
			 */
			result = session.createQuery("FROM Personne").getResultList();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("erreur dans getAll()", e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Personne getById(Long id) {
		Personne result = null;
		try {
			session = SessionBuilder.getSessionfactory().createEntityManager();
			result = session.find(Personne.class, id);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("erreur dans getById()", e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Personne> getByName(String name) {
		List<Personne> result = null;
		try {
			session = SessionBuilder.getSessionfactory().createEntityManager();
			/*
			 * le language JPQL : JPA Query Language.
			 */
			Query requete = session.createQuery("select p from Personne p where p.nom like :name");
			requete.setParameter("name", name);
			result = requete.getResultList();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("erreur dans getByName()", e);
			return null;
		} finally {
			session.close();
		}
	}

}
