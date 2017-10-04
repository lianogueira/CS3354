package shippingstore;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;
import static java.lang.System.out;

/**
 *  This class is used to represent a database interface for a list of
 *  <CODE>User List</CODE>'s. It displays,adds, and updates a user's
 *  information.
 *
 * @author Tyler Hooks and Lia Nogueira de Moura
 * @version 10/03/2017
 */
public class UserDatabase implements Serializable {

	Scanner in = new Scanner(System.in);
	private ArrayList<UserList> ListOfUsers;
	private final String DB_FILE_NAME = "UserDB.txt";


	/**
	 * Gets an incremental new user ID <br></>
	 * If there is no user in the database, start with 1. If not, gets the max user ID +1.
	 * @return maxUserId+1
	 */
	private int nextUserID(){
		int maxUserId =0;

		for(UserList i : ListOfUsers)
			if (i.getUserID() > maxUserId)
				maxUserId = i.getUserID();

		return maxUserId+1;
	}


	/**
	 * Finds the user type based on the User id parameter
	 * @param userID UserId that will be used to find the type
	 */
	public String findUserType(int userID){

		String userType="unknown";

		for(UserList i : ListOfUsers)
			if (i.getUserID() == userID)
				if (i instanceof Employee)
					userType = "Employee";
				else if (i instanceof Customer)
					userType = "Customer";

		return userType;
	}

	/** This constructor initializes the ArrayList with the data from file
     * 	@throws Exception (throws Exception)
	 */

	public UserDatabase() throws Exception {
		ListOfUsers = new ArrayList<>();

		//Read DB file
		try {
			FileInputStream fileIN = new FileInputStream(DB_FILE_NAME);
			ObjectInputStream objectinputstream = new ObjectInputStream(fileIN);
			ListOfUsers = (ArrayList<UserList>) objectinputstream.readObject();
		}catch (FileNotFoundException e) {
			FileOutputStream oFile = new FileOutputStream(DB_FILE_NAME, false);
		} catch (IOException e) {
			System.out.println("Error~ There is a problem with file input from " + DB_FILE_NAME + ".");
		}

	}

	/**
	 * This method displays all users in the database.
	 */
	public void displayUsers() {


		out.println(" ----------------------------------------------------------------------------------------------------------------------------------- ");
		out.println("| User type  | First Name  | Last Name   | User ID | Address      | Phone Number   | Social Security # | Direct Deposit | Salary   |");
		out.println(" ----------------------------------------------------------------------------------------------------------------------------------- ");

		for(UserList i : ListOfUsers) {
			if( i instanceof Employee) {
				out.println(String.format("| %-11s| %-12s| %-12s| %-8s| %-13s| %-15s| %-18s| %-15s| %-9s|",
				    "EMPLOYEE",
				    ((Employee)i).getFirstName(),
					((Employee)i).getLastName(),
					((Employee)i).getUserID(),
					"", "",
					((Employee)i).getSocial(),
					((Employee)i).getDirectDepoist(),
					((Employee)i).getSalary()
					));

			} else if(i instanceof Customer) {
				out.println(String.format("| %-11s| %-12s| %-12s| %-8s| %-13s| %-15s| %-18s| %-15s| %-9s|",
						"CUSTOMER",
						((Customer)i).getFirstName(),
						((Customer)i).getLastName(),
						((Customer)i).getUserID(),
						((Customer)i).getAddress(),
						((Customer)i).getPhoneNumber(),"", "", ""
						));
			}else {
				out.println("There are currently no users to display.");
			}
		}
		out.println(" ----------------------------------------------------------------------------------------------------------------------------------- ");

	}

