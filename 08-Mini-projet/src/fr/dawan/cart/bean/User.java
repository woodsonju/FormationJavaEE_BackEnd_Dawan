package fr.dawan.cart.bean;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	
	private int id;
	private String foreName;
	private String email; 
	private String password;
	private String phoneNumber;
	private Date date;
	private int role; 
	private Boolean validation;
	
	public User() {
		super();

	}
	
	public User(String foreName, String email, String password, String phoneNumber, Date date, int role,
			Boolean validation) {
		super();
		this.foreName = foreName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.date = date;
		this.role = role;
		this.validation = validation;
	}

	public User(int id, String foreName, String email, String password, String phoneNumber, Date date, int role,
			Boolean validation) {
		super();
		this.id = id;
		this.foreName = foreName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.date = date;
		this.role = role;
		this.validation = validation;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getForeName() {
		return foreName;
	}

	public void setForeName(String foreName) {
		this.foreName = foreName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public Boolean getValidation() {
		return validation;
	}

	public void setValidation(Boolean validation) {
		this.validation = validation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((foreName == null) ? 0 : foreName.hashCode());
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + role;
		result = prime * result + ((validation == null) ? 0 : validation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (foreName == null) {
			if (other.foreName != null)
				return false;
		} else if (!foreName.equals(other.foreName))
			return false;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (role != other.role)
			return false;
		if (validation == null) {
			if (other.validation != null)
				return false;
		} else if (!validation.equals(other.validation))
			return false;
		return true;
	}

	

}
