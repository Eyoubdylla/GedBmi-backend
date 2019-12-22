package banq.bmi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import banq.bmi.Repository.RoleRepository;
import banq.bmi.Repository.UtilisateurRepository;
import banq.bmi.entities.Role;
import banq.bmi.entities.Utilisateur;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
// cette classe est une maniere de centraliser la gestion de l'utilisateur 
public class AccountServiveImpl implements AccountServive{
	@Autowired 
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository ;

	@Autowired
	private RoleRepository roleRepository ;

    @Override
    public Utilisateur saveUser(Utilisateur user) {
        String hashPW=bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPW);
        return utilisateurRepository.save(user);
    }

    @Override
    public Utilisateur updateUser(Utilisateur user) {
       String hashPW=bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPW);
        return utilisateurRepository.save(user);
    }

    @Override
    public List<Utilisateur> getAllUser() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur findUserByUsername(String Username) {
        return utilisateurRepository.findByUsername(Username);
    }

    @Override
    public Optional<Utilisateur> findUserById(Long UserID) {
        return utilisateurRepository.findById(UserID);
    }

    @Override
    public Optional<Utilisateur> getUser(Long UserId) {
        return utilisateurRepository.findById(UserId);
    }

    @Override
    public void deleteUser(Long UserId) {
        utilisateurRepository.deleteById(UserId);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role role) {
        return roleRepository.saveAndFlush(role);
    }

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRole(Long RoleId) {
        return roleRepository.getOne(RoleId);
    }

    @Override
    public void deleteRole(Long RolerId) {
        roleRepository.deleteById(RolerId);
    }

    @Override
    public void AddRolesForUser(String username, String RoleName) {
        Role role=roleRepository.findByRoleName(RoleName);
    	Utilisateur user=utilisateurRepository.findByUsername(username);
        user.getRoles().add(role);
    }


}
