package ma.cigma.service.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Personne implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private String prenom;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "cin")
	@Basic(fetch=FetchType.LAZY)
	private Identite identite;

	public Personne(String nom, String prenom,Identite identite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.identite=identite;
	}
}
