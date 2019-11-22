package banq.bmi.services;

import banq.bmi.entities.Document;
import banq.bmi.entities.GroupsDoc;

import java.util.List;

public interface DocService {
    public GroupsDoc addDocument(GroupsDoc g);
    public Document addDocument(Document d);
    public List<GroupsDoc> listGroupsDoc();
    public Document getDocument(Long id);
    public GroupsDoc getGroupDoc(Long id);
    public List<Document> listDocument();
    public List<Document> DocumentParMC(String mc);
    public Document updateDocument(Document d);
    public GroupsDoc updateGroupDoc(GroupsDoc d);
    public boolean deleteDocument(Long id);
}
