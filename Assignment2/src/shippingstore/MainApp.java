package shippingstore;

import java.util.InputMismatchException;
import java.util.Scanner;

//import cs3354.assignment1.Package;

import java.io.*; 

/**
 * This is the main class of the ShippingStore database manager. It provides a
 * console for a user to use the 5 main commands.
 *
 * @author Junye Wen
 */
public class MainApp {

    /**
     * This method will begin the user interface console. Main uses a loop to
     * continue doing commands until the user types '6'. A lot of user input
     * validation is done in the loop. At least enough to allow the interface
     * with ShippingStore to be safe.
     *
     * @param args this program expects no command line arguments
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
    	
   	 	ShippingStore pack = new ShippingStore(); 
   	 	final String FILE_NAME = "packages.txt";
		 /**
        Create a new input file instance, a new input object instance,
        and attempt to read in an object from the file. If it fails simply
        create a new "Package" object to store items to.
		 */
			try {
	            FileInputStream fileIN = new FileInputStream(FILE_NAME);
	            ObjectInputStream objectIN= new ObjectInputStream(fileIN);
	            pack = (ShippingStore) objectIN.readObject();
	            fileIN.close();

	        } catch (FileNotFoundException e) {

	        } catch (IOException e) {
	            System.out.println("Error~ There is a problem with file input from "
	            + FILE_NAME + ".");
	        } catch (ClassNotFoundException e) {
	            System.out.println("Error~ Class not found on input from file named"
	                    + FILE_NAME + ".");
	        }
    	
        Scanner in = new Scanner(System.in);

        ShippingStore shippingstore = new ShippingStore();
        UserDatabase userdatabase = new UserDatabase(); 

        String welcomeMessage = "\nWelcome to the Shipping Store database. Choose one of the following functions:\n\n"
                + "\t1. Show all existing package orders in the database\n"
                + "\t2. Add a new package order to the database.\n"
                + "\t3. Delete a package order from a database.\n"
                + "\t4. Search for a package order (given its Tracking #).\n"
                + "\t5. Show a list of users in the database.\n"
                + "\t6. Add a new user to the database.\n"
                + "\t7. Update user info(given their id).\n"
                + "\t8. Complete a shipping transaction.\n"
                + "\t9. Show completed shpping transactions.\n"
                + "\te. Exit program.\n";


        System.out.println(welcomeMessage);

        int selection = in.next().charAt(0); 
        in.nextLine();

        while (selection != 'e') {

            switch (selection) {
                case '1':
                    shippingstore.showPackageOrders();
                    break;
                case '2':
                    System.out.println("\nPlease type description of package with the following pattern:\n"
                            + "\n TRACKING #  TYPE   SPECIFICATION   CLASS   WEIGHT   VOLUME\n"
                            + "example:\nGFR23 Box Books Retail 9500.00 45\n");
                    String inTemp = in.nextLine();

                    String temp[] = inTemp.split(" ");

                    if (temp.length != 6) {
                        System.out.println("Not correct number of fields to process.");
                        break;
                    }

                    shippingstore.addOrder(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
                    break;
                case '3':
                    shippingstore.showPackageOrders();

                    System.out.println("\nPlease enter the tracking # of the package order to delete from the database.\n");
                    String orderToDelete = in.nextLine();
                    shippingstore.removeOrder(orderToDelete);
                    break;
                case '4':
                    System.out.println("\nEnter the Tracking # of the order you wish to see.\n");
                    String trackingNum = in.next();
                    in.nextLine();
                    shippingstore.searchPackageOrder(trackingNum);
                    break;
                   
                case '5':	
                	userdatabase.displayUsers();
                    break;
                case '6':
                	System.out.println("\n Please enter a first name.\n");
                	String first = in.nextLine(); 
                	System.out.println("\n Please enter a last name.\n");
                	String last = in.nextLine(); 
                	userdatabase.addUser(first, last);
                	break;
                case '7':
                    break;
                case '8':
                    break;
                case '9':
                    break;
                case 'h':
                    System.out.println(welcomeMessage);
                    break;
                default:
                    System.out.println("That is not a recognized command. Please enter another command or 'h' to list the commands.");
                    break;

            }

            System.out.println("Please enter another command or 'h' to list the commands.\n");
            selection = in.next().charAt(0);

            in.nextLine();
        }

        in.close();
        shippingstore.flush();
        
        System.out.println("Done!");
        
        /**
        Create a new output file instance, a new output object instance,
        and attempt to write an object to the file. If it fails simply
        create a new "Package" object to store items to.
		*/	
		
			try {
            FileOutputStream fileOUT = new FileOutputStream(FILE_NAME);
            ObjectOutputStream objectOUT = new ObjectOutputStream(fileOUT);
            objectOUT.writeObject(pack);
            fileOUT.close();
			}catch (IOException e) {
           System.out.println("Error~ There is a problem writing to "
                    + FILE_NAME + ".");
				
                  
        }

    }
  }

