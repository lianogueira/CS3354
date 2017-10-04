package shippingstore;

/**
 * Class to describe the information of Customer (Extends UserList) <br><br>
 * <b>Data: </b><br>
 * User ID <br>
 * Social Security<br>
 * Salary<br>
 * Direct Deposit<br>
 *
 * @author Tyler Hooks and Lia Nogueira de Moura
 * @version 10/03/2017
 */

public class Customer extends UserList {

	private  String address;
	private  String phoneNumber;

	public Customer (String address, String phoneNumber,int userID, String first, String last){
		super(userID, first,last);
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setAddress(String address) {

		this.address =address;
	}
	public void setPhoneNumber(String phoneNumber) {

		this.phoneNumber = phoneNumber;
	}


}
