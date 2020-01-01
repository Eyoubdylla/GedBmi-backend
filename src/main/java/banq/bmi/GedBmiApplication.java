package banq.bmi;

import banq.bmi.Repository.DocumentRepositry;
import banq.bmi.Repository.GrpsDoc;
import banq.bmi.entities.*;
import banq.bmi.Repository.DossierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import banq.bmi.services.AccountServive;

@SpringBootApplication
public class GedBmiApplication{
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





	public static void main(String[] args) {
		SpringApplication.run(GedBmiApplication.class, args);
		/*ApplicationContext ctx = SpringApplication.run(GedBmiApplication.class, args);
		DossierRepository dossierRepository = ctx.getBean(DossierRepository.class);*/
		
		
	}
	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}
	/*@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stubts

		Utilisateur u1=accountServive.saveUser(new Utilisateur("sidi","1111","sidi@gmail.com",null));
		Utilisateur u2= accountServive.saveUser(new Utilisateur("MED","1234","med@gmail.com",null));
		Utilisateur u3= accountServive.saveUser(new Utilisateur("LALE","5678","Lale@gmail.com",null));
		Utilisateur u4= accountServive.saveUser(new Utilisateur("eyoub","5678","eyoub@gmail.com",null));

//		Dossier dossier1 =dossierRepository.save(new Dossier(null,"versement",new Date(),u1,null));
//		Dossier dossier2 =dossierRepository.save(new Dossier(null,"retraits",new Date(),u2,null));
//		Dossier dossier3 =dossierRepository.save(new Dossier(null,"abonnemant",new Date(),u1,null));
//		Dossier dossier4 =dossierRepository.save(new Dossier(null,"text",new Date(),u2,null));
//
//		testRepository.save(new test("eyoub","sss","ddddd"));
//		testRepository.save(new test("eyoub","sss","ddddd"));
//		testRepository.save(new test("eyoub","sss","ddddd"));
//		testRepository.save(new test("eyoub","sss","ddddd"));
//
//
//		GroupsDoc g1 =groupsDoc.save(new GroupsDoc(null,"Group1",null,null));
//		GroupsDoc g2 =groupsDoc.save(new GroupsDoc(null,"Group2",null,null));
//		GroupsDoc g3 =groupsDoc.save(new GroupsDoc(null,"Group1",null,null));
//		GroupsDoc g4 =groupsDoc.save(new GroupsDoc(null,"Group3",null,null));
//		GroupsDoc g5 =groupsDoc.save(new GroupsDoc(null,"Group4",null,null));
//
//		Document d1 = documentRepositry.save(new Document(null,"titre1", new Date(),"fggg","kk",null,null));
//		Document d2 = documentRepositry.save(new Document(null,null,null,null,null,null,null));
//		Document d3 = documentRepositry.save(new Document(null,"titre3",new Date(),"","",null,null));
//		Document d4 = documentRepositry.save(new Document(null,"titre4",new Date(),"","",null,null));
//		Document d5 = documentRepositry.save(new Document(null,"titre5",new Date(),"","",null,null));
//


		accountServive.saveRole(new Role("ADMI",null));
		accountServive.saveRole(new Role("EMPLOYER",null));
		accountServive.saveRole(new Role("GETIONNAIRE",null));
		accountServive.saveRole(new Role("Controller",null));
		accountServive.AddRolesForUser("SIDI","EMPLOYER");
		accountServive.AddRolesForUser("MED","GETIONNAIRE");
		accountServive.AddRolesForUser("LALE","ADMIN");
		accountServive.AddRolesForUser("eyoub","Controller");




	}*/
}
