package banq.bmi.web;


import banq.bmi.Repository.DocumentRepositry;
import banq.bmi.entities.Document;
import banq.bmi.payload.Response;
import banq.bmi.services.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
public class DocumentRestController {
    @Autowired
    private DocumentRepositry documentRepositry ;
    private static final Logger logger = LoggerFactory.getLogger(DocumentRestController.class);

    @GetMapping("/document")
    public List<Document> ListDocuments(){
        return documentRepositry.findAll();
    }

    @Autowired
    private DocumentService documentService;

    @PostMapping("/uploadFile")
    public Response uploadFile(@RequestParam("file") MultipartFile file) {
       Document document = documentService.storeFile(file);



        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(document.getId())
                .toUriString();
        return new Response(document.getId(),document.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize()) ;
    }

//    @PostMapping("/uploadMultipleFiles")
//    public List<Response> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//        return Arrays.asList(files)
//                .stream()
//                .map(file -> uploadFile(file))
//                .collect(Collectors.toList());
//    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        // Load file from database
        Document dbFile = documentService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }




    @PutMapping("/document/{id}")
    public ResponseEntity<Document> updateDocument(
            @PathVariable(value = "id") String IdDoc, @Valid @RequestBody Document documentDetails)
            throws ResourceNotFoundException {
        Document document =
                documentRepositry
                        .findById(IdDoc)
                        .orElseThrow(() -> new ResourceNotFoundException("Document not found on :: " + IdDoc));

        document.setFileName(documentDetails.getFileName());
        document.setGroupsDoc(documentDetails.getGroupsDoc());
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
    public Map<String, Boolean> deleteDocument(@PathVariable(value = "id") String documentId) throws Exception {
        Document docuemnt =
                documentRepositry
                        .findById(documentId)
                        .orElseThrow(() -> new ResourceNotFoundException("Document not found on :: " + documentId));
        documentRepositry.delete(docuemnt);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }






    /**
     * Gets Document by id.
     *
     * @param DocID the Document id
     * @return the Document by id
     * @throws ResourceNotFoundException the resource not found exception
     */
//    @GetMapping("/document/{id}")
//    public ResponseEntity<Document> getDocumentById(@PathVariable(value = "id") Long DocID)
//            throws ResourceNotFoundException {
//        Document doc =
//                documentRepositry
//                        .findById(DocID)
//                        .orElseThrow(() -> new ResourceNotFoundException("Document not found on :: " + DocID));
//        return ResponseEntity.ok().body(doc);
//    }

    /**
     * Create Document Document.
     *
     * @param user the user
     * @return the user
     */
//    @PostMapping("/document")
//    public Document createDocument(@Valid @RequestBody Document user) {
//        return documentRepositry.save(user);
//    }


}
