package shippingstore;

public class Customer extends UserList {

	private final String address;
	private final String phoneNumber;

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


}
