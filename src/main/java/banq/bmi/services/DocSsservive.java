package banq.bmi.services;

import banq.bmi.Repository.DocumentRepositry;
import banq.bmi.entities.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DocSsservive {

    @Autowired
    private DocumentRepositry documentRepositry;

    @GetMapping(value="/listDocument")
    public List<Document> listDocument(){
        return documentRepositry.findAll();
    }
    @RequestMapping(value ="/listDocument/{id}",method = RequestMethod.GET)
    public Document ListDocment(@PathVariable(name ="Id") Long id){
        return documentRepositry.findById(id).get();
    }
//    @RequestMapping(value = "/UpdateDocument/{id}", method = RequestMethod.PUT)
////    public Document update(@PathVariable(name = "Id") Long id, @RequestBody Document p){
////        p.setId(id);
////        return documentRepositry.saveAndFlush(p);
////    }
    @RequestMapping(value = "/SaveDocument/",method = RequestMethod.POST)
    public Document save(@RequestBody Document p){
        return documentRepositry.save(p);
    }
    @DeleteMapping(value = "/deleteProduits/{id}")
    public void delete(@PathVariable(name = "Id") Long id){
        documentRepositry.deleteById(id);
    }

}
