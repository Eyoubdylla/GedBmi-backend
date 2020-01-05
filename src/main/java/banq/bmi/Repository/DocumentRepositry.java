package banq.bmi.Repository;

import banq.bmi.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@CrossOrigin("*")
@RepositoryRestResource
public interface DocumentRepositry extends JpaRepository<Document, String> {
//    public Document findByUsername(String username);
@Query("select d from Document d where d.groupsDoc.id = :x")
public Collection<Document> documentByGroupe(@Param("x") Long id);
    @Query("select d from Document d where d.utilisateur.id = :x and status<>'en_cour_Suppression' order by d.id desc")
    public List<Document> documentByUser(@Param("x") Long id);
    @Query("select d from Document d where d.utilisateur.id = :x and d.groupsDoc.id= :y and status<>'en_cour_Suppression' order by d.id desc")
    public List<Document> documentByUserByGroup(@Param("x") Long id, @Param("y") Long idGroup);
    @Query("select d from Document d where d.groupsDoc.id= :y order by d.id desc")
    public List<Document> documentByGroup(@Param("y") Long idGroup);

}
