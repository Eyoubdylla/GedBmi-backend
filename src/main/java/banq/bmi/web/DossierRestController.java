package banq.bmi.web;

import banq.bmi.Repository.DossierRepository;
import banq.bmi.Repository.GrpsDoc;
import banq.bmi.entities.Dossier;

import banq.bmi.entities.GroupsDoc;
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
    private GrpsDoc grpsDoc;
    @Autowired
    private DossierRepository dossierRepository ;
    @GetMapping("/dossier")
    public List<Dossier> listDossier(){
        return dossierService.getAlDossierr();
    }

    @PostMapping("/dossier")
    public Dossier save(@RequestBody Dossier dossier) {

        Dossier doc = dossierRepository.save(dossier);
        if(dossier.getGroupsDocs()!=null){
            for (GroupsDoc groupsDoc : dossier.getGroupsDocs()) {
                GroupsDoc grp = groupsDoc;
                grp.setDossier(dossier);
                grpsDoc.save(grp);
            }
        }
        return doc;
    }
    @PatchMapping("/dossier/{id}")
    public Dossier update(@PathVariable long id, @RequestBody Dossier dossier) {
        if(dossier.getGroupsDocs()!=null){
            for (GroupsDoc groupsDoc : dossier.getGroupsDocs()) {
                GroupsDoc grp = groupsDoc;
                grp.setDossier(dossier);
                grpsDoc.save(grp);
            }
        }

       /* Dossier doc = dossierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Document not found on :: " + id));
        doc.setNom(dossier.getNom());
        doc.setDateCreation(dossier.getDateCreation());
        doc.setEmplacement(dossier.getEmplacement());*/
        Dossier updatedossier = dossierService.saveDossier(dossier);
        return  updatedossier;
    }

    @DeleteMapping("/dossier/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        Dossier dossier = dossierRepository.getOne(id);
        for(GroupsDoc groupsDoc: dossier.getGroupsDocs()){
            groupsDoc.setDossier(null);
            grpsDoc.save(groupsDoc);
        }
         dossierService.deleteDossier(id);
    }

}