	/**
	 * This method adds a new user to the database given a
	 * first and last name.
	 * @param first
	 * @param last
	 */
	public void addUser(String first, String last) {

		char choice;
		boolean valid = false;

		int id = nextUserID();
		out.println("\n Your user ID is: "+ id);

		out.print("\n Are you a customer or employee? Answer c for customer or e for employee: ");
		choice = in.next().charAt(0);
		in.nextLine();


		do {
			switch(choice) {
			case 'c':
			case 'C':
				out.print("\n Please enter address: ");
				String address = in.nextLine();


				out.print("\n Please enter phone number: ");
				String phone = in.nextLine();
				ListOfUsers.add(new Customer(address, phone,id,first,last));
				out.println(" User added.");
				valid = true;
				break;

			case 'e':
			case 'E':

				//get ssn from user and validate input
				out.print("\n Please enter your Social Security number: ");
				while (!in.hasNextInt()) {
					out.println("\n Error: Invalid Social Security number");
					out.print("\n Please enter your Social Security number: ");
					in.next();
				}
				int social = in.nextInt();
				in.nextLine();


				//get direct deposit from user and validates input
				System.out.print("\n Please enter Direct Deposit number:");
				while (!in.hasNextInt()) {
					out.println("\n Error: Invalid Direct Deposit number");
					out.print("\n Please enter your Direct Deposit number: ");
					in.next();
				}
				int directDeposit = in.nextInt();
				in.nextLine();


				//get Salary from user and validates input
				out.print("\n Please enter Salary:");
				while (!in.hasNextFloat()) {
					out.println("\n Error: Invalid Salary");
					out.print("\n Please enter Salary: ");
					in.next();
				}
				float salary = in.nextFloat();
				in.nextLine();


				ListOfUsers.add(new Employee(social, directDeposit,salary, id,first,last));
				out.println(" User added.");
				valid = true;
				break;


			default:
				out.println("\n Invalid Option~");
				out.print("\n Answer c for customer or e for employee: ");
				choice = in.next().charAt(0);
				in.nextLine();
				break;

			}
		}while(valid == false);

}
	/**
	 * Updates user information based on the userID.
	 * @param userID
	 */
	public void updateUser(int userID){


			for(UserList t : ListOfUsers) {
				if(userID == t.getUserID()) {

					out.println(" Updating record for: UserID=" + userID + " - Name=" + t.getFirstName() + " " + t.getLastName() );

					//get first name from user
					out.print("\n Please enter new First Name: ");
					String first = in.nextLine();
					t.setFirst(first);

					//get last name from user
					out.print("\n Please enter new Last Name: ");
					String last = in.nextLine();
					t.setLast(last);

					if (t instanceof Employee) {

						out.println(" Hello, " + first + " " + last);


						//get ssn from user and validate input
						out.print("\n Please enter your Social Security number: ");
						while (!in.hasNextInt()) {
							out.println("\n Error: Invalid Social Security number");
							out.print("\n Please enter your Social Security number: ");
							in.next();
						}
						int social = in.nextInt();
						in.nextLine();
						((Employee) t).setSocial(social);


						//get direct deposit from user and validates input
						out.print("\n Please enter Direct Deposit number: ");
						while (!in.hasNextInt()) {
							out.println("\n Error: Invalid Direct Deposit number");
							out.print("\n Please enter your Direct Deposit number: ");
							in.next();
						}
						int directDeposit = in.nextInt();
						in.nextLine();
						((Employee) t).setDirectDeposit(directDeposit);


						//get Salary from user and validates inout
						out.print("\n Please enter Salary: ");
						while (!in.hasNextFloat()) {
							out.println("\n Error: Invalid Salary");
							out.print("\n Please enter Salary: ");
							in.next();
						}
						float salary = in.nextFloat();
						in.nextLine();
						((Employee) t).setSalary(salary);

					}
					if (t instanceof Customer) {

						//get address from user
						out.print("\n Please enter address: ");
						String address = in.nextLine();
						((Customer) t).setAddress(address);

						//get phone number from user
						out.print("\n Please enter phone number: ");
						String phone = in.nextLine();
						((Customer) t).setPhoneNumber(phone);
					}
				}
			}


	}

    /**
     * This method writes the data into file
     * @throws Exception (throws Exception)
     */
	public void flush() throws Exception{

		//write to file
		try {
			FileOutputStream fileOUT = new FileOutputStream(DB_FILE_NAME);
			ObjectOutputStream objectOUT = new ObjectOutputStream(fileOUT);

			objectOUT.writeObject(ListOfUsers);
			objectOUT.close();
		}
		catch (IOException e) {
			System.out.println("Error~ There is a problem writing to " + DB_FILE_NAME + ".");
		}

	}


}
