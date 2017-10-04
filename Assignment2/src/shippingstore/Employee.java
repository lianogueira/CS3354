package shippingstore;

/**
 * Class to describe the information of Employee (Extends UserList) <br><br>
 * <b>Data: </b><br>
 * User ID <br>
 * Social Security<br>
 * Salary<br>
 * Direct Deposit<br>
 *
 * @author Tyler Hooks and Lia Nogueira de Moura
 * @version 10/03/2017
 */

public class Employee extends UserList{

	private  int social;
	private  int directDeposit;
	private  float salary;


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
