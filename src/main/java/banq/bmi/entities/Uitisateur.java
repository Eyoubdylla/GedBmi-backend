package banq.bmi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Uitisateur {
	@Id @GeneratedValue 
	private Long id;
	@Column(unique=true)
	private String username ;
	private String Password ;
	private String email ;
	// pour que chaque fois que je charge un utilisateur il avoir ses roles
	@ManyToMany(fetch=FetchType.EAGER)
	private Collection<Role> roles=new ArrayList<>();


}
