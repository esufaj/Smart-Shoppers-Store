import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import java.awt.Component;

public class Signup {

	JFrame frame;
	private JTextField usernameField;
	private JTextField emailField;
	private JPasswordField passwordField;
	String path = "C:\\Users\\PC\\Desktop\\user.csv";
	String path2 = "C:\\Users\\PC\\Desktop\\logins.csv";
	String path4 = "C:\\Users\\PC\\Desktop\\stores.csv";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup window = new Signup();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public Signup() {
		initialize();
		
	}
	
	public boolean usernameExists(String username) {
		MaintainUser maintain = new MaintainUser();
		
		try {
			maintain.load(path);
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(User u: maintain.users) {
			if(u.getName().toLowerCase().equals(username.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean areFieldsEmpty() {
		if(usernameField.getText().isEmpty() || String.valueOf(passwordField.getPassword()).isEmpty()) {
			return true;
		}
		return false;
	}
	
	public boolean isStoreSelected(JTable table) {
		if(table.getSelectedRow() != -1) {
			return true;
		}
		
		return false;
	}
	
	public boolean isUsersListEmpty() {
		MaintainUser maintain = new MaintainUser();
		
		try {
			maintain.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(maintain.users.size() == 0) {
			return true;
		}
		return false;
	}
	
	public int getNewID() {
		MaintainUser maintain = new MaintainUser();
		try {
			maintain.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int max = 0;
		if(maintain.users.size() != 0) {
			if(max < maintain.users.get(maintain.users.size() - 1).getId()) {
				max = maintain.users.get(maintain.users.size() - 1).getId() + 1;
			}
		}
		
		return max;
	}
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 820, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Signup | SmartShoppers");
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Sign Up for SmartShoppers");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(158, 0, 516, 59);
		frame.getContentPane().add(lblNewLabel);
		
		usernameField = new JTextField();
		usernameField.setForeground(Color.ORANGE);
		usernameField.setBackground(Color.BLACK);
		usernameField.setBounds(158, 110, 166, 23);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(158, 85, 166, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		emailField = new JTextField();
		emailField.setForeground(Color.ORANGE);
		emailField.setBackground(Color.BLACK);
		emailField.setBounds(323, 110, 168, 23);
		frame.getContentPane().add(emailField);
		emailField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.ORANGE);
		passwordField.setBackground(Color.BLACK);
		passwordField.setBounds(491, 110, 183, 23);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(491, 85, 183, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(323, 85, 168, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		
		// Table
	    JTable table = new JTable();
	    table.setShowVerticalLines(false);
	    table.setShowHorizontalLines(false);
	    table.setShowGrid(false);
	   
	    table.setModel(new DefaultTableModel(
	    	new Object[][] {
	    	},
	    	new String[] {
	    		"Store ID", "Name", "Address", "Distance [Km]"
	    	}
	    ));
	    table.setBackground(Color.BLACK);
	    table.setForeground(Color.ORANGE);
	    DefaultTableModel tb1 = (DefaultTableModel) table.getModel();
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	 // ScrollPane
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(158, 166, 516, 178);
	    frame.getContentPane().add(scrollPane);
	    table.setFillsViewportHeight(true); 
		
	    MaintainStore maintain = new MaintainStore();
	    
	    try {
			maintain.load(path4);
			
			for(Stores s: maintain.stores) {
				String data[] = {String.valueOf(s.getstoreID()), s.getName(), s.getAddress(), String.valueOf(s.getDistance())};
				tb1.addRow(data);
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				String username = usernameField.getText();
				String email = emailField.getText();
				String password = String.valueOf(passwordField.getPassword());
				
				MaintainUser maintain = new MaintainUser();
				MaintainLogins logins = new MaintainLogins();
				try {
					maintain.load(path);
					logins.load(path2);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(areFieldsEmpty()) {
					JOptionPane.showMessageDialog(frame, "Please complete all fields.", "Signup Error",
					        JOptionPane.ERROR_MESSAGE);
					
				}
				else if(!isStoreSelected(table)) {
					JOptionPane.showMessageDialog(frame, "Please select a store from the stores list.", "Signup Error",
					        JOptionPane.ERROR_MESSAGE);
				}
				else if(usernameExists(usernameField.getText())) {
					JOptionPane.showMessageDialog(frame, "Username already taken, please try again.", "Signup Error",
					        JOptionPane.ERROR_MESSAGE);
				}else if(!areFieldsEmpty() && isStoreSelected(table) && !usernameExists(usernameField.getText())) {
					int row = table.getSelectedRow();
					int storeid = Integer.parseInt(tb1.getValueAt(row,0).toString());
					User user = new User(usernameField.getText(), getNewID(), emailField.getText(), String.valueOf(passwordField.getPassword()), storeid, "Customer");
					maintain.users.add(user);
					logins.logins.add(user);
					File myObj = new File("C:\\Users\\PC\\Desktop\\" + user.getName()+".csv");
					try {
						myObj.createNewFile();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					try {
						maintain.update(path);
						logins.update(path2);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String storename = tb1.getValueAt(row, 1).toString();
					JOptionPane.showMessageDialog(frame, "Sign Up Successful. Store Preference Set to: " + storename, "Signup Successful",
					        JOptionPane.INFORMATION_MESSAGE);
					store1 store = new store1(user);
					store.frmSmartshoppers.setVisible(true);
					frame.dispose();
				}else if(isUsersListEmpty()) {
					int row = table.getSelectedRow();
					int storeid = Integer.parseInt(tb1.getValueAt(row,0).toString());
					User user = new User(usernameField.getText(), getNewID(), emailField.getText(), String.valueOf(passwordField.getPassword()), storeid, "Customer");
					maintain.users.add(user);
					logins.logins.add(user);
					File myObj = new File("C:\\Users\\PC\\Desktop\\" + user.getName()+".csv");
					try {
						myObj.createNewFile();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					try {
						maintain.update(path);
						logins.update(path2);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String storename = tb1.getValueAt(row, 1).toString();
					JOptionPane.showMessageDialog(frame, "Sign Up Successful. Store Preference Set to: " + storename, "Signup Successful",
					        JOptionPane.INFORMATION_MESSAGE);
					store1 store = new store1(user);
					store.frmSmartshoppers.setVisible(true);
					frame.dispose();
				}
			}
		});
		btnNewButton.setForeground(Color.ORANGE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(368, 401, 92, 32);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Have an account already? Sign in here");
		lblNewLabel_4.setForeground(Color.ORANGE);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(304, 444, 230, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Sign In");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_1.setForeground(Color.ORANGE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login loginwindow = new Login();
				loginwindow.frmLoginSmartshoppers.setVisible(true);
				frame.dispose();
			
				
			}
		});
		
	
		btnNewButton_1.setBounds(368, 469, 92, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 376, 784, 14);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel_3_1 = new JLabel("Store Preference Selection");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.ORANGE);
		lblNewLabel_3_1.setBounds(158, 141, 516, 14);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		
		
	
		
	}
}
