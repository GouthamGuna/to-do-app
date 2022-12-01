package in.gmsk.springbootapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	
	/*
	 * InMemoryUserDetailsManager InMemoryUserDetailsManager(UserDetails... users)
	 */
	
	@Bean
	public InMemoryUserDetailsManager createUser() {
		UserDetails user = User.withDefaultPasswordEncoder()
		.username("gowtham")
		.password("sreeja")
		.roles("ADMIN","USER")
		.build();
		return new InMemoryUserDetailsManager(user);
	}

}
