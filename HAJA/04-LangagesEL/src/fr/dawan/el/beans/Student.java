package fr.dawan.el.beans;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name = "Toto";
	private Integer age;
	private String faculty;
		
		
		
	public Student() {
		super();
	}
		
		
	public Student(String name, Integer age, String faculty) {
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
		
	public Integer getAge() {
		return age;
	}
		
	public void setAge(Integer age) {
		this.age = age;
	}
		
	public String getFaculty() {
		return faculty;
	}
		
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

}
