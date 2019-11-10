package banq.bmi.entities;

import banq.bmi.Repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dossier {
	@Id @GeneratedValue
	private Long id;
	private String nom ;
	private Date dateCreation;
	private String Emplacement ;
	@ManyToOne(fetch = FetchType.EAGER)
	private Utilisateur utilisateur;


	public Long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public String getEmplacement() {
		return Emplacement;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public void setEmplacement(String emplacement) {
		Emplacement = emplacement;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}
