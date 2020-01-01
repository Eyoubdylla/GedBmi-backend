package banq.bmi.services;

import banq.bmi.Repository.DocumentRepositry;
import banq.bmi.entities.Document;
import banq.bmi.entities.Utilisateur;
import banq.bmi.exception.FileNotFoundException;
import banq.bmi.exception.FileStorageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
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

    public Document storeFile(MultipartFile file, Utilisateur user){

        String  fileName= StringUtils.cleanPath(file.getOriginalFilename());
        try{
            if(fileName.contains("..")){
                throw new FileStorageException("Sorry! titre contains invalid path sequence " + fileName);
            }

            Document bdDocument ;
            bdDocument = new Document(fileName,file.getContentType(),
                    file.getBytes(), file.getSize());
            bdDocument.setStatus("Current");
            bdDocument.setUtilisateur(user);
//            bdDocument.setDateCration(doc.getDateCration());
//            bdDocument.setGroupsDoc(doc.getGroupsDoc());

            return  documentRepositry.save(bdDocument);
        }catch (IOException ex){
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }



    }

    public Document getFile(String fileId){
        return  documentRepositry.findById(fileId).orElseThrow(()-> new
                FileNotFoundException("File not founnd wiht id" + fileId));
    }


}
