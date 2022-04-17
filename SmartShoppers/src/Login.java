import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.ListSelectionModel;



public class Login {

	JFrame frmLoginSmartshoppers;
	private JTextField usernameField;
	private JPasswordField passwordField;
	String path = "C:\\Users\\PC\\Desktop\\user.csv";
	String path2 = "C:\\Users\\PC\\Desktop\\logins.csv";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLoginSmartshoppers.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	
	public boolean userExists(User user) {
		MaintainUser maintain = new MaintainUser();
		
		try {
			maintain.load(path);
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(User u: maintain.users) {
			if(u.getName().equals(user.getName()) && u.getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmLoginSmartshoppers = new JFrame();
		frmLoginSmartshoppers.setBackground(Color.WHITE);
		frmLoginSmartshoppers.setForeground(new Color(0, 0, 0));
		frmLoginSmartshoppers.setTitle("Login | SmartShoppers");
		frmLoginSmartshoppers.getContentPane().setBackground(Color.DARK_GRAY);
		frmLoginSmartshoppers.setBounds(100, 100, 588, 404);
		frmLoginSmartshoppers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginSmartshoppers.setResizable(false);
		
		JLabel LoginLabel = new JLabel("Authentication");
		LoginLabel.setBounds(200, 11, 192, 37);
		LoginLabel.setForeground(Color.ORANGE);
		LoginLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		LoginLabel.setBackground(Color.WHITE);
		LoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label = new JLabel("");
		label.setBounds(202, 182, 0, 0);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(207, 182, 0, 0);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(212, 182, 0, 0);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(217, 182, 0, 0);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(222, 182, 0, 0);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(227, 182, 0, 0);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(265, 95, 54, 15);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		usernameField = new JTextField();
		usernameField.setBounds(217, 121, 156, 28);
		usernameField.setBackground(Color.WHITE);
		usernameField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setBounds(265, 160, 51, 15);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(217, 182, 156, 28);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaintainUser maintain = new MaintainUser();
				
				try {
					maintain.load(path);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				User user = new User();
				for(User u: maintain.users) {
					if(u.getName().equals(usernameField.getText()) && u.getPassword().equals(String.valueOf(passwordField.getPassword()))) {
						user.setName(u.getName());
						user.setEmail(u.getEmail());
						user.setId(u.getId());
						user.setPassword(u.getPassword());
						user.setPermissions(u.getPermissions());
						user.setstoreID(u.getstoreID());
					}
					
					
				}
				
				if(userExists(user) && user.getPermissions().equals("Manager")) {
					JOptionPane.showMessageDialog(frmLoginSmartshoppers, "Manager Login Successful", "Login Successful",
					        JOptionPane.INFORMATION_MESSAGE);
					Manager manager = new Manager(user);
					manager.frmManagerControls.setVisible(true);
					frmLoginSmartshoppers.dispose();
					
				}else if(userExists(user) && user.getPermissions().equals("Admin")) {
					JOptionPane.showMessageDialog(frmLoginSmartshoppers, "Admin Login Successful", "Login Successful",
					        JOptionPane.INFORMATION_MESSAGE);
					Admin admin = new Admin(user);
					admin.frmAdminControls.setVisible(true);
					frmLoginSmartshoppers.dispose();
				}else if(userExists(user) && user.getPermissions().equals("Customer")) {
					JOptionPane.showMessageDialog(frmLoginSmartshoppers, "Login Successful", "Login Successful",
					        JOptionPane.INFORMATION_MESSAGE);
					store1 store = new store1(user);
					store.frmSmartshoppers.setVisible(true);
					frmLoginSmartshoppers.dispose();
				}else if(!userExists(user)) {
					JOptionPane.showMessageDialog(frmLoginSmartshoppers, "Username or Password is incorrect.", "Login Error",
					        JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(241, 239, 104, 28);
		btnNewButton.setForeground(Color.ORANGE);
		btnNewButton.setBackground(Color.BLACK);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_1.setForeground(Color.ORANGE);
		btnNewButton_1.setBounds(241, 331, 104, 23);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Signup signupwindow = new Signup();
				signupwindow.frame.setVisible(true);
				frmLoginSmartshoppers.dispose();
			}
		});
		frmLoginSmartshoppers.getContentPane().setLayout(null);
		frmLoginSmartshoppers.getContentPane().add(LoginLabel);
		frmLoginSmartshoppers.getContentPane().add(label);
		frmLoginSmartshoppers.getContentPane().add(label_1);
		frmLoginSmartshoppers.getContentPane().add(label_2);
		frmLoginSmartshoppers.getContentPane().add(label_3);
		frmLoginSmartshoppers.getContentPane().add(label_4);
		frmLoginSmartshoppers.getContentPane().add(label_5);
		frmLoginSmartshoppers.getContentPane().add(lblNewLabel);
		frmLoginSmartshoppers.getContentPane().add(usernameField);
		frmLoginSmartshoppers.getContentPane().add(lblNewLabel_1);
		frmLoginSmartshoppers.getContentPane().add(passwordField);
		frmLoginSmartshoppers.getContentPane().add(btnNewButton);
		frmLoginSmartshoppers.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dont have an account? Sign up here");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(172, 306, 245, 14);
		frmLoginSmartshoppers.getContentPane().add(lblNewLabel_2);
		frmLoginSmartshoppers.setPreferredSize(new Dimension(1000, 500));
	}
	

	
}
