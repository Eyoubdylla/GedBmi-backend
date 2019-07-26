package banq.bmi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import banq.bmi.Repository.DossierRepository;
import banq.bmi.entities.Dossier;
@RestController 
public class TestRestController {
	@Autowired
	private DossierRepository dossierRepository;
	@GetMapping("/dossier")
	public List<Dossier> ListDossier(){
		return dossierRepository.findAll();
	}
	
	@PostMapping("/dossier")
	public Dossier save(Dossier d) {
		return dossierRepository.save(d);
				
	}
}
