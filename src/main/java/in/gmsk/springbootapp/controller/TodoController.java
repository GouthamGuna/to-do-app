package in.gmsk.springbootapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		model.addAttribute("showList", getData);
		
		return "listToDos";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddToDoPage(){
		
		return "addToDoPage";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String AddToDoPage(@RequestParam String description, ModelMap model){
		
		String username=(String)model.get("username");
		doService.addToDo(username, description, LocalDate.now(), false);
		
		return "redirect:mylist";
	}
}
