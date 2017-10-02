package shippingstore;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.CompletionException;

import static java.lang.System.out;


public class CompletedTransactionsDatabase implements Serializable {

    private ArrayList<CompletedTransaction> transactionsList;
    private String DB_FILE_NAME = "TransactionDB.txt";


    //constructor
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


    //Completes transactions. Add transaction to list
    public void completeTransaction (Integer custumerID, String trackingNumber, String shippingDate, String deliveryDate, float costShipping, Integer employeeID, PackageDatabase packages)
    {

        transactionsList.add(new CompletedTransaction(custumerID,trackingNumber,shippingDate,deliveryDate, costShipping, employeeID));
        packages.removeOrder(trackingNumber);

    }


    /**
     * Private method used as an auxiliary method to display a given ArrayList
     * of package orders in a formatted manner.
     *
     *
     */
    public void showTransactions() {


        System.out.println(" --------------------------------------------------------------------------------------------- ");
        System.out.println("| Customer # | Tracking # | Shipping Date | Delivery Date  | Cost Of Shipping | Employee ID   |");
        System.out.println(" --------------------------------------------------------------------------------------------- ");

        for (CompletedTransaction i : transactionsList) {

                System.out.println(String.format("| %-11s| %-11s| %-14s| %-15s| %-17s| %-14s|",
                        i.getCostShipping(),
                        i.getTrackingNumber(),
                        i.getShippingDate(),
                        i.getDeliveryDate(),
                        String.format("%.2f", i.getCostShipping()),
                        i.getEmployeeID()));

        }

        System.out.println(" --------------------------------------------------------------------------------------------- \n");

    }


    //End
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
