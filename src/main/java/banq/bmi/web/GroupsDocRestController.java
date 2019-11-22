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
import java.util.HashMap;
import java.util.Map;

@RestController()
@Service
@CrossOrigin(origins = "http://localhost:4200")
public class GroupsDocRestController  {
    @Autowired
    private GrpsDoc grpsDoc ;

    @GetMapping("/GroupesDoc")
    public List<GroupsDoc> ListGroupDoc(){
        return grpsDoc.findAll();
    }






//    @DeleteMapping("/document/{id}")
//    public Map<String, Boolean> deleteGroupDocument(@PathVariable(value = "id") Long documentId) throws Exception {
//        GroupsDoc user =
//                grpsDoc
//                        .findById(documentId)
//                        .orElseThrow(() -> new ResourceNotFoundException("Document not found on :: " + documentId));
//        grpsDoc.delete(user);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }


}
