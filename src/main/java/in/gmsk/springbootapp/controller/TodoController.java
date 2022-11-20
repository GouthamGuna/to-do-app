package in.gmsk.springbootapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import in.gmsk.springbootapp.entity.ToDoPojo;
import in.gmsk.springbootapp.service.ToDoService;

@Controller
@SessionAttributes("uservalue")
public class TodoController {
	
	private ToDoService doService;
	
	public TodoController(ToDoService doService) {
		super();
		this.doService = doService;
	}

	@RequestMapping("/mylist")
	public String listAllToDos(ModelMap model) {
		
		List<ToDoPojo> getData=doService.findByUserName("gowtham");
		
		model.addAttribute("show", getData);
		
		return "listToDos";
	}
}
