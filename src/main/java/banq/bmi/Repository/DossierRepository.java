package banq.bmi.Repository;

import banq.bmi.entities.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DossierRepository  extends JpaRepository<Dossier, Long>{
    public Dossier findAllByNom(String nom);
}
