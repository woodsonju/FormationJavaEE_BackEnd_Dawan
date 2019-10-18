package fr.dawan.database.beans;

public class Student {
	
	private long id;
	private String name;
    private long age;
    private String faculty;
    
	public Student() {
		super();

	}
	
	public Student(String name, long age, String faculty) {
		super();

		this.name = name;
		this.age = age;
		this.faculty = faculty;
	}

	public Student(long id, String name, long age, String faculty) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.faculty = faculty;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
