package banq.bmi.web;

import banq.bmi.Repository.RoleRepository;
import banq.bmi.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
public class RoleRestController {

    @Autowired
    public RoleRepository roleRepository;

    @GetMapping("/getAllRole")
    public List<Role> listDossier(){
        return roleRepository.findAll();
    }
}


