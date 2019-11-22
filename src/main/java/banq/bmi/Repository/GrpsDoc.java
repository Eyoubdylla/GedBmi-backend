package banq.bmi.Repository;

import banq.bmi.entities.GroupsDoc;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin("*")
//@RepositoryRestResource
@RestController
public interface GrpsDoc extends JpaRepository<GroupsDoc, Long> {
    @Query(value = "select * from groupsdoc ;",nativeQuery = true)
   // @Query("select nom from groups_doc where nom=group3")
    public List<GroupsDoc> ChercheParNom();
}
