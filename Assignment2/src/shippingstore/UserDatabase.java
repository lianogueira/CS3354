package shippingstore;
import java.io.*;
import java.io.IOException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

public class UserDatabase implements Serializable {

	Scanner in = new Scanner(System.in);
	private ArrayList<UserList> ListOfUsers;


	public void displayUsers(/*ArrayList<UserList> users*/) {
		for(UserList i : ListOfUsers) {
			if( i instanceof Employee) {

				   System.out.format("|%1$-15s| %2$-15s| %3$-15s| %4$-15s|%5-15s|,%6-15s|",
				    (((Employee)i).getFirstName()),
					((Employee)i).getLastName(),
					((Employee)i).getUserID(),
					((Employee)i).getSocial(),
					((Employee)i).getDirectDepoist(),
					((Employee)i).getSalary());


			} else if(i instanceof Customer) {
				System.out.format("|%1$-15s| %2$-15s| %3$-15s| %4$-15s|%5-15s|",
						((Customer)i).getFirstName(),
						((Customer)i).getLastName(),
						((Customer)i).getUserID(),
						((Customer)i).getAddress(),
						((Customer)i).getPhoneNumber());

			}else {
				System.out.println("There are currently no users to display.");
			}
		}

	}

	public void addUser(String first, String last) {

		char choice;

		System.out.println("Are you a customer or employe? Answer c for customer or e for employee");
		choice = in.next().charAt(0);
		in.nextLine();

		int id = (int)(Math.random());
		System.out.println("Your user ID is: "+ id);

		switch(choice) {
		case 'c':
		case 'C':
			System.out.println("Please enter address:");
			String address = in.nextLine();

			System.out.println("Please enter phone number:");
			String phone = in.nextLine();
			ListOfUsers.add(new Customer(address, phone,id,first,last));
			System.out.println("User added.");
			break;
		case 'e':
		case 'E':
			System.out.println("Please enter your Social Security number:");
			int social= in.nextInt();
			in.nextLine();

			System.out.println("Please enter Direct Deposit number:");
			int directDeposit = in.nextInt();
			in.nextLine();

			System.out.println("Please enter Salary:");
			float salary = in.nextFloat();
			in.nextLine();

			ListOfUsers.add(new Employee(social, directDeposit,salary, id,first,last));
			System.out.println("User added.");
			break;
		default:
			System.out.println("Invalid Option~ Unable to add user.");


		}

}

	public void updateUser() {

	}


}
