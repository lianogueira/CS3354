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



public class GuiUserTab {

    public GuiUserTab(ShippingStore ss, JPanel MainUserPanel) {
        initGui(ss, MainUserPanel);
    }


    public void initGui(ShippingStore ss, JPanel MainUserPanel) {


        JLabel label = new JLabel("  Label Test ");
        MainUserPanel.add(label);



    }


}
