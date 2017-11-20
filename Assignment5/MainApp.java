package shippingstore;

import java.util.*;
import java.util.logging.*;


/**
* Main access point
*/
public class MainApp {
  
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
