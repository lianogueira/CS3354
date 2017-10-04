package shippingstore;

import java.io.*;
import java.util.*;
import static java.lang.System.out;

/**
 * Handles a list of objects of the type package <br><br>
 * <b>Functionalities:</b> <br>
 * Read list of packages from File,<br>
 * Save list of packages in File,<br>
 * Add package to list,<br>
 * Delete package from list,<br>
 * Display all packages,<br>
 * Search for a package based on tracking number
 *
 * @author Tyler Hooks and Lia Nogueira de Moura
 * @version 10/02/2017
 */

public class PackageDatabase implements Serializable {


    //array list to hold the list of packages
    private ArrayList<Package> packageList = new ArrayList<Package>();
    //File Name Constant
    private final String DB_FILE_NAME = "PackageDB.txt";


    /**
     * Displays list of packages <br><br>
     *
     * If no tracking number is passed as parameter, method will display all packages. <br><br>
     *
     * @param trackingNumber if not empty will be used to show only the package that matches this trackingnumber
     */
    private void showPackages(String trackingNumber) {


        //If its a search by tracking number, prints message accordingly
        if (trackingNumber != "") {
            out.println();
            out.println("Tracking Number = " + trackingNumber + "  - Search Results: ");
        }


        //Prints header
        out.println(" ---------------------------------------------------------------------------------------------------------------------- ");
        out.println("| Tracking # | Type    | Specification    | Class         | Custom 1                  | Custom 2                      |");
        out.println(" ---------------------------------------------------------------------------------------------------------------------- ");


        //loops through list of packages
        for (Package i : packageList) {
            if (trackingNumber.equals(i.getTrackingNumber()) || trackingNumber.equals("")) {
                //Prints package
                i.print("| %-11s| %-8s| %-17s| %-14s| %-26s| %-30s|");
            }
        }

        out.println(" ---------------------------------------------------------------------------------------------------------------------- \n");

    }

    /**
     * Reads file and saves data into the list of packages. (File name = variable DB_FILE_NAME) <br><br>
     * <b>Assumptions:</b> file will contain data in the correct format <br><br>
     * Serialization of "packageList" object
     * @throws Exception (throws Exception)
     **/
    private void readPackagesFromFile() throws Exception {
        try {
            FileInputStream fileIN = new FileInputStream(DB_FILE_NAME);
            ObjectInputStream objectinputstream = new ObjectInputStream(fileIN);
            packageList = (ArrayList<Package>) objectinputstream.readObject();
        }catch (FileNotFoundException e) {
            FileOutputStream oFile = new FileOutputStream(DB_FILE_NAME, false);
        } catch (IOException e) {
            System.out.println("Error~ There is a problem with file input from " + DB_FILE_NAME + ".");
        }
    }


    /**
     * Uses list of packages Array to write into file. (File name = variable DB_FILE_NAME) <br><br>
     * Serialization of "packageList" object
     * @throws Exception (throws Exception)
     **/
    private void writePackagesToFile() throws Exception{
        try {
            FileOutputStream fileOUT = new FileOutputStream(DB_FILE_NAME);
            ObjectOutputStream objectOUT = new ObjectOutputStream(fileOUT);

            objectOUT.writeObject(packageList);
            objectOUT.close();
        }
        catch (IOException e) {
            System.out.println("Error~ There is a problem writing to " + DB_FILE_NAME + ".");

        }
    }



    /**
     * This constructor calls function "readPackagesFromFile" to initialize the ArrayList with the data from the the file
     * @throws Exception (throws Exception)
     */
    public PackageDatabase() throws Exception {

        this.readPackagesFromFile();

    }


    /**
     * Displays list of all packages <br><br>
     */
    public void showPackages() {
        showPackages("");
    }


    /**
     * This method can be used to search for a package in the Arraylist of packages.
     *
     * @param trackingNumber a <CODE>String</CODE> that represents the tracking number
     * of the package that to be searched for.
     */
    public void searchPackage(String trackingNumber) {
        showPackages(trackingNumber);
    }



    /**
     * This method can be used to find a package in the Arraylist of packages.
     *
     * @param trackingNumber a <CODE>String</CODE> that represents the tracking number
     * of the package that to be searched for.
     * @return the <CODE>int</CODE> index of the package in the Arraylist of packages,
     * or -1 if the search failed.
     */
    public int findPackage(String trackingNumber) {

        int index = -1;

        for (int i = 0; i < packageList.size(); i++) {
            String temp = packageList.get(i).getTrackingNumber();

            if (trackingNumber.equalsIgnoreCase(temp)) {
                index = i;
                break;
            }
        }
        return index;
    }


