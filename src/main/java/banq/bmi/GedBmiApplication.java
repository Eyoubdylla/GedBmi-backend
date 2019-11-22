package banq.bmi;
import java.util.Date ;

import banq.bmi.Repository.DocumentRepositry;
import banq.bmi.Repository.GrpsDoc;
import banq.bmi.Repository.TestRepository;
import banq.bmi.entities.*;
import banq.bmi.Repository.DossierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.jdbc.support.incrementer.AbstractDataFieldMaxValueIncrementer;
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

	@Autowired
	private GrpsDoc groupsDoc ;

	@Autowired
	private DocumentRepositry documentRepositry ;
	@Autowired
	private TestRepository testRepository;





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
		// TODO Auto-generated method stubts

		Utilisateur u1=accountServive.saveUtilisateur(new Utilisateur(null,"sidi","1234","sidi@gmail.com",null,null));
		Utilisateur u2= accountServive.saveUtilisateur(new Utilisateur(null,"MED","4321","med@gmail.com",null,null));
		Utilisateur u3= accountServive.saveUtilisateur(new Utilisateur(null,"LALE","5678","Lale@gmail.com",null,null));

		Dossier dossier1 =dossierRepository.save(new Dossier(null,"versement",new Date(),u1,null));
		Dossier dossier2 =dossierRepository.save(new Dossier(null,"retraits",new Date(),u2,null));
		Dossier dossier3 =dossierRepository.save(new Dossier(null,"abonnemant",new Date(),u1,null));
		Dossier dossier4 =dossierRepository.save(new Dossier(null,"text",new Date(),u2,null));

		testRepository.save(new test("eyoub","sss","ddddd"));
		testRepository.save(new test("eyoub","sss","ddddd"));
		testRepository.save(new test("eyoub","sss","ddddd"));
		testRepository.save(new test("eyoub","sss","ddddd"));


		GroupsDoc g1 =groupsDoc.save(new GroupsDoc(null,"Group1",null,null));
		GroupsDoc g2 =groupsDoc.save(new GroupsDoc(null,"Group2",null,null));
		GroupsDoc g3 =groupsDoc.save(new GroupsDoc(null,"Group1",null,null));
		GroupsDoc g4 =groupsDoc.save(new GroupsDoc(null,"Group3",null,null));
		GroupsDoc g5 =groupsDoc.save(new GroupsDoc(null,"Group4",null,null));

		Document d1 = documentRepositry.save(new Document(null,"titre1", new Date(),"fggg","kk",null,null));
		Document d2 = documentRepositry.save(new Document(null,null,null,null,null,null,null));
		Document d3 = documentRepositry.save(new Document(null,"titre3",new Date(),"","",null,null));
		Document d4 = documentRepositry.save(new Document(null,"titre4",new Date(),"","",null,null));
		Document d5 = documentRepositry.save(new Document(null,"titre5",new Date(),"","",null,null));



		accountServive.saveRole(new Role(null,"ADMIN",null));
		accountServive.saveRole(new Role(null,"EMPLOYER",null));
		accountServive.saveRole(new Role(null,"GETIONNAIRE",null));

		accountServive.AjoutRoleAUtilisateur("SIDI","EMPLOYER");
		accountServive.AjoutRoleAUtilisateur("MED","GETIONNAIRE");
		accountServive.AjoutRoleAUtilisateur("LALE","ADMIN");




	}
}
