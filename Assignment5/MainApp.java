package shippingstore;

import java.io.IOException;
import java.util.*;
import java.util.logging.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
* Main access point
*/
public class MainApp {

    ShippingStore ss;
 	static final Logger logger = Logger.getLogger(MainApp.class.getName());
    static FileHandler fh;

    /*** Constructor*/
    public MainApp() {
        ss = ShippingStore.readDatabase();
        GuiMain myGui = new GuiMain(ss);
    }

    public static void main(String[] args) {
        MainApp app = new MainApp();
        Logger logger = Logger.getLogger("My Log");
        try {

       	 fh = new FileHandler("logFile.txt");
       	 SimpleFormatter formatter = new SimpleFormatter();
       	 fh.setFormatter(formatter);
       	 logger.setLevel(Level.FINEST);
       	 logger.log(Level.INFO, "Logging Info");
       	 //logger.info("a test log");
       	 //logger.warning("IO error");
        } catch(SecurityException ex) {
       	 ex.printStackTrace();
       	 logger.setLevel(Level.WARNING);

        } catch (IOException ex) {
       	 ex.printStackTrace();
       	 logger.setLevel(Level.WARNING);
        }
    }


}
