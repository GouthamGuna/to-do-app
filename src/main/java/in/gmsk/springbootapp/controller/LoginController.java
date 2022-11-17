package in.gmsk.springbootapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("/")
public class LoginController {

	private Logger logger=LoggerFactory.getLogger(getClass());
	
	@RequestMapping
	public String goToLoginPage(@RequestParam String name, ModelMap model) {
		model.put("name", name);
		logger.debug("Request Param {} ",name);
		return "login";
	}
}
