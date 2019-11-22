package banq.bmi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="utilisateur")
public class Utilisateur {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	@Column(unique=true)
	private String username ;
	private String Password ;
	private String email ;
	// pour que chaque fois que je charge un utilisateur il avoir ses roles
	@ManyToMany(fetch=FetchType.EAGER)
	private Collection<Role> roles=new ArrayList<>();
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
	@JsonIgnore
	private Collection<Dossier> dossiers;


}
