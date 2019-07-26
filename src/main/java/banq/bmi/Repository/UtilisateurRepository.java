package banq.bmi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import banq.bmi.entities.Uitisateur;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface UtilisateurRepository extends JpaRepository<Uitisateur, Long>{
	public Uitisateur findByUsername(String username);
}
