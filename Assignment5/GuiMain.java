package shippingstore;

import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.util.logging.*;


/**
 * Configures Shipping Store GUI for Package Tab <br>
 * Creates two tabs, one for packages and one for users <br>
 * Then calls two other classes to set up the content of each of these tabs
 * @author Tyler Hooks and Lia Nogueira de Moura
 * @version 11/20/2017
 */
public class GuiMain {

	private ShippingStore ss = new ShippingStore();
	
	/**
    * Class Constructor
	* Calls function to initialize GUI configuration
    */
    public GuiMain(ShippingStore ss, Logger logger) {
	
        initGui(ss, logger);
    }

    /**
     * Calls functions to initialize all GUI components
     */
    public void initGui(ShippingStore ss, Logger logger) {

		this.ss = ss;
        JFrame f = new JFrame("Shipping Store");


        //Setting up menu with Exit
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("Menu");
        JMenuItem eMenuItem;
        eMenuItem = new JMenuItem("Exit");
        eMenuItem.setToolTipText("Exit program");		
		//Write to file on window closing
		eMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){		
				write();				
				System.exit(0); 				
			}
		});				
        file.add(eMenuItem);
        menubar.add(file);
        f.setJMenuBar(menubar);


        //Setting up tabs (Packages and Users)
        JTabbedPane tabs = new JTabbedPane();
        tabs.setBounds(15,15,750,550);
        JPanel MainPackagePanel = new JPanel(new BorderLayout());
        JPanel MainUserPanel = new JPanel(new BorderLayout());
        tabs.add("Packages",MainPackagePanel);
        tabs.add("Users",MainUserPanel);
        f.add(tabs);

		
        //Creating gui for packages tab
        try {
            GuiPackagesTab packagesGui = new GuiPackagesTab(ss, MainPackagePanel, logger);
        }
        catch (Exception e){
            logger.log(Level.SEVERE, "Error occurred when setting up Package Tab GUI components");
        }


        //Creating gui for user tab
        try {
            GuiUserTab userGui = new GuiUserTab(ss, MainUserPanel, logger);
        }
        catch (Exception e){
            logger.log(Level.SEVERE, "Error occurred when setting up User Tab GUI components");
        }


        //Write to file on window closing
        f.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                write();
            }
        });

        //Frame configuration
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800,660);
        f.setLayout(new BorderLayout());
        f.setVisible(true);

    }
	
	
	/**
    * Method used to call ShippingStore object to add data to database
	* This function will called on system exit
    */
	private void write(){
		ss.writeDatabase();
	}

}
