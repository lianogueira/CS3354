package shippingstore;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.*;
import static java.lang.System.out;

/**
 * Handles a list of objects of the type CompletedTransaction <br><br>
 * <b>Functionalities:</b> <br>
 * Read list of completed transactions from File,<br>
 * Save list of completed transactions in File,<br>
 * Complete a transaction,<br>
 * Show Completed transaction<br>
 *
 * @author Tyler Hooks and Lia Nogueira de Moura
 * @version 10/04/2017
 */
public class CompletedTransactionsDatabase implements Serializable {

    private ArrayList<CompletedTransaction> cTransactionsList; 	/** Array list to save the list of completed transactions  */
    private String DB_FILE_NAME = "TransactionDB.txt";			/** Constant file name. This file will contain the list of completed transactions data */


    /**
     * This constructor initializes the ArrayList with the data from file
     * @throws Exception (throws Exception)
     */
    public CompletedTransactionsDatabase() throws Exception {
        cTransactionsList = new ArrayList<>();

        try {
            FileInputStream fileIN = new FileInputStream(DB_FILE_NAME);
            ObjectInputStream objectinputstream = new ObjectInputStream(fileIN);
            cTransactionsList = (ArrayList<CompletedTransaction>) objectinputstream.readObject();
        }catch (FileNotFoundException e) {
            FileOutputStream oFile = new FileOutputStream(DB_FILE_NAME, false);
        } catch (IOException e) {
            out.println("Error~ There is a problem with file input from " + DB_FILE_NAME + ".");
        }
    }


    /**
     * Adds new CompletedTransaction to the list. Accepts parameters for the content of the transaction<br><br>
     * Removes package from package list after adding to the completed transactions list
     *
     * @param customerID Customer ID of completed transaction - (Data type: Integer)
     * @param trackingNumber Tracking Number of completed transaction - (Data type: String)
     * @param shippingDate Shipping Date of completed transaction - (Data type: Date)
     * @param deliveryDate Delivery Date of completed transaction - (Data type: Date)
     * @param costShipping Cost Shipping of completed transaction - (Data type: Float)
     * @param employeeID Employee ID of completed transaction - (Data type: Integer)
     * @param packages package list object so we can remove a package from - (Data type: PackageDatabase)
     */
    public void completeTransaction (Integer customerID, String trackingNumber, Date shippingDate, Date deliveryDate, float costShipping, Integer employeeID, PackageDatabase packages)
    {
        //Add new completed transaction
        cTransactionsList.add(new CompletedTransaction(customerID,trackingNumber,shippingDate,deliveryDate, costShipping, employeeID));
        //Remove package from package list
        packages.removePackage(trackingNumber);

    }


    /**
     * Displays list of all completed transactions <br><br>
     *
     */
    public void showTransactions() {

        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MM/dd/yyyy");

        out.println(" -------------------------------------------------------------------------------------------------- ");
        out.println("| Customer ID | Tracking # | Shipping Date   | Delivery Date    | Cost Of Shipping | Employee ID   |");
        out.println(" -------------------------------------------------------------------------------------------------- ");

        for (CompletedTransaction i : cTransactionsList) {

            out.println(String.format("| %-12s| %-11s| %-16s| %-17s| %-17s| %-14s|",
                    i.getCustomerID(),
                    i.getTrackingNumber(),
                    sdf.format(i.getShippingDate()),
                    sdf.format(i.getDeliveryDate()),
                    String.format("%.2f", i.getCostShipping()),
                    i.getEmployeeID()));

        }

        out.println(" ------------------------------------------------------------------------------------------------- \n");

    }


    /**
     * This method writes the data into file
     * @throws Exception (throws Exception)
     */
    public void flush() throws Exception {

        try {
            FileOutputStream fileOUT = new FileOutputStream(DB_FILE_NAME);
            ObjectOutputStream objectOUT = new ObjectOutputStream(fileOUT);

            objectOUT.writeObject(cTransactionsList);
            objectOUT.close();
        }
        catch (IOException e) {
            out.println("Error~ There is a problem writing to " + DB_FILE_NAME + ".");

        }

    }


    /**
     * This method can be used to find a package in the Arraylist of completed transaction
     *
     * @param trackingNumber a <CODE>String</CODE> that represents the tracking number
     * of the package that to be searched for. - (Data type: String)
     * @return the <CODE>int</CODE> index of the package in the Arraylist of packages,
     * or -1 if the search failed. - (Data type: Integer)
     */
    public int findPackage(String trackingNumber) {

        int index = -1;

        for (int i = 0; i < cTransactionsList.size(); i++) {
            String temp = cTransactionsList.get(i).getTrackingNumber();

            if (trackingNumber.equalsIgnoreCase(temp)) {
                index = i;
                break;
            }
        }

        return index;
    }

}