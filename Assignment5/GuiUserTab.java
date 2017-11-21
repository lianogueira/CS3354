package shippingstore;

import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.logging.*;


/**
 * Configures GUI for Users Tab <br><br>
 *
 * @author Tyler Hooks and Lia Nogueira de Moura
 * @version 11/20/2017
 */
public class GuiUserTab {

    private JPanel MainUserPanel;
    private ShippingStore ss;
	private Logger logger = Logger.getLogger("shippingstore");;

    //New JPanels used in the Package Tab
    private SpringLayout layoutForms = new SpringLayout();
    private JPanel UserPanelButtons = new JPanel(new GridLayout());
    private JPanel UserPanelAdd = new JPanel(new BorderLayout());
    private JPanel UserPanelAddAux = new JPanel(layoutForms);
    private JPanel PackagePanelUpdate = new JPanel(new BorderLayout());
    private JPanel UserPanelUpdateAux = new JPanel(layoutForms);
    private JPanel UserPanelSearch = new JPanel(new BorderLayout());
    private JPanel UserPanelSearchAux = new JPanel(layoutForms);


    //Main Buttons
    private JButton buttonAdd = new JButton("Add");
    private JButton buttonUpdate = new JButton("Update");
    private JButton buttonSearch = new JButton("Search");
    private Font buttonFont = new Font("Arial", Font.PLAIN, 13);
    private Dimension buttonDimension = new Dimension(5, 60);


    //Radio button for user type
    private JPanel typeOfUserPanel = new JPanel(new FlowLayout());
    private JRadioButton rdbEmployee = new JRadioButton("Employee                ", true);
    private JRadioButton rdbCustomer = new JRadioButton("Customer                 ");


    //Labels and Text fields for Add Panel
    private JLabel lblFirstName = new JLabel("First Name: ");
    private JTextField txtFirstName = new JTextField("", 15);
    private JLabel lblLastName = new JLabel("Last Name: ");
    private JTextField txtLastName = new JTextField("", 15);
    private JLabel lblPhone = new JLabel("Phone Number: ");
    private JTextField txtPhone = new JTextField("", 15);
    private JLabel lblAddress = new JLabel("Address: ");
    private JTextField txtAddress = new JTextField("", 15);
    private JLabel lblSSN = new JLabel("SSN: ");
    private JTextField txtSSN = new JTextField("", 15);
    private JLabel lblSalary = new JLabel("Monthly Salary: ");
    private JTextField txtSalary = new JTextField("", 15);
    private JLabel lblAccount = new JLabel("Bank Account: ");
    private JTextField txtAccount = new JTextField("", 15);


    //Update panel
    private JLabel lblUpdateID = new JLabel("ID: ");
    private JTextField txtUpdateID = new JTextField("", 15);
    private JLabel lblUpdateType = new JLabel("User Type: ");
    private JTextField txtUpdateType = new JTextField("", 15);
    private JLabel lblUpdateFirstName = new JLabel("First Name: ");
    private JTextField txtUpdateFirstName = new JTextField("", 15);
    private JLabel lblUpdateLastName = new JLabel("Last Name: ");
    private JTextField txtUpdateLastName = new JTextField("", 15);
    private JLabel lblUpdatePhone = new JLabel("Phone Number: ");
    private JTextField txtUpdatePhone = new JTextField("", 15);
    private JLabel lblUpdateAddress = new JLabel("Address: ");
    private JTextField txtUpdateAddress = new JTextField("", 15);
    private JLabel lblUpdateSSN = new JLabel("SSN: ");
    private JTextField txtUpdateSSN = new JTextField("", 15);
    private JLabel lblUpdateSalary = new JLabel("Monthly Salary: ");
    private JTextField txtUpdateSalary = new JTextField("", 15);
    private JLabel lblUpdateAccount = new JLabel("Bank Account: ");
    private JTextField txtUpdateAccount = new JTextField("", 15);
    //Radio button for user type in update panel
    private JPanel typeOfUserUpdatePanel = new JPanel(new FlowLayout());
    private JRadioButton rdbUpdateEmployee = new JRadioButton("Employee                ", true);
    private JRadioButton rdbUpdateCustomer = new JRadioButton("Customer                 ");


    //Search panel objects
    private DefaultTableModel model = new DefaultTableModel();
    String[] userColumns = new String[] {"User Type", "Id", "First Name", "Last Name", "Phone", "Address", "SSN", "Salary", "Bank Account"};