    /**
     * Adds new package to the list. Accepts parameters for the content of the package<br><br>
     *
     * @param trackingNumberInput  Tracking Number of the new package.
     * @param typeInput Type code of the new package. Valid Options: [1-4]
     * @param specificationInput Specification Code of the new package. Valid Options: [1-5]
     * @param mailingClassInput Mailing Class Code of the new package. Valid Options: [1-5]
     * @param heightInput Height of the new package in oz - (Only if package type is Envelope)
     * @param widthInput Width of the new package - (Only if package type is Envelope)
     * @param largestDimensionInput Largest Dimension of the new package - (Only if package type is Box)
     * @param volumeInput Volume of the new package - (Only if package type is Box)
     * @param maxWeightInput Maximum Weight of the new package - (Only if package type is Crate)
     * @param contentInput Content of the new package - (Only if package type is Crate)
     * @param materialInput Material of the new package - (Only if package type is Drum)
     * @param diameterInput Diameter of the new package - (Only if package type is Drum)
     */
    public void addPackage(String trackingNumberInput, Integer typeInput, Integer specificationInput, Integer mailingClassInput,
                           Integer heightInput, Integer widthInput,
                           Integer largestDimensionInput, Integer volumeInput,
                           Float maxWeightInput, String contentInput,
                           Integer materialInput, Integer diameterInput) {


        //Quit if package already in database
        if (this.findPackage(trackingNumberInput) != -1) {
            System.out.println("\n Package already exists in database. Unable to add user");
            return;
        }

        //Quit if any of the amounts are negative
        if (maxWeightInput < 0) {System.out.println(" The maximum weight of package cannot be negative.");return;}
        if (heightInput < 0) {out.print(" The height cannot be negative"); return; };
        if (widthInput < 0) {out.print(" The width cannot be negative"); return; };
        if (largestDimensionInput < 0) {out.print(" The dimension cannot be negative"); return; };
        if (volumeInput < 0) {out.print(" The volume cannot be negative"); return; };
        if (maxWeightInput < 0) {out.print(" The weight cannot be negative"); return; };
        if (diameterInput < 0) {out.print(" The diameter cannot be negative"); return; };


        String type="";
        String specification="";
        String mailingClass="";
        String material="";

        //Translate type code
        switch (typeInput){
            case 1: type="Envelope"; break;
            case 2: type="Box"; break;
            case 3: type="Crate"; break;
            case 4: type="Drum"; break;
        }

        //Translate specification code
        switch (specificationInput){
            case 1: specification="Fragile"; break;
            case 2: specification="Books"; break;
            case 3: specification="Catalogs"; break;
            case 4: specification="Do-not-Bend"; break;
            case 5: specification="N/A"; break;
        }

        //Translate mailingClass code
        switch (mailingClassInput){
            case 1: mailingClass="First-Class"; break;
            case 2: mailingClass="Priority"; break;
            case 3: mailingClass="Retail"; break;
            case 4: mailingClass="Ground"; break;
            case 5: mailingClass="Metro"; break;
        }

        //Translate mailingClass code
        switch (materialInput){
            case 1: material="Plastic"; break;
            case 2: material="Fiber"; break;
        }



        if (type.equals("Envelope")){
            //If package type is "Envelope", create a new PackageEnvelope
            packageList.add(new PackageEnvelope(trackingNumberInput,type,specification,mailingClass, heightInput, widthInput));
        }
        else if (type.equals("Box")){
            //If package type is "Box", create a new PackageBox
            packageList.add(new PackageBox(trackingNumberInput,type,specification,mailingClass, largestDimensionInput, volumeInput));
        }
        else if (type.equals("Crate")){
            //If package type is "Crate", create a new PackageCrate
            packageList.add(new PackageCrate(trackingNumberInput,type,specification,mailingClass, maxWeightInput, contentInput));
        }
        else if (type.equals("Drum")){
            //If package type is "Drum", create a new PackageDrum
            packageList.add(new PackageDrum(trackingNumberInput,type,specification,mailingClass, material, diameterInput));
        }
        else {
            //If passed all the checks, add the package to the list
            packageList.add(new Package(trackingNumberInput, type, specification, mailingClass));
            System.out.println("Package has been added.\n");
        }


        //sort arrayList by tracking number
        Collections.sort(packageList);

    }


    /**
     * Remove a package from the <CODE>packageList</CODE> ArrayList. <br>
     * It will remove the instance of a package that matches tracking number that was
     * passed to this method. If no such package exists, it will produce an error message.
     *
     * @param trackingNum the <CODE>Package</CODE> object to be removed.
     */
    public void removePackage(String trackingNum) {
        int packageID = findPackage(trackingNum);
        if (packageID == -1) {
            System.out.println("\n Action failed. No package with the given tracking # exist in database.\n");
        }
        else {
            packageList.remove(packageID);
        }
    }



    /**
     * Gets user input and creates a new package <br>
     *
     */
    public void addNewPackageWithUserInput(CompletedTransactionsDatabase cTransaction){

        Scanner in = new Scanner(System.in);
        Integer height= 0;
        Integer width=0;
        Integer largestDimension=0;
        Integer volume=0;
        float maxWeight=0f;
        String content="";
        Integer material=0;
        Integer diameter=0;


        //Get package type from user and validates input
        out.print("\n Enter type (Options: 1-Envelope, 2-Box, 3-Crate, 4-Drum): ");
        while (!in.hasNext("[1234]")) {
            out.println("\n Error: Invalid type. Type must be a number between 1 and 4");
            out.print(" Enter type (Options: 1-Envelope, 2-Box, 3-Crate, 4-Drum): ");
            in.next();
        }
        Integer typeInput=in.nextInt();
        in.nextLine();


        //Get tracking Number from user and validates input
        out.print("\n Enter tracking Number:");
        String trackingNumberInput=in.nextLine();
        while (trackingNumberInput.length() != 5 || cTransaction.findPackage(trackingNumberInput) != -1) {
            if (trackingNumberInput.length() != 5)
                out.println("\n Error: Invalid tracking number. Tracking number must have 5 characters.");
            else
                out.println("\n Package already exists in the completed transactions database");
            out.print(" Enter tracking Number:");
            trackingNumberInput=in.nextLine();
        }


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

        }


        //add new package with the information given by the user
        this.addPackage(trackingNumberInput, typeInput, specificationInput, mailingClassInput,
                height, width,largestDimension,volume, maxWeight,content,material,diameter);


    }


    /**
     * This method calls writePackagesToFile function to write the data into file
     * @throws Exception (throws Exception)
     */
    public void flush() throws Exception {
        this.writePackagesToFile();
    }


}
