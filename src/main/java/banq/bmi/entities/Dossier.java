package banq.bmi.entities;

import banq.bmi.Repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="dossier")
public class Dossier implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	private String nom ;
	private Date dateCreation;
	@ManyToOne(fetch = FetchType.EAGER)
	private Utilisateur utilisateur;
	@OneToMany(mappedBy ="dossier",fetch=FetchType.LAZY )
	private Collection<GroupsDoc> groupsDocs;


}
