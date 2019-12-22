package banq.bmi.web;

import banq.bmi.Repository.UtilisateurRepository;
import banq.bmi.entities.Role;
import banq.bmi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import banq.bmi.entities.Utilisateur;
import banq.bmi.services.AccountServive;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Collection;
import java.util.List;

@RestController()
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

public class AccountRestController {
    @Autowired
    private AccountServive accountService;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/saveUser")
    public Utilisateur saveUser(@RequestBody Utilisateur user) {
        String hashPW = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPW);
        return accountService.saveUser(user);
    }

    @RequestMapping("/login")
    public Utilisateur user(Principal principal) {

        //logger.info("user logged "+principal);
        Utilisateur user = utilisateurRepository.findByUsername(principal.getName());
        //user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return user;
    }

    @GetMapping("/listUser")
    public List<Utilisateur> GetAllUser() {
        return accountService.getAllUser();
    }

    @PostMapping("/register")

    public Utilisateur register(@RequestBody RegisterForm UserForm) {
        if (!UserForm.getPassword().equals(UserForm.getRepassword()))
            throw new RuntimeException("you must confirm your password");
        Utilisateur usr = accountService.findUserByUsername(UserForm.getUsername());
        if (usr != null) throw new RuntimeException("this user already exists");
        Utilisateur utilsateur = new Utilisateur();
        utilsateur.setUsername(UserForm.getUsername());
        utilsateur.setPassword(UserForm.getPassword());
        utilsateur.setEmail(UserForm.getEmail());
        System.out.println("username" + utilsateur.getUsername() + "" + utilsateur.getEmail());
        accountService.saveUser(utilsateur);
        accountService.AddRolesForUser(UserForm.getUsername(), "GETIONNAIRE");
        return utilsateur;
    }

    @PutMapping("/listUser/{id}")
    public Utilisateur updateUser(@PathVariable long id, @RequestBody Utilisateur userdetail) {
        System.out.println("user " + userdetail.getRoles());
        Utilisateur user = utilisateurRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Uitisateur", "Id", id));
        user.setUsername(userdetail.getUsername());
        user.setPassword(userdetail.getPassword());
        user.setEmail(userdetail.getEmail());
        Collection<Role> roles = userdetail.getRoles();

        user.setRoles(userdetail.getRoles());
        Utilisateur updateUser = utilisateurRepository.save(user);
        System.out.println("********************");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getRoles());
        return updateUser;
    }

    @DeleteMapping("/listUser/{id}")
    //@RequestMapping(value ="/listUser/{id}",method = RequestMethod.DELETE.GET)
    public ResponseEntity<?> delete(@PathVariable(value = "id") long Id) {
        Utilisateur user = accountService.findUserById(Id).orElseThrow(() -> new ResourceNotFoundException("Uitisateur", "Id", Id));
        utilisateurRepository.delete(user);
        return ResponseEntity.ok().build();
    }

}
