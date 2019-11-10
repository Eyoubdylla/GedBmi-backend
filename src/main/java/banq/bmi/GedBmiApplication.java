package banq.bmi;
import java.util.Date ;
import banq.bmi.entities.Dossier ;
import banq.bmi.Repository.DossierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import banq.bmi.services.AccountServive;

@SpringBootApplication
public class GedBmiApplication implements CommandLineRunner{
	@Autowired
	private DossierRepository dossierRepository;
	@Autowired
	private AccountServive accountServive;
	// Pour confugurer le rest : apparaitre le id dans l'affichage json
	@Autowired
	private RepositoryRestConfigurer restConfigurer;
	
	public static void main(String[] args) {
		SpringApplication.run(GedBmiApplication.class, args);
		/*ApplicationContext ctx = SpringApplication.run(GedBmiApplication.class, args);
		DossierRepository dossierRepository = ctx.getBean(DossierRepository.class);*/
		
		
	}
	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

//		accountServive.saveUtilisateur(new Uitisateur(null,"sidi","1234","sidi@gmail.com",null));
//		accountServive.saveUtilisateur(new Uitisateur(null,"MED","4321","med@gmail.com",null));
//		accountServive.saveUtilisateur(new Uitisateur(null,"LALE","5678","Lale@gmail.com",null));
//
//		accountServive.saveRole(new Role(null,"ADMIN"));
//		accountServive.saveRole(new Role(null,"EMPLOYER"));
//		accountServive.saveRole(new Role(null,"GETIONNAIRE"));
//
//		accountServive.AjoutRoleAUtilisateur("SIDI","EMPLOYER");
//		accountServive.AjoutRoleAUtilisateur("MED","GETIONNAIRE");
//		accountServive.AjoutRoleAUtilisateur("LALE","ADMIN");
//
//		dossierRepository.save(new Dossier(null,"versement",new Date(),"destop"));
//		dossierRepository.save(new Dossier(null,"retraits",new Date(),"destop"));
//		dossierRepository.save(new Dossier(null,"abonnemant",new Date(),"destop"));
       // dossierRepository.save(new Dossier(null,"text",new Date(),"destop/vers/pupel/scan"));
//
//
//
	}
}
