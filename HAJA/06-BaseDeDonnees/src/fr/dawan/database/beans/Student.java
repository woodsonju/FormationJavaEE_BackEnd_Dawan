package fr.dawan.database.beans;

import java.io.Serializable;

public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String name = "Toto";
	private long age;
	private String faculty;
		
		
		
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Student() {
		super();
			// TODO Auto-generated constructor stub
	}
		
		
	public Student(String name, long age, String faculty) {
		super();
		this.name = name;
		this.age = age;
		this.faculty = faculty;
	}
		
	public String getName() {
		return name;
	}
		
	public void setName(String name) {
		this.name = name;
	}
		
	public long getAge() {
		return age;
	}
		
	public void setAge(long age) {
		this.age = age;
	}
		
	public String getFaculty() {
		return faculty;
	}
		
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

}
