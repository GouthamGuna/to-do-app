package in.gmsk.springbootapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
		
		String username=getLoginUsername(model);
		List<ToDoPojo> getData=doService.findByUserName(username);
		
		model.addAttribute("showList", getData);
		
		return "listToDos";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddToDoPage(ModelMap model){
		
		String username=getLoginUsername(model);
		ToDoPojo obj=new ToDoPojo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("todopojo", obj);
		
		return "addToDoPage";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String AddToDoPage(ModelMap model, ToDoPojo todopojo){
		
		String username=getLoginUsername(model);
		doService.addToDo(username, todopojo.getDescription(), todopojo.getDate(), false);
		
		return "redirect:mylist";
	}
	
	@RequestMapping("/delete-todo")
	public String deleteToDo(@RequestParam int id) {
		
		doService.deleteById(id);
		return "redirect:mylist";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateToDoPage(@RequestParam int id, ModelMap model) {
		
		ToDoPojo obj=doService.findById(id);
		model.addAttribute("todopojo", obj);
		
		return "addToDoPage";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateToDoPage(ModelMap model, ToDoPojo todopojo){
		
		String username=getLoginUsername(model);
		todopojo.setUserName(username);
		doService.updateToDo(todopojo);
		
		return "redirect:mylist";
	}
	
	private String getLoginUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
