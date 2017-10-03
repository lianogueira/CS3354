package shippingstore;
import java.io.*;
import java.io.IOException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.Serializable;

public class UserDatabase implements Serializable {

	Scanner in = new Scanner(System.in);
	private ArrayList<UserList> ListOfUsers;
	private Customer customer;

	public UserDatabase(){
		ListOfUsers = new ArrayList<>();
	}

	public void displayUsers(/*ArrayList<UserList> users*/) {
		for(UserList i : ListOfUsers) {
			if( i instanceof Employee) {

				   System.out.println(
				    (((Employee)i).getFirstName()+
					((Employee)i).getLastName()+
					((Employee)i).getUserID()+
					((Employee)i).getSocial()+
					((Employee)i).getDirectDepoist()+
					((Employee)i).getSalary()));


			} else if(i instanceof Customer) {
				//System.out.format("|%1$-15s| %2$-15s| %3$-15s| %4$-15s|%5-15s|",
				System.out.println(
						((Customer)i).getFirstName()+
						((Customer)i).getLastName()+
						((Customer)i).getUserID()+
						((Customer)i).getAddress()+
						((Customer)i).getPhoneNumber());

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
