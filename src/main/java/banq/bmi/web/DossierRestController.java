package banq.bmi.web;

import banq.bmi.Repository.DossierRepository;
import banq.bmi.entities.Dossier;
import ch.qos.logback.core.joran.spi.ConsoleTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController()
@CrossOrigin(origins = "http://localhost:4200")
public class DossierRestController {
    @Autowired
    private DossierRepository dossierRepository ;
    @GetMapping("/getAll")
    public List<Dossier> listDossier(){
        return dossierRepository.findAll();
    }

    @PostMapping("/add")
    public Dossier save(@RequestBody Dossier d) {
        return dossierRepository.save(d);
    }
    @PatchMapping("/update")
    public Dossier update(@RequestBody Dossier d) {
        return dossierRepository.save(d);
    }
    @DeleteMapping("/{1}")
    public void delete(@RequestParam Long id){
         dossierRepository.deleteById(id);
    }

}
