import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class profile {

	JFrame frame;
	String path = "C:\\Users\\PC\\Desktop\\user.csv";
	String path2 = "C:\\Users\\PC\\Desktop\\logins.csv";
	String path4 = "C:\\Users\\PC\\Desktop\\stores.csv";
	private JTextField passField1;
	private JTextField passField2;
	private JTextField username;
	private JTextField email;
	private JTextField storeid;
	private JTextField permissions;
	private JTextField password;
	private JTextField address;
	private JTextField storename;
	private JTextField userid;
	private JTextField kms;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					profile window = new profile(new User());
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
	public profile(User user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User user) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 690, 632);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Profile");
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(80, 11, 193, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setForeground(Color.ORANGE);
		lblEmail.setBounds(10, 71, 263, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblStoreid = new JLabel("Store ID");
		lblStoreid.setHorizontalAlignment(SwingConstants.CENTER);
		lblStoreid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStoreid.setForeground(Color.ORANGE);
		lblStoreid.setBounds(10, 131, 72, 14);
		frame.getContentPane().add(lblStoreid);
		
		JLabel lblStoreAddress = new JLabel("Store Address");
		lblStoreAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblStoreAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStoreAddress.setForeground(Color.ORANGE);
		lblStoreAddress.setBounds(273, 131, 215, 14);
		frame.getContentPane().add(lblStoreAddress);
		
		
		JButton backbutton = new JButton("Back");
		backbutton.setForeground(Color.ORANGE);
		backbutton.setBackground(Color.BLACK);
		backbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					store1 store1 = new store1(user);
					store1.frmSmartshoppers.setVisible(true);
					frame.dispose();
			}
		});
		backbutton.setBounds(10, 559, 83, 23);
		frame.getContentPane().add(backbutton);
		
		
		JLabel sttag = new JLabel("Available Stores Near You");
		sttag.setHorizontalAlignment(SwingConstants.CENTER);
		sttag.setForeground(Color.ORANGE);
		sttag.setFont(new Font("Tahoma", Font.BOLD, 14));
		sttag.setBounds(80, 246, 516, 23);
		frame.getContentPane().add(sttag);
		
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
	    scrollPane.setBounds(80, 280, 516, 178);
	    frame.getContentPane().add(scrollPane);
	    table.setFillsViewportHeight(true); 
	    
	    
	    
	    try {
	    	MaintainStore maintain = new MaintainStore();
			maintain.load(path4);
			
			for(Stores s: maintain.stores) {
				if(s.getstoreID() != user.getstoreID()) {
				String data[] = {String.valueOf(s.getstoreID()), s.getName(), s.getAddress(), String.valueOf(s.getDistance())};
				tb1.addRow(data);
				}
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		JButton btnNewButton = new JButton("Change Store");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.ORANGE);
		
		btnNewButton.setBounds(264, 469, 135, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.ORANGE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(273, 71, 253, 14);
		frame.getContentPane().add(lblPassword);
		
		passField1 = new JTextField();
		passField1.setBounds(536, 96, 122, 24);
		frame.getContentPane().add(passField1);
		passField1.setColumns(10);
		
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePassword.setForeground(Color.ORANGE);
		lblChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblChangePassword.setBounds(536, 11, 122, 14);
		frame.getContentPane().add(lblChangePassword);
		
		passField2 = new JTextField();
		passField2.setColumns(10);
		passField2.setBounds(536, 36, 122, 24);
		frame.getContentPane().add(passField2);
		
		JLabel lblRetypePassword = new JLabel("Re-type Password");
		lblRetypePassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetypePassword.setForeground(Color.ORANGE);
		lblRetypePassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRetypePassword.setBounds(536, 71, 122, 14);
		frame.getContentPane().add(lblRetypePassword);
		
		JButton changepass = new JButton("Change");
		changepass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaintainUser maintain = new MaintainUser();
				MaintainLogins logins = new MaintainLogins();
				if(passField1.getText().equals(passField2.getText()) && passField1.getText().length() > 0 && passField2.getText().length() > 0) {
					JOptionPane.showMessageDialog(frame, "Password successfully changed", "Password Changed",
					        JOptionPane.INFORMATION_MESSAGE);
					try {
						maintain.load(path);
						logins.load(path2);
						for(User u: maintain.users) {
							if(u.getName().equals(user.getName())) {
								user.setPassword(passField1.getText());
								u.setPassword(passField1.getText());
								logins.logins.get(logins.logins.size() - 1).setPassword(passField1.getText());
								maintain.update(path);
								logins.update(path2);
								password.setText(user.getPassword());
							}
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else if(passField1.getText().isEmpty() || passField2.getText().isEmpty() 
						 || !(passField1.getText().equals(passField2.getText())) ) {
					JOptionPane.showMessageDialog(frame, "Passwords do not match or are empty.", "Password Change Error",
					        JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		changepass.setBackground(Color.BLACK);
		changepass.setForeground(Color.ORANGE);
		changepass.setBounds(536, 156, 122, 24);
		frame.getContentPane().add(changepass);
		
		JLabel permifield = new JLabel("Permissions");
		permifield.setHorizontalAlignment(SwingConstants.CENTER);
		permifield.setForeground(Color.ORANGE);
		permifield.setFont(new Font("Tahoma", Font.PLAIN, 12));
		permifield.setBounds(273, 11, 253, 14);
		frame.getContentPane().add(permifield);
		
		JLabel deletetag = new JLabel("Want to leave us?");
		deletetag.setHorizontalAlignment(SwingConstants.CENTER);
		deletetag.setForeground(Color.LIGHT_GRAY);
		deletetag.setFont(new Font("Tahoma", Font.PLAIN, 10));
		deletetag.setBounds(488, 568, 108, 14);
		frame.getContentPane().add(deletetag);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaintainUser maintain = new MaintainUser();
				
				try {
					maintain.load(path);
					int input = JOptionPane.showConfirmDialog(frame, 
	                        "Are you sure you want to delete your account, all of your data will be lost?", "Delete Confirmation", JOptionPane.OK_CANCEL_OPTION);
					
					
						for(User u: new ArrayList<User>(maintain.users)) {
							if(input == 0 && u.getName().equals(user.getName())) { 
								maintain.users.remove(u);
								JOptionPane.showMessageDialog(frame, "Account Deletion Successful.", "Deletion Success",
								        JOptionPane.INFORMATION_MESSAGE);
								maintain.update(path);
								Login login = new Login();
								login.frmLoginSmartshoppers.setVisible(true);
								frame.dispose();
							}
						}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setBackground(Color.LIGHT_GRAY);
		btnDelete.setBounds(602, 568, 62, 14);
		frame.getContentPane().add(btnDelete);
		
		username = new JTextField();
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setEditable(false);
		username.setBounds(80, 36, 193, 24);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		email = new JTextField();
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setEditable(false);
		email.setColumns(10);
		email.setBounds(10, 96, 263, 24);
		frame.getContentPane().add(email);
		
		storeid = new JTextField();
		storeid.setHorizontalAlignment(SwingConstants.CENTER);
		storeid.setEditable(false);
		storeid.setColumns(10);
		storeid.setBounds(10, 156, 72, 24);
		frame.getContentPane().add(storeid);
		
		permissions = new JTextField();
		permissions.setHorizontalAlignment(SwingConstants.CENTER);
		permissions.setEditable(false);
		permissions.setColumns(10);
		permissions.setBounds(273, 36, 253, 24);
		frame.getContentPane().add(permissions);
		
		password = new JTextField();
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setEditable(false);
		password.setColumns(10);
		password.setBounds(273, 96, 253, 24);
		frame.getContentPane().add(password);
		
		address = new JTextField();
		address.setHorizontalAlignment(SwingConstants.CENTER);
		address.setEditable(false);
		address.setColumns(10);
		address.setBounds(273, 156, 215, 24);
		frame.getContentPane().add(address);
		
		
		
		storename = new JTextField();
		storename.setHorizontalAlignment(SwingConstants.CENTER);
		storename.setEditable(false);
		storename.setColumns(10);
		storename.setBounds(80, 156, 193, 24);
		frame.getContentPane().add(storename);
		
		JLabel lblStoreName = new JLabel("Store Name");
		lblStoreName.setHorizontalAlignment(SwingConstants.CENTER);
		lblStoreName.setForeground(Color.ORANGE);
		lblStoreName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStoreName.setBounds(80, 132, 193, 14);
		frame.getContentPane().add(lblStoreName);
		
		userid = new JTextField();
		userid.setHorizontalAlignment(SwingConstants.CENTER);
		userid.setEditable(false);
		userid.setColumns(10);
		userid.setBounds(10, 36, 72, 24);
		frame.getContentPane().add(userid);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserId.setForeground(Color.ORANGE);
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUserId.setBounds(10, 11, 72, 14);
		frame.getContentPane().add(lblUserId);
		
		
		
		userid.setText(String.valueOf(user.getId()));
		username.setText(user.getName());
		password.setText(user.getPassword());
		email.setText(user.getEmail());
		permissions.setText(user.getPermissions());
		
		kms = new JTextField();
		kms.setHorizontalAlignment(SwingConstants.CENTER);
		kms.setEditable(false);
		kms.setColumns(10);
		kms.setBounds(486, 156, 40, 24);
		frame.getContentPane().add(kms);
		
		JLabel kmstag = new JLabel("Kms");
		kmstag.setHorizontalAlignment(SwingConstants.CENTER);
		kmstag.setForeground(Color.ORANGE);
		kmstag.setFont(new Font("Tahoma", Font.PLAIN, 12));
		kmstag.setBounds(486, 132, 40, 14);
		frame.getContentPane().add(kmstag);
		
		
		try {
			MaintainStore maintain = new MaintainStore();
			maintain.load(path4);
			
			for(Stores s: maintain.stores) {
				if(s.getstoreID() == user.getstoreID()) {
					address.setText(s.getAddress());
					storeid.setText(String.valueOf(s.getstoreID()));
					storename.setText(s.getName());
					kms.setText(String.valueOf(s.getDistance()));
				}
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MaintainUser maintain = new MaintainUser();
				MaintainLogins logins = new MaintainLogins();
				MaintainStore stores = new MaintainStore();
				try {
					maintain.load(path);
					logins.load(path2);
					stores.load(path4);
					
					if(!isStoreSelected(table)) {
						JOptionPane.showMessageDialog(frame, "Please select a store from the table of available stores to change location preferences.", "Preference Error",
						        JOptionPane.ERROR_MESSAGE);
					}else {
						int selectedROW = table.getSelectedRow();
						int StoreIDCELL = Integer.parseInt(tb1.getValueAt(selectedROW, 0).toString());
						String StoreNameCELL = String.valueOf(tb1.getValueAt(selectedROW, 1));
						String StoreAddressCELL = String.valueOf(tb1.getValueAt(selectedROW, 2));
						String StoreDistanceCELL = String.valueOf(tb1.getValueAt(selectedROW, 3));
						
						String[] data = {storeid.getText(), storename.getText(), address.getText(), kms.getText()};
						tb1.addRow(data);
						
						storeid.setText(String.valueOf(StoreIDCELL));
						storename.setText(StoreNameCELL);
						address.setText(StoreAddressCELL);
						kms.setText(StoreDistanceCELL);
						tb1.removeRow(selectedROW);
						
						
						
							if(isCurUser(user)) {
								User u = getCurUser(user);
								u.setstoreID(StoreIDCELL);
								setStoreID(getCurUser(user),StoreIDCELL);
								user.setstoreID(StoreIDCELL);
								logins.logins.get(logins.logins.size() - 1).setstoreID(StoreIDCELL);	
							}
							
							logins.update(path2);
							
							JOptionPane.showMessageDialog(frame, "Store Preference Successfully Changed", "Preference Change Success",
							        JOptionPane.INFORMATION_MESSAGE);
						
						maintain.load(path);
						stores.load(path4);
						logins.load(path2);
						
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		if(user.getPermissions().equals("Manager")) {
			deletetag.setVisible(false);
			btnDelete.setVisible(false);
			btnNewButton.setVisible(false);
			sttag.setText("Stores In System");
			kmstag.setVisible(false);
			kms.setVisible(false);
		}else if(user.getPermissions().equals("Admin")) {
			deletetag.setVisible(false);
			btnDelete.setVisible(false);
			btnNewButton.setVisible(false);
			sttag.setText("Stores In System");
			kmstag.setVisible(false);
			kms.setVisible(false);
		}
		
	}
	
	public boolean isStoreSelected(JTable table) {
		if(table.getSelectedRow() != -1) {
			return true;
		}
		
		return false;
	}
	
	public boolean isCurUser(User user) {
		MaintainUser maintain = new MaintainUser();
		
		try {
			maintain.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(User u: maintain.users) {
			if(u.getId() == user.getId()) {
				return true;
			}
		}
		
		return false;
	}
	
	public User getCurUser(User user) {
		MaintainUser maintain = new MaintainUser();
		
		try {
			maintain.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(User u: maintain.users) {
			if(u.getId() == user.getId()) {
				return u;
			}
		}
		
		return null;
	}
	
	public void setStoreID( User user, int storeid) {
		MaintainUser maintain = new MaintainUser();
		
		try {
			maintain.load(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(User u: maintain.users) {
			if(u.getId() == user.getId()) {
				u.setstoreID(storeid);
				try {
					maintain.update(path);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
}
