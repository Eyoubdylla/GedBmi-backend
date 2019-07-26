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

}
