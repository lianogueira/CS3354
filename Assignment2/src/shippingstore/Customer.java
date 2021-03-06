package shippingstore;

/**
 * Class to describe the information of Customer (Extends UserList) <br><br>
 * <b>Data: </b><br>
 * Address<br>
 * Phone Number<br>
 *
 * @author Tyler Hooks and Lia Nogueira de Moura
 * @version 10/03/2017
 */

public class Customer extends UserList {

	private  String address;
	private  String phoneNumber;

	/**
	 * Constructs an Customer object given the input.
	 * @param address  Address to initialize the customer.
 	 * @param phoneNumber Phone Number to initialize the customer.
	 * @param userID UserID to initialize the customer.
	 * @param first First Name to initialize the customer.
	 * @param last Last Name to initialize the customer.
	 */
	public Customer (String address, String phoneNumber,int userID, String first, String last){
		super(userID, first,last);
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Get Address
	 * @return address
	 */

	public String getAddress() {
		return address;
	}
	/**
	 * Get Phone Number
	 * @return phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Set Address
	 * @param address customer new Address
	 */
	public void setAddress(String address) {this.address =address;}

	/**
	 * Set Phone Number
	 * @param phoneNumber Customer new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

}
