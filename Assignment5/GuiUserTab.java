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
import javax.swing.table.DefaultTableModel;


public class GuiUserTab {

    private JPanel MainUserPanel;
    private ShippingStore ss;

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
    private JButton buttonDelete = new JButton("Update");
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


    //Search panel
    private DefaultTableModel model = new DefaultTableModel();
    String[] userColumns = new String[] {"User Type", "Id", "First Name", "Last Name", "Phone", "Address", "SSN", "Salary", "Bank Account"};



    public GuiUserTab(ShippingStore ss, JPanel MainUserPanel) {
        initGui(ss, MainUserPanel);
    }


    public void initGui(ShippingStore ss, JPanel MainUserPanel) {

        this.MainUserPanel = MainUserPanel;
        this.ss = ss;

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

        //Setting up panel for delete
        TitledBorder titleDelete = BorderFactory.createTitledBorder("Update User");
        titleDelete.setTitleFont(buttonFont);
        PackagePanelUpdate.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        PackagePanelUpdate.add(UserPanelUpdateAux);
        UserPanelUpdateAux.setBorder(titleDelete);

        //Setting up panel for search
        TitledBorder titleSearch = BorderFactory.createTitledBorder("Show all Users");
        titleSearch.setTitleFont(buttonFont);
        UserPanelSearch.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        UserPanelSearch.add(UserPanelSearchAux);
        UserPanelSearchAux.setBorder(titleSearch);


        //setting up add panel
        setUpRadioButtonInAddPanel();
        setUpInputValuesInAddPanel();
        setUpAddToDatabaseButton();


        //Content in Search panel
        setUpSearchPanel();


        //Update panel
        setUpInputValuesInUpdatePanel();
        setUpRadioButtonInUpdatePanel();
        setUpUpdateDatabaseButton();

    }



