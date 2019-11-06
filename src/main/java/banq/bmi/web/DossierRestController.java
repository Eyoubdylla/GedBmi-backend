package banq.bmi.web;

import banq.bmi.Repository.DossierRepository;
import banq.bmi.entities.Dossier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class DossierRestController {
    @Autowired
    private DossierRepository dossierRepository ;

    @GetMapping("/listDossier")
    public List<Dossier> listDossier(){
        return dossierRepository.findAll();
    }

    @PostMapping("/savedossier")
    public Dossier save(Dossier d) {
        return dossierRepository.save(d);
    }

}
