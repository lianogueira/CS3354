package shippingstore;

import java.io.Serializable;

public class UserList implements Serializable {
	
	protected int userID;
	protected String first;
	protected String last;

	
	public UserList(int userID, String first, String last) {
		this.userID = userID;
		this.first = first; 
		this.last = last; 
	}
	
	public int getUserID() {
		return userID; 
	}

	public String getFirstName() {
		return first; 
	}
	
	public String getLastName() {
		return last; 
	}

	public void setFirst(String first){this.first = first;}

	public void setLast(String last){this.last = last;}
}
