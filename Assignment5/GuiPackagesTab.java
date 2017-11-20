package shippingstore;


import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.*;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.TitledBorder;



public class GuiPackagesTab {

    private JPanel MainPackagePanel;
    private ShippingStore ss;

    //New JPanels used in the Package Tab
    private SpringLayout layoutForms = new SpringLayout();
    private JPanel PackagePanelButtons = new JPanel(new GridLayout());
    private JPanel UserPanelAdd = new JPanel(new BorderLayout());
    private JPanel UserPanelAddAux = new JPanel(layoutForms);
    private JPanel UserPanelDelete = new JPanel(new BorderLayout());
    private JPanel UserPanelDeleteAux = new JPanel(layoutForms);
    private JPanel UserPanelComplete = new JPanel(new BorderLayout());
    private JPanel UserPanelCompleteAux = new JPanel(new BorderLayout());
    private JPanel UserPanelSearch = new JPanel(new BorderLayout());
    private JPanel UserPanelSearchAux = new JPanel(new BorderLayout());

    //Main Buttons
    private JButton buttonAdd = new JButton("Add");
    private JButton buttonDelete = new JButton("Delete");
    private JButton buttonComplete = new JButton("Complete");
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
    private JComboBox specificationList = new JComboBox(specificationString);
    private JLabel lblMailingClass= new JLabel("Mailing Class: ");
    private String[] mailingClassString = { "First-Class              ", "Priority", "Retail", "Ground", "Metro" };
    private JComboBox mailingClassList = new JComboBox(mailingClassString);
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
    private JComboBox materialList = new JComboBox(materialString);
    private JLabel lblDiameter = new JLabel("Diameter: ");
    private JTextField txtDiameter = new JTextField("", 10);


    //Labels and Text fields for Delete Panel
    private JLabel lblDeleteTrackingNumber = new JLabel("Tracking Number: ");
    private JTextField txtDeleteTrackingNumber = new JTextField("", 15);


    //constructor
    public GuiPackagesTab(ShippingStore ss, JPanel MainPackagePanel) {
        initGui(ss, MainPackagePanel);
    }



    public void initGui(ShippingStore ss, JPanel MainPackagePanel) {

        this.MainPackagePanel = MainPackagePanel;
        this.ss = ss;

        //Setting up inside of MainPackagePanel
        MainPackagePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        MainPackagePanel.add(PackagePanelButtons, BorderLayout.PAGE_START);


        //Set up Main buttons
        setUpMainButtonsPanel();


        //Setting up panel for add
        TitledBorder titleAdd = BorderFactory.createTitledBorder("Add New package Order");
        titleAdd.setTitleFont(buttonFont);
        UserPanelAdd.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        UserPanelAdd.add(UserPanelAddAux);
        UserPanelAddAux.setBorder(titleAdd);

        //Setting up panel for delete
        TitledBorder titleDelete = BorderFactory.createTitledBorder("Delete Package Order");
        titleDelete.setTitleFont(buttonFont);
        UserPanelDelete.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        UserPanelDelete.add(UserPanelDeleteAux);
        UserPanelDeleteAux.setBorder(titleDelete);

        //Setting up panel for delete
        TitledBorder titleComplete = BorderFactory.createTitledBorder("Complete Order");
        titleComplete.setTitleFont(buttonFont);
        UserPanelComplete.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        UserPanelComplete.add(UserPanelCompleteAux);
        UserPanelCompleteAux.setBorder(titleComplete);

        //Setting up panel for search
        TitledBorder titleSearch = BorderFactory.createTitledBorder("Search Orders");
        titleSearch.setTitleFont(buttonFont);
        UserPanelSearch.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        UserPanelSearch.add(UserPanelSearchAux);
        UserPanelSearchAux.setBorder(titleSearch);


        //Content of Add Panel
        setUpInputValuesInAddPanel();
        setUpRadioButtonInAddPanel();
        setUpAddToDatabaseButton();

        //Content of Delete Panel
        setUpDeletePanel();


    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        // if exception isn't thrown, then it is an integer
        return true;
    }



