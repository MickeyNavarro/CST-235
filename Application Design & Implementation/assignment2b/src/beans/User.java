package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean 
@ViewScoped
public class User {
	// attributes
	private String firstName;
	private String lastName;

	// default constructor
	public User() {
		// initialize with my name
		this.firstName = "Mickey";
		this.lastName = "Navarro";
	}

	// setters & getters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
