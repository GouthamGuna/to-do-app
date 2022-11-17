package in.gmsk.springbootapp.controller;

import org.springframework.stereotype.Service;

@Service
public class AuthenticateUserService {

	public boolean validate(String name, String password) {
		
		boolean validusername = name.equalsIgnoreCase("admin");
		boolean validpassword = password.equalsIgnoreCase("dummy");
		
		return validusername && validpassword;
	}
}
