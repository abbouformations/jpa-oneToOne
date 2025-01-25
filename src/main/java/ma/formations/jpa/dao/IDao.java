package ma.formations.jpa.dao;

import java.util.List;

import ma.formations.jpa.service.model.Personne;

public interface IDao {
	void save(Personne p);

	void remove(Long id);

	List<Personne> getAll();

	Personne getById(Long id);

	List<Personne> getByName(String name);

}
