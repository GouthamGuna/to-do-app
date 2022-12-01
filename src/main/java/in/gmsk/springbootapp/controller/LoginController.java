package in.gmsk.springbootapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("uservalue")
public class LoginController {

	private Logger logger=LoggerFactory.getLogger(getClass());

	private AuthenticateUserService authenticateUserService;
	
	public LoginController(AuthenticateUserService authenticateUserService) {
		super();
		this.authenticateUserService = authenticateUserService;
	}

	@RequestMapping(value = ("/"), method = RequestMethod.GET)
	public String goToLoginPage() {
		return "login";
	}

	@RequestMapping(value = ("/"), method = RequestMethod.POST)
	public String goToWelcomePage(@RequestParam String name,
			@RequestParam String password, ModelMap model) {

		logger.debug("Username {}", name);

		if(authenticateUserService.validate(name, password)){
			model.put("uservalue", name);

			return "listToDos";
		}
		
		model.put("error", "incorrect credentials...");
		
		return "login";
	}
	
}
