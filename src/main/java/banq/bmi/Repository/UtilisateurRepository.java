package banq.bmi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import banq.bmi.entities.Utilisateur;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	public Utilisateur findByUsername(String username);
}
