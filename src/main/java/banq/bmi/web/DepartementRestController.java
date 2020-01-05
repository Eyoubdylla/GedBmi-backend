package banq.bmi.web;

import banq.bmi.Repository.DepartementRepository;
import banq.bmi.entities.Departement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
public class DepartementRestController {
    @Autowired
    private DepartementRepository departementRepository;

    @GetMapping("/Departement")
    public Collection<Departement> ListeDepaartements(){
        return departementRepository.findAll();
    }

    @PostMapping("/Departement")
    public Departement SaveDepartement(@RequestBody Departement departement){
        return departementRepository.save(departement);
    }

}