    private void setUpAddToDatabaseButton(){

        JButton buttonAddDatabase = new JButton("Add to Database");
        buttonAddDatabase.setPreferredSize(new Dimension(140, 50));
        buttonAddDatabase.setFont(buttonFont);
        layoutForms.putConstraint(SpringLayout.SOUTH, buttonAddDatabase,65, SpringLayout.SOUTH, lblWidth);
        layoutForms.putConstraint(SpringLayout.WEST, buttonAddDatabase, 0, SpringLayout.WEST, txtTrackingNumber);
        UserPanelAddAux.add(buttonAddDatabase);


        buttonAddDatabase.addActionListener((ActionEvent event) -> {

            if (txtTrackingNumber.getText().length() != 5) {
                JOptionPane.showMessageDialog(MainPackagePanel, "Tracking Number must have 5 characters!");
            }
            else if (!isInteger(txtHeight.getText()) && rdbEnvelope.isSelected()) {
                JOptionPane.showMessageDialog(MainPackagePanel, "Heigh must be a number");
            }
            else if (!isInteger(txtWidth.getText()) && rdbEnvelope.isSelected()) {
                JOptionPane.showMessageDialog(MainPackagePanel, "Width must be a number");
            }
            else if (!isInteger(txtLargestDimension.getText()) && rdbBox.isSelected()) {
                JOptionPane.showMessageDialog(MainPackagePanel, "Largest Dimension must be a number");
            }
            else if (!isInteger(txtVolume.getText()) && rdbBox.isSelected()) {
                JOptionPane.showMessageDialog(MainPackagePanel, "Volume must be a number");
            }
            else if (!isInteger(txtMaximumLoad.getText()) && rdbCrate.isSelected()) {
                JOptionPane.showMessageDialog(MainPackagePanel, "Maximum Load must be a number");
            }
            else if (!isInteger(txtDiameter.getText()) && rdbDrum.isSelected()) {
                JOptionPane.showMessageDialog(MainPackagePanel, "Diameter must be a number");
            }
            else {
                if (rdbEnvelope.isSelected()) {
                    ss.addEnvelope(txtTrackingNumber.getText(), specificationList.getSelectedItem().toString().replace(" ", ""), mailingClassList.getSelectedItem().toString().replace(" ", ""), Integer.parseInt(txtHeight.getText()), Integer.parseInt(txtHeight.getText()));
                } else if (rdbBox.isSelected()) {
                    ss.addBox(txtTrackingNumber.getText(), specificationList.getSelectedItem().toString().replace(" ", ""), mailingClassList.getSelectedItem().toString().replace(" ", ""), Integer.parseInt(txtLargestDimension.getText()), Integer.parseInt(txtVolume.getText()));
                } else if (rdbCrate.isSelected()) {
                    ss.addCrate(txtTrackingNumber.getText(), specificationList.getSelectedItem().toString().replace(" ", ""), mailingClassList.getSelectedItem().toString().replace(" ", ""), Integer.parseInt(txtMaximumLoad.getText()), txtContent.getText());
                } else if (rdbDrum.isSelected()) {
                    ss.addDrum(txtTrackingNumber.getText(), specificationList.getSelectedItem().toString().replace(" ", ""), mailingClassList.getSelectedItem().toString().replace(" ", ""), materialList.getSelectedItem().toString().replace(" ", ""), Integer.parseInt(txtDiameter.getText()));
                }

                txtTrackingNumber.setText("");
                txtContent.setText("");
                txtDiameter.setText("");
                txtHeight.setText("");
                txtLargestDimension.setText("");
                txtMaximumLoad.setText("");
                txtVolume.setText("");
                txtWidth.setText("");


                System.out.println(ss.getAllPackagesFormatted());
                JOptionPane.showMessageDialog(MainPackagePanel, "Package added to the Database!");
            }
        });
    }



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
        buttonAdd.addActionListener((ActionEvent event) -> {
            MainPackagePanel.remove(UserPanelDelete);
            MainPackagePanel.remove(UserPanelComplete);
            MainPackagePanel.remove(UserPanelSearch);
            MainPackagePanel.setVisible(false);
            MainPackagePanel.add(UserPanelAdd, BorderLayout.CENTER);
            MainPackagePanel.setVisible(true);
        });


        buttonDelete.addActionListener((ActionEvent event) -> {
            MainPackagePanel.remove(UserPanelAdd);
            MainPackagePanel.remove(UserPanelComplete);
            MainPackagePanel.remove(UserPanelSearch);
            MainPackagePanel.setVisible(false);
            MainPackagePanel.add(UserPanelDelete, BorderLayout.CENTER);
            MainPackagePanel.setVisible(true);
        });

        buttonComplete.addActionListener((ActionEvent event) -> {
            MainPackagePanel.remove(UserPanelAdd);
            MainPackagePanel.remove(UserPanelDelete);
            MainPackagePanel.remove(UserPanelSearch);
            MainPackagePanel.setVisible(false);
            MainPackagePanel.add(UserPanelComplete, BorderLayout.CENTER);
            MainPackagePanel.setVisible(true);
        });

