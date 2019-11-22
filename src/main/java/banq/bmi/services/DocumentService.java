package banq.bmi.services;

import banq.bmi.Repository.DocumentRepositry;
import banq.bmi.entities.Document;
import banq.bmi.exception.FileNotFoundException;
import banq.bmi.exception.FileStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DocumentService {
//    private Map<Long, Document> document=new HashMap<Long, Document>();
//    private Map<Long, GroupsDoc> groubDoc=new HashMap<Long, GroupsDoc>();


    @Autowired
    private DocumentRepositry documentRepositry;

    public Document storeFile(MultipartFile file){

        String  fileName= StringUtils.cleanPath(file.getOriginalFilename());
        try{
            if(fileName.contains("..")){
                throw new FileStorageException("Sorry! titre contains invalid path sequence " + fileName);
            }

            Document bdDocument;
            bdDocument = new Document(fileName,file.getContentType(), file.getBytes());
            return  documentRepositry.save(bdDocument);
        }catch (IOException ex){
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }

    }

    public Document getFile(Long fileId){
        return  documentRepositry.findById(fileId).orElseThrow(()-> new FileNotFoundException("File not founnd wiht id" + fileId));
    }

//    @Override
//    public GroupsDoc addDocument(GroupsDoc g) {
//        return null;
//    }
//
//    @Override
//    public Document addDocument(Document d) {
//        document.put(d.getId(), d);
//        return d;
//    }
//
//    @Override
//    public List<GroupsDoc> listGroupsDoc() {
//        return null;
//    }
//
//    @Override
//    public Document getDocument(Long id) {
//        return document.get(id);
//    }
//
//    @Override
//    public GroupsDoc getGroupDoc(Long id) {
//        return groubDoc.get(id);
//    }
//
//
//    @Override
//    public List<Document> listDocument() {
//        return new ArrayList<Document>(document.values());
//    }
//
//    @Override
//    public List<Document> DocumentParMC(String mc) {
//        List<Document> Docm=new ArrayList<Document>();
//        for (Document Doc:document.values())
//            if (Doc.getTitre().contains(mc));
//        return null;
//    }
//
//    @Override
//    public Document updateDocument(Document d) {
//        document.put(d.getId(),d);
//        return d;
//    }
//
//    @Override
//    public GroupsDoc updateGroupDoc(GroupsDoc g) {
//        groubDoc.put(g.getId(), g);
//        return g;
//    }
//
//    @Override
//    public boolean deleteDocument(Long id) {
//        if (document.get(id)!=null){
//            document.remove(id);
//            return true ;
//        }
//        else throw new RuntimeException("Document intrrouvable");
//    }
}
