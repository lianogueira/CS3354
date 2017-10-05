package shippingstore;

/**
 * Class to describe the information of Employee (Extends UserList) <br><br>
 * <b>Data: </b><br>
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

	/**
	 * Constructs an Employee object given the input.
	 * @param directDeposit Direct Deposit to initialize the employee.
 	 * @param social Social Security to initialize the employee.
	 * @param salary Salary to initialize the employee.
	 * @param userID UserID to initialize the employee.
	 * @param first First Name to initialize the employee.
	 * @param last Last Name to initialize the employee.
	 */
	public Employee(int social, int directDeposit, float salary,int userID, String first, String last) {
		super(userID, first,last);
		this.directDeposit = directDeposit;
		this.social = social;
		this.salary = salary;
	}

	/**
	 * Get Social
	 * @return social
	 */
	public int getSocial() {
		return social;
	}

	/**
	 * Get Direct Deposit
	 * @return directDeposit
	 */
	public int getDirectDepoist() {
		return directDeposit;
	}

	/**
	 * Get Salary
	 * @return salary
	 */
	public float getSalary() {
		return salary;
	}

	/**
	 *  Set Social
	 * @param social Employee new SSN
	 */
	public void setSocial(int social){
		this.social = social;
	}

	/**
	 * Set Direct Deposit
	 * @param directDeposit Employee new Direct Deposit Number
	 */
	public void setDirectDeposit(int directDeposit){
		this.directDeposit = directDeposit;
	}

	/**
	 * Set Salary
	 * @param salary Employee new salary
	 */
	public void setSalary(float salary){
		this.salary = salary;
	}


}
