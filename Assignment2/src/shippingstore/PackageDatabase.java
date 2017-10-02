package shippingstore;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
//import java.*;

import static java.lang.System.out;

/**
 * This class is used to represent a database interface for a list of
 * <CODE>Package</CODE>'s. It using a plain-text file "PackageDB.txt"
 * to store and write package order objects in readable text form. It contains
 * an <CODE>ArrayList</CODE> called <CODE>packageOrderList</CODE> to store the
 * database in a runtime friendly data structure. The <CODE>packageOrderList</CODE>
 * is written to "PackageDB.txt" at the end of the <CODE>PackageDatabase</CODE> object's
 * life by calling <CODE>flush()</CODE>. This class also provides methods for
 * adding, remove, and searching for shipping orders from the list.
 *
 * @author Junye Wen
 */
public class PackageDatabase implements Serializable {

    private ArrayList<Package> packageOrderList;
    private String DB_FILE_NAME = "PackageDB.txt";

    /**
     * This constructor is hard-coded to open "<CODE>PackageDB.txt</CODE>" and
     * initialize the <CODE>packageOrderList</CODE> with its contents. If no such file
     * exists, then one is created. The contents of the file are "loaded" into
     * the packageOrderList ArrayList in no particular order. The file is then closed
     * during the duration of the program until <CODE>flush()</CODE> is called.
     * @throws IOException
     */
    public PackageDatabase() throws Exception {
        packageOrderList = new ArrayList<>();


        try {
            FileInputStream fileIN = new FileInputStream(DB_FILE_NAME);
            ObjectInputStream objectinputstream = new ObjectInputStream(fileIN);
            packageOrderList = (ArrayList<Package>) objectinputstream.readObject();
        }catch (FileNotFoundException e) {
            FileOutputStream oFile = new FileOutputStream(DB_FILE_NAME, false);
        } catch (IOException e) {
            System.out.println("Error~ There is a problem with file input from " + DB_FILE_NAME + ".");
        }

    }

    /**
     * Method showPackageOrer displays the current list of package orders in the Arraylist in no
     * particular order.
     *
     */
    public void showPackages() {
        showPackages("");
    }

    /**
     * This method can be used to search for a package order in the Arraylist of orders.
     *
     * @param trackingNumber a <CODE>String</CODE> that represents the tracking number
     * of the order that to be searched for.
     */
    public void searchPackage(String trackingNumber) {
        showPackages(trackingNumber);
    }


    /**
     * Private method used as an auxiliary method to display a given ArrayList
     * of package orders in a formatted manner.
     *
     * @param trackingNumber if not empty will be used to show only the package that matches this trackingnumber
     */
    private void showPackages(String trackingNumber) {


        if (trackingNumber != "") {
            out.println();
            out.println("Tracking Number = " + trackingNumber + "  - Search Results: ");
        }

        System.out.println(" ---------------------------------------------------------------------------------------------------------------------- ");
        System.out.println("| Tracking # | Type    | Specification    | Class         | Custom 1                  | Custom 2                      |");
        System.out.println(" ---------------------------------------------------------------------------------------------------------------------- ");


        for (Package i : packageOrderList) {

            if (trackingNumber.equals(i.getTrackingNumber()) || trackingNumber.equals("")) {

                System.out.print(String.format("| %-11s| %-8s| %-17s| %-14s",
                        i.getTrackingNumber(),
                        i.getType(),
                        i.getSpecification(),
                        i.getMailingClass()));

                if (i instanceof PackageEnvelope) {
                    System.out.println(String.format("| %-26s| %-30s|",
                            "Height: " + Integer.toString(((PackageEnvelope) i).getHeight()),
                            "Width: " + Integer.toString(((PackageEnvelope) i).getWidth())));
                } else if (i instanceof PackageBox) {
                    System.out.println(String.format("| %-26s| %-30s|",
                            "Largest Dimension: " + Integer.toString(((PackageBox) i).getLargestDimension()),
                            "Volume: " + Integer.toString(((PackageBox) i).getVolume())));
                } else if (i instanceof PackageCrate) {
                    System.out.println(String.format("| %-26s| %-30s|",
                            "Max Load Weight: " + String.format("%.2f", ((PackageCrate) i).getMaxWeight()),
                            "Content: " + ((PackageCrate) i).getContent()));
                } else if (i instanceof PackageDrum) {
                    System.out.println(String.format("| %-26s| %-30s|",
                            "Material: " + ((PackageDrum) i).getMaterial(),
                            "Diameter: " + Integer.toString(((PackageDrum) i).getDiameter())));
                }
            }
        }

        System.out.println(" ---------------------------------------------------------------------------------------------------------------------- \n");

    }


