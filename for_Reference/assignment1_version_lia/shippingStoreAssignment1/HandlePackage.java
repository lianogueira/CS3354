package shippingStoreAssignment1;

import java.util.ArrayList;
import java.io.*;
import static java.lang.System.out;


/**
 * Handles a list of objects of the type package <br><br>
 * <b>Functionalities:</b> <br>
 * Read list of packages from File,<br>
 * Save list of packages in File,<br>
 * Add package to list,<br>
 * Delete package from list,<br>
 * Display all packages,<br>
 * Search for a package based on tracking number or weight range
 *
 * @author Lia Nogueira de Moura
 * @version 09/19/2017
 */

public class HandlePackage {


    /** Default constructor of a HandlePackage object */
    public HandlePackage(){
    }


    /**
     * Reads file called "packages.txt" and saves data into the list of packages <br><br>
     *
     * <b>Assumptions:</b> file "packages.txt" will contain data in the correct format <br><br>
     *
     * <b>"packages.txt" format:</b><br>
     * each line will contain one package <br>
     * each word will be separated by a space <br>
     *  _  word1=Tracking Number <br>
     *  _  word2=Type  -- (Options: Postcard, Envelope, Packet, Box, Crate, Drum, Roll, Tube) <br>
     *  _  word3=Specification  -- (Options: Fragile, Books, Catalogs, Do-not-Bend, N/A) <br>
     *  _  word4=Class  -- (Options: Fragile, Books, Catalogs, Do-not-Bend, N/A) <br>
     *  _  word5=Weight -- (Must be a float) <br>
     *  _  word6=Volume -- (Must be an integer)*/

