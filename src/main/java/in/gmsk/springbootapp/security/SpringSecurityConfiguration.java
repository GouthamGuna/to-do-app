package in.gmsk.springbootapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	
	/*
	 * InMemoryUserDetailsManager InMemoryUserDetailsManager(UserDetails... users)
	 */
	
	@Bean
	public InMemoryUserDetailsManager createUser() {
		
		Function<String, String> encoder = input -> encoder().encode(input);
		
		UserDetails user = User.builder()
								.passwordEncoder(encoder)
								.username("gowtham")
								.password("sreeja")
								.roles("ADMIN","USER")
								.build();
		return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
