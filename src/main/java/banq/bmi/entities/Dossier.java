package banq.bmi.entities;

import banq.bmi.Repository.UtilisateurRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
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
	private String Type;
    @ManyToOne()
    @JoinColumn(name = "IdBoxe")
	private Boxe boxe;
    @ManyToOne()
    @JoinColumn(name = "IdCasier")
	private Casier casier;
    @ManyToOne()
    @JoinColumn(name = "IdArchive")
	private Archive archive;
	@ManyToOne()
	@JoinColumn(name = "IdUser")
	private Utilisateur utilisateur;
	@ManyToOne()
    @JoinColumn(name = "IdDepartement")
    private Departement departement;
	@OneToMany(mappedBy ="dossier",fetch=FetchType.LAZY )
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Collection<GroupsDoc> groupsDocs;


}
