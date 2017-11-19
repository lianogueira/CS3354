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

    public GuiPackagesTab(ShippingStore ss, JPanel MainPackagePanel) {
        initGui(MainPackagePanel);
    }


    public void initGui(JPanel MainPackagePanel) {

        //Setting up inside of MainPackagePanel
        MainPackagePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        SpringLayout layoutForms = new SpringLayout();
        JPanel UserPanelButtons = new JPanel(new GridLayout());
        JPanel UserPanelAdd = new JPanel(new BorderLayout());
        JPanel UserPanelAddAux = new JPanel(layoutForms);
        JPanel UserPanelDelete = new JPanel(new BorderLayout());
        JPanel UserPanelDeleteAux = new JPanel(new BorderLayout());
        JPanel UserPanelComplete = new JPanel(new BorderLayout());
        JPanel UserPanelCompleteAux = new JPanel(new BorderLayout());
        JPanel UserPanelSearch = new JPanel(new BorderLayout());
        JPanel UserPanelSearchAux = new JPanel(new BorderLayout());
        MainPackagePanel.add(UserPanelButtons, BorderLayout.PAGE_START);



        //Setting up inside of buttons panel
        Font buttonFont = new Font("Arial", Font.PLAIN, 13);
        Dimension buttonDimension = new Dimension(5, 60);

        JButton buttonAdd = new JButton("Add");
        JButton buttonDelete = new JButton("Delete");
        JButton buttonComplete = new JButton("Complete");
        JButton buttonSearch = new JButton("Search");

        buttonAdd.setPreferredSize(buttonDimension);
        buttonDelete.setPreferredSize(buttonDimension);
        buttonComplete.setPreferredSize(buttonDimension);
        buttonSearch.setPreferredSize(buttonDimension);

        buttonAdd.setFont(buttonFont);
        buttonDelete.setFont(buttonFont);
        buttonComplete.setFont(buttonFont);
        buttonSearch.setFont(buttonFont);

        UserPanelButtons.add(buttonAdd);
        UserPanelButtons.add(buttonDelete);
        UserPanelButtons.add(buttonComplete);
        UserPanelButtons.add(buttonSearch);



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




        //Radio button inside add
        JPanel typeOfPackagePanel = new JPanel(new FlowLayout());
        TitledBorder titleTypePackage = BorderFactory.createTitledBorder("Type of Package");
        titleTypePackage.setTitleFont(buttonFont);
        typeOfPackagePanel.setBorder(titleTypePackage);

        JRadioButton rdbEnvelope = new JRadioButton("Envelope     ", true);
        JRadioButton rdbBox = new JRadioButton("Box         ");
        JRadioButton rdbCrate = new JRadioButton("Crate          ");
        JRadioButton rdbDrum = new JRadioButton("Drum          ");

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




        //Tracking Number
        JLabel lblTrackingNumber = new JLabel("Tracking Number: ");
        layoutForms.putConstraint(SpringLayout.SOUTH, lblTrackingNumber,40, SpringLayout.SOUTH, typeOfPackagePanel);
        layoutForms.putConstraint(SpringLayout.WEST, lblTrackingNumber, 18, SpringLayout.WEST, UserPanelAddAux);
        UserPanelAddAux.add(lblTrackingNumber);

        JTextField txtTrackingNumber = new JTextField("", 15);
        layoutForms.putConstraint(SpringLayout.SOUTH, txtTrackingNumber,43, SpringLayout.SOUTH, typeOfPackagePanel);
        layoutForms.putConstraint(SpringLayout.WEST, txtTrackingNumber, 110, SpringLayout.WEST, lblTrackingNumber);
        UserPanelAddAux.add(txtTrackingNumber);




        //Specification
        JLabel lblSpecification= new JLabel("Specification: ");
        layoutForms.putConstraint(SpringLayout.SOUTH, lblSpecification,40, SpringLayout.SOUTH, lblTrackingNumber);
        layoutForms.putConstraint(SpringLayout.EAST, lblSpecification, 0, SpringLayout.EAST, lblTrackingNumber);
        UserPanelAddAux.add(lblSpecification);

        String[] specificationString = { "Fragile", "Books", "Catalogs", "Do-not-Bend           ", "N/A" };
        JComboBox specificationList = new JComboBox(specificationString);
        layoutForms.putConstraint(SpringLayout.SOUTH, specificationList,44, SpringLayout.SOUTH, lblTrackingNumber);
        layoutForms.putConstraint(SpringLayout.WEST, specificationList, 0, SpringLayout.WEST, txtTrackingNumber);
        UserPanelAddAux.add(specificationList);



        //Mailing Class:
        JLabel lblMailingClass= new JLabel("Mailing Class: ");
        layoutForms.putConstraint(SpringLayout.SOUTH, lblMailingClass,40, SpringLayout.SOUTH, lblSpecification);
        layoutForms.putConstraint(SpringLayout.EAST, lblMailingClass, 0, SpringLayout.EAST, lblSpecification);
        UserPanelAddAux.add(lblMailingClass);

        String[] mailingClassString = { "First-Class              ", "Priority", "Retail", "Ground", "Metro" };
        JComboBox mailingClassList = new JComboBox(mailingClassString);
        layoutForms.putConstraint(SpringLayout.SOUTH, mailingClassList,44, SpringLayout.SOUTH, lblSpecification);
        layoutForms.putConstraint(SpringLayout.WEST, mailingClassList, 0, SpringLayout.WEST, txtTrackingNumber);
        UserPanelAddAux.add(mailingClassList);




        //Height
        JLabel lblHeight = new JLabel("Height: ");
        layoutForms.putConstraint(SpringLayout.SOUTH, lblHeight,40, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.EAST, lblHeight, 0, SpringLayout.EAST, lblMailingClass);
        UserPanelAddAux.add(lblHeight);

        JTextField txtHeight = new JTextField("", 10);
        layoutForms.putConstraint(SpringLayout.SOUTH, txtHeight,43, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.WEST, txtHeight, 0, SpringLayout.WEST, txtTrackingNumber);
        UserPanelAddAux.add(txtHeight);



        //Width
        JLabel lblWidth = new JLabel("Width: ");
        layoutForms.putConstraint(SpringLayout.SOUTH, lblWidth,40, SpringLayout.SOUTH, lblHeight);
        layoutForms.putConstraint(SpringLayout.EAST, lblWidth, 0, SpringLayout.EAST, lblHeight);
        UserPanelAddAux.add(lblWidth);

        JTextField txtWidth = new JTextField("", 10);
        layoutForms.putConstraint(SpringLayout.SOUTH, txtWidth,43, SpringLayout.SOUTH, lblHeight);
        layoutForms.putConstraint(SpringLayout.WEST, txtWidth, 0, SpringLayout.WEST, txtTrackingNumber);
        UserPanelAddAux.add(txtWidth);




        // Largest dimension
        JLabel lblLargestDimension = new JLabel("Largest Dimension: ");
        layoutForms.putConstraint(SpringLayout.SOUTH, lblLargestDimension,40, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.EAST, lblLargestDimension, 0, SpringLayout.EAST, lblMailingClass);
        UserPanelAddAux.add(lblLargestDimension);

        JTextField txtLargestDimension = new JTextField("", 10);
        layoutForms.putConstraint(SpringLayout.SOUTH, txtLargestDimension,43, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.WEST, txtLargestDimension, 0, SpringLayout.WEST, txtTrackingNumber);
        UserPanelAddAux.add(txtLargestDimension);


        //Volume
        JLabel lblVolume = new JLabel("Volume: ");
        layoutForms.putConstraint(SpringLayout.SOUTH, lblVolume,40, SpringLayout.SOUTH, lblLargestDimension);
        layoutForms.putConstraint(SpringLayout.EAST, lblVolume, 0, SpringLayout.EAST, lblLargestDimension);
        UserPanelAddAux.add(lblVolume);

        JTextField txtVolume = new JTextField("", 10);
        layoutForms.putConstraint(SpringLayout.SOUTH, txtVolume,43, SpringLayout.SOUTH, lblLargestDimension);
        layoutForms.putConstraint(SpringLayout.WEST, txtVolume, 0, SpringLayout.WEST, txtTrackingNumber);
        UserPanelAddAux.add(txtVolume);



        //Maximum Load
        JLabel lblMaximumLoad = new JLabel("Maximum Load: ");
        layoutForms.putConstraint(SpringLayout.SOUTH, lblMaximumLoad,40, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.EAST, lblMaximumLoad, 0, SpringLayout.EAST, lblMailingClass);
        UserPanelAddAux.add(lblMaximumLoad);

        JTextField txtMaximumLoad = new JTextField("", 10);
        layoutForms.putConstraint(SpringLayout.SOUTH, txtMaximumLoad,43, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.WEST, txtMaximumLoad, 0, SpringLayout.WEST, txtTrackingNumber);
        UserPanelAddAux.add(txtMaximumLoad);


        //content
        JLabel lblContent = new JLabel("Content: ");
        layoutForms.putConstraint(SpringLayout.SOUTH, lblContent,40, SpringLayout.SOUTH, lblLargestDimension);
        layoutForms.putConstraint(SpringLayout.EAST, lblContent, 0, SpringLayout.EAST, lblLargestDimension);
        UserPanelAddAux.add(lblContent);

        JTextField txtContent = new JTextField("", 10);
        layoutForms.putConstraint(SpringLayout.SOUTH, txtContent,43, SpringLayout.SOUTH, lblMaximumLoad);
        layoutForms.putConstraint(SpringLayout.WEST, txtContent, 0, SpringLayout.WEST, txtTrackingNumber);
        UserPanelAddAux.add(txtContent);



        //Material
        JLabel lblMaterial = new JLabel("Material: ");
        layoutForms.putConstraint(SpringLayout.SOUTH, lblMaterial,40, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.EAST, lblMaterial, 0, SpringLayout.EAST, lblMailingClass);
        UserPanelAddAux.add(lblMaterial);

        String[] materialString = { "Plastic                     ", "Fiber"};
        JComboBox materialList = new JComboBox(materialString);
        layoutForms.putConstraint(SpringLayout.SOUTH, materialList,44, SpringLayout.SOUTH, lblMailingClass);
        layoutForms.putConstraint(SpringLayout.WEST, materialList, 0, SpringLayout.WEST, txtTrackingNumber);
        UserPanelAddAux.add(materialList);


        //Diameter
        JLabel lblDiameter = new JLabel("Diameter: ");
        layoutForms.putConstraint(SpringLayout.SOUTH, lblDiameter,40, SpringLayout.SOUTH, lblMaterial);
        layoutForms.putConstraint(SpringLayout.EAST, lblDiameter, 0, SpringLayout.EAST, lblMaterial);
        UserPanelAddAux.add(lblDiameter);

        JTextField txtDiameter = new JTextField("", 10);
        layoutForms.putConstraint(SpringLayout.SOUTH, txtDiameter,43, SpringLayout.SOUTH, lblMaterial);
        layoutForms.putConstraint(SpringLayout.WEST, txtDiameter, 0, SpringLayout.WEST, txtTrackingNumber);
        UserPanelAddAux.add(txtDiameter);



        //Initial visibility
        lblHeight.setVisible(true);
        txtHeight.setVisible(true);
        lblWidth.setVisible(true);
        txtWidth.setVisible(true);
        lblLargestDimension.setVisible(false);
        txtLargestDimension.setVisible(false);
        lblVolume.setVisible(false);
        txtVolume.setVisible(false);
        lblMaximumLoad.setVisible(false);
        txtMaximumLoad.setVisible(false);
        lblContent.setVisible(false);
        txtContent.setVisible(false);
        lblMaterial.setVisible(false);
        materialList.setVisible(false);
        lblDiameter.setVisible(false);
        txtDiameter.setVisible(false);



        //Radio button actions
        rdbEnvelope.addActionListener((ActionEvent event) -> {
            lblHeight.setVisible(true);
            txtHeight.setVisible(true);
            lblWidth.setVisible(true);
            txtWidth.setVisible(true);

            lblLargestDimension.setVisible(false);
            txtLargestDimension.setVisible(false);
            lblVolume.setVisible(false);
            txtVolume.setVisible(false);
            lblMaximumLoad.setVisible(false);
            txtMaximumLoad.setVisible(false);
            lblContent.setVisible(false);
            txtContent.setVisible(false);
            lblMaterial.setVisible(false);
            materialList.setVisible(false);
            lblDiameter.setVisible(false);
            txtDiameter.setVisible(false);
        });
        rdbBox.addActionListener((ActionEvent event) -> {
            lblHeight.setVisible(false);
            txtHeight.setVisible(false);
            lblWidth.setVisible(false);
            txtWidth.setVisible(false);

            lblLargestDimension.setVisible(true);
            txtLargestDimension.setVisible(true);
            lblVolume.setVisible(true);
            txtVolume.setVisible(true);
            lblMaximumLoad.setVisible(false);
            txtMaximumLoad.setVisible(false);
            lblContent.setVisible(false);
            txtContent.setVisible(false);
            lblMaterial.setVisible(false);
            materialList.setVisible(false);
            lblDiameter.setVisible(false);
            txtDiameter.setVisible(false);
        });
        rdbCrate.addActionListener((ActionEvent event) -> {
            lblHeight.setVisible(false);
            txtHeight.setVisible(false);
            lblWidth.setVisible(false);
            txtWidth.setVisible(false);
            lblLargestDimension.setVisible(false);
            txtLargestDimension.setVisible(false);
            lblVolume.setVisible(false);
            txtVolume.setVisible(false);
            lblMaximumLoad.setVisible(true);
            txtMaximumLoad.setVisible(true);
            lblContent.setVisible(true);
            txtContent.setVisible(true);
            lblMaterial.setVisible(false);
            materialList.setVisible(false);
            lblDiameter.setVisible(false);
            txtDiameter.setVisible(false);
        });

        rdbDrum.addActionListener((ActionEvent event) -> {
            lblHeight.setVisible(false);
            txtHeight.setVisible(false);
            lblWidth.setVisible(false);
            txtWidth.setVisible(false);
            lblLargestDimension.setVisible(false);
            txtLargestDimension.setVisible(false);
            lblVolume.setVisible(false);
            txtVolume.setVisible(false);
            lblMaximumLoad.setVisible(false);
            txtMaximumLoad.setVisible(false);
            lblContent.setVisible(false);
            txtContent.setVisible(false);
            lblMaterial.setVisible(true);
            materialList.setVisible(true);
            lblDiameter.setVisible(true);
            txtDiameter.setVisible(true);
        });



    }

}
