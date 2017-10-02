package shippingstore;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.io.*;

import static java.lang.System.out;

/**
 * This is the main class of the PackageDatabase database manager. It provides a
 * console for a user to use the 5 main commands.
 *
 * @author Junye Wen
 */
public class MainApp {

    /**
     * This method will begin the user interface console. Main uses a loop to
     * continue doing commands until the user types '6'. A lot of user input
     * validation is done in the loop. At least enough to allow the interface
     * with PackageDatabase to be safe.
     *
     * @param args this program expects no command line arguments
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {


        Scanner in = new Scanner(System.in);
        PackageDatabase PackageDB = new PackageDatabase();
        UserDatabase userdatabase = new UserDatabase();
        CompletedTransactionsDatabase CompletedTransactionDB = new CompletedTransactionsDatabase();

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


        System.out.println(welcomeMessage);

        String selection = in.next();
        in.nextLine();


        while (selection.equals("10") == false) {

            switch (selection) {
                case "1":
                    PackageDB.showPackages();
                    break;

                case "2":

                    //Get tracking Number from user and validates input
                    out.print("\n Enter tracking Number:");
                    String trackingNumberInput=in.nextLine();
                    while (trackingNumberInput.length() != 5) {
                        out.println("\n Error: Invalid tracking number. Tracking number must have 5 characters.");
                        out.print(" Enter tracking Number:");
                        trackingNumberInput=in.nextLine();
                    }

                    //Get package type from user and validates input
                    out.print("\n Enter type (Options: 1-Envelope, 2-Box, 3-Crate, 4-Drum): ");
                    while (!in.hasNext("[1234]")) {
                        out.println("\n Error: Invalid type. Type must be a number between 1 and 4");
                        out.print(" Enter type (Options: 1-Postcard, 2-Envelope, 3-Packet, 4-Box, 5-Crate, 6-Drum, 7-Roll, 8-Tube): ");
                        in.next();
                    }
                    Integer typeInput=in.nextInt();
                    in.nextLine();


                    //Get specification from user and validates input
                    out.print("\n Enter specification (Options: 1-Fragile, 2-Books, 3-Catalogs, 4-Do-not-Bend, 5-N/A): ");
                    while (!in.hasNext("[12345]")) {
                        out.println("\n Error: Invalid specification. Specification must be a number between 1 and 5");
                        out.print(" Enter specification (Options: 1-Fragile, 2-Books, 3-Catalogs, 4-Do-not-Bend, 5-N/A): ");
                        in.next();
                    }
                    Integer specificationInput=in.nextInt();
                    in.nextLine();


                    //Get Mailing Class from user and validates input
                    out.print("\n Enter Mailing Class (Options: 1-First-Class, 2-Priority, 3-Retail, 4-Ground, 5-Metro): ");
                    while (!in.hasNext("[12345]")) {
                        out.println("\n Error: Invalid Mailing Class. Mailing Class must be a number between 1 and 5");
                        out.print(" Enter specification (Options: 1-Fragile, 2-Books, 3-Catalogs, 4-Do-not-Bend, 5-N/A): ");
                        in.next();
                    }
                    Integer mailingClassInput=in.nextInt();
                    in.nextLine();



                    Integer height= 0;
                    Integer width=0;
                    Integer largestDimension=0;
                    Integer volume=0;
                    float maxWeight=0f;
                    String content="";
                    Integer material=0;
                    Integer diameter=0;


                    switch (typeInput){
                        case 1: //Envelope

                            //Get Height from user and validates input
                            out.print("\n Enter Height: ");
                            while (!in.hasNextInt()) {
                                out.println("\n Error: Invalid height.");
                                out.print(" Enter Height: ");
                                in.next();
                            }
                            height=in.nextInt();


                            //Get Width from user and validates input
                            out.print("\n Enter Width: ");
                            while (!in.hasNextInt()) {
                                out.println("\n Error: Invalid Width.");
                                out.print(" Enter Width: ");
                                in.next();
                            }
                            width=in.nextInt();

                            break;

                        case 2: //Box

                            //Get Height from user and validates input
                            out.print("\n Enter Largest dimension: ");
                            while (!in.hasNextInt()) {
                                out.println("\n Error: Invalid dimension.");
                                out.print(" Enter Largest dimension: ");
                                in.next();
                            }
                            largestDimension=in.nextInt();

                            //Get Volume from user and validates input
                            out.print("\n Enter Volume: ");
                            while (!in.hasNextInt()) {
                                out.println("\n Error: Invalid volume.");
                                out.print(" Enter Volume: ");
                                in.next();
                            }
                            volume=in.nextInt();

                            break;

                        case 3: //Crate

                            //Get weight from user and validates input
                            out.print("\n Enter Maximum Load Weight: ");
                            while (!in.hasNextFloat()) {
                                out.println("\n Error: Invalid weight.");
                                out.print(" Enter Maximum Load Weight: ");
                                in.next();
                            }
                            maxWeight=in.nextFloat();
                            in.nextLine();


                            //Get content from user
                            out.print("\n Enter content:");
                            content=in.nextLine();
                            break;

                        case 4: //Drum

                            //Get material type from user and validates input
                            out.print("\n Enter type (Options: 1-Plastic, 2-Fiber): ");
                            while (!in.hasNext("[12]")) {
                                out.println("\n Error: Invalid type. Type must be a number between 1 and 2");
                                out.print(" Enter type (Options: 1-Plastic, 2-Fiber): ");
                                in.next();
                            }
                            material=in.nextInt();
                            in.nextLine();


                            //Get diameter from user and validates input
                            out.print("\n Enter Diameter: ");
                            while (!in.hasNextInt()) {
                                out.println("\n Error: Invalid Diameter.");
                                out.print(" Enter Diameter: ");
                                in.next();
                            }
                            diameter=in.nextInt();
                            break;

                        } //End switch type of package


                    //add new package with the information given by the user
                    PackageDB.addOrder(trackingNumberInput, typeInput, specificationInput, mailingClassInput,
                                             height, width,largestDimension,volume, maxWeight,content,material,diameter);


                    break;

                case "3":
                    PackageDB.showPackages();

                    out.println("\nPlease enter the tracking # of the package order to delete from the database.\n");
                    String orderToDelete = in.nextLine();
                    PackageDB.removeOrder(orderToDelete);
                    break;
                case "4":
                    out.println("\nEnter the Tracking # of the order you wish to see.\n");
                    String trackingNum = in.next();
                    in.nextLine();
                    PackageDB.searchPackage(trackingNum);
                    break;

                case "5":

                    //userdatabase.displayUsers();
                    break;
                case "6":
                    out.println("\n Please enter a first name.\n");
                    String first = in.nextLine();
                    out.println("\n Please enter a last name.\n");
                    String last = in.nextLine();
                    //userdatabase.addUser(first, last);
                    break;
                case "7":
                    break;
                case "8":

                    //Get customerID type from user
                    out.print("\n Enter customer ID: ");
                    Integer customerID=in.nextInt();
                    in.nextLine();

                    //Get tracking Number from user
                    out.print("\n Enter tracking Number:");
                    trackingNumberInput=in.nextLine();

                    //Get Shipping Date from user
                    out.print("\n Enter Shipping Date: ");
                    String shippingDate=in.next();
                    in.nextLine();

                    //Get delivery Date from user
                    out.print("\n Enter delivery Date: ");
                    String delivery=in.next();
                    in.nextLine();

                    //Get shippingCost from user and validates input
                    out.print("\n Enter Shipping Cost: ");
                    while (!in.hasNextFloat()) {
                        out.println("\n Error: Shipping Cost.");
                        out.print(" Enter Shipping Cost: ");
                        in.next();
                    }
                    float cost=in.nextFloat();
                    in.nextLine();


                    //Get employeeID type from user
                    out.print("\n Enter employee ID: ");
                    Integer employeeID=in.nextInt();
                    in.nextLine();


                    //add new package with the information given by the user
                    CompletedTransactionDB.completeTransaction(customerID, trackingNumberInput,shippingDate, delivery, cost, employeeID, PackageDB);

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

            out.println("\nPlease enter another command or 'h' to list the commands.\n");
            selection = in.next();
            in.nextLine();
        }


        in.close();
        PackageDB.flush();
        CompletedTransactionDB.flush();

        out.print("\n\n Thank you!");
        out.print("\n\n ** Implemented by Tyler Hooks and Lia Nogueira de Moura ** \n\n");


    }
}

