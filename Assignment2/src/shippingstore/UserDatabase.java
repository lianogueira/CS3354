package shippingstore;

import java.io.*;
import java.io.IOException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

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
	private Customer customer;

	public UserDatabase(){
		ListOfUsers = new ArrayList<>();
	}

	public void displayUsers() {

		for(UserList i : ListOfUsers) {
		if( i instanceof Employee) {
				System.out.println("EMPLOYEE");
				/*System.out.println(" ------------------------------------------------------------------------------------------------- ");
			    System.out.println("| First Name  | Last Name   | User ID    | Social Security #   |Direct Deposit|Salary |");
			    System.out.println(" ------------------------------------------------------------------------------------------------- ");*/
				//I wasn't sure if we wanted to add this or not, if so, I can come back and format it. I just wasn't sure what she was expecting

				System.out.println(String.format("| %-11s| %-11s| %-16s| %-17s| %-17s| %-14s|",
				    ((Employee)i).getFirstName(),
					((Employee)i).getLastName(),
					((Employee)i).getUserID(),
					((Employee)i).getSocial(),
					((Employee)i).getDirectDepoist(),
					((Employee)i).getSalary(),"EMPLOYEE", "/n"
					));


			} else if(i instanceof Customer) {
				System.out.println("CUSTOMER");
				System.out.format(String.format("| %-11s| %-11s| %-16s| %-17s| %-17s|",
						((Customer)i).getFirstName(),
						((Customer)i).getLastName(),
						((Customer)i).getUserID(),
						((Customer)i).getAddress(),
						((Customer)i).getPhoneNumber(),"CUSTOMER", "/n"
						));

			}else {
				System.out.println("There are currently no users to display.");
			}
		}

	}

	public void addUser(String first, String last) {

		char choice;
		boolean valid = false;

		System.out.println("Are you a customer or employe? Answer c for customer or e for employee");
		choice = in.next().charAt(0);
		in.nextLine();

		int id = (int)(Math.random());
		System.out.println("Your user ID is: "+ id);

		do {
		switch(choice) {
		case 'c':
		case 'C':
			System.out.println("Please enter address:");
			String address = in.nextLine();

			System.out.println("Please enter phone number:");
			String phone = in.nextLine();
		    ListOfUsers.add(new Customer(address, phone,id,first,last));
			System.out.println("User added.");
			valid = true;
			break;
		case 'e':
		case 'E':
			System.out.println("Please enter your Social Security number:");
			int social= in.nextInt();
			in.nextLine();
			/*if(social != 9) {
				System.out.println("Invalid Social Security number. Please renter.\n");
				System.out.println("Please enter your Social Security number:");
				social= in.nextInt();
				in.nextLine();
				}*/

			System.out.println("Please enter Direct Deposit number:");
			int directDeposit = in.nextInt();
			in.nextLine();

			System.out.println("Please enter Salary:");
			float salary = in.nextFloat();
			in.nextLine();

			ListOfUsers.add(new Employee(social, directDeposit,salary, id,first,last));
			System.out.println("User added.");
			valid = true;
			break;


		default:
			System.out.println("Invalid Option~ Unable to add user.");
			break;


		}

		}while(valid == false);

}

	public void updateUser(int userID){
		char choice;
		boolean index = true;
		for(int i = 0; i < ListOfUsers.size();i++) {
			UserList userUpdate = ListOfUsers.get(i);
			if(userID == userUpdate.getUserID()) {
			for(UserList t : ListOfUsers) {
					if(t instanceof Employee) {
						String first = userUpdate.getFirstName();
						String last = userUpdate.getLastName();
						System.out.println("Hello, " + first+" " + last);

						System.out.println("Please enter your Social Security number:");
						int social= in.nextInt();
						in.nextLine();
						userUpdate = ListOfUsers.get(ListOfUsers.indexOf(social));

						System.out.println("Please enter Direct Deposit number:");
						int directDeposit = in.nextInt();
						in.nextLine();

						System.out.println("Please enter Salary:");
						float salary = in.nextFloat();
						in.nextLine();


					}
					if(t instanceof Customer) {

						System.out.println("Please enter address:");
						String address = in.nextLine();

						System.out.println("Please enter phone number:");
						String phone = in.nextLine();
					}
				}

				}else {
				System.out.println("User not found.");
				}
			}

	}




}
