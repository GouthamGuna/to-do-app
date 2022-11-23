package in.gmsk.springbootapp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import in.gmsk.springbootapp.entity.ToDoPojo;

@Service
public class ToDoService {

	private static List<ToDoPojo> retrieve=new ArrayList<>();
	
	private static int todosCount = 0;
	
	static {
		retrieve.add(new ToDoPojo(++todosCount, "Gowtham", "Learn AWS", LocalDate.now().plusYears(1), false));
		retrieve.add(new ToDoPojo(++todosCount, "Jay kumar", "Learn AWS", LocalDate.now().plusYears(1), false));
		retrieve.add(new ToDoPojo(++todosCount, "Karthik", "Learn AWS", LocalDate.now().plusYears(1), false));
	}
	
	public List<ToDoPojo> findByUserName(String userName){
		return retrieve;
	}
	
	public void addToDo(String username, String description, LocalDate date, boolean done) {
		
		ToDoPojo obj=new ToDoPojo(++todosCount, username, description, date, done);
		retrieve.add(obj);
	}
}
