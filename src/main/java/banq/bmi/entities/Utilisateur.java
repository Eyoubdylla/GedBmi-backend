package banq.bmi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;


@Entity
//@Data  @NoArgsConstructor  @AllArgsConstructor
public class Utilisateur implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	private String username ;
	private String Password ;
	private String email ;
	// pour que chaque fois que je charge un utilisateur il avoir ses roles
	@ManyToMany(fetch=FetchType.EAGER)
	private Collection<Role> roles = new ArrayList<>();
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
	@JsonIgnore
	private Collection<Dossier> dossiers;
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Collection<Document> documents;

	public Utilisateur() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Dossier> getDossiers() {
		return dossiers;
	}

	public void setDossiers(Collection<Dossier> dossiers) {
		this.dossiers = dossiers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
@JsonIgnore
	public String getPassword() {
		return Password;
	}
@JsonSetter
	public void setPassword(String password) {
		Password = password;
	}

	public Collection<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Utilisateur(String username, String password, String email, Collection<Role> roles) {
		this.username = username;
		Password = password;
		this.email = email;
		this.roles = roles;
		this.dossiers = dossiers;
	}
}