    private void setUpMainButtonsPanel(){

        buttonAdd.setPreferredSize(buttonDimension);
        buttonDelete.setPreferredSize(buttonDimension);
        buttonSearch.setPreferredSize(buttonDimension);

        buttonAdd.setFont(buttonFont);
        buttonDelete.setFont(buttonFont);
        buttonSearch.setFont(buttonFont);

        UserPanelButtons.add(buttonAdd);
        UserPanelButtons.add(buttonDelete);
        UserPanelButtons.add(buttonSearch);


        //Setting up button actions
        buttonAdd.addActionListener((ActionEvent event) -> {
            MainUserPanel.remove(PackagePanelUpdate);
            MainUserPanel.remove(UserPanelSearch);
            MainUserPanel.setVisible(false);
            MainUserPanel.add(UserPanelAdd, BorderLayout.CENTER);
            MainUserPanel.setVisible(true);
        });


        buttonDelete.addActionListener((ActionEvent event) -> {
            MainUserPanel.remove(UserPanelAdd);
            MainUserPanel.remove(UserPanelSearch);
            MainUserPanel.setVisible(false);
            MainUserPanel.add(PackagePanelUpdate, BorderLayout.CENTER);
            MainUserPanel.setVisible(true);
        });

        buttonSearch.addActionListener((ActionEvent event) -> {
            MainUserPanel.remove(UserPanelAdd);
            MainUserPanel.remove(PackagePanelUpdate);
            MainUserPanel.setVisible(false);
            MainUserPanel.add(UserPanelSearch, BorderLayout.CENTER);
            MainUserPanel.setVisible(true);
            //model.setRowCount(0);
        });

    }


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
        rdbEmployee.addActionListener((ActionEvent event) -> {
            setVisibilityBasedOnUserType(true, false);
        });
        rdbCustomer.addActionListener((ActionEvent event) -> {
            setVisibilityBasedOnUserType(false, true);
        });

    }


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


    private static boolean validatePhoneNumber(String phoneNo) {
        //validate phone numbers of format "1234567890"
        if (phoneNo.matches("\\d{10}")) return true;
            //validating phone number with -, . or spaces
        else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
            //validating phone number with extension length from 3 to 5
        else if(phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
            //validating phone number where area code is in braces ()
        else if(phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
            //return false if nothing matches the input
        else return false;

    }



    private void setUpAddToDatabaseButton(){

        JButton buttonAddDatabase = new JButton("Add to Database");
        buttonAddDatabase.setPreferredSize(new Dimension(140, 50));
        buttonAddDatabase.setFont(buttonFont);
        layoutForms.putConstraint(SpringLayout.SOUTH, buttonAddDatabase,65, SpringLayout.SOUTH, lblAccount);
        layoutForms.putConstraint(SpringLayout.WEST, buttonAddDatabase, 0, SpringLayout.WEST, txtFirstName);
        UserPanelAddAux.add(buttonAddDatabase);


        buttonAddDatabase.addActionListener((ActionEvent event) -> {

            if (txtFirstName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(MainUserPanel, "Enter First Name");
            }
            else if (txtLastName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(MainUserPanel, "Enter Last Name");
            }
            else if (txtPhone.getText().isEmpty() && rdbCustomer.isSelected()) {
                JOptionPane.showMessageDialog(MainUserPanel, "Enter Valid Phone Number");
            }
            else if (txtAddress.getText().isEmpty() && rdbCustomer.isSelected()) {
                JOptionPane.showMessageDialog(MainUserPanel, "Enter Address");
            }
            else if (!isInteger(txtSSN.getText()) && rdbEmployee.isSelected()) {
                JOptionPane.showMessageDialog(MainUserPanel, "Enter Valid SSN");
            }
            else if (!isInteger(txtSalary.getText()) && rdbEmployee.isSelected()) {
                JOptionPane.showMessageDialog(MainUserPanel, "Enter Valid Monthly Salary");
            }
            else if (!isInteger(txtAccount.getText()) && rdbEmployee.isSelected()) {
                JOptionPane.showMessageDialog(MainUserPanel, "Enter Bank Account");
            }
            else {
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


                System.out.println(ss.getAllUsersFormatted());
                JOptionPane.showMessageDialog(MainUserPanel, "User added to the Database!");
            }
        });
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


        buttonSearchDatabase.addActionListener((ActionEvent event) -> {

                model.setRowCount(0);

                Object[][] data;
                data = ss.returnUserDataArray();
                model.setDataVector(data,userColumns);

        });
    }




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
        rdbUpdateEmployee.addActionListener((ActionEvent event) -> {
            setVisibilityBasedOnUpdateUserType(true, false);
        });
        rdbUpdateCustomer.addActionListener((ActionEvent event) -> {
            setVisibilityBasedOnUpdateUserType(false, true);
        });

    }


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





    private void setUpUpdateDatabaseButton(){

        JButton buttonUpdateDatabase = new JButton("Update Database");
        buttonUpdateDatabase.setPreferredSize(new Dimension(140, 50));
        buttonUpdateDatabase.setFont(buttonFont);
        layoutForms.putConstraint(SpringLayout.SOUTH, buttonUpdateDatabase,65, SpringLayout.SOUTH, lblUpdateAccount);
        layoutForms.putConstraint(SpringLayout.WEST, buttonUpdateDatabase, 0, SpringLayout.WEST, txtUpdateFirstName);
        UserPanelUpdateAux.add(buttonUpdateDatabase);


        buttonUpdateDatabase.addActionListener((ActionEvent event) -> {


            if (!isInteger(txtUpdateID.getText()) ) {
                JOptionPane.showMessageDialog(MainUserPanel, "Enter Valid ID");
            }
            else if (!ss.userExists(Integer.parseInt(txtUpdateID.getText())) ) {
                JOptionPane.showMessageDialog(MainUserPanel, "Enter Valid ID");
            }
            else if (ss.isEmployee(Integer.parseInt(txtUpdateID.getText()))  && rdbUpdateCustomer.isSelected() ) {
                JOptionPane.showMessageDialog(MainUserPanel, "User ID " + txtUpdateID.getText() + " is an Employee and not a Customer");
            }
            else if (!ss.isEmployee(Integer.parseInt(txtUpdateID.getText()))  && rdbUpdateEmployee.isSelected() ) {
                JOptionPane.showMessageDialog(MainUserPanel, "User ID " + txtUpdateID.getText() + " is a Customer and not an Employee");
            }
            else if (txtUpdateFirstName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(MainUserPanel, "Enter First Name");
            }
            else if (txtUpdateLastName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(MainUserPanel, "Enter Last Name");
            }
            else if (txtUpdatePhone.getText().isEmpty() && rdbUpdateCustomer.isSelected()) {
                JOptionPane.showMessageDialog(MainUserPanel, "Enter Valid Phone Number");
            }
            else if (txtUpdateAddress.getText().isEmpty() && rdbUpdateCustomer.isSelected()) {
                JOptionPane.showMessageDialog(MainUserPanel, "Enter Address");
            }
            else if (!isInteger(txtUpdateSSN.getText()) && rdbUpdateEmployee.isSelected()) {
                JOptionPane.showMessageDialog(MainUserPanel, "Enter Valid SSN");
            }
            else if (!isInteger(txtUpdateSalary.getText()) && rdbUpdateEmployee.isSelected()) {
                JOptionPane.showMessageDialog(MainUserPanel, "Enter Valid Monthly Salary");
            }
            else if (!isInteger(txtUpdateAccount.getText()) && rdbUpdateEmployee.isSelected()) {
                JOptionPane.showMessageDialog(MainUserPanel, "Enter Bank Account");
            }
            else {
                if (rdbUpdateEmployee.isSelected()) {
                    ss.updateEmployee(Integer.parseInt(txtUpdateID.getText()),txtUpdateFirstName.getText(), txtUpdateLastName.getText(), Integer.parseInt(txtUpdateSSN.getText()), Float.parseFloat(txtUpdateSalary.getText()), Integer.parseInt(txtUpdateAccount.getText()));
                } else if (rdbUpdateCustomer.isSelected()) {
                    ss.updateCustomer(Integer.parseInt(txtUpdateID.getText()), txtUpdateFirstName.getText(), txtUpdateLastName.getText(), txtUpdatePhone.getText(), txtUpdateAddress.getText());
                }

                txtUpdateID.setText("");
                txtUpdateFirstName.setText("");
                txtUpdateLastName.setText("");
                txtUpdatePhone.setText("");
                txtUpdateAddress.setText("");
                txtUpdateSSN.setText("");
                txtUpdateSalary.setText("");
                txtUpdateAccount.setText("");


                System.out.println(ss.getAllUsersFormatted());
                JOptionPane.showMessageDialog(MainUserPanel, "User updated in the Database!");
            }
        });
    }


}