     /**
     * Class Constructor
	 * Initializes MainUserPanel, ShipingStore and Logger variables
     */
    public GuiUserTab(ShippingStore ss, JPanel MainUserPanel, Logger logger) {
	    this.MainUserPanel = MainUserPanel;
        this.ss = ss;
		this.logger = logger;
		
        initGui();
    }


	/**
    * Calls functions to initialize all GUI components in the User Tab
    */
    public void initGui() {

		
		logger.log(Level.INFO, "Setting up GUI in User Tab");		
			

        //Setting up inside of MainPackagePanel
        MainUserPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        MainUserPanel.add(UserPanelButtons, BorderLayout.PAGE_START);


        //Set up Main buttons
        setUpMainButtonsPanel();


        //Setting up panel for add
        TitledBorder titleAdd = BorderFactory.createTitledBorder("Add New User");
        titleAdd.setTitleFont(buttonFont);
        UserPanelAdd.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        UserPanelAdd.add(UserPanelAddAux);
        UserPanelAddAux.setBorder(titleAdd);
		logger.log(Level.INFO, "Setting up GUI for Add a User panel");
		

        //Setting up panel for Update
        TitledBorder titleDelete = BorderFactory.createTitledBorder("Update User");
        titleDelete.setTitleFont(buttonFont);
        PackagePanelUpdate.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        PackagePanelUpdate.add(UserPanelUpdateAux);
        UserPanelUpdateAux.setBorder(titleDelete);
		logger.log(Level.INFO, "Setting up GUI for Update a User panel");
		

        //Setting up panel for search
        TitledBorder titleSearch = BorderFactory.createTitledBorder("Show all Users");
        titleSearch.setTitleFont(buttonFont);
        UserPanelSearch.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        UserPanelSearch.add(UserPanelSearchAux);
        UserPanelSearchAux.setBorder(titleSearch);
		logger.log(Level.INFO, "Setting up GUI for User Search panel");


        //setting up add panel
        setUpRadioButtonInAddPanel();
        setUpInputValuesInAddPanel();
        setUpAddToDatabaseButton();
		logger.log(Level.INFO, "Adding GUI content in ADD panel");
		

        //Content in Search panel
        setUpSearchPanel();
		logger.log(Level.INFO, "Adding GUI content in Search panel");
		
		
        //Update panel
        setUpInputValuesInUpdatePanel();
        setUpRadioButtonInUpdatePanel();
        setUpUpdateDatabaseButton();
		logger.log(Level.INFO, "Adding GUI content in Update panel");

    }


