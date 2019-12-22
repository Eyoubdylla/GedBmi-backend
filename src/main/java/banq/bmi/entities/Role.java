package banq.bmi.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name="role")
public class Role implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id ;
	private String roleName;
	@ManyToMany
	private Collection<Utilisateur>  utilisateur;
	public Role(String roleName, Collection<Utilisateur> utilisateur) {
		this.roleName = roleName;
		this.utilisateur = utilisateur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Collection<Utilisateur> getUtilisateurs() {
		return utilisateur;
	}

	public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
		this.utilisateur = utilisateurs;
	}
}
