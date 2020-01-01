package banq.bmi.entities;

import java.io.Serializable;
import java.nio.file.Path;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.core.io.Resource;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name="document")
public class Document implements Serializable {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String fileName;
	private String fileType;
	private  Long size;
	private Date lastModifiedDate ;
	private String Status ;
	@ManyToOne
	@JoinColumn(name = "IdUser")
	private Utilisateur utilisateur;
	@Lob
	private byte[] data;
    @ManyToOne()
    @JoinColumn(name = "IdCatg")
    private GroupsDoc groupsDoc;
//	public Document() {
//	}

	public Document(String fileName, String contentType, byte[] bytes, long size) {
		this.fileName=fileName;
		this.fileType=contentType;
		this.data=bytes;
		this.size = size;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public GroupsDoc getGroupsDoc() {
		return groupsDoc;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

}
