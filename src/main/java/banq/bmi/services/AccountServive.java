package banq.bmi.services;

import banq.bmi.entities.Role;
import banq.bmi.entities.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface AccountServive {
    public Utilisateur saveUser(Utilisateur user);

    public Utilisateur updateUser(Utilisateur user);

    public List<Utilisateur> getAllUser();

    public Utilisateur findUserByUsername(String Username);

    public Optional<Utilisateur> findUserById(Long UserID);

    public Optional<Utilisateur> getUser(Long UserId);

    void deleteUser(Long UserId);
 // **************  Roles *****************
    public Role saveRole(Role role);

    public Role updateRole(Role role);

    public List<Role> getAllRole();

    public Role getRole(Long RoleId);

    void deleteRole(Long RolerId);


    //************ Add Role For User

    public void AddRolesForUser(String name, String RoleName );
}
