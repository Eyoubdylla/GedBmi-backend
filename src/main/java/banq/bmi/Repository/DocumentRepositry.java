package banq.bmi.Repository;

import banq.bmi.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;


@CrossOrigin("*")
@RepositoryRestResource
public interface DocumentRepositry extends JpaRepository<Document, Long> {

}
