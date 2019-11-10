package banq.bmi.web;

import banq.bmi.Repository.UtilisateurRepository;
import banq.bmi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import banq.bmi.entities.Utilisateur;
import banq.bmi.services.AccountServive;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class AccountRestController {
	@Autowired
	private AccountServive accountService ;
	@Autowired
	private UtilisateurRepository utilisateurRepository ;

	@RequestMapping("/login")
	public Utilisateur user(Principal principal) {
		//logger.info("user logged "+principal);
		Utilisateur user = utilisateurRepository.findByUsername(principal.getName());
		//user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return user;
	}

	@GetMapping("/listUser")
	public List<Utilisateur> ListDossier(){
		return utilisateurRepository.findAll();
	}


	@PostMapping("/register")

	public Utilisateur register(@RequestBody RegisterForm utilisateurForm) {
		if(utilisateurForm.equals(utilisateurForm.getRepassword())) 
			throw new RuntimeException("you must confirm your password");
		Utilisateur usr=accountService.findUtilisateurByUsername(utilisateurForm.getUsername());
		if(usr!=null)throw new RuntimeException("this user already exists");
		Utilisateur utilsateur=new Utilisateur();
		utilsateur.setUsername(utilisateurForm.getUsername());
		utilsateur.setPassword(utilisateurForm.getPassword());
		accountService.saveUtilisateur(utilsateur);
		accountService.AjoutRoleAUtilisateur(utilisateurForm.getUsername(), "GETIONNAIRE");
		return utilsateur;
	}

@PutMapping("/listUser/update/{id}")
    public Utilisateur updateUser(@PathVariable(value = "Id") long Id , @Valid @RequestBody Utilisateur userdetail){
        Utilisateur user = utilisateurRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("Uitisateur","Id", Id));
        user.setUsername(userdetail.getUsername());
        user.setPassword(userdetail.getPassword());
        user.setRoles(userdetail.getRoles());
        Utilisateur updateUser = utilisateurRepository.save(user);
        System.out.println("********************");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getRoles());
        return updateUser;
    }
    @DeleteMapping ("/listUser/{id}")
    //@RequestMapping(value ="/listUser/{id}",method = RequestMethod.DELETE.GET)
    public ResponseEntity<?> delete(@PathVariable(value = "id") long Id){
        Utilisateur user = utilisateurRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("Uitisateur","Id", Id));
        utilisateurRepository.delete(user);
        return ResponseEntity.ok().build();
    }

}
