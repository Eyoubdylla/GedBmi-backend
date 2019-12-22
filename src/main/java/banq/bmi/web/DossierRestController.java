package banq.bmi.web;

import banq.bmi.Repository.DossierRepository;
import banq.bmi.entities.Dossier;

import banq.bmi.services.DossierService;
import ch.qos.logback.core.joran.spi.ConsoleTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController()
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class DossierRestController {
    @Autowired
    private DossierService dossierService;
    @Autowired
    private DossierRepository dossierRepository ;
    @GetMapping("/dossier")
    public List<Dossier> listDossier(){
        return dossierService.getAlDossierr();
    }

    @PostMapping("/dossier")
    public Dossier save(@RequestBody Dossier d) {
        return dossierService.saveDossier(d);
    }
    @PatchMapping("/dossier/{id}")
    public ResponseEntity<Dossier> update(@PathVariable(value = "id") long id, @Valid @RequestBody Dossier d) {
        Dossier dossier = dossierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Document not found on :: " + id));
       dossier.setNom(d.getNom());
       dossier.setDateCreation(d.getDateCreation());
       dossier.setEmplacement(d.getEmplacement());
        Dossier updatedossier = dossierService.saveDossier(dossier);
        return ResponseEntity.ok(updatedossier);
    }

    @DeleteMapping("/dossier/{id}")
    public void delete(@PathVariable(value = "id") Long id){
         dossierService.deleteDossier(id);
    }

}