    /**
     * This method can be used to find a package order in the Arraylist of orders.
     *
     * @param trackingNumber a <CODE>String</CODE> that represents the tracking number
     * of the order that to be searched for.
     * @return the <CODE>int</CODE> index of the package orders in the Arraylist of orders,
     * or -1 if the search failed.
     */
    public int findPackage(String trackingNumber) {

        int index = -1;

        for (int i = 0; i < packageOrderList.size(); i++) {
            String temp = packageOrderList.get(i).getTrackingNumber();

            if (trackingNumber.equalsIgnoreCase(temp)) {
                index = i;
                break;
            }
        }
        return index;
    }



    /**
     * This method is used to add a package order to the orderList ArrayList. In order for a
     * package order to be added to the ArrayList it must comply with the following:
     * <p>
     * 1. The order is not already in the ArrayList according to the tracking number
     * as the unique key.
     * <p>
     * 2. The TrackningNumber string matches the following regular expression:
     * <CODE>"[A-Za-z0-9]{5}"</CODE> or in other words: it
     * is 5 avinhanumeric characters.
     * <p>
     * 3. The Type of the order can be only one of the following:
     *    Postcard, Letter, Envelope, Packet, Box, Crate, Drum, Roll, Tube.
     * <p>
     * 4. The Specification of the order can be only one of the following:
     *    Fragile, Books, Catalogs, Do-not-Bend, N/A.
     * <p>
     * 5. The Mailing Class of the order can be only one of the following:
     *    First-Class, Priority, Retail, Ground, Metro.
     * <p>
     * 6. The Weight must be non-negative.
     * <p>
     * 7. The Volume must be non-negative.
     * @param toAdd the <CODE>Package</CODE> object to add to the
     * <CODE>packageOrderList</CODE>
     */
    public void addOrder(String trackingNumberInput, Integer typeInput, Integer specificationInput, Integer mailingClassInput,
                         Integer heightInput, Integer widthInput,
                         Integer largestDimensionInput, Integer volumeInput,
                         Float maxWeightInput, String contentInput,
                         Integer materialInput, Integer diameterInput) {

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


        if (this.findPackage(trackingNumberInput) != -1) {
            System.out.println("Package Order already exists in database. \n");
            return;
        }

        if (maxWeightInput < 0) {
            System.out.println("The weight of package cannot be negative.");
            return;
        }


        if (type.equals("Envelope")){
            PackageEnvelope newEnvelope = new PackageEnvelope(trackingNumberInput,type,specification,mailingClass, heightInput, widthInput);
            packageOrderList.add(newEnvelope);
        }
        else if (type.equals("Box")){
            PackageBox newBox = new PackageBox(trackingNumberInput,type,specification,mailingClass, largestDimensionInput, volumeInput);
            packageOrderList.add(newBox);
        }
        else if (type.equals("Crate")){
            PackageCrate newCrate = new PackageCrate(trackingNumberInput,type,specification,mailingClass, maxWeightInput, contentInput);
            packageOrderList.add(newCrate);
        }
        else if (type.equals("Drum")){
            PackageDrum newDrum = new PackageDrum(trackingNumberInput,type,specification,mailingClass, material, diameterInput);
            packageOrderList.add(newDrum);
        }
        else {
            //If passed all the checks, add the order to the list
            packageOrderList.add(new Package(trackingNumberInput, type, specification, mailingClass));
            System.out.println("Package Order has been added.\n");
        }


    }


    /**
     * This method will remove an order from the <CODE>packageOrderList</CODE> ArrayList. It
     * will remove the instance of an order that matches tracking number that was
     * passed to this method. If no such order exists, it will produce an error message.
     *
     * @param toDelete the <CODE>Package</CODE> object to be removed.
     */
    public void removeOrder(String trackingNum) {
        int orderID = findPackage(trackingNum);
        if (orderID == -1) {
            System.out.println("\nAction failed. No package order with the given tracking # exist in database.\n");
        }
        else {
            packageOrderList.remove(orderID);
            System.out.println("\nAction successful. Package order has been removed from the database.\n");
        }
    }


    /**
     * This method opens <CODE>"PackageDB.txt"</CODE> and overwrites it with a text representation of
     * all the package orders in the <CODE>PackageList</CODE>.
     * This should be the last method to be called before exiting the program.
     * @throws IOException
     */
    public void flush() throws Exception {

        try {
            FileOutputStream fileOUT = new FileOutputStream(DB_FILE_NAME);
            ObjectOutputStream objectOUT = new ObjectOutputStream(fileOUT);

            objectOUT.writeObject(packageOrderList);
            objectOUT.close();
        }
        catch (IOException e) {
            System.out.println("Error~ There is a problem writing to " + DB_FILE_NAME + ".");

        }

    }

}
