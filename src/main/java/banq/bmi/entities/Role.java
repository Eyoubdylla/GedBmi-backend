package banq.bmi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Role {
	@Id @GeneratedValue
	private Long id ;
	private String roleName;
	@ManyToMany
	@JsonIgnore
	private Collection<Utilisateur> utilisateurs;

	
}