    public void readPackagesFromFile() {

        try {

            //Get content of file packages.txt
            FileInputStream fstream = new FileInputStream("packages.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String line;

            //Read File Line By Line
            while ((line = br.readLine()) != null) {

                //Separates the words in each line of the file
                String[] words = line.split(" ");

                //adds new package with the data found in one line of the file
                Package newPackage = new Package(words[0], words[1], words[2], words[3], Float.parseFloat(words[4]), Integer.parseInt(words[5]));
                listOfPackages.add(newPackage);
            }

            br.close();

        } catch (Exception ex) {

        }

    }


    /**
     * Saves list of packages into  "packages.txt" file <br><br>
     *
     * <b>"packages.txt" format: </b> <br>
     *  each line will contain one package <br>
     *  each word will be separated by a space <br>
     *  _  word1=Tracking Number <br>
     *  _  word2=Type  -- (Options: Postcard, Envelope, Packet, Box, Crate, Drum, Roll, Tube) <br>
     *  _  word3=Specification  -- (Options: Fragile, Books, Catalogs, Do-not-Bend, N/A) <br>
     *  _  word4=Class  -- (Options: Fragile, Books, Catalogs, Do-not-Bend, N/A) <br>
     *  _  word5=Weight -- (Must be a float) <br>
     *  _  word6=Volume -- (Must be an integer)
     */
    public void savePackagesToFile()  {

        try {

            //Open File writer for packages.txt file
            FileWriter fw = new FileWriter("packages.txt", false);
            PrintWriter outFile = new PrintWriter(fw);

            //loops through list of packages and saves each package in a line
            for (Package i : listOfPackages) {

                outFile.println(i.getTrackingNumber() + " " +
                                i.getType() + " " +
                                i.getSpecification() + " " +
                                i.getMailingClass() + " " +
                                Float.toString(i.getWeight()) + " " +
                                Integer.toString(i.getVolume()));
            }

            //close file
            outFile.flush();
            outFile.close();

        } catch (Exception ex) {

        }

    }

    /**
     * Displays list of packages <br><br>
     *
     * If no tracking number or weight range is passed as parameter, method will display all packages. <br><br>
     *
     * @param trackingNumber  If a tracking number is passed, the function will only display packages with the correspondent tracking number.
     * @param weightMin  Only display packages with weight larger or equal to this value. <br>  Parameter is considered empty when equal to -1f. Parameter must be used together with weightMax.
     * @param weightMax Only display packages with weight smaller or equal to this value. <br>  Parameter is considered empty when equal to -1f. Parameter must be used together with weightMin.
     *
     */
    public void showListOfPackages(String trackingNumber, Float weightMin, Float weightMax){


        //If its a search by tracking number, prints message accordingly
        if (trackingNumber != "") {
            out.println();
            out.println("Tracking Number = " + trackingNumber + "  - Search Results: ");
        }
        //If its a search by weight range, prints message accordingly
        else if (weightMin != -1f && weightMax !=-1f ) {
            out.println();
            out.println("Weight between " + weightMin + " " + weightMax +  "  - Search Results: ");
        }
        //If no search criteria, prints message accordingly
        else {
            out.println();
            out.println("Showing all packages");
        }

        //Format header
        out.println("---------------------------------------------------------------------------------------");
        out.print("| " +  String.format("%10s","TRACKING #"));
        out.print(" | " +  String.format("%10s","TYPE"));
        out.print(" | " +  String.format("%16s","SPECIFICATION"));
        out.print(" | " +  String.format("%12s","CLASS"));
        out.print(" | " +  String.format("%10s","WEIGHT"));
        out.println(" | " +  String.format("%12s","VOLUME |"));
        out.println("---------------------------------------------------------------------------------------");

        //loops through list of packages
        for (Package i : listOfPackages) {

            //Prints package if one of the three condition are true:
            // 1-Tracking number matches with tracking number passed in the parameter
            // 2-Package weight is between weight range passed in parameter
            // 3-Parameters are empty
            if (trackingNumber.equals(i.getTrackingNumber()) || (weightMin <= i.getWeight() && weightMax >= i.getWeight()) || (trackingNumber.equals("") && (weightMin == -1.0 || weightMax ==-1.0)) ) {

                out.print("| " +  String.format("%10s",i.getTrackingNumber()));
                out.print(" | " +  String.format("%10s",i.getType()));
                out.print(" | " +  String.format("%16s",i.getSpecification()));
                out.print(" | " +  String.format("%12s",i.getMailingClass()));
                out.print(" | " +  String.format("%10s", String.format("%.2f",i.getWeight())));
                out.println(" | " +  String.format("%" + 12 + "s",i.getVolume() + " |"));
            }
        }

        //String.format("%.2f", floatValue)

        out.println("---------------------------------------------------------------------------------------");
        out.println();
    }


    /**
     * Adds new package to the list. Accepts parameters for the content of the package<br><br>
     *
     * @param trackingNumberInput  Tracking Number of the new package.
     * @param typeInput Type code of the new package. Valid Options: [1-8]
     * @param specificationInput Specification Code of the new package. Valid Options: [1-5]
     * @param mailingClassInput Mailing Class Code of the new package. Valid Options: [1-5]
     * @param weightInput Weight of the new package in oz
     * @param volumeInput Volume of the new package.
     */
    public void addToPackage(String trackingNumberInput, Integer typeInput, Integer specificationInput, Integer mailingClassInput, Float weightInput, Integer volumeInput){

        String type="";
        String specification="";
        String mailingClass="";


        //Translate type code
        switch (typeInput){
            case 1: type="Postcard"; break;
            case 2: type="Envelope"; break;
            case 3: type="Packet"; break;
            case 4: type="Box"; break;
            case 5: type="Crate"; break;
            case 6: type="Drum"; break;
            case 7: type="Roll"; break;
            case 8: type="Tube"; break;
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

        //Create new package using values from method input
        Package newPackage = new Package(trackingNumberInput,type,specification,mailingClass,weightInput,volumeInput);

        //Add new package to the list of packages
        listOfPackages.add(newPackage);

    }

    /**
     * Deletes package from list based on tracking number input<br><br>
     * @param trackingNumber  Tracking Number to be deleted. Deletes only the first package with the correspondent tracking number
     */
    public void deletePackage(String trackingNumber){

        //loops through list of packages
        for (Package i : listOfPackages) {

            //If tracking number is found, deleted package
            if (trackingNumber.equals(i.getTrackingNumber()) ) {
                listOfPackages.remove(listOfPackages.indexOf(i));
                break;
            }

        }

    }

    //array list to hold the list of packages
    private ArrayList<Package> listOfPackages = new ArrayList<Package>();

}