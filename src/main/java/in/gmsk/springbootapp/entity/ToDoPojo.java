package in.gmsk.springbootapp.entity;

import java.time.LocalDate;

public class ToDoPojo {
		
	private int id;
	private String userName;
	private String description;
	private LocalDate date;
	private boolean isDone;
	

	public ToDoPojo(int id, String userName, String description, LocalDate date, boolean isDone) {
		super();
		this.id = id;
		this.userName = userName;
		this.description = description;
		this.date = date;
		this.isDone = isDone;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public boolean isDone() {
		return isDone;
	}


	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public String toString() {
		return "ToDoPojo [id=" + id + ", userName=" + userName + ", description=" + description + ", date=" + date
				+ ", isDone=" + isDone + "]";
	}
	
}
