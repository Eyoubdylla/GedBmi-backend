package banq.bmi.Repository;

import banq.bmi.entities.test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface TestRepository  extends JpaRepository<test, String> {

}
