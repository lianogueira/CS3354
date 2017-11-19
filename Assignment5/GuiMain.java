package shippingstore;

import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;


public class GuiMain {


    public GuiMain(ShippingStore ss) {
        initGui(ss);
    }


    public void initGui(ShippingStore ss) {

        JFrame f = new JFrame("Shipping Store");


        //Setting up menu with Exit
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("Menu");
        JMenuItem eMenuItem;
        eMenuItem = new JMenuItem("Exit");
        eMenuItem.setToolTipText("Exit program");
        eMenuItem.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });
        file.add(eMenuItem);
        menubar.add(file);
        f.setJMenuBar(menubar);


        //Setting up tab (Packages and Users)
        JTabbedPane tabs = new JTabbedPane();
        tabs.setBounds(15,15,750,550);
        JPanel MainPackagePanel = new JPanel(new BorderLayout());
        JPanel MainUserPanel = new JPanel(new BorderLayout());
        tabs.add("Packages",MainPackagePanel);
        tabs.add("Users",MainUserPanel);
        f.add(tabs);

        //Creating gui of packages tab
        GuiPackagesTab packagesGui = new GuiPackagesTab(ss, MainPackagePanel);

        //Creating gui of user tab
        GuiUserTab userGui = new GuiUserTab(ss, MainUserPanel);


        //Frame configuration
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800,660);
        f.setLayout(new BorderLayout());
        f.setVisible(true);

    }

}
