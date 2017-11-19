package shippingstore;

import java.util.*;
import java.util.logging.*;


/**
* Main access point
*/
public class MainApp {

    private static Logger logger = Logger.getLogger("shippingstore");
    //private static FileHandler fh = new FileHandler("log.txt");
    ShippingStore ss;


    /*** Constructor*/
    public MainApp() {
        ss = ShippingStore.readDatabase();
        GuiMain myGui = new GuiMain(ss);
    }

    public static void main(String[] args) {
        MainApp app = new MainApp();
    }


}
