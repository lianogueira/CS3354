package shippingstore;

public class Employee extends UserList{

	private final int social;
	private final int directDeposit;
	private final float salary;


	public Employee(int social, int directDeposit, float salary,int userID, String first, String last) {
		super(userID, first,last);
		this.directDeposit = directDeposit;
		this.social = social;
		this.salary = salary;
	}

	public int getSocial() {
		return social;
	}

	public int getDirectDepoist() {
		return directDeposit;
	}

	public float getSalary() {
		return salary;
	}


}
