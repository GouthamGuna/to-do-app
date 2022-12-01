package in.gmsk.springbootapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

	@RequestMapping(value = ("/"), method = RequestMethod.GET)
	public String goToWelcomePage(ModelMap model) {
		model.put("uservalue", "gmsk");
		return "welcome";
	}

}
