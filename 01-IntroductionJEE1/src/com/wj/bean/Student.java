package com.wj.bean;

public class Student {
	private String name;
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

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", faculty=" + faculty + "]";
	}
    
    
	

}
