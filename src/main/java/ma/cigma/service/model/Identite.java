package ma.cigma.service.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Identite implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String cin;
	
	@OneToOne(mappedBy="identite")
	private Personne personne;

	public Identite(String cin) {
		super();
		this.cin = cin;
	}

}
