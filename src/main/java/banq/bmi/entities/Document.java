package banq.bmi.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Document {
	@Id @GeneratedValue
	private Long id;
	private String titre ;
	private Date dateCreation;
	private String Drescription ;
	private Date dateStockage;

	public Long getId() {
		return id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getDrescription() {
		return Drescription;
	}

	public void setDrescription(String drescription) {
		Drescription = drescription;
	}

	public Date getDateStockage() {
		return dateStockage;
	}

	public void setDateStockage(Date dateStockage) {
		this.dateStockage = dateStockage;
	}
}
