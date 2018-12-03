package learn.epam.mlhh;

import learn.epam.mlhh.entity.Candidate;
import learn.epam.mlhh.entity.Users;
import learn.epam.mlhh.service.CandidateService;
import learn.epam.mlhh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import learn.epam.mlhh.controllers.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;


@SpringBootApplication
public class MlHhApplication {

	@Autowired
	private CandidateService candidateService;

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(MlHhApplication.class, args);
		Database.connectDatabase();
	}

	@EventListener(ApplicationReadyEvent.class)
	private void testJpaMethods(){
		Candidate candidate = new Candidate();
		candidate.setName("Smith");
		candidate.setAge(25);
		candidate.setGender("М");
		candidate.setRegion("Gorky");
		candidate.setSalary(50.000);
		candidate.setDeveloper("Java Developer");
		candidate.setExperience(1);
		candidate.setKeyWord("Spring");
		candidateService.createCandidate(candidate);

		Candidate newCandidate = new Candidate();
		newCandidate.setName("FIO");
		newCandidate.setAge(20);
		newCandidate.setGender("М");
		newCandidate.setRegion("Gorky");
		newCandidate.setSalary(5000.0);
		newCandidate.setDeveloper("");
		newCandidate.setExperience(0);
		newCandidate.setKeyWord("-");
		candidateService.createCandidate(newCandidate);

		Users user = new Users();
		user.setUserName("Admin");
		user.setUserPassword("password123");
		userService.createUser(user);

		/*candidateService.findAll().forEach(it-> System.out.println(it));

		candidateService.findAllByName("Smith").forEach(it-> System.out.println(it));*/
	}
}
