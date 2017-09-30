package shippingStoreAssignment1;

import java.util.Scanner;
import static java.lang.System.out;


/**
 * Shipping Store <br><br>
 *
 * Program that simulates a shipping store database<br>
 * The database maintain records of the packages that are in the storage room  <br><br>
 *
 * <b>User options: </b><br>
 * 1- Show all existing package records in the database (in any order).<br>
 * 2- Add new package record to the database.<br>
 * 3- Delete package record from a database.<br>
 * 4- Search for a package (given its tracking number).<br>
 * 5- Show a list of packages within a given weight range.<br>
 * 6- Exit program<br>
 *
 * @author Lia Nogueira de Moura
 * @version 09/19/2017
 */
public class ShippingStoreMain {

    public static void main(String[] args)
    {

        HandlePackage shippingStorePackages = new HandlePackage();
        Scanner sc = new Scanner(System.in);
        int inputOption;
        String trackingNumberInput;

        //Read file with existing package data
        shippingStorePackages.readPackagesFromFile();


        //Print Header
        out.println();
        out.println("| --------------------------  SHIPPING STORE ----------------------------------- |");
        out.println("| ------------------------------------------------------------------------------ |");
        out.println();


        do {

            //Print Menu
            out.println();
            out.println(" 1. Show all existing package records in the database (in any order).");
            out.println(" 2. Add new package record to the database.");
            out.println(" 3. Delete package record from a database.");
            out.println(" 4. Search for a package (given its tracking number).");
            out.println(" 5. Show a list of packages within a given weight range.");
            out.println(" 6. Exit program.");
            out.print("\n Enter option: ");

            //Menu Option user input validation
            while (!sc.hasNext("[123456]")) {
                out.println("\n Error: Invalid option. You choice must be a number between 1 and 6");
                out.print(" Enter option: ");
                sc.next();
            }

            //Get option choice from user when valid
            inputOption = sc.nextInt();
            sc.nextLine();


            //Use user input to decide next action
            switch (inputOption){


                case 1: //If Option 1, calls function to show all packages
                        shippingStorePackages.showListOfPackages("", -1f, -1f);
                        break;


                case 2: //If Option 2, gets user input for a new package and call function to add new package


                    //Get tracking Number from user and validates input
                    out.print("\n Enter tracking Number:");
                    trackingNumberInput=sc.nextLine();
                    while (trackingNumberInput.length() != 5) {
                        out.println("\n Error: Invalid tracking number. Tracking number must have 5 characters.");
                        out.print(" Enter tracking Number:");
                        trackingNumberInput=sc.nextLine();
                    }


                    //Get package type from user and validates input
                    out.print("\n Enter type (Options: 1-Postcard, 2-Envelope, 3-Packet, 4-Box, 5-Crate, 6-Drum, 7-Roll, 8-Tube): ");
                    while (!sc.hasNext("[12345678]")) {
                        out.println("\n Error: Invalid type. Type must be a number between 1 and 8");
                        out.print(" Enter type (Options: 1-Postcard, 2-Envelope, 3-Packet, 4-Box, 5-Crate, 6-Drum, 7-Roll, 8-Tube): ");
                        sc.next();
                    }
                    Integer typeInput=sc.nextInt();
                    sc.nextLine();


                    //Get specification from user and validates input
                    out.print("\n Enter specification (Options: 1-Fragile, 2-Books, 3-Catalogs, 4-Do-not-Bend, 5-N/A): ");
                    while (!sc.hasNext("[12345]")) {
                        out.println("\n Error: Invalid specification. Specification must be a number between 1 and 5");
                        out.print(" Enter specification (Options: 1-Fragile, 2-Books, 3-Catalogs, 4-Do-not-Bend, 5-N/A): ");
                        sc.next();
                    }
                    Integer specificationInput=sc.nextInt();
                    sc.nextLine();


                    //Get Mailing Class from user and validates input
                    out.print("\n Enter Mailing Class (Options: 1-First-Class, 2-Priority, 3-Retail, 4-Ground, 5-Metro): ");
                    while (!sc.hasNext("[12345]")) {
                        out.println("\n Error: Invalid Mailing Class. Mailing Class must be a number between 1 and 5");
                        out.print(" Enter specification (Options: 1-Fragile, 2-Books, 3-Catalogs, 4-Do-not-Bend, 5-N/A): ");
                        sc.next();
                    }
                    Integer mailingClassInput=sc.nextInt();
                    sc.nextLine();


                    //Get weight from user and validates input
                    out.print("\n Enter Weight: ");
                    while (!sc.hasNextFloat()) {
                        out.println("\n Error: Invalid weight.");
                        out.print(" Enter Weight: ");
                        sc.next();
                    }
                    Float weightInput=sc.nextFloat();
                    sc.nextLine();


                    //Get Volume from user and validates input
                    out.print("\n Enter Volume: ");
                    while (!sc.hasNextInt()) {
                        out.println("\n Error: Invalid volume.");
                        out.print(" Enter Volume: ");
                        sc.next();
                    }
                    Integer volumeInput=sc.nextInt();


                    //add new package with the information given by the user
                    shippingStorePackages.addToPackage(trackingNumberInput, typeInput, specificationInput, mailingClassInput, weightInput, volumeInput );

                    break;


                case 3: //If option 3, get tracking number from user and call function to delete package

                    out.print(" Enter tracking Number to Delete: ");
                    trackingNumberInput=sc.nextLine();
                    shippingStorePackages.deletePackage(trackingNumberInput);

                    break;


                case 4: //If option 4, get tracking number from user and call function to search package

                    out.print(" Enter tracking Number: ");
                    trackingNumberInput=sc.nextLine();

                    //show packages with given tracking number
                    shippingStorePackages.showListOfPackages(trackingNumberInput, -1f,-1f);

                    break;


                case 5: //If option 5, get weight range from user and call function to search package


                    //Get minimum weight from user
                    out.print(" Enter minimum weight: ");
                    while (!sc.hasNextFloat()) { //Minimum weight Input validation
                        out.println("\n Error: Invalid weight.");
                        out.print(" Enter minimum weight: ");
                        sc.next();
                    }
                    Float minWeight=sc.nextFloat();


                    //Get maximum weight from user
                    out.print("\n Enter maximum weight: ");
                    while (!sc.hasNextFloat()) { //Maximum weight Input validation
                        out.println("\n Error: Invalid weight.");
                        out.print(" Enter maximum weight: ");
                        sc.next();
                    }
                    Float maxWeight=sc.nextFloat();

                    //Show packages within given weight range
                    shippingStorePackages.showListOfPackages("", minWeight, maxWeight);

                    break;


                case 6: //If option 6, calls function to save data in file
                    shippingStorePackages.savePackagesToFile();
                    out.print("\n\n Thank you!");
                    out.print("\n\n ** Implemented by Lia Nogueira de Moura ** \n\n");
                    break;
            }

        } while (inputOption != 6); //exits the program if user chooses option 6

    }
}