	/**
     * Sets up User Tab Main buttons - (layout and action listener)
     */		
    private void setUpMainButtonsPanel(){

        buttonAdd.setPreferredSize(buttonDimension);
        buttonUpdate.setPreferredSize(buttonDimension);
        buttonSearch.setPreferredSize(buttonDimension);

        buttonAdd.setFont(buttonFont);
        buttonUpdate.setFont(buttonFont);
        buttonSearch.setFont(buttonFont);

        UserPanelButtons.add(buttonAdd);
        UserPanelButtons.add(buttonUpdate);
        UserPanelButtons.add(buttonSearch);


        //Setting up button actions		
		buttonAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MainUserPanel.remove(PackagePanelUpdate);
				MainUserPanel.remove(UserPanelSearch);
				MainUserPanel.setVisible(false);
				MainUserPanel.add(UserPanelAdd, BorderLayout.CENTER);
				MainUserPanel.setVisible(true);			
				
				logger.log(Level.INFO, "User Request: Add User");
			}								
		});
						
		buttonUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MainUserPanel.remove(UserPanelAdd);
				MainUserPanel.remove(UserPanelSearch);
				MainUserPanel.setVisible(false);
				MainUserPanel.add(PackagePanelUpdate, BorderLayout.CENTER);
				MainUserPanel.setVisible(true);	

				logger.log(Level.INFO, "User Request: Update User");				
			}
		});

		buttonSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MainUserPanel.remove(UserPanelAdd);
				MainUserPanel.remove(PackagePanelUpdate);
				MainUserPanel.setVisible(false);
				MainUserPanel.add(UserPanelSearch, BorderLayout.CENTER);
				MainUserPanel.setVisible(true);
				model.setRowCount(0);	

				logger.log(Level.INFO, "User Request: Search User");								
			}
		});
			
			

    }

	/**
     * Sets up User Type radio buttons in Add a User screen - (layout and action listeners)
     */	
    private void setUpRadioButtonInAddPanel(){

        //Setting up radio buttons
        TitledBorder titleTypePackage = BorderFactory.createTitledBorder("Type of User");
        titleTypePackage.setTitleFont(buttonFont);
        typeOfUserPanel.setBorder(titleTypePackage);

        ButtonGroup group = new ButtonGroup();
        group.add(rdbEmployee);
        group.add(rdbCustomer);

        typeOfUserPanel.add(rdbEmployee);
        typeOfUserPanel.add(rdbCustomer);
        layoutForms.putConstraint(SpringLayout.NORTH, typeOfUserPanel,20, SpringLayout.NORTH, UserPanelAddAux);
        layoutForms.putConstraint(SpringLayout.WEST, typeOfUserPanel, 10, SpringLayout.WEST, UserPanelAddAux);
        UserPanelAddAux.add(typeOfUserPanel);

        setVisibilityBasedOnUserType(true, false);

        //Radio button actions
		rdbEmployee.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisibilityBasedOnUserType(true, false);				
				logger.log(Level.INFO, "User Request: Select Employee User Type in Add User Panel");
			}
		});		
		rdbCustomer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisibilityBasedOnUserType(false, true);
				logger.log(Level.INFO, "User Request: Select Customer User Type in Add User Panel");
			}
		});		
			

    }


	/**
     * This method is used to change visibility of labels and text fields in the Add a User screen, 
	 * based on the User type
	 * @param isEmployeeVisible send true when user is an employee
	 * @param isCustomerVisible send true when user is a customer
     */		
    private void setVisibilityBasedOnUserType(boolean isEmployeeVisible, boolean isCustomerVisible){
        lblPhone.setVisible(isCustomerVisible);
        txtPhone.setVisible(isCustomerVisible);
        lblAddress.setVisible(isCustomerVisible);
        txtAddress.setVisible(isCustomerVisible);
        lblSSN.setVisible(isEmployeeVisible);
        txtSSN.setVisible(isEmployeeVisible);
        lblSalary.setVisible(isEmployeeVisible);
        txtSalary.setVisible(isEmployeeVisible);
        lblAccount.setVisible(isEmployeeVisible);
        txtAccount.setVisible(isEmployeeVisible);
    }


	 /**
     * This method can be used to verify if a phone number is valid or not
     *
     * @param p a string with the phone number (Data type: String)     
     * @return returns true if string can be used as a phone number    
     */
    private boolean validatePhoneNumber(String p) {
			
        //phone numbers of type "1234567890"
        if (p.matches("\\d{10}")) return true;	
        //phone number with -, . or spaces
        else if(p.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;        
        //phone number where area code is in braces ()
        else if(p.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
        //false if nothing matches the input
        else return false;
    }


	/**
     * Sets up "Add User to Database" button - (layout and action listener)
     */		
    private void setUpAddToDatabaseButton(){

		//button Layout
        JButton buttonAddDatabase = new JButton("Add to Database");
        buttonAddDatabase.setPreferredSize(new Dimension(140, 50));
        buttonAddDatabase.setFont(buttonFont);
        layoutForms.putConstraint(SpringLayout.SOUTH, buttonAddDatabase,65, SpringLayout.SOUTH, lblAccount);
        layoutForms.putConstraint(SpringLayout.WEST, buttonAddDatabase, 0, SpringLayout.WEST, txtFirstName);
        UserPanelAddAux.add(buttonAddDatabase);

		//Action for Add User to Database button
		buttonAddDatabase.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){			     

				logger.log(Level.INFO, "User Request: Add User to Database");
			
				if (txtFirstName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(MainUserPanel, "Enter First Name");
					logger.log(Level.INFO, "Message Sent to User: Enter First Name");
				}
				else if (txtLastName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(MainUserPanel, "Enter Last Name");
					logger.log(Level.INFO, "Message Sent to User: Enter Last Name");
				}
				else if (txtPhone.getText().isEmpty() && rdbCustomer.isSelected()) {
					JOptionPane.showMessageDialog(MainUserPanel, "Enter Valid Phone Number");
					logger.log(Level.INFO, "Message Sent to User: Enter Valid Phone Number");
				}
				else if (!validatePhoneNumber(txtPhone.getText()) && rdbCustomer.isSelected()) {
					JOptionPane.showMessageDialog(MainUserPanel, "Enter Valid Phone Number");
					logger.log(Level.INFO, "Message Sent to User: Enter Valid Phone Number");
				}							
				else if (txtAddress.getText().isEmpty() && rdbCustomer.isSelected()) {
					JOptionPane.showMessageDialog(MainUserPanel, "Enter Address");
					logger.log(Level.INFO, "Message Sent to User: Enter Address");
				}
				else if (!isInteger(txtSSN.getText()) && rdbEmployee.isSelected()) {
					JOptionPane.showMessageDialog(MainUserPanel, "Enter Valid SSN");
					logger.log(Level.INFO, "Message Sent to User: Enter Valid SSN");
				}
				else if (!isFloat(txtSalary.getText()) && rdbEmployee.isSelected()) {
					JOptionPane.showMessageDialog(MainUserPanel, "Enter Valid Monthly Salary");
					logger.log(Level.INFO, "Message Sent to User: Enter Valid Monthly Salary");
				}
				else if (!isInteger(txtAccount.getText()) && rdbEmployee.isSelected()) {
					JOptionPane.showMessageDialog(MainUserPanel, "Enter Bank Account");
					logger.log(Level.INFO, "Message Sent to User: Enter Bank Account");
				}
				else {
				
					//Call ShippingStore method to Add user
					if (rdbEmployee.isSelected()) {
						ss.addEmployee(txtFirstName.getText(), txtLastName.getText(), Integer.parseInt(txtSSN.getText()), Float.parseFloat(txtSalary.getText()), Integer.parseInt(txtAccount.getText())) ;
					} else if (rdbCustomer.isSelected()) {
						ss.addCustomer(txtFirstName.getText(), txtLastName.getText(), txtPhone.getText(), txtAddress.getText());
					}

					txtFirstName.setText("");
					txtLastName.setText("");
					txtPhone.setText("");
					txtAddress.setText("");
					txtSSN.setText("");
					txtSalary.setText("");
					txtAccount.setText("");
					
					JOptionPane.showMessageDialog(MainUserPanel, "User added to the Database!");
					logger.log(Level.INFO, "Message Sent to User: User added to the Database!");
				}
        	}
		});
    }

    /**
     * This method can be used to verify if a string is an integer or not
     *
     * @param s a string that will be used for the verification (Data type: String)     
     * @return returns true if string can be parsed as an integer     
     */
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        // if exception isn't thrown, then it is an integer
        return true;
    }
	

    /**
     * This method can be used to verify if a string is an float or not
     *
     * @param s a string that will be used for the verification (Data type: String)     
     * @return returns true if string can be parsed as a float     
     */
    public static boolean isFloat(String s) {
        try {
            Float.parseFloat(s);
        } catch(NumberFormatException e) {
            return false;
        }
        // if exception isn't thrown, then it is a float
        return true;
    }	


	/**
     * Sets up layout of labels and text fields in Add a User screen
     */		
    private void setUpInputValuesInAddPanel(){

        //First Name
        layoutForms.putConstraint(SpringLayout.SOUTH, lblFirstName,40, SpringLayout.SOUTH, typeOfUserPanel);
        layoutForms.putConstraint(SpringLayout.WEST, lblFirstName, 40, SpringLayout.WEST, UserPanelAddAux);
        UserPanelAddAux.add(lblFirstName);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtFirstName,43, SpringLayout.SOUTH, typeOfUserPanel);
        layoutForms.putConstraint(SpringLayout.WEST, txtFirstName, 75, SpringLayout.WEST, lblFirstName);
        UserPanelAddAux.add(txtFirstName);


        //Last Name
        layoutForms.putConstraint(SpringLayout.SOUTH, lblLastName,40, SpringLayout.SOUTH, lblFirstName);
        layoutForms.putConstraint(SpringLayout.EAST, lblLastName, 0, SpringLayout.EAST, lblFirstName);
        UserPanelAddAux.add(lblLastName);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtLastName,44, SpringLayout.SOUTH, lblFirstName);
        layoutForms.putConstraint(SpringLayout.WEST, txtLastName, 0, SpringLayout.WEST, txtFirstName);
        UserPanelAddAux.add(txtLastName);


        //Phone
        layoutForms.putConstraint(SpringLayout.SOUTH, lblPhone,40, SpringLayout.SOUTH, lblLastName);
        layoutForms.putConstraint(SpringLayout.EAST, lblPhone, 0, SpringLayout.EAST, lblLastName);
        UserPanelAddAux.add(lblPhone);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtPhone,44, SpringLayout.SOUTH, lblLastName);
        layoutForms.putConstraint(SpringLayout.WEST, txtPhone, 0, SpringLayout.WEST, txtFirstName);
        UserPanelAddAux.add(txtPhone);


        //Address
        layoutForms.putConstraint(SpringLayout.SOUTH, lblAddress,40, SpringLayout.SOUTH, lblPhone);
        layoutForms.putConstraint(SpringLayout.EAST, lblAddress, 0, SpringLayout.EAST, lblPhone);
        UserPanelAddAux.add(lblAddress);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtAddress,43, SpringLayout.SOUTH, lblPhone);
        layoutForms.putConstraint(SpringLayout.WEST, txtAddress, 0, SpringLayout.WEST, txtFirstName);
        UserPanelAddAux.add(txtAddress);



        //SSN
        layoutForms.putConstraint(SpringLayout.SOUTH, lblSSN,40, SpringLayout.SOUTH, lblLastName);
        layoutForms.putConstraint(SpringLayout.EAST, lblSSN, 0, SpringLayout.EAST, lblLastName);
        UserPanelAddAux.add(lblSSN);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtSSN,44, SpringLayout.SOUTH, lblLastName);
        layoutForms.putConstraint(SpringLayout.WEST, txtSSN, 0, SpringLayout.WEST, txtFirstName);
        UserPanelAddAux.add(txtSSN);


        //Salary
        layoutForms.putConstraint(SpringLayout.SOUTH, lblSalary,40, SpringLayout.SOUTH, lblPhone);
        layoutForms.putConstraint(SpringLayout.EAST, lblSalary, 0, SpringLayout.EAST, lblPhone);
        UserPanelAddAux.add(lblSalary);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtSalary,43, SpringLayout.SOUTH, lblPhone);
        layoutForms.putConstraint(SpringLayout.WEST, txtSalary, 0, SpringLayout.WEST, txtFirstName);
        UserPanelAddAux.add(txtSalary);


        //Bank Account
        layoutForms.putConstraint(SpringLayout.SOUTH, lblAccount,40, SpringLayout.SOUTH, lblSalary);
        layoutForms.putConstraint(SpringLayout.EAST, lblAccount, 0, SpringLayout.EAST, lblSalary);
        UserPanelAddAux.add(lblAccount);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtAccount,43, SpringLayout.SOUTH, lblSalary);
        layoutForms.putConstraint(SpringLayout.WEST, txtAccount, 0, SpringLayout.WEST, txtFirstName);
        UserPanelAddAux.add(txtAccount);


    }




	/**
     * Sets up objects in search users screen - (layout and action listener)
     */		
    private void setUpSearchPanel(){


        JButton buttonSearchDatabase = new JButton("Show Users");
        buttonSearchDatabase.setPreferredSize(new Dimension(170, 50));
        buttonSearchDatabase.setFont(buttonFont);
        layoutForms.putConstraint(SpringLayout.NORTH, buttonSearchDatabase,20, SpringLayout.NORTH, UserPanelAddAux);
        layoutForms.putConstraint(SpringLayout.WEST, buttonSearchDatabase, 10, SpringLayout.WEST, UserPanelAddAux);
        UserPanelSearchAux.add(buttonSearchDatabase);


        //Table to show packages
        JTable table;
        model.setDataVector(null,userColumns);
        table = new JTable(model);
        JScrollPane scrollList = new JScrollPane(table);
        scrollList.setPreferredSize(new Dimension(700, 220));
        UserPanelSearchAux.add(scrollList);
        layoutForms.putConstraint(SpringLayout.NORTH, scrollList,70, SpringLayout.NORTH, buttonSearchDatabase);
        layoutForms.putConstraint(SpringLayout.WEST, scrollList, 0, SpringLayout.WEST, buttonSearchDatabase);


		buttonSearchDatabase.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
                model.setRowCount(0);

                Object[][] data;								
                data = ss.returnUserDataArray(); //Call ShippingStore method to get Array with User data				
                model.setDataVector(data,userColumns);
				
				logger.log(Level.INFO, "Result sent to User: Showing All Users info");
			}
		});	
			
    }



	/**
     * Sets up layout of labels and text fields in Update a User screen
     */	
    private void setUpInputValuesInUpdatePanel(){


        //ID
        layoutForms.putConstraint(SpringLayout.SOUTH, lblUpdateID,40, SpringLayout.SOUTH, typeOfUserPanel);
        layoutForms.putConstraint(SpringLayout.WEST, lblUpdateID, 40, SpringLayout.WEST, UserPanelAddAux);
        UserPanelUpdateAux.add(lblUpdateID);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtUpdateID,43, SpringLayout.SOUTH, typeOfUserPanel);
        layoutForms.putConstraint(SpringLayout.WEST, txtUpdateID, 75, SpringLayout.WEST, lblFirstName);
        UserPanelUpdateAux.add(txtUpdateID);


        //First Name
        layoutForms.putConstraint(SpringLayout.SOUTH, lblUpdateFirstName,40, SpringLayout.SOUTH, lblUpdateID);
        layoutForms.putConstraint(SpringLayout.WEST, lblUpdateFirstName, 0, SpringLayout.WEST, lblUpdateID);
        UserPanelUpdateAux.add(lblUpdateFirstName);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtUpdateFirstName,44, SpringLayout.SOUTH, lblUpdateID);
        layoutForms.putConstraint(SpringLayout.WEST, txtUpdateFirstName, 0, SpringLayout.WEST, txtUpdateID);
        UserPanelUpdateAux.add(txtUpdateFirstName);


        //Last Name
        layoutForms.putConstraint(SpringLayout.SOUTH, lblUpdateLastName,40, SpringLayout.SOUTH, lblUpdateFirstName);
        layoutForms.putConstraint(SpringLayout.EAST, lblUpdateLastName, 0, SpringLayout.EAST, lblUpdateFirstName);
        UserPanelUpdateAux.add(lblUpdateLastName);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtUpdateLastName,44, SpringLayout.SOUTH, lblUpdateFirstName);
        layoutForms.putConstraint(SpringLayout.WEST, txtUpdateLastName, 0, SpringLayout.WEST, txtUpdateFirstName);
        UserPanelUpdateAux.add(txtUpdateLastName);


        //Phone
        layoutForms.putConstraint(SpringLayout.SOUTH, lblUpdatePhone,40, SpringLayout.SOUTH, lblUpdateLastName);
        layoutForms.putConstraint(SpringLayout.EAST, lblUpdatePhone, 0, SpringLayout.EAST, lblUpdateLastName);
        UserPanelUpdateAux.add(lblUpdatePhone);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtUpdatePhone,44, SpringLayout.SOUTH, lblUpdateLastName);
        layoutForms.putConstraint(SpringLayout.WEST, txtUpdatePhone, 0, SpringLayout.WEST, txtUpdateFirstName);
        UserPanelUpdateAux.add(txtUpdatePhone);


        //Address
        layoutForms.putConstraint(SpringLayout.SOUTH, lblUpdateAddress,40, SpringLayout.SOUTH, lblUpdatePhone);
        layoutForms.putConstraint(SpringLayout.EAST, lblUpdateAddress, 0, SpringLayout.EAST, lblUpdatePhone);
        UserPanelUpdateAux.add(lblUpdateAddress);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtUpdateAddress,43, SpringLayout.SOUTH, lblUpdatePhone);
        layoutForms.putConstraint(SpringLayout.WEST, txtUpdateAddress, 0, SpringLayout.WEST, txtUpdateFirstName);
        UserPanelUpdateAux.add(txtUpdateAddress);


        //SSN
        layoutForms.putConstraint(SpringLayout.SOUTH, lblUpdateSSN,40, SpringLayout.SOUTH, lblUpdateLastName);
        layoutForms.putConstraint(SpringLayout.EAST, lblUpdateSSN, 0, SpringLayout.EAST, lblUpdateLastName);
        UserPanelUpdateAux.add(lblUpdateSSN);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtUpdateSSN,44, SpringLayout.SOUTH, lblUpdateLastName);
        layoutForms.putConstraint(SpringLayout.WEST, txtUpdateSSN, 0, SpringLayout.WEST, txtUpdateFirstName);
        UserPanelUpdateAux.add(txtUpdateSSN);


        //Salary
        layoutForms.putConstraint(SpringLayout.SOUTH, lblUpdateSalary,40, SpringLayout.SOUTH, lblUpdatePhone);
        layoutForms.putConstraint(SpringLayout.EAST, lblUpdateSalary, 0, SpringLayout.EAST, lblUpdatePhone);
        UserPanelUpdateAux.add(lblUpdateSalary);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtUpdateSalary,43, SpringLayout.SOUTH, lblUpdatePhone);
        layoutForms.putConstraint(SpringLayout.WEST, txtUpdateSalary, 0, SpringLayout.WEST, txtUpdateFirstName);
        UserPanelUpdateAux.add(txtUpdateSalary);


        //Bank Account
        layoutForms.putConstraint(SpringLayout.SOUTH, lblUpdateAccount,40, SpringLayout.SOUTH, lblUpdateSalary);
        layoutForms.putConstraint(SpringLayout.EAST, lblUpdateAccount, 0, SpringLayout.EAST, lblUpdateSalary);
        UserPanelUpdateAux.add(lblUpdateAccount);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtUpdateAccount,43, SpringLayout.SOUTH, lblUpdateSalary);
        layoutForms.putConstraint(SpringLayout.WEST, txtUpdateAccount, 0, SpringLayout.WEST, txtUpdateFirstName);
        UserPanelUpdateAux.add(txtUpdateAccount);


    }


	/**
     * Sets up User Type radio buttons in Update a User screen - (layout and action listeners)
     */	
    private void setUpRadioButtonInUpdatePanel(){

        //Setting up radio buttons
        TitledBorder titleTypePackage = BorderFactory.createTitledBorder("Type of User");
        titleTypePackage.setTitleFont(buttonFont);
        typeOfUserUpdatePanel.setBorder(titleTypePackage);

        ButtonGroup group = new ButtonGroup();
        group.add(rdbUpdateEmployee);
        group.add(rdbUpdateCustomer);

        typeOfUserUpdatePanel.add(rdbUpdateEmployee);
        typeOfUserUpdatePanel.add(rdbUpdateCustomer);
        layoutForms.putConstraint(SpringLayout.NORTH, typeOfUserUpdatePanel,20, SpringLayout.NORTH, UserPanelUpdateAux);
        layoutForms.putConstraint(SpringLayout.WEST, typeOfUserUpdatePanel, 10, SpringLayout.WEST, UserPanelUpdateAux);
        UserPanelUpdateAux.add(typeOfUserUpdatePanel);

        setVisibilityBasedOnUpdateUserType(true, false);

			
        //Radio button actions		
		rdbUpdateEmployee.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisibilityBasedOnUpdateUserType(true, false);
				logger.log(Level.INFO, "User Request: Select Employee User Type in Update Screen");
			}
		});		
		rdbUpdateCustomer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisibilityBasedOnUpdateUserType(false, true);
				logger.log(Level.INFO, "User Request: Select Customer User Type in Update Screen");
			}
		});			
		

    }

	/**
     * This method is used to change visibility of labels and text fields in the Update a User screen, 
	 * based on the User type
	 * @param isEmployeeVisible send true when user is an employee
	 * @param isCustomerVisible send true when user is a customer
     */	
    private void setVisibilityBasedOnUpdateUserType(boolean isEmployeeVisible, boolean isCustomerVisible){

        lblUpdatePhone.setVisible(isCustomerVisible);
        txtUpdatePhone.setVisible(isCustomerVisible);
        lblUpdateAddress.setVisible(isCustomerVisible);
        txtUpdateAddress.setVisible(isCustomerVisible);
        lblUpdateSSN.setVisible(isEmployeeVisible);
        txtUpdateSSN.setVisible(isEmployeeVisible);
        lblUpdateSalary.setVisible(isEmployeeVisible);
        txtUpdateSalary.setVisible(isEmployeeVisible);
        lblUpdateAccount.setVisible(isEmployeeVisible);
        txtUpdateAccount.setVisible(isEmployeeVisible);

    }



	/**
     * Sets up "Update User" button - (layout and action listener)
     */	
    private void setUpUpdateDatabaseButton(){

		//button Layout
        JButton buttonUpdateDatabase = new JButton("Update Database");
        buttonUpdateDatabase.setPreferredSize(new Dimension(140, 50));
        buttonUpdateDatabase.setFont(buttonFont);
        layoutForms.putConstraint(SpringLayout.SOUTH, buttonUpdateDatabase,65, SpringLayout.SOUTH, lblUpdateAccount);
        layoutForms.putConstraint(SpringLayout.WEST, buttonUpdateDatabase, 0, SpringLayout.WEST, txtUpdateFirstName);
        UserPanelUpdateAux.add(buttonUpdateDatabase);

		//Action for Update Users button
		buttonUpdateDatabase.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){        

				logger.log(Level.INFO, "User Request: Update User in Database");
				
				if (!isInteger(txtUpdateID.getText()) ) {
					JOptionPane.showMessageDialog(MainUserPanel, "Enter Valid ID");
					logger.log(Level.INFO, "Message Sent To User: Enter Valid ID");
				}
				else if (!ss.userExists(Integer.parseInt(txtUpdateID.getText())) ) {
					JOptionPane.showMessageDialog(MainUserPanel, "Enter Valid ID");
					logger.log(Level.INFO, "Message Sent To User: Enter Valid ID");
				}
				else if (ss.isEmployee(Integer.parseInt(txtUpdateID.getText()))  && rdbUpdateCustomer.isSelected() ) {
					JOptionPane.showMessageDialog(MainUserPanel, "User ID " + txtUpdateID.getText() + " is an Employee and not a Customer");
					logger.log(Level.INFO, "Message Sent To User: User ID " + txtUpdateID.getText() + " is an Employee and not a Customer");
				}
				else if (!ss.isEmployee(Integer.parseInt(txtUpdateID.getText()))  && rdbUpdateEmployee.isSelected() ) {
					JOptionPane.showMessageDialog(MainUserPanel, "User ID " + txtUpdateID.getText() + " is a Customer and not an Employee");
					logger.log(Level.INFO, "Message Sent To User: User ID " + txtUpdateID.getText() + " is a Customer and not an Employee");
				}
				else if (txtUpdateFirstName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(MainUserPanel, "Enter First Name");
					logger.log(Level.INFO, "Message Sent To User: Enter First Name");
				}
				else if (txtUpdateLastName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(MainUserPanel, "Enter Last Name");
					logger.log(Level.INFO, "Message Sent To User: Enter Last Name");
				}
				else if (txtUpdatePhone.getText().isEmpty() && rdbUpdateCustomer.isSelected()) {
					JOptionPane.showMessageDialog(MainUserPanel, "Enter Valid Phone Number");
					logger.log(Level.INFO, "Message Sent To User: Enter Valid Phone Number");
				}
				else if (txtUpdateAddress.getText().isEmpty() && rdbUpdateCustomer.isSelected()) {
					JOptionPane.showMessageDialog(MainUserPanel, "Enter Address");
					logger.log(Level.INFO, "Message Sent To User: Enter Address");
				}
				else if (!isInteger(txtUpdateSSN.getText()) && rdbUpdateEmployee.isSelected()) {
					JOptionPane.showMessageDialog(MainUserPanel, "Enter Valid SSN");
					logger.log(Level.INFO, "Message Sent To User: Enter Valid SSN");
				}
				else if (!isFloat(txtUpdateSalary.getText()) && rdbUpdateEmployee.isSelected()) {
					JOptionPane.showMessageDialog(MainUserPanel, "Enter Valid Monthly Salary");
					logger.log(Level.INFO, "Message Sent To User: Enter Valid Monthly Salary");
				}
				else if (!isInteger(txtUpdateAccount.getText()) && rdbUpdateEmployee.isSelected()) {
					JOptionPane.showMessageDialog(MainUserPanel, "Enter Bank Account");
					logger.log(Level.INFO, "Message Sent To User: Enter Bank Account");
				}
				else {
				
					//Call Shipping Store method to update user
					if (rdbUpdateEmployee.isSelected()) {
						ss.updateEmployee(Integer.parseInt(txtUpdateID.getText()),txtUpdateFirstName.getText(), txtUpdateLastName.getText(), Integer.parseInt(txtUpdateSSN.getText()), Float.parseFloat(txtUpdateSalary.getText()), Integer.parseInt(txtUpdateAccount.getText()));
					} else if (rdbUpdateCustomer.isSelected()) {
						ss.updateCustomer(Integer.parseInt(txtUpdateID.getText()), txtUpdateFirstName.getText(), txtUpdateLastName.getText(), txtUpdatePhone.getText(), txtUpdateAddress.getText());
					}

					//Clean text fields in Update a User screen
					txtUpdateID.setText("");
					txtUpdateFirstName.setText("");
					txtUpdateLastName.setText("");
					txtUpdatePhone.setText("");
					txtUpdateAddress.setText("");
					txtUpdateSSN.setText("");
					txtUpdateSalary.setText("");
					txtUpdateAccount.setText("");
				
					JOptionPane.showMessageDialog(MainUserPanel, "User updated in the Database!");
					logger.log(Level.INFO, "Message Sent To User: User updated in the Database!");
				}
       		}
		});
    }


}
