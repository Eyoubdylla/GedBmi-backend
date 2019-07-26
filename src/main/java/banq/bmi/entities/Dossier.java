package banq.bmi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

}
