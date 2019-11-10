package banq.bmi.Repository;

import banq.bmi.entities.GroupsDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GrpsDoc extends JpaRepository<GroupsDoc, Long> {
    //public GrpsDoc findByNom(String Nom);
}
