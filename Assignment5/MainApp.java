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
import javax.swing.border.TitledBorder;
import java.util.logging.*;


import java.util.Scanner;
import java.util.Date;
import java.text.*;
import static java.lang.System.out;


public class MainApp {
  private static Logger logger = Logger.getLogger("shippingstore");
  //private static FileHandler fh = new FileHandler("log.txt");


    public static void main(String[] args) throws Exception {


		JFrame f = new JFrame("Shipping Store");



		//Setting up menu
		JMenuBar menubar = new JMenuBar();

		JMenu file = new JMenu("Menu");
		file.setMnemonic(KeyEvent.VK_F);
		JMenuItem eMenuItem;

		eMenuItem = new JMenuItem("Exit");
		eMenuItem.setToolTipText("Exit program");
		eMenuItem.addActionListener((ActionEvent event) -> {
			System.exit(0);
		});

		file.add(eMenuItem);
		menubar.add(file);
		f.setJMenuBar(menubar);




		//ImageIcon icon = new ImageIcon("src/shippingstore/images/icon2.png");

		//Setting up new tab
		JTabbedPane tabs = new JTabbedPane();
		tabs.setBounds(15,15,750,550);
		JPanel MainUserPanel = new JPanel(new BorderLayout());
		JPanel ButtonsUserPanel = new JPanel(new BorderLayout());
		tabs.add("Packages",MainUserPanel);
		tabs.add("Users",ButtonsUserPanel);
		f.add(tabs);



		//Setting up inside of MainUserPanel
		MainUserPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		JPanel UserPanelButtons = new JPanel(new GridLayout());
		JPanel UserPanelAdd = new JPanel(new BorderLayout());
		JPanel UserPanelAddAux = new JPanel(new BorderLayout());
		JPanel UserPanelDelete = new JPanel(new BorderLayout());
		JPanel UserPanelDeleteAux = new JPanel(new BorderLayout());
		JPanel UserPanelComplete = new JPanel(new BorderLayout());
		JPanel UserPanelCompleteAux = new JPanel(new BorderLayout());
		JPanel UserPanelSearch = new JPanel(new BorderLayout());
		JPanel UserPanelSearchAux = new JPanel(new BorderLayout());
		MainUserPanel.add(UserPanelButtons, BorderLayout.PAGE_START);



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




		buttonAdd.addActionListener((ActionEvent event) -> {
			MainUserPanel.remove(UserPanelDelete);
			MainUserPanel.remove(UserPanelComplete);
			MainUserPanel.remove(UserPanelSearch);
			MainUserPanel.setVisible(false);
			MainUserPanel.add(UserPanelAdd, BorderLayout.CENTER);
			MainUserPanel.setVisible(true);
		});


		buttonDelete.addActionListener((ActionEvent event) -> {
			MainUserPanel.remove(UserPanelAdd);
			MainUserPanel.remove(UserPanelComplete);
			MainUserPanel.remove(UserPanelSearch);
			MainUserPanel.setVisible(false);
			MainUserPanel.add(UserPanelDelete, BorderLayout.CENTER);
			MainUserPanel.setVisible(true);
		});


		buttonComplete.addActionListener((ActionEvent event) -> {
			MainUserPanel.remove(UserPanelAdd);
			MainUserPanel.remove(UserPanelDelete);
			MainUserPanel.remove(UserPanelSearch);
			MainUserPanel.setVisible(false);
			MainUserPanel.add(UserPanelComplete, BorderLayout.CENTER);
			MainUserPanel.setVisible(true);
		});


		buttonSearch.addActionListener((ActionEvent event) -> {
			MainUserPanel.remove(UserPanelAdd);
			MainUserPanel.remove(UserPanelDelete);
			MainUserPanel.remove(UserPanelComplete);
			MainUserPanel.setVisible(false);
			MainUserPanel.add(UserPanelSearch, BorderLayout.CENTER);
			MainUserPanel.setVisible(true);
		});





		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800,660);
		f.setLayout(new BorderLayout());
		f.setVisible(true);


    }





}
