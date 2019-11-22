package banq.bmi.services;

import banq.bmi.entities.Role;
import banq.bmi.entities.Utilisateur;

public interface AccountServive {
	public Utilisateur saveUtilisateur(Utilisateur utilisateur);
	public Role saveRole(Role roles);
	public void AjoutRoleAUtilisateur(String username, String roleName);
	public Utilisateur findUtilisateurByUsername(String username);
//	public Uitisateur updateUtilisateur();
//	public void DeleteUtilisateur();
}
