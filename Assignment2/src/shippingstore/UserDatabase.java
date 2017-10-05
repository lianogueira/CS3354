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
	private ArrayList<UserList> listOfUsers;
	private final String DB_FILE_NAME = "UserDB.txt";


	/**
	 * Gets a new incremental new user ID <br>
	 * If there is no user in the database, return 1 <br>
	 * Is list of user is not empty, find the max id and returns maxUserID+1
	 * @return maxUserId+1
	 */
	private int nextUserID(){
		int maxUserId =0;

		//Finds max UserID
		for(UserList i : listOfUsers)
			if (i.getUserID() > maxUserId)
				maxUserId = i.getUserID();

		return maxUserId+1;
	}



	/** This constructor initializes the ArrayList with the data from file
	 * 	@throws Exception (throws Exception)
	 */
	public UserDatabase() throws Exception {
		listOfUsers = new ArrayList<>();

		//Read DB file
		try {
			FileInputStream fileIN = new FileInputStream(DB_FILE_NAME);
			ObjectInputStream objectinputstream = new ObjectInputStream(fileIN);
			listOfUsers = (ArrayList<UserList>) objectinputstream.readObject();
		}catch (FileNotFoundException e) {
			FileOutputStream oFile = new FileOutputStream(DB_FILE_NAME, false);
		} catch (IOException e) {
			System.out.println("Error~ There is a problem with file input from " + DB_FILE_NAME + ".");
		}

	}


	/**
	 * Finds the user type based on the UserID parameter <br>
	 * If no user is found, return "unknown"
	 * @param userID UserId that will be used to find the type
	 * @return userType - (unknown, Employee or Customer)
	 */
	public String findUserType(int userID){

		String userType="unknown";

		//loops through the list of users to find the user that matches the user id passed as parameter
		//If it finds it, gets the type of user
		for(UserList i : listOfUsers)
			if (i.getUserID() == userID)
				if (i instanceof Employee)
					userType = "Employee";
				else if (i instanceof Customer)
					userType = "Customer";

		return userType;
	}


	/**
	 * This method displays all users in the database.
	 */
	public void displayUsers() {

		//Maximum length constants. They will be used to truncate string that are too long
		int MAX_FIRST_NAME_LEN = 11;
		int MAX_LAST_NAME_LEN = 11;
		int MAX_ADDRESS_LEN = 12;
		int MAX_PHONE_LEN = 14;

		out.println(" ----------------------------------------------------------------------------------------------------------------------------------- ");
		out.println("| User type  | First Name  | Last Name   | User ID | Address      | Phone Number   | Social Security # | Direct Deposit | Salary   |");
		out.println(" ----------------------------------------------------------------------------------------------------------------------------------- ");

		for(UserList i : listOfUsers) {
			if( i instanceof Employee) {
				out.println(String.format("| %-11s| %-12s| %-12s| %-8s| %-13s| %-15s| %-18s| %-15s| %-9s|",
						"EMPLOYEE",
						i.getFirstName().substring(0,(i.getFirstName().length() < MAX_FIRST_NAME_LEN)?i.getFirstName().length():MAX_FIRST_NAME_LEN), //truncates to MAX_FIRST_NAME_LEN,
						i.getLastName().substring(0,(i.getLastName().length() < MAX_LAST_NAME_LEN)?i.getLastName().length():MAX_LAST_NAME_LEN), //truncates to MAX_LAST_NAME_LEN,
						i.getUserID(),
						"", "",
						((Employee)i).getSocial(),
						((Employee)i).getDirectDepoist(),
						String.format("%.2f",((Employee)i).getSalary())
				));

			} else if(i instanceof Customer) {

				out.println(String.format("| %-11s| %-12s| %-12s| %-8s| %-13s| %-15s| %-18s| %-15s| %-9s|",
						"CUSTOMER",
						i.getFirstName().substring(0,(i.getFirstName().length() < MAX_FIRST_NAME_LEN)?i.getFirstName().length():MAX_FIRST_NAME_LEN), //truncates to MAX_FIRST_NAME_LEN
						i.getLastName().substring(0,(i.getLastName().length() < MAX_LAST_NAME_LEN)?i.getLastName().length():MAX_LAST_NAME_LEN), //truncates to MAX_LAST_NAME_LEN
						i.getUserID(),
						((Customer)i).getAddress().substring(0,(((Customer)i).getAddress().length() < MAX_ADDRESS_LEN)?((Customer)i).getAddress().length():MAX_ADDRESS_LEN), //truncates to MAX_ADDRESS_LEN
						((Customer)i).getPhoneNumber().substring(0,(((Customer)i).getPhoneNumber().length() < MAX_PHONE_LEN)?((Customer)i).getPhoneNumber().length():MAX_PHONE_LEN),  //truncates to MAX_PHONE_LEN
						"", "", ""
				));
			}
		}
		out.println(" ----------------------------------------------------------------------------------------------------------------------------------- ");

	}

	/**
	 * This method adds a new user to the database given a
	 * first and last name.
	 * @param first First Name of the new user. - (Data type: String)
	 * @param last Last Name of the new user. - (Data type: String)
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

					//gets address from user
					out.print("\n Please enter address: ");
					String address = in.nextLine();

					//gets phone from user
					out.print("\n Please enter phone number: ");
					String phone = in.nextLine();

					//adds new customer
					listOfUsers.add(new Customer(address, phone,id,first,last));
					out.println(" User added.");
					valid = true;
					break;

				case 'e':
				case 'E':

					//gets ssn from user and validates input
					out.print("\n Please enter your Social Security number: ");
					while (!in.hasNextInt()) {
						out.println("\n Error: Invalid Social Security number");
						out.print("\n Please enter your Social Security number: ");
						in.next();
					}
					int social = in.nextInt();
					in.nextLine();


					//gets direct deposit from user and validates input
					out.print("\n Please enter Direct Deposit number:");
					while (!in.hasNextInt()) {
						out.println("\n Error: Invalid Direct Deposit number");
						out.print("\n Please enter your Direct Deposit number: ");
						in.next();
					}
					int directDeposit = in.nextInt();
					in.nextLine();


					//gets Salary from user and validates input
					out.print("\n Please enter Salary:");
					while (!in.hasNextFloat()) {
						out.println("\n Error: Invalid Salary");
						out.print("\n Please enter Salary: ");
						in.next();
					}
					float salary = in.nextFloat();
					in.nextLine();

					//adds new employee
					listOfUsers.add(new Employee(social, directDeposit,salary, id,first,last));
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
	 * @param userID userID UserID to be used for the update - (Data type: Integer)
	 */
	public void updateUser(int userID){
		boolean doesUserExist=false;

		for(UserList t : listOfUsers) {
			if(userID == t.getUserID()) {

				doesUserExist=true;

				out.println(" Updating record for: UserID=" + userID + " - Name=" + t.getFirstName() + " " + t.getLastName() );

				//gets first name from user
				out.print("\n Please enter new First Name: ");
				String first = in.nextLine();
				t.setFirst(first);

				//gets last name from user
				out.print("\n Please enter new Last Name: ");
				String last = in.nextLine();
				t.setLast(last);

				if (t instanceof Employee) {

					out.println(" Hello, " + first + " " + last);

					//gets ssn from user and validate input
					out.print("\n Please enter your Social Security number: ");
					while (!in.hasNextInt()) {
						out.println("\n Error: Invalid Social Security number");
						out.print("\n Please enter your Social Security number: ");
						in.next();
					}
					int social = in.nextInt();
					in.nextLine();
					((Employee) t).setSocial(social);


					//gets direct deposit from user and validates input
					out.print("\n Please enter Direct Deposit number: ");
					while (!in.hasNextInt()) {
						out.println("\n Error: Invalid Direct Deposit number");
						out.print("\n Please enter your Direct Deposit number: ");
						in.next();
					}
					int directDeposit = in.nextInt();
					in.nextLine();
					((Employee) t).setDirectDeposit(directDeposit);


					//gets Salary from user and validates inout
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

					//gets address from user
					out.print("\n Please enter address: ");
					String address = in.nextLine();
					((Customer) t).setAddress(address);

					//gets phone number from user
					out.print("\n Please enter phone number: ");
					String phone = in.nextLine();
					((Customer) t).setPhoneNumber(phone);
				}
			}
		}

		if (doesUserExist==false) {
			out.println(" \n User does not exist ");
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

			objectOUT.writeObject(listOfUsers);
			objectOUT.close();
		}
		catch (IOException e) {
			System.out.println("Error~ There is a problem writing to " + DB_FILE_NAME + ".");
		}

	}


}
