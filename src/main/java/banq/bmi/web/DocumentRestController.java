package banq.bmi.web;


import banq.bmi.Repository.DocumentRepositry;
import banq.bmi.entities.Document;
import banq.bmi.exception.FileStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DocumentRestController {
    @Autowired
    private DocumentRepositry documentRepositry ;

    @GetMapping("/document")
    public List<Document> ListDocuments(){
        return documentRepositry.findAll();
    }

    /**
     * Gets Document by id.
     *
     * @param DocID the Document id
     * @return the Document by id
     * @throws ResourceNotFoundException the resource not found exception
     */
    @GetMapping("/document/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable(value = "id") Long DocID)
            throws ResourceNotFoundException {
        Document doc =
                documentRepositry
                        .findById(DocID)
                        .orElseThrow(() -> new ResourceNotFoundException("Document not found on :: " + DocID));
        return ResponseEntity.ok().body(doc);
    }

    /**
     * Create Document Document.
     *
     * @param user the user
     * @return the user
     */
    @PostMapping("/document")
    public Document createDocument(@Valid @RequestBody Document user) {
        return documentRepositry.save(user);
    }

    /**
     * Update Document response entity.
     *
     * @param IdDoc the Document id
     * @param documentDetails the Document details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/document/{id}")
    public ResponseEntity<Document> updateDocument(
            @PathVariable(value = "id") Long IdDoc, @Valid @RequestBody Document documentDetails)
            throws ResourceNotFoundException {
        Document document =
                documentRepositry
                        .findById(IdDoc)
                        .orElseThrow(() -> new ResourceNotFoundException("Document not found on :: " + IdDoc));
        document.setTitre(documentDetails.getTitre());
        final Document updateDocument = documentRepositry.save(document);
        return ResponseEntity.ok(updateDocument);
    }

    /**
     * Delete Document map.
     *
     * @param documentId the user id
     * @return the map
     * @throws Exception the exception
     */
    @DeleteMapping("/document/{id}")
    public Map<String, Boolean> deleteDocument(@PathVariable(value = "id") Long documentId) throws Exception {
        Document user =
                documentRepositry
                        .findById(documentId)
                        .orElseThrow(() -> new ResourceNotFoundException("Document not found on :: " + documentId));
        documentRepositry.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
