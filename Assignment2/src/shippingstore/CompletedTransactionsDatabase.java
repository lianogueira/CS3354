package shippingstore;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.*;

/**
 * Handles a list of objects of the type CompletedTransaction <br><br>
 * <b>Functionalities:</b> <br>
 * Read list of completed transactions from File,<br>
 * Save list of completed transactions in File,<br>
 * Complete a transaction,<br>
 * Show Completed transaction<br>
 *
 * @author Tyler Hooks and Lia Nogueira de Moura
 * @version 10/02/2017
 */
public class CompletedTransactionsDatabase implements Serializable {

    private ArrayList<CompletedTransaction> transactionsList;
    private String DB_FILE_NAME = "TransactionDB.txt";


    /**
     * This constructor initializes the ArrayList with the data from file
     * @throws Exception (throws Exception)
     */
    public CompletedTransactionsDatabase() throws Exception {
        transactionsList = new ArrayList<>();

        try {
            FileInputStream fileIN = new FileInputStream(DB_FILE_NAME);
            ObjectInputStream objectinputstream = new ObjectInputStream(fileIN);
            transactionsList = (ArrayList<CompletedTransaction>) objectinputstream.readObject();
        }catch (FileNotFoundException e) {
            FileOutputStream oFile = new FileOutputStream(DB_FILE_NAME, false);
        } catch (IOException e) {
            System.out.println("Error~ There is a problem with file input from " + DB_FILE_NAME + ".");
        }
    }


    /**
     * Adds new CompletedTransaction to the list. Accepts parameters for the content of the transaction<br><br>
     * Removes package from package list after adding to the completed transactions list
     *
     * @param customerID  Customer ID of completed transaction
     * @param trackingNumber Tracking Number of completed transaction
     * @param shippingDate Shipping Date of completed transaction
     * @param deliveryDate Delivery Date of completed transaction
     * @param costShipping Cost Shipping of completed transaction
     * @param employeeID Employee ID of completed transaction
     * @param packages package list objects so we can remove a package from
     */
    public void completeTransaction (Integer customerID, String trackingNumber, Date shippingDate, Date deliveryDate, float costShipping, Integer employeeID, PackageDatabase packages)
    {
        transactionsList.add(new CompletedTransaction(customerID,trackingNumber,shippingDate,deliveryDate, costShipping, employeeID));
        packages.removePackage(trackingNumber);

    }


    /**
     * Displays list of all completed transactions <br><br>
     *
     */
    public void showTransactions() {

        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MM/dd/yyyy");
        //sdf = new SimpleDateFormat("EEE, MM/dd/yyyy");


        System.out.println(" ------------------------------------------------------------------------------------------------- ");
        System.out.println("| Customer # | Tracking # | Shipping Date   | Delivery Date    | Cost Of Shipping | Employee ID   |");
        System.out.println(" ------------------------------------------------------------------------------------------------- ");

        for (CompletedTransaction i : transactionsList) {

                System.out.println(String.format("| %-11s| %-11s| %-16s| %-17s| %-17s| %-14s|",
                        i.getCostShipping(),
                        i.getTrackingNumber(),
                        sdf.format(i.getShippingDate()),
                        sdf.format(i.getDeliveryDate()),
                        String.format("%.2f", i.getCostShipping()),
                        i.getEmployeeID()));

        }

        System.out.println(" ------------------------------------------------------------------------------------------------- \n");

    }


    /**
     * This method writes the data into file
     * @throws Exception (throws Exception)
     */
    public void flush() throws Exception {

        try {
            FileOutputStream fileOUT = new FileOutputStream(DB_FILE_NAME);
            ObjectOutputStream objectOUT = new ObjectOutputStream(fileOUT);

            objectOUT.writeObject(transactionsList);
            objectOUT.close();
        }
        catch (IOException e) {
            System.out.println("Error~ There is a problem writing to " + DB_FILE_NAME + ".");

        }

    }


}
