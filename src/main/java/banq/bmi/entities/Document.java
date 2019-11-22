package banq.bmi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name="document")
public class Document implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long Id;
	private String titre ;
	private Date DateCreation;
	private String fileName;
	private String fileType;
	@Lob
	private byte[] data;

	public Document(String fileName, String contentType, byte[] bytes) {
	}
	@ManyToOne(fetch = FetchType.EAGER)
	private GroupsDoc groupsDoc;



}
