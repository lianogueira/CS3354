package shippingstore;


import java.util.Scanner;
import java.util.Date;
import java.text.*;
import static java.lang.System.out;


/**
 * Shipping Store <br><br>
 *
 * Program that simulates a shipping store database<br>
 * The database maintain records of the packages, users and completed transactions of a shipping store<br><br>
 *
 * <b>User options: </b><br>
 * 1 Show all existing package orders in the database<br>
 * 2 Add a new package order to the database<br>
 * 3 Delete a package order from a database<br>
 * 4 Search for a package order (given its Tracking #)<br>
 * 5 Show a list of users in the database<br>
 * 6 Add a new user to the database<br>
 * 7 Update user info(given their id)<br>
 * 8 Complete a shipping transaction.<br>
 * 9 Show completed shipping transactions<br>
 * 10 Exit program.<br>
 *
 * @author Tyler Hooks and Lia Nogueira de Moura
 * @version 10/02/2017
 */



public class MainApp {

    /**
     * This method will begin the user interface console. Main uses a loop to
     * continue doing commands until the user types '10'. A lot of user input
     * validation is done in the loop. At least enough to allow the interface
     * with PackageDatabase to be safe.
     *
     * @param args this program expects no command line arguments
     * @throws Exception (throws Exception)
     */
    public static void main(String[] args) throws Exception {


        Scanner in = new Scanner(System.in);
        PackageDatabase PackageDB = new PackageDatabase();
        UserDatabase userdatabase = new UserDatabase();
        CompletedTransactionsDatabase CompletedTransactionDB = new CompletedTransactionsDatabase();


        //Print Menu
        String welcomeMessage = "\nWelcome to the Shipping Store database. Choose one of the following functions:\n\n"
                + "\t1. Show all existing package orders in the database\n"
                + "\t2. Add a new package order to the database.\n"
                + "\t3. Delete a package order from a database.\n"
                + "\t4. Search for a package order (given its Tracking #).\n"
                + "\t5. Show a list of users in the database.\n"
                + "\t6. Add a new user to the database.\n"
                + "\t7. Update user info(given their id).\n"
                + "\t8. Complete a shipping transaction.\n"
                + "\t9. Show completed shipping transactions.\n"
                + "\t10. Exit program.\n";


        out.println(welcomeMessage);
        String selection = in.next();
        in.nextLine();


        while (selection.equals("10") == false) {

            //Use user input to decide next action
            switch (selection) {
                case "1":
                    PackageDB.showPackages();
                    break;
                case "2":

                    PackageDB.addNewPackageWithUserInput(CompletedTransactionDB);
                    break;
                case "3":
                    PackageDB.showPackages();
                    out.println("\n Please enter the tracking # of the package order to delete from the database: ");
                    String orderToDelete = in.nextLine();
                    PackageDB.removePackage(orderToDelete);
                    break;
                case "4":

                    out.println("\nEnter the Tracking # of the order you wish to see.\n");
                    String trackingNum = in.next();
                    in.nextLine();
                    PackageDB.searchPackage(trackingNum);
                    break;

                case "5":

                    userdatabase.displayUsers();
                    break;

                case "6":

                    out.print("\n Please enter a first name: ");
                    String first = in.nextLine();
                    out.print("\n Please enter a last name: ");
                    String last = in.nextLine();
                    userdatabase.addUser(first, last);
                    break;

                case "7":

                  System.out.println(" Please enter user ID: " );
                  int userID = in.nextInt();
                  userdatabase.updateUser(userID);
                  break;

                case "8":

                    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

                    //Get customerID type from user
                    out.print("\n Enter customer ID: ");
                    while (!in.hasNextInt()) {
                        out.println("\n Error: Invalid Customer ID");
                        out.print("\n Enter customer ID: ");
                        in.next();
                    }
                    Integer customerID=in.nextInt();
                    in.nextLine();
                    if (userdatabase.findUserType(customerID) == "unknown") {
                        out.print("\n Customer does not exists. Please create the customer first.");
                        break;
                    }
                    else if (userdatabase.findUserType(customerID) == "Employee") {
                        out.print("\n This User id is for an employee. Please enter the customer ID.");
                        break;
                    }


                    //Get tracking Number from user
                    out.print("\n Enter tracking Number:");
                    String trackingNumberInput = in.nextLine();
                    if (PackageDB.findPackage(trackingNumberInput) == -1) {
                        out.print("\n Tracking Number does not exists. Please create the package first.");
                        break;
                    }


                    //Get Shipping Date
                    Date shippingDate = new Date();
                    while (true)
                    {
                        out.print("\n Enter Shipping Date (format MM-dd-yyyy): ");
                        String str = in.nextLine();

                        try {
                            shippingDate = sdf.parse(str);
                        } catch (ParseException e) {
                            System.out.println("\n Not a valid date");
                            continue;
                        }
                        break;
                    }


                    //Get Delivery Date
                    Date deliveryDate = new Date();
                    while (true)
                    {
                        out.print("\n Enter Delivery Date (format MM-dd-yyyy): ");
                        String str = in.nextLine();

                        try {
                            deliveryDate = sdf.parse(str);
                        } catch (ParseException e) {
                            System.out.println("\n Not a valid date");
                            continue;
                        }
                        break;
                    }


                    //Get shippingCost from user and validates input
                    out.print("\n Enter Shipping Cost: ");
                    while (!in.hasNextFloat()) {
                        out.println("\n Error: Invalid Shipping Cost.");
                        out.print("\n Enter Shipping Cost: ");
                        in.next();
                    }
                    float cost=in.nextFloat();
                    in.nextLine();


                    //Get EmployeeID type from user
                    out.print("\n Enter Employee ID: ");
                    while (!in.hasNextInt()) {
                        out.println("\n Error: Invalid Employee ID");
                        out.print("\n Enter Employee ID: ");
                        in.next();
                    }
                    Integer employeeID=in.nextInt();
                    in.nextLine();
                    if (userdatabase.findUserType(employeeID) == "unknown") {
                        out.print("\n Employee does not exists. Please create the employee first.");
                        break;
                    }
                    else if (userdatabase.findUserType(employeeID) == "Customer") {
                        out.print("\n This User id is for a customer. Please enter an employee ID or create a new user.");
                        break;
                    }


                    //add new package with the information given by the user
                    CompletedTransactionDB.completeTransaction(customerID, trackingNumberInput, shippingDate, deliveryDate, cost, employeeID, PackageDB);

                    break;
                case "9":
                    CompletedTransactionDB.showTransactions();
                    break;
                case "h":
                    out.println(welcomeMessage);
                    break;
                default:
                    out.println("That is not a recognized command. Please enter another command or 'h' to list the commands.");
                    break;

            }

            out.println("\n\n Please enter another command or 'h' to list the commands.\n");
            selection = in.next();
            in.nextLine();
        }


        in.close();
        PackageDB.flush();
        userdatabase.flush();
        CompletedTransactionDB.flush();

        out.print("\n\n Thank you!");
        out.print("\n\n ** Implemented by Tyler Hooks and Lia Nogueira de Moura ** \n\n");


    }
}
