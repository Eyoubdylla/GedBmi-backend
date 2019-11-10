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
public class Utilisateur {
	@Id @GeneratedValue 
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

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return Password;
	}

	public String getEmail() {
		return email;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Collection<Dossier> getDossiers() {
		return dossiers;
	}

	public void setDossiers(Collection<Dossier> dossiers) {
		this.dossiers = dossiers;
	}
}
