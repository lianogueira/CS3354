package shippingstore;

public class UserList {
	
	protected final int userID; 
	protected final String first; 
	protected final String last; 

	
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
}
