package in.gmsk.springbootapp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import in.gmsk.springbootapp.entity.ToDoPojo;

@Service
public class ToDoService {

	private static List<ToDoPojo> retrieve=new ArrayList<>();
	
	private static int todosCount = 0;

	static {
		retrieve.add(new ToDoPojo(++todosCount, "default desc", "Learn AWS", LocalDate.now().plusYears(1), false));
	}
	
	public List<ToDoPojo> findByUserName(String userName){
		Predicate<? super ToDoPojo> Predicate = todopojo -> todopojo.getUserName().equalsIgnoreCase(userName);
		return retrieve.stream().filter(Predicate).toList();
	}
	
	public void addToDo(String username, String description, LocalDate date, boolean done) {
		
		ToDoPojo obj=new ToDoPojo(++todosCount, username, description, date, done);
		retrieve.add(obj);
	}
	
	public void deleteById(int id) {
		
		Predicate<? super ToDoPojo> Predicate = todopojo -> todopojo.getId() == id;
		
		retrieve.removeIf(Predicate);
	}

	public ToDoPojo findById(int id) {
		
		Predicate<? super ToDoPojo> Predicate = todopojo -> todopojo.getId() == id;

	    ToDoPojo toDoPojo2 = retrieve.stream().filter(Predicate).findFirst().get();
		
		return toDoPojo2;
	}

	public void updateToDo(ToDoPojo todopojo) {
		
		deleteById(todopojo.getId());
		retrieve.add(todopojo);
	}

}
