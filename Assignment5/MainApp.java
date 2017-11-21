package shippingstore;


import java.io.IOException;
import java.util.logging.*;


/**
 * <b>Shipping Store (GUI version) </b><br><br>
 *
 * Program that simulates a shipping store database<br>
 * The database maintain records of the packages, users and completed transactions of a shipping store<br><br>
 *
 * <b>User options: </b><br>
 * 1) Show all existing package orders in the database<br>
 * 2) Add a new package order to the database<br>
 * 3) Delete a package order from a database<br>
 * 4) Search for a package order (given its Tracking #)<br>
 * 5) Show a list of users in the database<br>
 * 6) Add a new user to the database<br>
 * 7) Update user info(given their id)<br>
 * 8) Complete a shipping transaction.<br>
 * 9) Show completed shipping transactions<br>
 * 10) Exit program.<br>
 *
 * All user interaction is done in an user interface
 * *
 * @author Tyler Hooks and Lia Nogueira de Moura
 * @version 11/20/2017
 */
public class MainApp {

    private static final Logger logger = Logger.getLogger(ShippingStore.class.getName());
    static FileHandler fh;

    public static void main(String[] args) {


        //Setting up logger
        try {
            fh = new FileHandler("logFile.txt");
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.addHandler(fh);
            logger.setLevel(Level.FINEST);
            logger.log(Level.INFO, "Initiating Logging");
        } catch(SecurityException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //Initializing ShippingStore
        ShippingStore ss;
        ss = ShippingStore.readDatabase(logger);

       //Initializing Gui class
        GuiMain ssInterface = new GuiMain(ss,logger);

    }


}
