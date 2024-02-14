package debit.manager;

import debit.manager.domain.User;
import debit.manager.domain.dto.UserDto;
import debit.manager.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.cert.Extension;

@SpringBootApplication
public class DebitManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DebitManagerApplication.class, args);
	}
	@Bean
	public CommandLineRunner runner(UserRepo repo) {
		UserDto dto = new UserDto("admin@email.com", "$2a$12$f.UVXQrtYt.usEOqVpja6e2wHW8zVRLt1A4R6d685iF4r/4HowJC.");
		return args -> repo.save(new User(dto));
	}
}