        buttonSearch.addActionListener((ActionEvent event) -> {
            MainPackagePanel.remove(UserPanelAdd);
            MainPackagePanel.remove(UserPanelDelete);
            MainPackagePanel.remove(UserPanelComplete);
            MainPackagePanel.setVisible(false);
            MainPackagePanel.add(UserPanelSearch, BorderLayout.CENTER);
            MainPackagePanel.setVisible(true);
        });

    }


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
        layoutForms.putConstraint(SpringLayout.NORTH, typeOfPackagePanel,20, SpringLayout.NORTH, UserPanelAddAux);
        layoutForms.putConstraint(SpringLayout.WEST, typeOfPackagePanel, 10, SpringLayout.WEST, UserPanelAddAux);
        UserPanelAddAux.add(typeOfPackagePanel);

        setVisibilityBasedOnPackageType(true, false, false, false);

        //Radio button actions
        rdbEnvelope.addActionListener((ActionEvent event) -> {
            setVisibilityBasedOnPackageType(true, false, false, false);
        });
        rdbBox.addActionListener((ActionEvent event) -> {
            setVisibilityBasedOnPackageType(false, true, false, false);
        });
        rdbCrate.addActionListener((ActionEvent event) -> {
            setVisibilityBasedOnPackageType(false, false, true, false);
        });

        rdbDrum.addActionListener((ActionEvent event) -> {
            setVisibilityBasedOnPackageType(false, false, false, true);
        });
    }


    private void setUpInputValuesInAddPanel(){
        //Tracking Number
        layoutForms.putConstraint(SpringLayout.SOUTH, lblTrackingNumber,40, SpringLayout.SOUTH, typeOfPackagePanel);
        layoutForms.putConstraint(SpringLayout.WEST, lblTrackingNumber, 18, SpringLayout.WEST, UserPanelAddAux);
        UserPanelAddAux.add(lblTrackingNumber);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtTrackingNumber,43, SpringLayout.SOUTH, typeOfPackagePanel);
        layoutForms.putConstraint(SpringLayout.WEST, txtTrackingNumber, 110, SpringLayout.WEST, lblTrackingNumber);
        UserPanelAddAux.add(txtTrackingNumber);


        //Specification
        layoutForms.putConstraint(SpringLayout.SOUTH, lblSpecification,40, SpringLayout.SOUTH, lblTrackingNumber);
        layoutForms.putConstraint(SpringLayout.EAST, lblSpecification, 0, SpringLayout.EAST, lblTrackingNumber);
        UserPanelAddAux.add(lblSpecification);

        layoutForms.putConstraint(SpringLayout.SOUTH, specificationList,44, SpringLayout.SOUTH, lblTrackingNumber);
        layoutForms.putConstraint(SpringLayout.WEST, specificationList, 0, SpringLayout.WEST, txtTrackingNumber);
        UserPanelAddAux.add(specificationList);


        //Mailing Class:
        layoutForms.putConstraint(SpringLayout.SOUTH, lblMailingClass,40, SpringLayout.SOUTH, lblSpecification);
        layoutForms.putConstraint(SpringLayout.EAST, lblMailingClass, 0, SpringLayout.EAST, lblSpecification);
        UserPanelAddAux.add(lblMailingClass);

        layoutForms.putConstraint(SpringLayout.SOUTH, mailingClassList,44, SpringLayout.SOUTH, lblSpecification);
        layoutForms.putConstraint(SpringLayout.WEST, mailingClassList, 0, SpringLayout.WEST, txtTrackingNumber);
        UserPanelAddAux.add(mailingClassList);

        //Height
        layoutForms.putConstraint(SpringLayout.SOUTH, lblHeight,40, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.EAST, lblHeight, 0, SpringLayout.EAST, lblMailingClass);
        UserPanelAddAux.add(lblHeight);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtHeight,43, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.WEST, txtHeight, 0, SpringLayout.WEST, txtTrackingNumber);
        UserPanelAddAux.add(txtHeight);

        //Width
        layoutForms.putConstraint(SpringLayout.SOUTH, lblWidth,40, SpringLayout.SOUTH, lblHeight);
        layoutForms.putConstraint(SpringLayout.EAST, lblWidth, 0, SpringLayout.EAST, lblHeight);
        UserPanelAddAux.add(lblWidth);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtWidth,43, SpringLayout.SOUTH, lblHeight);
        layoutForms.putConstraint(SpringLayout.WEST, txtWidth, 0, SpringLayout.WEST, txtTrackingNumber);
        UserPanelAddAux.add(txtWidth);

        // Largest dimension
        layoutForms.putConstraint(SpringLayout.SOUTH, lblLargestDimension,40, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.EAST, lblLargestDimension, 0, SpringLayout.EAST, lblMailingClass);
        UserPanelAddAux.add(lblLargestDimension);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtLargestDimension,43, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.WEST, txtLargestDimension, 0, SpringLayout.WEST, txtTrackingNumber);
        UserPanelAddAux.add(txtLargestDimension);

        //Volume
        layoutForms.putConstraint(SpringLayout.SOUTH, lblVolume,40, SpringLayout.SOUTH, lblLargestDimension);
        layoutForms.putConstraint(SpringLayout.EAST, lblVolume, 0, SpringLayout.EAST, lblLargestDimension);
        UserPanelAddAux.add(lblVolume);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtVolume,43, SpringLayout.SOUTH, lblLargestDimension);
        layoutForms.putConstraint(SpringLayout.WEST, txtVolume, 0, SpringLayout.WEST, txtTrackingNumber);
        UserPanelAddAux.add(txtVolume);

        //Maximum Load
        layoutForms.putConstraint(SpringLayout.SOUTH, lblMaximumLoad,40, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.EAST, lblMaximumLoad, 0, SpringLayout.EAST, lblMailingClass);
        UserPanelAddAux.add(lblMaximumLoad);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtMaximumLoad,43, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.WEST, txtMaximumLoad, 0, SpringLayout.WEST, txtTrackingNumber);
        UserPanelAddAux.add(txtMaximumLoad);

        //content
        layoutForms.putConstraint(SpringLayout.SOUTH, lblContent,40, SpringLayout.SOUTH, lblLargestDimension);
        layoutForms.putConstraint(SpringLayout.EAST, lblContent, 0, SpringLayout.EAST, lblLargestDimension);
        UserPanelAddAux.add(lblContent);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtContent,43, SpringLayout.SOUTH, lblMaximumLoad);
        layoutForms.putConstraint(SpringLayout.WEST, txtContent, 0, SpringLayout.WEST, txtTrackingNumber);
        UserPanelAddAux.add(txtContent);


        //Material
        layoutForms.putConstraint(SpringLayout.SOUTH, lblMaterial,40, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.EAST, lblMaterial, 0, SpringLayout.EAST, lblMailingClass);
        UserPanelAddAux.add(lblMaterial);

        layoutForms.putConstraint(SpringLayout.SOUTH, materialList,44, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.WEST, materialList, 0, SpringLayout.WEST, txtTrackingNumber);
        UserPanelAddAux.add(materialList);


        //Diameter
        layoutForms.putConstraint(SpringLayout.SOUTH, lblDiameter,40, SpringLayout.SOUTH, lblMaterial);
        layoutForms.putConstraint(SpringLayout.EAST, lblDiameter, 0, SpringLayout.EAST, lblMaterial);
        UserPanelAddAux.add(lblDiameter);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtDiameter,43, SpringLayout.SOUTH, lblMaterial);
        layoutForms.putConstraint(SpringLayout.WEST, txtDiameter, 0, SpringLayout.WEST, txtTrackingNumber);
        UserPanelAddAux.add(txtDiameter);
    }



    private void setUpDeletePanel(){
        //Tracking Number
        layoutForms.putConstraint(SpringLayout.NORTH, lblDeleteTrackingNumber,20, SpringLayout.NORTH, UserPanelDeleteAux);
        layoutForms.putConstraint(SpringLayout.WEST, lblDeleteTrackingNumber, 10, SpringLayout.WEST, UserPanelDeleteAux);
        UserPanelDeleteAux.add(lblDeleteTrackingNumber);

        layoutForms.putConstraint(SpringLayout.SOUTH, txtDeleteTrackingNumber,5, SpringLayout.SOUTH, lblDeleteTrackingNumber);
        layoutForms.putConstraint(SpringLayout.WEST, txtDeleteTrackingNumber, 110, SpringLayout.WEST, lblDeleteTrackingNumber);
        UserPanelDeleteAux.add(txtDeleteTrackingNumber);


        JButton buttonDeleteDatabase = new JButton("Delete From Database");
        buttonDeleteDatabase.setPreferredSize(new Dimension(170, 50));
        buttonDeleteDatabase.setFont(buttonFont);
        layoutForms.putConstraint(SpringLayout.SOUTH, buttonDeleteDatabase,65, SpringLayout.SOUTH, lblDeleteTrackingNumber);
        layoutForms.putConstraint(SpringLayout.WEST, buttonDeleteDatabase, 0, SpringLayout.WEST, txtDeleteTrackingNumber);
        UserPanelDeleteAux.add(buttonDeleteDatabase);


        buttonDeleteDatabase.addActionListener((ActionEvent event) -> {

            if (!ss.packageExists(txtDeleteTrackingNumber.getText().toString())){
                JOptionPane.showMessageDialog(MainPackagePanel, "Tracking Number not found");
            }
            else {

                ss.deletePackage(txtDeleteTrackingNumber.getText().toString());

                txtDeleteTrackingNumber.setText("");

                System.out.println(ss.getAllPackagesFormatted());
                JOptionPane.showMessageDialog(MainPackagePanel, "Package deleted from the Database!");
            }
        });

    }


}
