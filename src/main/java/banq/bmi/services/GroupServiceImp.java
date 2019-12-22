package banq.bmi.services;

import banq.bmi.Repository.GrpsDoc;
import banq.bmi.entities.GroupsDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class GroupServiceImp implements GroupService{

    @Autowired
    private GrpsDoc grpsDoc;
    @Override
    public GroupsDoc saveGroupsDoc(GroupsDoc Group) {
        return null;
    }

    @Override
    public GroupsDoc updateDossier(GroupsDoc Group) {
        return null;
    }

    @Override
    public List<GroupsDoc> getAlGroupsDoc() {
        return null;
    }

    @Override
    public GroupsDoc findUserByUsername(String Username) {
        return null;
    }
}
