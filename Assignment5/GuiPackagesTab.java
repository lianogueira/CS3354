package shippingstore;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.Date;
import java.text.*;
import static java.lang.System.out;
import java.util.logging.*;


/**
 * Configures GUI for Package Tab <br><br>
 *
 * @author Tyler Hooks and Lia Nogueira de Moura
 * @version 11/20/2017
 */
 
public class GuiPackagesTab {

    private JPanel MainPackagePanel;    
	private ShippingStore ss = new ShippingStore();
	private Logger logger = Logger.getLogger("shippingstore");;
	

    //New JPanels used in the Package Tab
    private SpringLayout layoutForms = new SpringLayout();
    private JPanel PackagePanelButtons = new JPanel(new GridLayout());
    private JPanel PackagePanelAdd = new JPanel(new BorderLayout());
    private JPanel PackagePanelAddAux = new JPanel(layoutForms);
    private JPanel PackagePanelDelete = new JPanel(new BorderLayout());
    private JPanel PackagePanelDeleteAux = new JPanel(layoutForms);
    private JPanel PackagePanelComplete = new JPanel(new BorderLayout());
    private JPanel PackagePanelCompleteAux = new JPanel(layoutForms);
    private JPanel PackagePanelSearch = new JPanel(new BorderLayout());
    private JPanel PackagePanelSearchAux = new JPanel(layoutForms);

    //Main Buttons
    private JButton buttonAdd = new JButton("Add");
    private JButton buttonDelete = new JButton("Delete");
    private JButton buttonComplete = new JButton("Transactions");
    private JButton buttonSearch = new JButton("Search");
    private Font buttonFont = new Font("Arial", Font.PLAIN, 13);
    private Dimension buttonDimension = new Dimension(5, 60);

    //Radio button for package type
    private JPanel typeOfPackagePanel = new JPanel(new FlowLayout());
    private JRadioButton rdbEnvelope = new JRadioButton("Envelope     ", true);
    private JRadioButton rdbBox = new JRadioButton("Box         ");
    private JRadioButton rdbCrate = new JRadioButton("Crate          ");
    private JRadioButton rdbDrum = new JRadioButton("Drum          ");

    //Labels and Text fields for Add Panel
    private JLabel lblTrackingNumber = new JLabel("Tracking Number: ");
    private JTextField txtTrackingNumber = new JTextField("", 15);
    private JLabel lblSpecification= new JLabel("Specification: ");
    private String[] specificationString = { "Fragile", "Books", "Catalogs", "Do-not-Bend           ", "N/A" };
    private JComboBox<String> specificationList = new JComboBox<>(specificationString);	 
    private JLabel lblMailingClass= new JLabel("Mailing Class: ");
    private String[] mailingClassString = { "First-Class              ", "Priority", "Retail", "Ground", "Metro" };
    private JComboBox<String> mailingClassList = new JComboBox<>(mailingClassString);
    private JLabel lblHeight = new JLabel("Height: ");
    private JTextField txtHeight = new JTextField("", 10);
    private JLabel lblWidth = new JLabel("Width: ");
    private JTextField txtWidth = new JTextField("", 10);
    private JLabel lblLargestDimension = new JLabel("Largest Dimension: ");
    private JTextField txtLargestDimension = new JTextField("", 10);
    private JLabel lblVolume = new JLabel("Volume: ");
    private JTextField txtVolume = new JTextField("", 10);
    private JLabel lblMaximumLoad = new JLabel("Maximum Load: ");
    private JTextField txtMaximumLoad = new JTextField("", 10);
    private JLabel lblContent = new JLabel("Content: ");
    private JTextField txtContent = new JTextField("", 10);
    private JLabel lblMaterial = new JLabel("Material: ");
    private String[] materialString = { "Plastic                     ", "Fiber"};
    private JComboBox<String> materialList = new JComboBox<>(materialString);
    private JLabel lblDiameter = new JLabel("Diameter: ");
    private JTextField txtDiameter = new JTextField("", 10);


    ///Delete Panel objects
    private JLabel lblDeleteTrackingNumber = new JLabel("Tracking Number: ");
    private JTextField txtDeleteTrackingNumber = new JTextField("", 15);


    //Search Panel objects    
    private JLabel lblSearchTrackingNumber = new JLabel("Tracking Number: ");
    private JTextField txtSearchTrackingNumber = new JTextField("", 15);
    private DefaultTableModel model = new DefaultTableModel();
    String[] packageColumns = new String[] {"Type", "Tracking Number", "Specification", "MailingList", "Custom 1", "Custom 2"};
	
	
	//Transactions Panel objects
	private JLabel lblCustomerID = new JLabel("Customer ID: ");
    private JTextField txtCustomerID = new JTextField("", 13);
	private JLabel lblEmployeeID = new JLabel("Employee ID: ");
    private JTextField txtEmployeeID = new JTextField("", 13);		
	private JLabel lblTranTrackingNumber = new JLabel("Tracking Number: ");
    private JTextField txtTranTrackingNumber = new JTextField("", 13);		
	private JLabel lblShippingDate = new JLabel("Shipping Date: ");
    private JTextField txtShippingDate = new JTextField("", 13);	
	private JLabel lblDeliveryDate = new JLabel("Delivery Date: ");
    private JTextField txtDeliveryDate = new JTextField("", 13);	
	private JLabel lblPrice = new JLabel("Price: ");
    private JTextField txtPrice = new JTextField("", 13);		
	private DefaultTableModel modelTransactions = new DefaultTableModel();
    String[] transactionsColumns = new String[] {"Customer ID", "Employee ID", "Tracking Number", "Shipping Date", "Delivery Date", "Price"};

	

