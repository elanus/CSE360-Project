package edu.asu.cse360.data;

public abstract class User extends SQLEntity {
	
	protected String username, lastName, firstName;
	protected boolean isInstructor;
	
	public User()
	{}

	
/*** Getter and Setter ***/	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public boolean isInstructor() {
		return isInstructor;
	}
	


}
