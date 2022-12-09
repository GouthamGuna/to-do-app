package in.gmsk.springbootapp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
	/*
	 * InMemoryUserDetailsManager InMemoryUserDetailsManager(UserDetails... users)
	 */
	
	@Bean
	public InMemoryUserDetailsManager createUser() {
		
		UserDetails user = CreateNewUser("gowtham", "admin");
		UserDetails user1 = CreateNewUser("gmsk", "admin");
		
		return new InMemoryUserDetailsManager(user, user1);
	}

	private UserDetails CreateNewUser(String username, String password) {
		Function<String, String> encoder = input -> encoder().encode(input);
		
		UserDetails user = User.builder()
								.passwordEncoder(encoder)
								.username(username)
								.password(password)
								.roles("ADMIN","USER")
								.build();
		return user;
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	/*
	 * All URL's are protected
	 * A Login from is shown for unauthorized requests
	 * CSRF disable
	 * Frames are allow
	 * 
	 */
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		
		http.formLogin(withDefaults());
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		return http.build();
	}
}
