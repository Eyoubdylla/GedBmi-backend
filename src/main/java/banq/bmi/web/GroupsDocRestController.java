package banq.bmi.web;

import banq.bmi.Repository.GrpsDoc;
import banq.bmi.entities.GroupsDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@Service
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class GroupsDocRestController  {
    @Autowired
    private GrpsDoc grpsDoc ;

    @GetMapping("/Groupes")
    public List<GroupsDoc> ListGroupDoc(){
        return grpsDoc.findAll();
    }

    @PostMapping("/Groupes")
    public GroupsDoc createDocument(@RequestBody GroupsDoc user) {
        return grpsDoc.save(user);
    }
    @PutMapping("/Groupes/{id}")
    public GroupsDoc update(@PathVariable(value = "id") long id, @RequestBody GroupsDoc GROUPS) {
         GroupsDoc gp = grpsDoc.findById(id).orElseThrow(() -> new ResourceNotFoundException("Document not found on :: " + id));
         gp.setLibelle(GROUPS.getLibelle());
         GroupsDoc updateGroups = grpsDoc.save(gp);
        return updateGroups;
    }
    @DeleteMapping("/Groupes/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        grpsDoc.deleteById(id);
    }


}