     /**
     * Class Constructor
	 * Initializes MainUserPanel, ShipingStore and Logger variables
     */
    public GuiPackagesTab(ShippingStore ss, JPanel MainPackagePanel, Logger logger) {
	
		this.MainPackagePanel = MainPackagePanel;
        this.ss = ss;
		this.logger = logger;
		
        initGui();
    }



	 /**
     * Calls functions to initialize all GUI components in the Packages Tab
     */
    public void initGui() {

		logger.log(Level.INFO, "Setting up GUI in Package Tab");
		
				
        //Setting up inside of MainPackagePanel
        MainPackagePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        MainPackagePanel.add(PackagePanelButtons, BorderLayout.PAGE_START);

		
        //Set up Main buttons
        setUpMainButtonsPanel();

		
        //Setting up panel for add
        TitledBorder titleAdd = BorderFactory.createTitledBorder("Add New package Order");
        titleAdd.setTitleFont(buttonFont);
        PackagePanelAdd.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        PackagePanelAdd.add(PackagePanelAddAux);
        PackagePanelAddAux.setBorder(titleAdd);
		logger.log(Level.INFO, "Setting up GUI for Add a package panel");
		
		
        //Setting up panel for delete
        TitledBorder titleDelete = BorderFactory.createTitledBorder("Delete Package Order");
        titleDelete.setTitleFont(buttonFont);
        PackagePanelDelete.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        PackagePanelDelete.add(PackagePanelDeleteAux);
        PackagePanelDeleteAux.setBorder(titleDelete);
		logger.log(Level.INFO, "Setting up GUI for Delete a package panel");
		
		
        //Setting up panel for Complete
        TitledBorder titleComplete = BorderFactory.createTitledBorder("Completed Order Transactions");
        titleComplete.setTitleFont(buttonFont);
        PackagePanelComplete.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        PackagePanelComplete.add(PackagePanelCompleteAux);
        PackagePanelCompleteAux.setBorder(titleComplete);
		logger.log(Level.INFO, "Setting up GUI for Transactions panel");
		

        //Setting up panel for search
        TitledBorder titleSearch = BorderFactory.createTitledBorder("Search Orders");
        titleSearch.setTitleFont(buttonFont);
        PackagePanelSearch.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        PackagePanelSearch.add(PackagePanelSearchAux);
        PackagePanelSearchAux.setBorder(titleSearch);
		logger.log(Level.INFO, "Setting up GUI for Package Search panel");
		

        //Content of Add Panel
        setUpInputValuesInAddPanel();
        setUpRadioButtonInAddPanel();
        setUpAddToDatabaseButton();
		logger.log(Level.INFO, "Adding GUI content in ADD panel");
		
		
        //Content of Delete Panel
        setUpDeletePanel();
		logger.log(Level.INFO, "Adding GUI content in Delete panel");
		
		
		//Content of Transactions Panel
		setUpInputValuesInTransPanel();
		logger.log(Level.INFO, "Adding GUI content in Transactions panel");
				
				
        //Content of Search Panel
        setUpSearchPanel();
		setUpCompleteTransButton();
		setUpShowCompleteTransButton();
		logger.log(Level.INFO, "Adding GUI content in Search panel");
		

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
     * This method can be used to verify if a string is a Date or not
     *
     * @param s a string that will be used for the verification (Data type: String)     
     * @return returns true if string can be parsed as a Date in  the format MM/dd/yyyy
     */	
    public static boolean isDate(String s) {
		Date shippingDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		try {
			shippingDate = sdf.parse(s);
		} catch (ParseException e) {
			return false;
		}			
		// if exception isn't thrown, then it is a date
        return true;
    }	

    
    /**
    * Sets up "Add Package to Database" button - (layout and action listener)
    */
    private void setUpAddToDatabaseButton(){

		//button Layout
        JButton buttonAddDatabase = new JButton("Add to Database");
        buttonAddDatabase.setPreferredSize(new Dimension(140, 50));
        buttonAddDatabase.setFont(buttonFont);
        layoutForms.putConstraint(SpringLayout.SOUTH, buttonAddDatabase,65, SpringLayout.SOUTH, lblWidth);
        layoutForms.putConstraint(SpringLayout.WEST, buttonAddDatabase, 0, SpringLayout.WEST, txtTrackingNumber);
        PackagePanelAddAux.add(buttonAddDatabase);
			
		//Action for Add Package to Database button
		buttonAddDatabase.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			
			logger.log(Level.INFO, "User Request: Add Package to Database");

			if (txtTrackingNumber.getText().length() != 5) {
                JOptionPane.showMessageDialog(MainPackagePanel, "Tracking Number must have 5 characters");
				logger.log(Level.INFO, "Message sent to user: Tracking Number must have 5 characters");
            }
            else if (ss.packageExists(txtTrackingNumber.getText())) {
                JOptionPane.showMessageDialog(MainPackagePanel, "Tracking Number already exist");
				logger.log(Level.INFO, "Message sent to user: Tracking Number already exist");
            }
            else if (!isInteger(txtHeight.getText()) && rdbEnvelope.isSelected()) {
                JOptionPane.showMessageDialog(MainPackagePanel, "Heigh must be a number");
				logger.log(Level.INFO, "Message sent to user: Heigh must be a number");
            }
            else if (!isInteger(txtWidth.getText()) && rdbEnvelope.isSelected()) {
                JOptionPane.showMessageDialog(MainPackagePanel, "Width must be a number");
				logger.log(Level.INFO, "Message sent to user: Width must be a number");
            }
            else if (!isInteger(txtLargestDimension.getText()) && rdbBox.isSelected()) {
                JOptionPane.showMessageDialog(MainPackagePanel, "Largest Dimension must be a number");
				logger.log(Level.INFO, "Message sent to user: Largest Dimension must be a number");
            }
            else if (!isInteger(txtVolume.getText()) && rdbBox.isSelected()) {
                JOptionPane.showMessageDialog(MainPackagePanel, "Volume must be a number");
				logger.log(Level.INFO, "Message sent to user: Volume must be a number");
            }
            else if (!isFloat(txtMaximumLoad.getText()) && rdbCrate.isSelected()) {
                JOptionPane.showMessageDialog(MainPackagePanel, "Maximum Load must be a number");
				logger.log(Level.INFO, "Message sent to user: Maximum Load must be a number");
            }
            else if (!isFloat(txtDiameter.getText()) && rdbDrum.isSelected()) {
                JOptionPane.showMessageDialog(MainPackagePanel, "Diameter must be a number");
				logger.log(Level.INFO, "Message sent to user: Diameter must be a number");
            }
            else {
			
                if (rdbEnvelope.isSelected()) {
                    ss.addEnvelope(txtTrackingNumber.getText(), specificationList.getSelectedItem().toString().replace(" ", ""), mailingClassList.getSelectedItem().toString().replace(" ", ""), Integer.parseInt(txtHeight.getText()), Integer.parseInt(txtWidth.getText()));
                } else if (rdbBox.isSelected()) {
                    ss.addBox(txtTrackingNumber.getText(), specificationList.getSelectedItem().toString().replace(" ", ""), mailingClassList.getSelectedItem().toString().replace(" ", ""), Integer.parseInt(txtLargestDimension.getText()), Integer.parseInt(txtVolume.getText()));
                } else if (rdbCrate.isSelected()) {
                    ss.addCrate(txtTrackingNumber.getText(), specificationList.getSelectedItem().toString().replace(" ", ""), mailingClassList.getSelectedItem().toString().replace(" ", ""), Float.parseFloat(txtMaximumLoad.getText()), txtContent.getText());
                } else if (rdbDrum.isSelected()) {
                    ss.addDrum(txtTrackingNumber.getText(), specificationList.getSelectedItem().toString().replace(" ", ""), mailingClassList.getSelectedItem().toString().replace(" ", ""), materialList.getSelectedItem().toString().replace(" ", ""), Float.parseFloat(txtDiameter.getText()));
                }

                txtTrackingNumber.setText("");
                txtContent.setText("");
                txtDiameter.setText("");
                txtHeight.setText("");
                txtLargestDimension.setText("");
                txtMaximumLoad.setText("");
                txtVolume.setText("");
                txtWidth.setText("");

                
                JOptionPane.showMessageDialog(MainPackagePanel, "Package added to the Database!");
				logger.log(Level.INFO, "Message sent to user: Package added to the Database");
            }
			
			  }
			}
		);
		
    }


	/**
     * Sets up Main Package Tab button - (layout and action listener)
     */		
    private void setUpMainButtonsPanel(){

		
        buttonAdd.setPreferredSize(buttonDimension);
        buttonDelete.setPreferredSize(buttonDimension);
        buttonComplete.setPreferredSize(buttonDimension);
        buttonSearch.setPreferredSize(buttonDimension);

        buttonAdd.setFont(buttonFont);
        buttonDelete.setFont(buttonFont);
        buttonComplete.setFont(buttonFont);
        buttonSearch.setFont(buttonFont);

        PackagePanelButtons.add(buttonAdd);
        PackagePanelButtons.add(buttonDelete);
        PackagePanelButtons.add(buttonComplete);
        PackagePanelButtons.add(buttonSearch);


        //Setting up button actions
		
		buttonAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			      
				MainPackagePanel.remove(PackagePanelDelete);
				MainPackagePanel.remove(PackagePanelComplete);
				MainPackagePanel.remove(PackagePanelSearch);
				MainPackagePanel.setVisible(false);
				MainPackagePanel.add(PackagePanelAdd, BorderLayout.CENTER);
				MainPackagePanel.setVisible(true);
                logger.log(Level.INFO, "User Request: Add Button Selected");
			}
		});


		buttonDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			      
				MainPackagePanel.remove(PackagePanelAdd);
				MainPackagePanel.remove(PackagePanelComplete);
				MainPackagePanel.remove(PackagePanelSearch);
				MainPackagePanel.setVisible(false);
				MainPackagePanel.add(PackagePanelDelete, BorderLayout.CENTER);
				MainPackagePanel.setVisible(true);
                logger.log(Level.INFO, "User Request: Delete Button Selected");
			}
		});
		
		
		buttonComplete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			      
				MainPackagePanel.remove(PackagePanelAdd);
				MainPackagePanel.remove(PackagePanelDelete);
				MainPackagePanel.remove(PackagePanelSearch);
				MainPackagePanel.setVisible(false);
				MainPackagePanel.add(PackagePanelComplete, BorderLayout.CENTER);
				MainPackagePanel.setVisible(true);
				logger.log(Level.INFO, "User Request: See/Complete Transactions Button Selected\"");
			}
		});		
		
		buttonSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			      
				MainPackagePanel.remove(PackagePanelAdd);
				MainPackagePanel.remove(PackagePanelDelete);
				MainPackagePanel.remove(PackagePanelComplete);
				MainPackagePanel.setVisible(false);
				MainPackagePanel.add(PackagePanelSearch, BorderLayout.CENTER);
				MainPackagePanel.setVisible(true);
				model.setRowCount(0);
				logger.log(Level.INFO, "User Request: Search Packages Button Selected");
			}
		});				


    }

	
	/**
     * This method is used to change visibility of label and text fields in the Add a package screen, 
	 * based on the package type
	 * @param isEnvelopeVisible send true when user is an envelope
	 * @param isBoxVisible send true when user is a Box
	 * @param isCrateVisible send true when user is a Crate
	 * @param isDrumVisible send true when user is a Drum
     */	
    private void setVisibilityBasedOnPackageType(boolean isEnvelopeVisible, boolean isBoxVisible, boolean isCrateVisible, boolean isDrumVisible){

        lblHeight.setVisible(isEnvelopeVisible);
        txtHeight.setVisible(isEnvelopeVisible);
        lblWidth.setVisible(isEnvelopeVisible);
        txtWidth.setVisible(isEnvelopeVisible);
        lblLargestDimension.setVisible(isBoxVisible);
        txtLargestDimension.setVisible(isBoxVisible);
        lblVolume.setVisible(isBoxVisible);
        txtVolume.setVisible(isBoxVisible);
        lblMaximumLoad.setVisible(isCrateVisible);
        txtMaximumLoad.setVisible(isCrateVisible);
        lblContent.setVisible(isCrateVisible);
        txtContent.setVisible(isCrateVisible);
        lblMaterial.setVisible(isDrumVisible);
        materialList.setVisible(isDrumVisible);
        lblDiameter.setVisible(isDrumVisible);
        txtDiameter.setVisible(isDrumVisible);
    }


	/**
     * Sets up package type radio buttons - (layout and action listeners)
     */		
    private void setUpRadioButtonInAddPanel(){

        //Setting up radio buttons
        TitledBorder titleTypePackage = BorderFactory.createTitledBorder("Type of Package");
        titleTypePackage.setTitleFont(buttonFont);
        typeOfPackagePanel.setBorder(titleTypePackage);

        ButtonGroup group = new ButtonGroup();
        group.add(rdbEnvelope);
        group.add(rdbBox);
        group.add(rdbCrate);
        group.add(rdbDrum);

        typeOfPackagePanel.add(rdbEnvelope);
        typeOfPackagePanel.add(rdbBox);
        typeOfPackagePanel.add(rdbCrate);
        typeOfPackagePanel.add(rdbDrum);
        layoutForms.putConstraint(SpringLayout.NORTH, typeOfPackagePanel,20, SpringLayout.NORTH, PackagePanelAddAux);
        layoutForms.putConstraint(SpringLayout.WEST, typeOfPackagePanel, 10, SpringLayout.WEST, PackagePanelAddAux);
        PackagePanelAddAux.add(typeOfPackagePanel);

        setVisibilityBasedOnPackageType(true, false, false, false);

		
		//Radio button actions
		rdbEnvelope.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){			      
				setVisibilityBasedOnPackageType(true, false, false, false);
				logger.log(Level.INFO, "User Request: Select Envelope package Type in Add package screen");
			}
		});
		
		rdbBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){	
				setVisibilityBasedOnPackageType(false, true, false, false);	
				logger.log(Level.INFO, "User Request: Select Box package Type in Add package screen");				
			}
		});
		
		rdbCrate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){			      
				setVisibilityBasedOnPackageType(false, false, true, false);
				logger.log(Level.INFO, "User Request: Select Crate package Type in Add package screen");				
			}
		});
				
		rdbDrum.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){			      
				setVisibilityBasedOnPackageType(false, false, false, true);
				logger.log(Level.INFO, "User Request: Select Drum package Type in Add package screen");				
			}
		});
		
    }

	/**
     * Sets up layout of labels and text fields in Add a package screen
     */		
    private void setUpInputValuesInAddPanel(){
        //Tracking Number
        layoutForms.putConstraint(SpringLayout.SOUTH, lblTrackingNumber,40, SpringLayout.SOUTH, typeOfPackagePanel);
        layoutForms.putConstraint(SpringLayout.WEST, lblTrackingNumber, 18, SpringLayout.WEST, PackagePanelAddAux);
        PackagePanelAddAux.add(lblTrackingNumber);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtTrackingNumber,43, SpringLayout.SOUTH, typeOfPackagePanel);
        layoutForms.putConstraint(SpringLayout.WEST, txtTrackingNumber, 110, SpringLayout.WEST, lblTrackingNumber);
        PackagePanelAddAux.add(txtTrackingNumber);


        //Specification
        layoutForms.putConstraint(SpringLayout.SOUTH, lblSpecification,40, SpringLayout.SOUTH, lblTrackingNumber);
        layoutForms.putConstraint(SpringLayout.EAST, lblSpecification, 0, SpringLayout.EAST, lblTrackingNumber);
        PackagePanelAddAux.add(lblSpecification);

        layoutForms.putConstraint(SpringLayout.SOUTH, specificationList,44, SpringLayout.SOUTH, lblTrackingNumber);
        layoutForms.putConstraint(SpringLayout.WEST, specificationList, 0, SpringLayout.WEST, txtTrackingNumber);
        PackagePanelAddAux.add(specificationList);


        //Mailing Class:
        layoutForms.putConstraint(SpringLayout.SOUTH, lblMailingClass,40, SpringLayout.SOUTH, lblSpecification);
        layoutForms.putConstraint(SpringLayout.EAST, lblMailingClass, 0, SpringLayout.EAST, lblSpecification);
        PackagePanelAddAux.add(lblMailingClass);

        layoutForms.putConstraint(SpringLayout.SOUTH, mailingClassList,44, SpringLayout.SOUTH, lblSpecification);
        layoutForms.putConstraint(SpringLayout.WEST, mailingClassList, 0, SpringLayout.WEST, txtTrackingNumber);
        PackagePanelAddAux.add(mailingClassList);

        //Height
        layoutForms.putConstraint(SpringLayout.SOUTH, lblHeight,40, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.EAST, lblHeight, 0, SpringLayout.EAST, lblMailingClass);
        PackagePanelAddAux.add(lblHeight);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtHeight,43, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.WEST, txtHeight, 0, SpringLayout.WEST, txtTrackingNumber);
        PackagePanelAddAux.add(txtHeight);

        //Width
        layoutForms.putConstraint(SpringLayout.SOUTH, lblWidth,40, SpringLayout.SOUTH, lblHeight);
        layoutForms.putConstraint(SpringLayout.EAST, lblWidth, 0, SpringLayout.EAST, lblHeight);
        PackagePanelAddAux.add(lblWidth);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtWidth,43, SpringLayout.SOUTH, lblHeight);
        layoutForms.putConstraint(SpringLayout.WEST, txtWidth, 0, SpringLayout.WEST, txtTrackingNumber);
        PackagePanelAddAux.add(txtWidth);

        // Largest dimension
        layoutForms.putConstraint(SpringLayout.SOUTH, lblLargestDimension,40, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.EAST, lblLargestDimension, 0, SpringLayout.EAST, lblMailingClass);
        PackagePanelAddAux.add(lblLargestDimension);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtLargestDimension,43, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.WEST, txtLargestDimension, 0, SpringLayout.WEST, txtTrackingNumber);
        PackagePanelAddAux.add(txtLargestDimension);

        //Volume
        layoutForms.putConstraint(SpringLayout.SOUTH, lblVolume,40, SpringLayout.SOUTH, lblLargestDimension);
        layoutForms.putConstraint(SpringLayout.EAST, lblVolume, 0, SpringLayout.EAST, lblLargestDimension);
        PackagePanelAddAux.add(lblVolume);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtVolume,43, SpringLayout.SOUTH, lblLargestDimension);
        layoutForms.putConstraint(SpringLayout.WEST, txtVolume, 0, SpringLayout.WEST, txtTrackingNumber);
        PackagePanelAddAux.add(txtVolume);

        //Maximum Load
        layoutForms.putConstraint(SpringLayout.SOUTH, lblMaximumLoad,40, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.EAST, lblMaximumLoad, 0, SpringLayout.EAST, lblMailingClass);
        PackagePanelAddAux.add(lblMaximumLoad);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtMaximumLoad,43, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.WEST, txtMaximumLoad, 0, SpringLayout.WEST, txtTrackingNumber);
        PackagePanelAddAux.add(txtMaximumLoad);

        //content
        layoutForms.putConstraint(SpringLayout.SOUTH, lblContent,40, SpringLayout.SOUTH, lblLargestDimension);
        layoutForms.putConstraint(SpringLayout.EAST, lblContent, 0, SpringLayout.EAST, lblLargestDimension);
        PackagePanelAddAux.add(lblContent);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtContent,43, SpringLayout.SOUTH, lblMaximumLoad);
        layoutForms.putConstraint(SpringLayout.WEST, txtContent, 0, SpringLayout.WEST, txtTrackingNumber);
        PackagePanelAddAux.add(txtContent);


        //Material
        layoutForms.putConstraint(SpringLayout.SOUTH, lblMaterial,40, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.EAST, lblMaterial, 0, SpringLayout.EAST, lblMailingClass);
        PackagePanelAddAux.add(lblMaterial);

        layoutForms.putConstraint(SpringLayout.SOUTH, materialList,44, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.WEST, materialList, 0, SpringLayout.WEST, txtTrackingNumber);
        PackagePanelAddAux.add(materialList);


        //Diameter
        layoutForms.putConstraint(SpringLayout.SOUTH, lblDiameter,40, SpringLayout.SOUTH, lblMaterial);
        layoutForms.putConstraint(SpringLayout.EAST, lblDiameter, 0, SpringLayout.EAST, lblMaterial);
        PackagePanelAddAux.add(lblDiameter);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtDiameter,43, SpringLayout.SOUTH, lblMaterial);
        layoutForms.putConstraint(SpringLayout.WEST, txtDiameter, 0, SpringLayout.WEST, txtTrackingNumber);
        PackagePanelAddAux.add(txtDiameter);
    }


	/**
     * Sets up delete a package button - (layout and action listeners)
     */		
    private void setUpDeletePanel(){
       
	   //Tracking Number
        layoutForms.putConstraint(SpringLayout.NORTH, lblDeleteTrackingNumber,20, SpringLayout.NORTH, PackagePanelDeleteAux);
        layoutForms.putConstraint(SpringLayout.WEST, lblDeleteTrackingNumber, 10, SpringLayout.WEST, PackagePanelDeleteAux);
        PackagePanelDeleteAux.add(lblDeleteTrackingNumber);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtDeleteTrackingNumber,5, SpringLayout.SOUTH, lblDeleteTrackingNumber);
        layoutForms.putConstraint(SpringLayout.WEST, txtDeleteTrackingNumber, 110, SpringLayout.WEST, lblDeleteTrackingNumber);
        PackagePanelDeleteAux.add(txtDeleteTrackingNumber);

		//Delete from database button
        JButton buttonDeleteDatabase = new JButton("Delete From Database");
        buttonDeleteDatabase.setPreferredSize(new Dimension(170, 50));
        buttonDeleteDatabase.setFont(buttonFont);
        layoutForms.putConstraint(SpringLayout.SOUTH, buttonDeleteDatabase,65, SpringLayout.SOUTH, lblDeleteTrackingNumber);
        layoutForms.putConstraint(SpringLayout.WEST, buttonDeleteDatabase, 0, SpringLayout.WEST, txtDeleteTrackingNumber);
        PackagePanelDeleteAux.add(buttonDeleteDatabase);
	

		buttonDeleteDatabase.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){			      
				if (!ss.packageExists(txtDeleteTrackingNumber.getText().toString())){
					JOptionPane.showMessageDialog(MainPackagePanel, "Tracking Number not found");
					logger.log(Level.INFO, "Message Sent to User: Tracking Number not found");				
				}
				else {

					ss.deletePackage(txtDeleteTrackingNumber.getText().toString());

					txtDeleteTrackingNumber.setText("");
					
					JOptionPane.showMessageDialog(MainPackagePanel, "Package deleted from the Database!");
					logger.log(Level.INFO, "Message Sent to User: Package deleted from the Database!");				
					
				}	
			}
		});
				

    }


	/**
     * Sets up objects in search a package screen - (layout and action listener)
     */	
    private void setUpSearchPanel(){

        //Tracking Number
        layoutForms.putConstraint(SpringLayout.NORTH, lblSearchTrackingNumber,20, SpringLayout.NORTH, PackagePanelDeleteAux);
        layoutForms.putConstraint(SpringLayout.WEST, lblSearchTrackingNumber, 10, SpringLayout.WEST, PackagePanelDeleteAux);
        PackagePanelSearchAux.add(lblSearchTrackingNumber);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtSearchTrackingNumber,5, SpringLayout.SOUTH, lblSearchTrackingNumber);
        layoutForms.putConstraint(SpringLayout.WEST, txtSearchTrackingNumber, 110, SpringLayout.WEST, lblSearchTrackingNumber);
        PackagePanelSearchAux.add(txtSearchTrackingNumber);

		//Info label
		JLabel lblSearchInfo = new JLabel("<html> Enter a tracking number to see one specific Tracking Number <br> or leave text field blank to see all packages </html>");	
		layoutForms.putConstraint(SpringLayout.SOUTH, lblSearchInfo, 7, SpringLayout.SOUTH, lblSearchTrackingNumber);
        layoutForms.putConstraint(SpringLayout.WEST, lblSearchInfo, 300, SpringLayout.WEST, lblSearchTrackingNumber);		
		lblSearchInfo.setFont(new Font("Arial", Font.PLAIN, 11));
        PackagePanelSearchAux.add(lblSearchInfo);
		
		
		//Show Packages button
        JButton buttonSearchDatabase = new JButton("Show packages");
        buttonSearchDatabase.setPreferredSize(new Dimension(170, 50));
        buttonSearchDatabase.setFont(buttonFont);
        layoutForms.putConstraint(SpringLayout.SOUTH, buttonSearchDatabase,65, SpringLayout.SOUTH, lblSearchTrackingNumber);
        layoutForms.putConstraint(SpringLayout.WEST, buttonSearchDatabase, 0, SpringLayout.WEST, txtSearchTrackingNumber);
        PackagePanelSearchAux.add(buttonSearchDatabase);


        //Table to show packages
        JTable table;
        model.setDataVector(null,packageColumns);
        table = new JTable(model);
        JScrollPane scrollList = new JScrollPane(table);
        scrollList.setPreferredSize(new Dimension(685, 220));
        PackagePanelSearchAux.add(scrollList);
        layoutForms.putConstraint(SpringLayout.NORTH, scrollList,100, SpringLayout.NORTH, lblSearchTrackingNumber);
        layoutForms.putConstraint(SpringLayout.WEST, scrollList, 5, SpringLayout.WEST, lblSearchTrackingNumber);

		
		
		buttonSearchDatabase.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){			      
				if (!ss.packageExists(txtSearchTrackingNumber.getText()) && !txtSearchTrackingNumber.getText().isEmpty() ){
					JOptionPane.showMessageDialog(MainPackagePanel, "Tracking Number not found");
					model.setRowCount(0);
					logger.log(Level.INFO, "Message sent to user: Tracking Number not found");				
				}
				else {

					model.setRowCount(0);

					Object[][] data;
					data = ss.returnPackageDataArray(txtSearchTrackingNumber.getText());
					model.setDataVector(data,packageColumns);

					logger.log(Level.INFO, "Result sent to User: Showing packages info");	
					
				}
			}
		});

    }
	
	
	
	/**
     * Sets up labels and text fields in Transactions screen
     */		
    private void setUpInputValuesInTransPanel(){
        		
		//CustomerID
		layoutForms.putConstraint(SpringLayout.NORTH, lblCustomerID,20, SpringLayout.NORTH, PackagePanelCompleteAux);
        layoutForms.putConstraint(SpringLayout.WEST, lblCustomerID, 40, SpringLayout.WEST, PackagePanelCompleteAux);
        PackagePanelCompleteAux.add(lblCustomerID);

        layoutForms.putConstraint(SpringLayout.NORTH, txtCustomerID,20, SpringLayout.NORTH, PackagePanelCompleteAux);
        layoutForms.putConstraint(SpringLayout.WEST, txtCustomerID, 90, SpringLayout.WEST, lblCustomerID);
        PackagePanelCompleteAux.add(txtCustomerID);


        //EmployeeID
        layoutForms.putConstraint(SpringLayout.SOUTH, lblEmployeeID,30, SpringLayout.SOUTH, lblCustomerID);
        layoutForms.putConstraint(SpringLayout.EAST, lblEmployeeID, 0, SpringLayout.EAST, lblCustomerID);
        PackagePanelCompleteAux.add(lblEmployeeID);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtEmployeeID,34, SpringLayout.SOUTH, lblCustomerID);
        layoutForms.putConstraint(SpringLayout.WEST, txtEmployeeID, 0, SpringLayout.WEST, txtCustomerID);
        PackagePanelCompleteAux.add(txtEmployeeID);

		
        //TrackingNumber
        layoutForms.putConstraint(SpringLayout.SOUTH, lblTranTrackingNumber,30, SpringLayout.SOUTH, lblEmployeeID);
        layoutForms.putConstraint(SpringLayout.EAST, lblTranTrackingNumber, 0, SpringLayout.EAST, lblEmployeeID);
        PackagePanelCompleteAux.add(lblTranTrackingNumber);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtTranTrackingNumber,34, SpringLayout.SOUTH, lblEmployeeID);
        layoutForms.putConstraint(SpringLayout.WEST, txtTranTrackingNumber, 0, SpringLayout.WEST, txtCustomerID);
        PackagePanelCompleteAux.add(txtTranTrackingNumber);

				
        //Shipping Date
        layoutForms.putConstraint(SpringLayout.SOUTH, lblShippingDate,30, SpringLayout.SOUTH, lblTranTrackingNumber);
        layoutForms.putConstraint(SpringLayout.EAST, lblShippingDate, 0, SpringLayout.EAST, lblTranTrackingNumber);
        PackagePanelCompleteAux.add(lblShippingDate);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtShippingDate,34, SpringLayout.SOUTH, lblTranTrackingNumber);
        layoutForms.putConstraint(SpringLayout.WEST, txtShippingDate, 0, SpringLayout.WEST, txtCustomerID);
        PackagePanelCompleteAux.add(txtShippingDate);

				
        //Delivery DAte
        layoutForms.putConstraint(SpringLayout.SOUTH, lblDeliveryDate,30, SpringLayout.SOUTH, lblShippingDate);
        layoutForms.putConstraint(SpringLayout.EAST, lblDeliveryDate, 0, SpringLayout.EAST, lblShippingDate);
        PackagePanelCompleteAux.add(lblDeliveryDate);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtDeliveryDate,34, SpringLayout.SOUTH, lblShippingDate);
        layoutForms.putConstraint(SpringLayout.WEST, txtDeliveryDate, 0, SpringLayout.WEST, txtCustomerID);
        PackagePanelCompleteAux.add(txtDeliveryDate);

				
        // Price
        layoutForms.putConstraint(SpringLayout.SOUTH, lblPrice,30, SpringLayout.SOUTH, lblDeliveryDate);
        layoutForms.putConstraint(SpringLayout.EAST, lblPrice, 0, SpringLayout.EAST, lblDeliveryDate);
        PackagePanelCompleteAux.add(lblPrice);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtPrice,34, SpringLayout.SOUTH, lblDeliveryDate);
        layoutForms.putConstraint(SpringLayout.WEST, txtPrice, 0, SpringLayout.WEST, txtCustomerID);
        PackagePanelCompleteAux.add(txtPrice);

    }	
	
	
	
	/**
	* Sets up Complete Transaction button - (layout and action listener)
	*/		
   private void setUpCompleteTransButton(){	
   
        JButton buttonCompleteTrans = new JButton("Complete Transaction");
        buttonCompleteTrans.setPreferredSize(new Dimension(195, 60));
        buttonCompleteTrans.setFont(buttonFont);
        layoutForms.putConstraint(SpringLayout.SOUTH, buttonCompleteTrans,155, SpringLayout.SOUTH, lblCustomerID);
        layoutForms.putConstraint(SpringLayout.WEST, buttonCompleteTrans, 160, SpringLayout.WEST, txtCustomerID);
        PackagePanelCompleteAux.add(buttonCompleteTrans);


		//Action for Complete Transaction button
		buttonCompleteTrans.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				logger.log(Level.INFO, "User Request: Complete Transaction");	
			
				//Input Validation 
				if (!isInteger(txtCustomerID.getText()) ) {
					JOptionPane.showMessageDialog(MainPackagePanel, "Enter a Valid Customer ID");
					logger.log(Level.INFO, "Message Sent to User: Enter a Valid Customer ID");	
				}
				else if (!ss.userExists(Integer.parseInt(txtCustomerID.getText())) ) {
					JOptionPane.showMessageDialog(MainPackagePanel, "Enter a Valid Customer ID");
					logger.log(Level.INFO, "Message Sent to User: Enter a Valid Customer ID");	
				}			
				else if (ss.isEmployee(Integer.parseInt(txtCustomerID.getText()))) {
					JOptionPane.showMessageDialog(MainPackagePanel, "Enter a Valid Customer ID.  User with ID " + txtCustomerID.getText() + " is an Employee and not a Customer.");
					logger.log(Level.INFO, "Message Sent to User: Enter a Valid Customer ID.  User with ID " + txtCustomerID.getText() + " is an Employee and not a Customer.");	
				}
				else if (!isInteger(txtEmployeeID.getText()) ) {
					JOptionPane.showMessageDialog(MainPackagePanel, "Enter a Valid Employee ID");
					logger.log(Level.INFO, "Message Sent to User: Enter a Valid Employee ID");	
				}
				else if (!ss.userExists(Integer.parseInt(txtEmployeeID.getText())) ) {
					JOptionPane.showMessageDialog(MainPackagePanel, "Enter a Valid Employee ID");
					logger.log(Level.INFO, "Message Sent to User: Enter a Valid Employee ID");	
				}			
				else if (!ss.isEmployee(Integer.parseInt(txtEmployeeID.getText()))) {
					JOptionPane.showMessageDialog(MainPackagePanel, "Enter a Valid Employee ID.  User with ID " + txtEmployeeID.getText() + " is aCustomer and not an Employee.");
					logger.log(Level.INFO, "Message Sent to User: Enter a Valid Employee ID.  User with ID " + txtEmployeeID.getText() + " is aCustomer and not an Employee.");	
				}
				else if (!ss.packageExists(txtTranTrackingNumber.getText())) {
					JOptionPane.showMessageDialog(MainPackagePanel, "Tracking Number does not exist");
					logger.log(Level.INFO, "Message Sent to User: Tracking Number does not exist");
				}
				else if (!isDate(txtShippingDate.getText())) {
					JOptionPane.showMessageDialog(MainPackagePanel, "Enter a Valid Shipping Date in the format MM/dd/yyyy");
					logger.log(Level.INFO, "Message Sent to User: Enter a Valid Shipping Date in the format MM/dd/yyyy");
				}
				else if (!isDate(txtDeliveryDate.getText())) {
					JOptionPane.showMessageDialog(MainPackagePanel, "Enter a Valid Delivery Date in the format MM/dd/yyyy");
					logger.log(Level.INFO, "Message Sent to User: Enter a Valid Delivery Date in the format MM/dd/yyyy");
				}
				else if (!isFloat(txtPrice.getText())) {
					JOptionPane.showMessageDialog(MainPackagePanel, "Enter a Valid Price");
					logger.log(Level.INFO, "Message Sent to User: Enter a Valid Price");
				}
				
				else {
				
					SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
					Date shippingDate = new Date();
					Date deliveryDate = new Date();
			
					try {
						shippingDate = sdf.parse(txtShippingDate.getText());
						deliveryDate = sdf.parse(txtDeliveryDate.getText());
					} catch (ParseException ex) {
                            logger.log(Level.SEVERE, "Error parsing Completed Transaction Dates");
					}
												
					ss.addShppingTransaction(Integer.parseInt(txtCustomerID.getText()), 
											Integer.parseInt(txtEmployeeID.getText()),
											txtTranTrackingNumber.getText(),
											shippingDate,
											deliveryDate,
											Float.parseFloat(txtPrice.getText())
											);
											
					ss.deletePackage(txtTranTrackingNumber.getText());
											
					//Clean text fields
					txtCustomerID.setText("");
					txtEmployeeID.setText("");
					txtTranTrackingNumber.setText("");
					txtShippingDate.setText("");
					txtDeliveryDate.setText("");
					txtPrice.setText("");                
					
					JOptionPane.showMessageDialog(MainPackagePanel, "Transaction Completed!");
					logger.log(Level.INFO, "Message Sent to User: Transaction Completed!");
					
				}
			
			}
		});
    }
	
	
	/**
	* Sets up Show Complete Transactions button - (layout and action listener)
	*/			
   private void setUpShowCompleteTransButton(){

        JButton buttonShowCompleteTrans = new JButton("Show Completed Transactions");
        buttonShowCompleteTrans.setPreferredSize(new Dimension(210, 60));
        buttonShowCompleteTrans.setFont(buttonFont);
        layoutForms.putConstraint(SpringLayout.SOUTH, buttonShowCompleteTrans,155, SpringLayout.SOUTH, lblCustomerID);
        layoutForms.putConstraint(SpringLayout.WEST, buttonShowCompleteTrans, 360, SpringLayout.WEST, txtCustomerID);
        PackagePanelCompleteAux.add(buttonShowCompleteTrans);
	
		//Table to show packages
        JTable table;
        modelTransactions.setDataVector(null,transactionsColumns);
        table = new JTable(modelTransactions);
        JScrollPane scrollList = new JScrollPane(table);
        scrollList.setPreferredSize(new Dimension(680, 180));
        PackagePanelCompleteAux.add(scrollList);
        layoutForms.putConstraint(SpringLayout.NORTH, scrollList,80, SpringLayout.NORTH, lblDeliveryDate);
        layoutForms.putConstraint(SpringLayout.WEST, scrollList, -20, SpringLayout.WEST, lblDeliveryDate);

		//Action for Show Transaction button
		buttonShowCompleteTrans.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
										
				modelTransactions.setRowCount(0);
				Object[][] data;
				data = ss.returnTransactionsDataArray();				
				modelTransactions.setDataVector(data,transactionsColumns);	

				logger.log(Level.INFO, "Result sent to User: Showing completed transactions info");
			  }
			}
		);
		
    }	
	

}
