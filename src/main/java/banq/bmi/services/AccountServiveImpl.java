package banq.bmi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import banq.bmi.Repository.RoleRepository;
import banq.bmi.Repository.UtilisateurRepository;
import banq.bmi.entities.Role;
import banq.bmi.entities.Uitisateur;
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
	public Uitisateur saveUtilisateur(Uitisateur utilisateur) {
		// encrypter le mot de passe 
		String hashPW=bCryptPasswordEncoder.encode(utilisateur.getPassword());
		utilisateur.setPassword(hashPW);
		// TODO Auto-generated method stub
		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public Role saveRole(Role roles) {
		// TODO Auto-generated method stub
		return roleRepository.save(roles);
	}

	@Override
	public void AjoutRoleAUtilisateur(String username, String roleName) {
		// TODO Auto-generated method stub
		Role role=roleRepository.findByRoleName(roleName);
		Uitisateur utilisateur=utilisateurRepository.findByUsername(username);
		utilisateur.getRoles().add(role);
		
		
	}

	@Override
	public Uitisateur findUtilisateurByUsername(String username) {
		// TODO Auto-generated method stub
		return utilisateurRepository.findByUsername(username);
	}

}
