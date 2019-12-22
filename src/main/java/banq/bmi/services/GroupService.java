package banq.bmi.services;

import banq.bmi.entities.GroupsDoc;

import java.util.List;

public interface GroupService {

    public GroupsDoc saveGroupsDoc(GroupsDoc Group);

    public GroupsDoc updateDossier(GroupsDoc Group);

    public List<GroupsDoc> getAlGroupsDoc();

    public GroupsDoc findUserByUsername(String Username);
}
