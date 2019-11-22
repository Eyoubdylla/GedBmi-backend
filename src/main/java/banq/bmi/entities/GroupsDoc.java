package banq.bmi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="groupsdoc")
public class GroupsDoc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    private String libelle;
    @ManyToOne(fetch = FetchType.EAGER)
    private Dossier dossier;
    @OneToMany(mappedBy ="groupsDoc", fetch=FetchType.LAZY )
    @JsonIgnore
    private Collection<Document> documents;


}
