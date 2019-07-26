package banq.bmi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import banq.bmi.entities.Dossier;

public interface DossierRepository  extends JpaRepository<Dossier,Long>{
	
}
