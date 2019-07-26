package banq.bmi.services;

import banq.bmi.entities.Role;
import banq.bmi.entities.Uitisateur;

public interface AccountServive {
	public Uitisateur saveUtilisateur(Uitisateur utilisateur);
	public Role saveRole(Role roles);
	public void AjoutRoleAUtilisateur(String username, String roleName);
	public Uitisateur findUtilisateurByUsername(String username);
//	public Uitisateur updateUtilisateur();
//	public void DeleteUtilisateur();
}
