package in.gmsk.springbootapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("uservalue")
public class WelcomeController {

	@RequestMapping(value = ("/"), method = RequestMethod.GET)
	public String goToWelcomePage(ModelMap model) {
		model.put("uservalue", getLoginUsername());
		return "welcome";
	}
	
	private String getLoginUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}
