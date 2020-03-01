package br.com.userAccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.userAccess.domain.Client;
import br.com.userAccess.domain.User;
import br.com.userAccess.repository.UserRepository;

@SpringBootApplication
public class UserAccessApplication  implements CommandLineRunner {
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(UserAccessApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		userRepository.deleteAll();
		Client client = new Client(null, "crane@gmail.com", "kyle Crane");
		User user = new User(null, "crane" , bCryptPasswordEncoder.encode("123"), client);
		userRepository.save(user);
	}

}

