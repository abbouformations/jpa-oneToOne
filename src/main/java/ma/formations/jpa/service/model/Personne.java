package ma.formations.jpa.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Personne {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String prenom;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresse")
    private Adresse adresse;
}
