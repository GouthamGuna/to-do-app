package in.gmsk.springbootapp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import in.gmsk.springbootapp.entity.ToDoPojo;

@Service
public class ToDoService {

	private static List<ToDoPojo> retrieve=new ArrayList<>();
	
	static {
		retrieve.add(new ToDoPojo(1, "Gowtham", "Learn AWS", LocalDate.now().plusYears(1), false));
		retrieve.add(new ToDoPojo(2, "Jay kumar", "Learn AWS", LocalDate.now().plusYears(1), false));
		retrieve.add(new ToDoPojo(3, "Karthik", "Learn AWS", LocalDate.now().plusYears(1), false));
	}
	
	public List<ToDoPojo> findByUserName(String userName){
		return retrieve;
	}
}
