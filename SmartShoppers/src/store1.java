import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class store1 {

	JFrame frmSmartshoppers;
	//String path = "C:\\Users\\PC\\Desktop\\user.csv";
	//String path2 = "C:\\Users\\PC\\Desktop\\logins.csv";
	String path3 = "C:\\Users\\PC\\Desktop\\items.csv";
	String path4 = "C:\\Users\\PC\\Desktop\\stores.csv";
	private JTextField bar;
	private JTextField storeaddress;
	//Map<item,Integer> cart = new HashMap<item,Integer>();
	private JTextField shopname;
	private JTextField shopaddy;
	private JTextField shophours;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					store1 window = new store1(new User());
					window.frmSmartshoppers.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public store1(User user) {
		initialize(user);
		
	}
	
	public Stores getStoreByID(int storeid) {
		MaintainStore maintain =  new MaintainStore();
		
		try {
			maintain.load(path4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		for(Stores s: maintain.stores) {
			if(s.getstoreID() == storeid) {
				return s;
			}
		}
		return null;
		
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User user) {
		String cartpath = "C:\\Users\\PC\\Desktop\\" + user.getName()+".csv";
		frmSmartshoppers = new JFrame();
		frmSmartshoppers.setTitle("SmartShoppers | Store 1");
		frmSmartshoppers.setBackground(Color.WHITE);
		frmSmartshoppers.setBounds(100, 100, 898, 599);
		frmSmartshoppers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSmartshoppers.getContentPane().setLayout(null);
		frmSmartshoppers.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 198, 563);
		frmSmartshoppers.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel tab1 = new JPanel();
		
		tab1.setBackground(Color.GRAY);
		tab1.setBounds(10, 196, 178, 36);
		panel.add(tab1);
		tab1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HOME");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(54, 0, 70, 36);
		tab1.add(lblNewLabel);
		
		JPanel tab2 = new JPanel();
		
		tab2.setBackground(Color.DARK_GRAY);
		tab2.setLayout(null);
		tab2.setBounds(10, 243, 178, 36);
		panel.add(tab2);
		
		JLabel lblProfile = new JLabel("PROFILE");
		lblProfile.setForeground(Color.ORANGE);
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProfile.setBounds(54, 0, 70, 36);
		tab2.add(lblProfile);
		
		JPanel tab3 = new JPanel();
	
		tab3.setBackground(Color.DARK_GRAY);
		tab3.setLayout(null);
		tab3.setBounds(10, 290, 178, 36);
		panel.add(tab3);
		
		JLabel carttag = new JLabel("CART");
		carttag.setForeground(Color.ORANGE);
		carttag.setHorizontalAlignment(SwingConstants.CENTER);
		carttag.setFont(new Font("Tahoma", Font.PLAIN, 15));
		carttag.setBounds(54, 0, 70, 36);
		tab3.add(carttag);
		
		MaintainCart cart = new MaintainCart();
		
		try {
			cart.load(cartpath);
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		if(cart.cartitems.size() == 0) {
			carttag.setText("CART[0]");
		}else {
		int cartsize = cart.cartitems.size();
		carttag.setText("CART [" + cartsize + "]");
		}
		
		
		JPanel tab4 = new JPanel();
		
		tab4.setBackground(Color.DARK_GRAY);
		tab4.setLayout(null);
		tab4.setBounds(10, 516, 178, 36);
		panel.add(tab4);
		
		JLabel lblLogout = new JLabel("LOGOUT");
		lblLogout.setForeground(Color.ORANGE);
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLogout.setBounds(54, 0, 70, 36);
		tab4.add(lblLogout);
		
	
		
		JLabel lblNewLabel_1 = new JLabel("SmartShoppers");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 0, 178, 36);
		panel.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.ORANGE);
		separator.setForeground(Color.ORANGE);
		separator.setBounds(25, 34, 148, 2);
		panel.add(separator);
		
		storeaddress = new JTextField();
		storeaddress.setHorizontalAlignment(SwingConstants.CENTER);
		storeaddress.setFont(new Font("Tahoma", Font.PLAIN, 11));
		storeaddress.setForeground(Color.ORANGE);
		storeaddress.setEditable(false);
		storeaddress.setBackground(Color.BLACK);
		storeaddress.setBounds(10, 469, 178, 36);
		panel.add(storeaddress);
		storeaddress.setColumns(10);
		
		storeaddress.setText("[" + user.getId() + "]: " + user.getName());
		
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(196, 0, 686, 563);
		frmSmartshoppers.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		jp1.setBackground(Color.DARK_GRAY);
		jp1.setBounds(0, 61, 686, 502);
		panel_1.add(jp1);
		
		JPanel jp1_1 = new JPanel();
		jp1_1.setBackground(Color.DARK_GRAY);
		jp1_1.setBounds(0, 0, 686, 61);
		panel_1.add(jp1_1);
		jp1_1.setLayout(null);
		
		bar = new JTextField();
		bar.setForeground(Color.ORANGE);
		bar.setColumns(10);
		bar.setBackground(Color.BLACK);
		bar.setBounds(201, 21, 332, 29);
		jp1_1.add(bar);
		
		JButton search = new JButton("Search");
		
		
		search.setForeground(Color.BLACK);
		search.setBackground(Color.ORANGE);
		search.setBounds(533, 21, 89, 29);
		jp1_1.add(search);
		
		JComboBox comboBox = new JComboBox();
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"All", "Food", "Accessories", "Appliances", "Electronics", "Cleaning", "Clothes", "Office", "Sale", "Available"}));
		comboBox.setSelectedIndex(0);
		comboBox.setForeground(Color.ORANGE);
		comboBox.setBackground(Color.BLACK);
		comboBox.setBounds(49, 21, 152, 29);
		jp1_1.add(comboBox);
		
		MaintainItem item = new MaintainItem();
		Map<JButton,String> buttons = new HashMap<JButton,String>();
		Map<JButton,Boolean> sale = new HashMap<JButton,Boolean>();
		Map<JButton,Boolean> available = new HashMap<JButton,Boolean>();
		ArrayList<JButton> Food = new ArrayList<JButton>();
		ArrayList<JButton> Accessories = new ArrayList<JButton>();
		ArrayList<JButton> Appliances = new ArrayList<JButton>();
		ArrayList<JButton> Electronics = new ArrayList<JButton>();
		ArrayList<JButton> Cleaning = new ArrayList<JButton>();
		ArrayList<JButton> Office = new ArrayList<JButton>();
		ArrayList<JButton> Sale = new ArrayList<JButton>();
		ArrayList<JButton> Available = new ArrayList<JButton>();
		ArrayList<JButton> Clothes = new ArrayList<JButton>();
		
		
		try {
			
			
			item.load(path3);
			jp1.setLayout(new java.awt.FlowLayout(0,40,30));

			for(item i: item.items) {
				
				JButton b = new JButton(String.valueOf(i.getName()));
				buttons.put(b, i.getCategory());
				sale.put(b,i.getonSale());
				available.put(b,i.getisItemAvailable());
				
				
				b.setForeground(Color.ORANGE);
				b.setBackground(Color.BLACK);
				b.setPreferredSize(new Dimension(120,25));
				jp1.add(b);
				
				b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int viewed = i.getnumTimesViewed();
						i.setnumTimesViewed(viewed + 1);
						
						try {
							item.update(path3);
							//item.load(path3);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						ItemInfo Info = new ItemInfo(i, user);
						Info.frame.setVisible(true);
						frmSmartshoppers.dispose();
					}
				});
			}
				
				
				buttons.entrySet().forEach(entry -> {
				    if(entry.getValue().toString().equals("Food")) {
				    	Food.add(entry.getKey());
				    }else if(entry.getValue().toString().equals("Accessories")) {
				    	Accessories.add(entry.getKey());
				    }else if(entry.getValue().toString().equals("Appliances")) {
				    	Appliances.add(entry.getKey());
				    }else if(entry.getValue().toString().equals("Electronics")) {
				    	Electronics.add(entry.getKey());
				    }else if(entry.getValue().toString().equals("Cleaning")) {
				    	Cleaning.add(entry.getKey());
				    }else if(entry.getValue().toString().equals("Office")) {
				    	Office.add(entry.getKey());
				    }else if(entry.getValue().toString().equals("Available")) {
				    	Available.add(entry.getKey());
				    }else if(entry.getValue().toString().equals("Clothes")) {
				    	Clothes.add(entry.getKey());
				    }
				});
				
				sale.entrySet().forEach(entry -> {
				    if(entry.getValue().equals(true)) {
				    	Sale.add(entry.getKey());
				    }
				});
				
				available.entrySet().forEach(entry -> {
				    if(entry.getValue().equals(true)) {
				    	Available.add(entry.getKey());
				    }
				});
				
				
				
				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						buttons.entrySet().forEach(entry -> {
							if(comboBox.getSelectedItem().equals("Reset")) {
								for(JButton buttons: Food) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Accessories) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Appliances) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Electronics) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Cleaning) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Office) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Clothes) {
						    		buttons.setVisible(false);
						    	}
							}
							
						    if(comboBox.getSelectedItem().equals("Food")) {
						    	for(JButton buttons: Food) {
						    		buttons.setVisible(true);
						    	}
						    	for(JButton buttons: Accessories) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Appliances) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Electronics) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Cleaning) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Office) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Clothes) {
						    		buttons.setVisible(false);
						    	}
						    	
						    }
						    
						    if(comboBox.getSelectedItem().equals("Accessories")) {
						    	for(JButton buttons: Food) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Accessories) {
						    		buttons.setVisible(true);
						    	}
						    	for(JButton buttons: Appliances) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Electronics) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Cleaning) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Office) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Clothes) {
						    		buttons.setVisible(false);
						    	}
						    }
						    
						    if(comboBox.getSelectedItem().equals("Appliances")) {
						    	for(JButton buttons: Food) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Accessories) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Appliances) {
						    		buttons.setVisible(true);
						    	}
						    	for(JButton buttons: Electronics) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Cleaning) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Office) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Clothes) {
						    		buttons.setVisible(false);
						    	}
						    }
						    
						    if(comboBox.getSelectedItem().equals("Electronics")) {
						    	for(JButton buttons: Food) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Accessories) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Appliances) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Electronics) {
						    		buttons.setVisible(true);
						    	}
						    	for(JButton buttons: Cleaning) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Office) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Clothes) {
						    		buttons.setVisible(false);
						    	}
						    }
						    
						    if(comboBox.getSelectedItem().equals("Cleaning")) {
						    	for(JButton buttons: Food) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Accessories) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Appliances) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Electronics) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Cleaning) {
						    		buttons.setVisible(true);
						    	}
						    	for(JButton buttons: Office) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Clothes) {
						    		buttons.setVisible(false);
						    	}
						    }
						    
						    if(comboBox.getSelectedItem().equals("Office")) {
						    	for(JButton buttons: Food) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Accessories) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Appliances) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Electronics) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Cleaning) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Office) {
						    		buttons.setVisible(true);
						    	}
						    	for(JButton buttons: Clothes) {
						    		buttons.setVisible(false);
						    	}
						    }
						    
						    if(comboBox.getSelectedItem().equals("Clothes")) {
						    	for(JButton buttons: Food) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Accessories) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Appliances) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Electronics) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Cleaning) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Office) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Clothes) {
						    		buttons.setVisible(true);
						    	}
						    }
						    
						    if(comboBox.getSelectedItem().equals("Sale")) {
						    	for(JButton buttons: Food) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Accessories) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Appliances) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Electronics) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Cleaning) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Office) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Clothes) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Sale) {
						    		buttons.setVisible(true);
						    	}
						    	
						    }
						    
						    if(comboBox.getSelectedItem().equals("Available")) {
						    	for(JButton buttons: Food) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Accessories) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Appliances) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Electronics) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Cleaning) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Office) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Clothes) {
						    		buttons.setVisible(false);
						    	}
						    	for(JButton buttons: Available) {
						    		buttons.setVisible(true);
						    	}
						    	
						    }
						    
						    if(comboBox.getSelectedItem().equals("All")) {
						    	for(JButton buttons: Food) {
						    		buttons.setVisible(true);
						    	}
						    	for(JButton buttons: Accessories) {
						    		buttons.setVisible(true);
						    	}
						    	for(JButton buttons: Appliances) {
						    		buttons.setVisible(true);
						    	}
						    	for(JButton buttons: Electronics) {
						    		buttons.setVisible(true);
						    	}
						    	for(JButton buttons: Cleaning) {
						    		buttons.setVisible(true);
						    	}
						    	for(JButton buttons: Office) {
						    		buttons.setVisible(true);
						    	}
						    	for(JButton buttons: Clothes) {
						    		buttons.setVisible(true);
						    	}
						    	
						    }
						    
						    
						    
						});
					}
				});
				
				
				search.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					    	buttons.entrySet().forEach(entry -> {
					    		if(bar.getText().equals("")) {
								   entry.getKey().setVisible(true);
					    	}else if(bar.getText().equals("Food") || bar.getText().equals("food")) {
					    		if(entry.getValue().equals("Food")) {
					    			entry.getKey().setVisible(true);
					    		}else {
					    			entry.getKey().setVisible(false);
					    		}
					    	}else if(bar.getText().equals("Accessories") || bar.getText().equals("accessories")) {
					    		if(entry.getValue().equals("Accessories")) {
					    			entry.getKey().setVisible(true);
					    		}else {
					    			entry.getKey().setVisible(false);
					    		}
					    	}else if(bar.getText().equals("Appliances") || bar.getText().equals("appliances")) {
					    		if(entry.getValue().equals("Appliances")) {
					    			entry.getKey().setVisible(true);
					    		}else {
					    			entry.getKey().setVisible(false);
					    		}
					    	}else if(bar.getText().equals("Electronics") || bar.getText().equals("electronics")) {
					    		if(entry.getValue().equals("Electronics")) {
					    			entry.getKey().setVisible(true);
					    		}else {
					    			entry.getKey().setVisible(false);
					    		}
					    	}else if(bar.getText().equals("Clothes") || bar.getText().equals("clothes")) {
					    		if(entry.getValue().equals("Clothes")) {
					    			entry.getKey().setVisible(true);
					    		}else {
					    			entry.getKey().setVisible(false);
					    		}
					    	}else if(bar.getText().equals("Office") || bar.getText().equals("office")) {
					    		if(entry.getValue().equals("Office")) {
					    			entry.getKey().setVisible(true);
					    		}else {
					    			entry.getKey().setVisible(false);
					    		}
					    	}else if(bar.getText().equals("Cleaning") || bar.getText().equals("cleaning")) {
					    		if(entry.getValue().equals("Cleaning")) {
					    			entry.getKey().setVisible(true);
					    		}else {
					    			entry.getKey().setVisible(false);
					    		}
					    	}else if(entry.getKey().getText().equals(bar.getText())) {
					    		entry.getKey().setVisible(true);
					    	}else if(entry.getKey().getText().toLowerCase().equals(bar.getText().toLowerCase())) {
					    		entry.getKey().setVisible(true);
					    	}else {
					    		entry.getKey().setVisible(false);
					    	}
						});
					    	
					    	sale.entrySet().forEach(entry -> {
					    		 if(bar.getText().equals("Sale") || bar.getText().equals("sale")) {
						    		if(entry.getValue() == true) {
						    			entry.getKey().setVisible(true);
						    		}else {
						    			entry.getKey().setVisible(false);
						    		}
						    	}
					    	});
					    	
					    	available.entrySet().forEach(entry -> {
					    		 if(bar.getText().equals("Available") || bar.getText().equals("available")) {
						    		if(entry.getValue() == true) {
						    			entry.getKey().setVisible(true);
						    		}else {
						    			entry.getKey().setVisible(false);
						    		}
						    	}
					    	});
					    	
						}
					
				});
				
				
			
			
			
			
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		tab1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jp1.setVisible(true);
				tab1.setBackground(Color.GRAY);
				store1 store1 = new store1(user);
				store1.frmSmartshoppers.setVisible(true);
				frmSmartshoppers.dispose();
			}
		});
		
		tab2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				MaintainUser maintain = new MaintainUser();
				try {
							profile profile = new profile(user);
							profile.frame.setVisible(true);
							frmSmartshoppers.dispose();
						
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		
		//carttag.setText("CART (" + cartitems + ")");
		
		shopname = new JTextField();
		shopname.setFont(new Font("Tahoma", Font.BOLD, 12));
		shopname.setHorizontalAlignment(SwingConstants.CENTER);
		shopname.setForeground(Color.WHITE);
		shopname.setBackground(Color.BLACK);
		shopname.setEditable(false);
		shopname.setBounds(10, 47, 178, 43);
		panel.add(shopname);
		shopname.setColumns(10);
		
		
		shopaddy = new JTextField();
		shopaddy.setText("RANDOM SHIT");
		shopaddy.setHorizontalAlignment(SwingConstants.CENTER);
		shopaddy.setForeground(Color.WHITE);
		shopaddy.setEditable(false);
		shopaddy.setColumns(10);
		shopaddy.setBackground(Color.BLACK);
		shopaddy.setBounds(10, 90, 178, 43);
		panel.add(shopaddy);
		
		shophours = new JTextField();
		shophours.setText("RANDOM SHIT");
		shophours.setHorizontalAlignment(SwingConstants.CENTER);
		shophours.setForeground(Color.WHITE);
		shophours.setEditable(false);
		shophours.setColumns(10);
		shophours.setBackground(Color.BLACK);
		shophours.setBounds(10, 132, 178, 43);
		panel.add(shophours);
		shopname.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		shophours.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		shopaddy.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		MaintainStore maintain = new MaintainStore();
		try {
			maintain.load(path4);
			
			Stores s =  getStoreByID(user.getstoreID());
			
			shopname.setText(s.getName());
			shopaddy.setText(s.getAddress());
			shophours.setText(s.getOpening() + " - " + s.getClosing());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		tab3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// go to cart
				ShoppingCart shop = new ShoppingCart(user);
				shop.frame.setVisible(true);
				frmSmartshoppers.dispose();
			}
		});
		
		tab4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.frmLoginSmartshoppers.setVisible(true);
				frmSmartshoppers.dispose();
			}
		});
		
		if(user.getPermissions().equals("Manager")) {
			JPanel controlstab = new JPanel();
			controlstab.setLayout(null);
			controlstab.setBackground(Color.DARK_GRAY);
			controlstab.setBounds(10, 337, 178, 36);
			panel.add(controlstab);
			
			JLabel controlstag = new JLabel(" MANAGER CONTROLS");
			controlstag.setHorizontalAlignment(SwingConstants.CENTER);
			controlstag.setForeground(Color.ORANGE);
			controlstag.setFont(new Font("Tahoma", Font.PLAIN, 13));
			controlstag.setBounds(0, 0, 178, 36);
			controlstab.add(controlstag);
			
			controlstab.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Manager manager = new Manager(user);
					manager.frmManagerControls.setVisible(true);
					frmSmartshoppers.dispose();
				}
			});
		}else if(user.getPermissions().equals("Admin")) {
			JPanel controlstab = new JPanel();
			controlstab.setLayout(null);
			controlstab.setBackground(Color.DARK_GRAY);
			controlstab.setBounds(10, 337, 178, 36);
			panel.add(controlstab);
			
			JLabel controlstag = new JLabel("ADMIN CONTROLS");
			controlstag.setHorizontalAlignment(SwingConstants.CENTER);
			controlstag.setForeground(Color.ORANGE);
			controlstag.setFont(new Font("Tahoma", Font.PLAIN, 13));
			controlstag.setBounds(0, 0, 178, 36);
			controlstab.add(controlstag);
			controlstab.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Admin admin = new Admin(user);
					admin.frmAdminControls.setVisible(true);
					frmSmartshoppers.dispose();
				}
			});
			
			
			
		}
	}
}
