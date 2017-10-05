package shippingstore;

import java.io.Serializable;

/**
 * Class to describe the information of a User <br><br>
 * <b>Data: </b><br>
 * UserID<br>
 * First Name<br>
 * Last Name<br>
 *
 * @author Tyler Hooks and Lia Nogueira de Moura
 * @version 10/03/2017
 */
public class UserList implements Serializable {
	
	protected int userID;
	protected String first;
	protected String last;

	/** Constructs a UserList object. Initializes data using input
	 *
	 * @param userID UserID to initialize the user.
	 * @param first First Name to initialize the user.
	 * @param last Last Name to initialize the user.
	 * */
	public UserList(int userID, String first, String last) {
		this.userID = userID;
		this.first = first; 
		this.last = last; 
	}

	/** Get UserId
	 * @return UserID
	 */
	public int getUserID() {
		return userID; 
	}

	/** Get First Name
	 * @return First Name
	 */
	public String getFirstName() {
		return first; 
	}

	/** Get Last Name
	 * @return Last Name
	 */
	public String getLastName() {
		return last; 
	}

	/**
	 *  Set First Name
	 * @param first User New First Name
	 */
	public void setFirst(String first){this.first = first;}

	/**
	 *  Set Last Name
	 * @param last User New Last Name
	 */
	public void setLast(String last){this.last = last;}
}
