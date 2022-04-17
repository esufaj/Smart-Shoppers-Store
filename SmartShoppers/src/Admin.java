import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.border.MatteBorder;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Admin {

	JFrame frmAdminControls;
	String path = "C:\\Users\\PC\\Desktop\\user.csv";
	String path2 = "C:\\Users\\PC\\Desktop\\logins.csv";
	String path3 = "C:\\Users\\PC\\Desktop\\items.csv";
	String path4 = "C:\\Users\\PC\\Desktop\\stores.csv";
	private JTextField Name;
	private JTextField Size;
	private JTextField Price;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField passwordField;
	private JTextField n;
	private JTextField a;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin(new User());
					window.frmAdminControls.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin(User user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User user) {
		frmAdminControls = new JFrame();
		frmAdminControls.getContentPane().setForeground(Color.WHITE);
		frmAdminControls.setTitle("Admin | Controls");
		frmAdminControls.getContentPane().setBackground(Color.DARK_GRAY);
		frmAdminControls.getContentPane().setLayout(null);
		frmAdminControls.setResizable(false);
		
		JComboBox itemslist = new JComboBox();
		
		//itemslist.setModel(new DefaultComboBoxModel(new String[] {"this"}));
		itemslist.setForeground(Color.ORANGE);
		itemslist.setBackground(Color.BLACK);
		itemslist.setBounds(353, 303, 138, 22);
		frmAdminControls.getContentPane().add(itemslist);
		
		JLabel name = new JLabel("Name");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setForeground(Color.ORANGE);
		name.setFont(new Font("Tahoma", Font.PLAIN, 13));
		name.setBounds(491, 286, 136, 14);
		frmAdminControls.getContentPane().add(name);
		
		JLabel itemid = new JLabel("Item ID");
		itemid.setHorizontalAlignment(SwingConstants.CENTER);
		itemid.setForeground(Color.ORANGE);
		itemid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		itemid.setBounds(353, 340, 138, 14);
		frmAdminControls.getContentPane().add(itemid);
		
		JLabel size = new JLabel("Size");
		size.setHorizontalAlignment(SwingConstants.CENTER);
		size.setForeground(Color.ORANGE);
		size.setFont(new Font("Tahoma", Font.PLAIN, 13));
		size.setBounds(627, 286, 136, 14);
		frmAdminControls.getContentPane().add(size);
		
		JLabel category = new JLabel("Category");
		category.setHorizontalAlignment(SwingConstants.CENTER);
		category.setForeground(Color.ORANGE);
		category.setFont(new Font("Tahoma", Font.PLAIN, 13));
		category.setBounds(491, 340, 136, 14);
		frmAdminControls.getContentPane().add(category);
		
		JLabel price = new JLabel("Price");
		price.setHorizontalAlignment(SwingConstants.CENTER);
		price.setForeground(Color.ORANGE);
		price.setFont(new Font("Tahoma", Font.PLAIN, 13));
		price.setBounds(627, 342, 136, 14);
		frmAdminControls.getContentPane().add(price);
		
		JLabel availability = new JLabel("Availability");
		availability.setHorizontalAlignment(SwingConstants.CENTER);
		availability.setForeground(Color.ORANGE);
		availability.setFont(new Font("Tahoma", Font.PLAIN, 13));
		availability.setBounds(491, 389, 136, 14);
		frmAdminControls.getContentPane().add(availability);
		
		JLabel aislenumber = new JLabel("Aisle");
		aislenumber.setHorizontalAlignment(SwingConstants.CENTER);
		aislenumber.setForeground(Color.ORANGE);
		aislenumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		aislenumber.setBounds(353, 389, 138, 14);
		frmAdminControls.getContentPane().add(aislenumber);
		
		JLabel sale = new JLabel("Sale");
		sale.setHorizontalAlignment(SwingConstants.CENTER);
		sale.setForeground(Color.ORANGE);
		sale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sale.setBounds(627, 389, 136, 14);
		frmAdminControls.getContentPane().add(sale);
		
		Name = new JTextField();
		Name.setForeground(Color.WHITE);
		Name.setBackground(Color.BLACK);
		Name.setBounds(491, 303, 136, 22);
		frmAdminControls.getContentPane().add(Name);
		Name.setColumns(10);
		
		Size = new JTextField();
		Size.setForeground(Color.WHITE);
		Size.setBackground(Color.BLACK);
		Size.setColumns(10);
		Size.setBounds(627, 303, 136, 22);
		frmAdminControls.getContentPane().add(Size);
		
		JSpinner ItemID = new JSpinner();
		ItemID.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		ItemID.setForeground(Color.WHITE);
		ItemID.setBackground(Color.BLACK);
		ItemID.setBounds(353, 356, 138, 22);
		frmAdminControls.getContentPane().add(ItemID);
		
		JComboBox Category = new JComboBox();
		Category.setForeground(Color.WHITE);
		Category.setBackground(Color.BLACK);
		Category.setModel(new DefaultComboBoxModel(new String[] {"Food", "Accessories", "Appliances", "Electronics", "Cleaning", "Office", "Clothes"}));
		Category.setBounds(491, 356, 136, 22);
		frmAdminControls.getContentPane().add(Category);
		
		JSpinner Aisle = new JSpinner();
		Aisle.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		Aisle.setForeground(Color.WHITE);
		Aisle.setBackground(Color.BLACK);
		Aisle.setBounds(353, 402, 138, 22);
		frmAdminControls.getContentPane().add(Aisle);
		
		JComboBox Sale = new JComboBox();
		Sale.setForeground(Color.WHITE);
		Sale.setBackground(Color.BLACK);
		Sale.setModel(new DefaultComboBoxModel(new String[] {"true", "false"}));
		Sale.setSelectedIndex(0);
		Sale.setBounds(627, 402, 136, 22);
		frmAdminControls.getContentPane().add(Sale);
		
		JTextArea Description = new JTextArea();
		Description.setWrapStyleWord(true);
		Description.setLineWrap(true);
		Description.setForeground(Color.WHITE);
		Description.setBackground(Color.BLACK);
		Description.setBounds(353, 437, 281, 105);
		frmAdminControls.getContentPane().add(Description);
		
		JComboBox Availability = new JComboBox();
		Availability.setModel(new DefaultComboBoxModel(new String[] {"true", "false"}));
		Availability.setSelectedIndex(0);
		Availability.setForeground(Color.WHITE);
		Availability.setBackground(Color.BLACK);
		Availability.setBounds(491, 402, 136, 22);
		frmAdminControls.getContentPane().add(Availability);
		
		JButton additem = new JButton("Add Item");
		
		additem.setForeground(Color.ORANGE);
		additem.setBackground(Color.BLACK);
		additem.setBounds(353, 553, 95, 32);
		frmAdminControls.getContentPane().add(additem);
		
		JButton removeitem = new JButton("Remove");
		removeitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaintainItem maintain = new MaintainItem();
				
				try {
					maintain.load(path3);
					
					if(itemslist.getSelectedIndex() == -1) {
						JOptionPane.showMessageDialog(frmAdminControls, "To remove an item, please choose an item from the item list.", "Removal Error",
						        JOptionPane.ERROR_MESSAGE);
					}else {
						//Iterator<item> items = maintain.items.iterator();
						/*while(items.hasNext()) {
							item s = items.next();
							if(s.getName().equals(itemslist.getSelectedItem())) {
								items.remove();
								maintain.update(path3);
								JOptionPane.showMessageDialog(frmManagerControls, "Item Successfully Removed.", "Item Removal Success",
								        JOptionPane.INFORMATION_MESSAGE);
								maintain.load(path3);
								itemslist.removeItem(s.getName());
							}
							
							
						}*/
						int input = JOptionPane.showConfirmDialog(frmAdminControls, 
		                        "Are you sure you want to remove this item?", "Remove Item Confirmation", JOptionPane.OK_CANCEL_OPTION);
						
						for(item items: new ArrayList<item>(maintain.items)) {
							if(items.getName().equals(itemslist.getSelectedItem()) && input == 0) {
								maintain.items.remove(items);
								maintain.update(path3);
								JOptionPane.showMessageDialog(frmAdminControls, "Item Successfully Removed.", "Item Removal Success",
								        JOptionPane.INFORMATION_MESSAGE);
								maintain.load(path3);
								itemslist.removeItem(items.getName());
								break;
							}
						}

					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		removeitem.setForeground(Color.ORANGE);
		removeitem.setBackground(Color.BLACK);
		removeitem.setBounds(539, 553, 95, 32);
		frmAdminControls.getContentPane().add(removeitem);
		
		JButton edititem = new JButton("Edit Item");
		edititem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaintainItem maintain = new MaintainItem();
				
				try {
					maintain.load(path3);
					//boolean immut = false;
					for(int i = 0; i < maintain.items.size(); i++) {
					if(itemslist.getSelectedIndex() == -1) {
						JOptionPane.showMessageDialog(frmAdminControls, "To edit an item, please select an item from the list.", "Item Selection Error",
						        JOptionPane.ERROR_MESSAGE);
						break;
					}else if(Name.getText().isEmpty() || Size.getText().isEmpty() || Category.getSelectedIndex() == -1 ||
					   Availability.getSelectedIndex() == -1 || Sale.getSelectedIndex() == -1 || Description.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frmAdminControls, "Please complete all fields to edit item.", "Fields Empty Error",
						        JOptionPane.ERROR_MESSAGE);
						break;
					}else if(!Price.getText().matches("[0-9]{1,13}(\\.[0-9]*)?")) {
						JOptionPane.showMessageDialog(frmAdminControls, "Price is not a valid price. Please insert a valid price like: 5.36.", "Price Error",
						        JOptionPane.ERROR_MESSAGE);
						break;
					}else if(!Name.getText().equals(itemslist.getSelectedItem())) {
						JOptionPane.showMessageDialog(frmAdminControls, "Name cannot be edited. You may create a new items with the desired name.", "Name Error",
						        JOptionPane.ERROR_MESSAGE);
						break;
					}else if(maintain.items.get(i).getName().equals(itemslist.getSelectedItem().toString()) && maintain.items.get(i).getitemID() != Integer.parseInt(ItemID.getValue().toString())) {
						JOptionPane.showMessageDialog(frmAdminControls, "Item ID cannot be changed. You may create a new item with a valid item ID", "Item ID Error",
						        JOptionPane.ERROR_MESSAGE);
						break;
					} else if(maintain.items.get(i).getName().equals(itemslist.getSelectedItem().toString())) {
						maintain.items.get(i).setAisleNumber(Integer.parseInt(Aisle.getValue().toString()));
						maintain.items.get(i).setCategory(Category.getSelectedItem().toString());
						maintain.items.get(i).setDescription(Description.getText());
						maintain.items.get(i).setItemAvailability(Boolean.parseBoolean(Availability.getSelectedItem().toString()));
						maintain.items.get(i).setonSale(Boolean.parseBoolean(Sale.getSelectedItem().toString()));
						maintain.items.get(i).setPrice(Double.parseDouble(Price.getText()));
						maintain.items.get(i).setSize(Size.getText());
						JOptionPane.showMessageDialog(frmAdminControls, "Item Successfully Updated.", "Update Success",
						        JOptionPane.INFORMATION_MESSAGE);
						maintain.update(path3);
						//maintain.load(path3);
						break;
					}
					
						
					}
					//maintain.load(path3);
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		edititem.setForeground(Color.ORANGE);
		edititem.setBackground(Color.BLACK);
		edititem.setBounds(446, 553, 95, 32);
		frmAdminControls.getContentPane().add(edititem);
		
		JLabel lblSelectItem = new JLabel("Select Item");
		lblSelectItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectItem.setForeground(Color.ORANGE);
		lblSelectItem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelectItem.setBounds(353, 286, 138, 14);
		frmAdminControls.getContentPane().add(lblSelectItem);
		
		Price = new JTextField();
		Price.setForeground(Color.WHITE);
		Price.setBackground(Color.BLACK);
		Price.setBounds(627, 356, 136, 22);
		frmAdminControls.getContentPane().add(Price);
		Price.setColumns(10);
		
		JButton reset = new JButton("Reset");
		
		reset.setForeground(Color.ORANGE);
		reset.setBackground(Color.BLACK);
		reset.setBounds(644, 488, 119, 53);
		frmAdminControls.getContentPane().add(reset);
		frmAdminControls.setBounds(100, 100, 1139, 640);
		frmAdminControls.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

		try {
			MaintainItem maintain = new MaintainItem();
			maintain.load(path3);
			for(item items: maintain.items) {
				itemslist.addItem(items.getName());
				itemslist.setSelectedIndex(-1);
				ItemID.setValue(maintain.items.get(maintain.items.size() - 1).getitemID() + 1);
				Availability.setSelectedIndex(-1);
				Sale.setSelectedIndex(-1);
				Category.setSelectedIndex(-1);
				//ItemID.setValue(item.items.get(item.items.size() - 1).getitemID() + 1);
			}
			
			itemslist.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						maintain.load(path3);
						for(item items: maintain.items) {
							if(items.getName().equals(itemslist.getSelectedItem().toString())) {
								Name.setText(items.getName());
								ItemID.setValue(items.getitemID());
								Size.setText(items.getSize());
								Category.setSelectedItem(items.getCategory());
								Price.setText(String.valueOf(items.getPrice()));
								
								if(items.getisItemAvailable() == true) {
									Availability.setSelectedIndex(0);
								}else if(items.getisItemAvailable() == false) {
									Availability.setSelectedIndex(1);
								}
								Aisle.setValue(items.getAisleNumber());
								if(items.getonSale() == true) {
									Sale.setSelectedIndex(0);
								}else if(items.getonSale() == false){
									Sale.setSelectedIndex(1);
								}
								
								Description.setText(items.getDescription());
								
							}
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaintainItem maintain = new MaintainItem();
				try {
					maintain.load(path3);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(item items: maintain.items) {
					//itemslist.setSelectedIndex(0);
					ItemID.setValue(maintain.items.get(maintain.items.size() - 1).getitemID() + 1);
					Availability.setSelectedIndex(-1);
					Sale.setSelectedIndex(-1);
					Category.setSelectedIndex(-1);
					Name.setText("");
					Size.setText("");
					Price.setText("");
					Aisle.setValue(0);
					Description.setText("");
					//ItemID.setValue(item.items.get(item.items.size() - 1).getitemID() + 1);
				}
			}
		});
		
		

			additem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MaintainItem maintain = new MaintainItem();
					try {
						boolean id = false;
						boolean name = false;
						boolean field = false;
						maintain.load(path3);
						for(item i: maintain.items) {
							
							if(Name.getText().equals(i.getName())) {
								JOptionPane.showMessageDialog(frmAdminControls, "Item already exists, please change item Name.", "Item Name Error",
								        JOptionPane.ERROR_MESSAGE);
								name = true;
							}else if(ItemID.getValue().equals(i.getitemID())){
								int goodids = maintain.items.get(maintain.items.size() - 1).getitemID();
								JOptionPane.showMessageDialog(frmAdminControls, "Item ID is already in use, please choose another ID. IDs after " + goodids + " are valid", "Item Error",
								        JOptionPane.ERROR_MESSAGE);
								id = true;
							}else if(!Price.getText().matches("[0-9]{1,13}(\\.[0-9]*)?")) {
								JOptionPane.showMessageDialog(frmAdminControls, "Price given is not valid. Please input a valid price", "Price Error",
								        JOptionPane.ERROR_MESSAGE);
								break;
							}else if(Category.getSelectedIndex() == -1 || Availability.getSelectedIndex() == -1 || Sale.getSelectedIndex() == -1 || Description.getText().isEmpty() || Size.getText().isEmpty() || Name.getText().isEmpty()) {
								JOptionPane.showMessageDialog(frmAdminControls, "Please ensure all field are completed", "Add Item Error",
								        JOptionPane.ERROR_MESSAGE);
								field = true;
								break;
							}
							
						}
								
						//if(id == true || name == true) {
						//	int itemID = maintain.items.get(maintain.items.size()-1).getitemID();
						//	JOptionPane.showMessageDialog(frmManagerControls, "Please ensure name and id are unique", "Item Error",
						//	        JOptionPane.ERROR_MESSAGE);
						//}
						
						if(id == false && name == false && field == false) {
						item newItem = new item();
								newItem.setName(Name.getText());
								newItem.setitemID(Integer.parseInt(ItemID.getValue().toString()));
								newItem.setCategory(String.valueOf(Category.getSelectedItem()));
								newItem.setPrice(Double.parseDouble(Price.getText()));
								newItem.setSize(Size.getText());
								newItem.setAisleNumber(Integer.parseInt(Aisle.getValue().toString()));
								newItem.setnumTimesViewed(0);
								newItem.setDescription(Description.getText());
								newItem.setItemAvailability(Boolean.parseBoolean(Availability.getSelectedItem().toString()));
								newItem.setonSale(Boolean.parseBoolean(Sale.getSelectedItem().toString()));

								maintain.items.add(newItem);
								maintain.update(path3);
								JOptionPane.showMessageDialog(frmAdminControls, "Item Successfully Added.", "Item Success",
								        JOptionPane.INFORMATION_MESSAGE);
								maintain.load(path3);
								itemslist.addItem(newItem.getName());
								
						}
							
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
					
				}
			});
			
		    // Table
		    JTable table = new JTable();
		   
		    table.setModel(new DefaultTableModel(
		    	new Object[][] {
		    	},
		    	new String[] {
		    		"User ID", "Username", "Email", "Password", "Store ID"
		    	}
		    ));
		    table.setBackground(Color.BLACK);
		    table.setForeground(Color.ORANGE);
		    DefaultTableModel tb1 = (DefaultTableModel) table.getModel();
		    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		    MaintainUser maintain = new MaintainUser();
		    try {
				maintain.load(path);
				 for(User u: maintain.users) {
				    	if(u.getPermissions().equals("Manager")) {
				    		String data[] = {String.valueOf(u.getId()), u.getName(), u.getEmail(), u.getPassword(), String.valueOf(u.getstoreID())};
				    		tb1.addRow(data);
				    		
				    	}
				    	
				    }
				 maintain.load(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    
		   
		    
		    
		    

		    // ScrollPane
		    JScrollPane scrollPane = new JScrollPane(table);
		    scrollPane.setBounds(10, 33, 541, 166);
		    frmAdminControls.getContentPane().add(scrollPane);
		    table.setFillsViewportHeight(true); 
		    
		    JLabel lblManagerList = new JLabel("Manage Employee");
		    lblManagerList.setHorizontalAlignment(SwingConstants.CENTER);
		    lblManagerList.setForeground(Color.ORANGE);
		    lblManagerList.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    lblManagerList.setBounds(10, 11, 541, 22);
		    frmAdminControls.getContentPane().add(lblManagerList);
		    
		    JButton btnAddManager = new JButton("Add Manager");
		   
		    btnAddManager.setForeground(Color.ORANGE);
		    btnAddManager.setBackground(Color.BLACK);
		    btnAddManager.setBounds(10, 243, 138, 32);
		    frmAdminControls.getContentPane().add(btnAddManager);
		    
		    JButton btnRemoveManager = new JButton("Remove Manager");
		    btnRemoveManager.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		MaintainUser maintain = new MaintainUser();
		    		
		    		try {
						maintain.load(path);
						
						
						if(table.getSelectedRow() == -1) {
							JOptionPane.showMessageDialog(frmAdminControls, "To remove a manager, please select one from the table.", "Manager Removal Error",
							        JOptionPane.ERROR_MESSAGE);
						}
						else  {
							int input = JOptionPane.showConfirmDialog(frmAdminControls, 
			                        "Are you sure you want to remove this Manager?", "Remove Manager Confirmation", JOptionPane.OK_CANCEL_OPTION);
							if(input == 0) {
								
							
							int row = table.getSelectedRow();
							//System.out.println(row);
							//tb1.removeRow(row);
							
							//tb1.getValueAt(row, 0);
							int userid = Integer.parseInt(tb1.getValueAt(row, 0).toString());
							//System.out.println(userid);
							for(User u: maintain.users) {
								if(u.getId() == userid) {
									maintain.users.remove(u);
									tb1.removeRow(row);
									maintain.update(path);
									JOptionPane.showMessageDialog(frmAdminControls, "Manager Successfully Removed.", "Manager Removal Success",
									        JOptionPane.INFORMATION_MESSAGE);
									break;
								}
							}
							}
						}

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		
		    	}
		    });
		    btnRemoveManager.setForeground(Color.ORANGE);
		    btnRemoveManager.setBackground(Color.BLACK);
		    btnRemoveManager.setBounds(282, 243, 138, 32);
		    frmAdminControls.getContentPane().add(btnRemoveManager);
		    
		    JButton btnEditManager = new JButton("Edit Manager");
		   
		    
		    btnEditManager.setForeground(Color.ORANGE);
		    btnEditManager.setBackground(Color.BLACK);
		    btnEditManager.setBounds(146, 243, 138, 32);
		    frmAdminControls.getContentPane().add(btnEditManager);
		    
		    nameField = new JTextField();
		    nameField.setForeground(Color.ORANGE);
		    nameField.setBackground(Color.BLACK);
		    nameField.setBounds(115, 210, 112, 22);
		    frmAdminControls.getContentPane().add(nameField);
		    nameField.setColumns(10);
		    
		    emailField = new JTextField();
		    emailField.setForeground(Color.ORANGE);
		    emailField.setBackground(Color.BLACK);
		    emailField.setBounds(225, 210, 106, 22);
		    frmAdminControls.getContentPane().add(emailField);
		    emailField.setColumns(10);
		    
		    passwordField = new JTextField();
		    passwordField.setForeground(Color.ORANGE);
		    passwordField.setBackground(Color.BLACK);
		    passwordField.setBounds(330, 210, 112, 22);
		    frmAdminControls.getContentPane().add(passwordField);
		    passwordField.setColumns(10);
		    
		    JButton reset_1 = new JButton("Reset");
		    
		    reset_1.setForeground(Color.ORANGE);
		    reset_1.setBackground(Color.BLACK);
		    reset_1.setBounds(418, 243, 133, 32);
		    frmAdminControls.getContentPane().add(reset_1);
		    
		    JSpinner useridField = new JSpinner();
		    useridField.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		    useridField.setForeground(Color.ORANGE);
		    useridField.setBackground(Color.BLACK);
		    useridField.setBounds(10, 210, 106, 22);
		    MaintainUser maintain1 = new MaintainUser();
		    try {
				maintain1.load(path);
				int count = maintain1.users.get(maintain1.users.size() - 1).getId();
			    useridField.setValue(count + 1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    
		    frmAdminControls.getContentPane().add(useridField);
		    
		    JSpinner storeidField = new JSpinner();
		    //storeidField.setModel(new SpinnerNumberModel(1, 1, 2, 1));
		    storeidField.setForeground(Color.ORANGE);
		    storeidField.setBackground(Color.BLACK);
		    storeidField.setBounds(441, 210, 110, 22);
		    frmAdminControls.getContentPane().add(storeidField);
		    MaintainStore store = new MaintainStore();
		    try {
				store.load(path4);
			} catch (Exception e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
		    int storecount = store.stores.size();
		    storeidField.setModel(new SpinnerNumberModel(1, 1, storecount, 1));
		    
		    JButton view = new JButton("View Store");
		    view.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		store1 store = new store1(user);
		    		store.frmSmartshoppers.setVisible(true);
		    		frmAdminControls.dispose();
		    	}
		    });
		    view.setForeground(Color.ORANGE);
		    view.setBackground(Color.BLACK);
		    view.setBounds(644, 437, 119, 53);
		    frmAdminControls.getContentPane().add(view);
		    
		    JButton logout = new JButton("Logout");
		    logout.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		Login login = new Login();
		    		login.frmLoginSmartshoppers.setVisible(true);
		    		frmAdminControls.dispose();
		    	}
		    });
		    logout.setForeground(Color.ORANGE);
		    logout.setBackground(Color.BLACK);
		    logout.setBounds(644, 553, 119, 32);
		    frmAdminControls.getContentPane().add(logout);
		    
		    btnAddManager.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		MaintainUser maintain = new MaintainUser();
		    		
		    		try {
						maintain.load(path);
						boolean userGood = true;
						boolean idGood = true;
						boolean fieldsGood = true;
						ArrayList<String> usernames = new ArrayList<>();
						
				    		if(nameField.getText().isEmpty() || emailField.getText().isEmpty() || passwordField.getText().isEmpty()) {
				    			JOptionPane.showMessageDialog(frmAdminControls, "To add a manager, please complete all fields.", "Add Manager Error",
								        JOptionPane.ERROR_MESSAGE);
				    			fieldsGood = false;
				    			
				    		}
				    		for(User u: maintain.users) {
				    			usernames.add(u.getName());
				    		}
				    		
				    		for(User u: maintain.users) {
				    			if(u.getId() == Integer.parseInt(useridField.getValue().toString())) {
				    				int id = maintain.users.get(maintain.users.size() - 1).getId();
				    				JOptionPane.showMessageDialog(frmAdminControls, "User ID is already taken, user IDs after " + id + " are valid." , "Add Manager Error",
								        JOptionPane.ERROR_MESSAGE);
				    				idGood = false;
				    				break;
				    		}
				    		}
				    		
				    		
				    			if(usernames.contains(nameField.getText())) {
				    				JOptionPane.showMessageDialog(frmAdminControls, "Username already taken, please choose another username." , "Username Error",
								        JOptionPane.ERROR_MESSAGE);
				    				userGood = false;
				    		}
				    		
		    
				    		 if(userGood == true && idGood == true && fieldsGood == true){
				    			User user = new User();
				    			user.setId(Integer.parseInt(useridField.getValue().toString()));
				    			user.setName(nameField.getText());
				    			user.setEmail(emailField.getText());
				    			user.setPassword(passwordField.getText());
				    			user.setstoreID(Integer.parseInt(storeidField.getValue().toString()));
				    			user.setPermissions("Manager");
				    			
				    			File myObj = new File("C:\\Users\\PC\\Desktop\\" + user.getName()+".csv");
								try {
									myObj.createNewFile();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
				    			
				    			maintain.users.add(user);
				    			maintain.update(path);
				    			maintain.load(path);
				    			
				    			String data[] = {String.valueOf(user.getId()), user.getName(), user.getEmail(), user.getPassword(), String.valueOf(user.getstoreID())};
				    			tb1.addRow(data);
				    			useridField.setValue(Integer.parseInt(useridField.getValue().toString()) + 1);
				    			JOptionPane.showMessageDialog(frmAdminControls, "Manager Successfully Added" , "Add Manager Success",
								        JOptionPane.INFORMATION_MESSAGE);
				    		}
				    		
				    		
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		
		    		
		    	}
		    });
		    
		    reset_1.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		nameField.setText("");
		    		emailField.setText("");
		    		passwordField.setText("");
		    	
		    		MaintainUser maintain = new MaintainUser();
		    		try {
						maintain.load(path);
						int id = maintain.users.get(maintain.users.size() - 1).getId();
			    		
			    		useridField.setValue(id + 1);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		
		    	}
		    });
		    
		   
		    
		    table.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseClicked(MouseEvent e) {
		    		int row = table.getSelectedRow();
		    		
		    		int userid = Integer.parseInt(tb1.getValueAt(row, 0).toString());
		    		String username = String.valueOf(tb1.getValueAt(row, 1).toString());
		    		String email = String.valueOf(tb1.getValueAt(row, 2).toString());
		    		String password = String.valueOf(tb1.getValueAt(row, 3).toString());
		    		int storeid = Integer.parseInt(tb1.getValueAt(row, 4).toString());
		    		
		    		useridField.setValue(userid);
		    		nameField.setText(username);
		    		emailField.setText(email);
		    		passwordField.setText(password);
		    		storeidField.setValue(storeid);
		    	}
		    });
		    
		    
		    
		    btnEditManager.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		
		    		MaintainUser maintain = new MaintainUser();
		    		ArrayList<String> users = new ArrayList<String>();
		    		try {
						maintain.load(path);
						
						
						for(User u: maintain.users) {
							if(table.getSelectedRow() != -1) {
								int row = table.getSelectedRow();
								String username = String.valueOf(tb1.getValueAt(row, 1));
								int userid = Integer.parseInt(tb1.getValueAt(row, 0).toString());
								
								if(nameField.getText().isEmpty() || emailField.getText().isEmpty() || passwordField.getText().isEmpty()) {
									JOptionPane.showMessageDialog(frmAdminControls, "Please Complete All Fields." , "Edit Error",
									        JOptionPane.ERROR_MESSAGE);
									break;
								}else if(!username.equals(nameField.getText())) {
									JOptionPane.showMessageDialog(frmAdminControls, "Username cannot be changed after it has already been set. You may create a new user with the desired username." , "Edit Error",
									        JOptionPane.ERROR_MESSAGE);
									break;
								}else if(userid != Integer.parseInt(useridField.getValue().toString())) {
									JOptionPane.showMessageDialog(frmAdminControls, "User ID Cannot Be Changed." , "Edit Error",
									        JOptionPane.ERROR_MESSAGE);
									break;
								}else if(u.getId() == userid && u.getName().equals(username)) {
									u.setName(nameField.getText());
									u.setEmail(emailField.getText());
									u.setPassword(passwordField.getText());
									u.setPermissions("Manager");
									u.setstoreID(Integer.parseInt(storeidField.getValue().toString()));
									tb1.setValueAt(nameField.getText(), row, 1);
									tb1.setValueAt(emailField.getText(), row, 2);
									tb1.setValueAt(passwordField.getText(), row, 3);
									tb1.setValueAt(Integer.parseInt(storeidField.getValue().toString()), row, 4);
									maintain.update(path);
									JOptionPane.showMessageDialog(frmAdminControls, "Manager Successfully Updated.", "Update Success",
									        JOptionPane.INFORMATION_MESSAGE);
									break;
								}
								
							}else {
								JOptionPane.showMessageDialog(frmAdminControls, "Please Select A Manager From Table." , "Edit Error",
								        JOptionPane.ERROR_MESSAGE);
								break;
							}
							
						}
						maintain.update(path);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	}
		    });
		    
		 // Table
		    JTable table2 = new JTable();
		   
		    table2.setModel(new DefaultTableModel(
		    	new Object[][] {
		    	},
		    	new String[] {
		    		"Store ID", "Name", "Address", "Opening", "Closing"
		    	}
		    ));
		    table2.setBackground(Color.BLACK);
		    table2.setForeground(Color.ORANGE);
		    DefaultTableModel tb2 = (DefaultTableModel) table2.getModel();
		    table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		    
		    JScrollPane scrollPane_1 = new JScrollPane(table2);
		    scrollPane_1.setBounds(561, 33, 541, 166);
		    frmAdminControls.getContentPane().add(scrollPane_1);
		    table2.setFillsViewportHeight(true);
		    
		    
		    
		    JButton addstore = new JButton("Add Store");
		    addstore.setForeground(Color.ORANGE);
		    addstore.setBackground(Color.BLACK);
		    addstore.setBounds(561, 243, 138, 32);
		    frmAdminControls.getContentPane().add(addstore);
		    
		    JSpinner storesids = new JSpinner();
		    storesids.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		    storesids.setForeground(Color.ORANGE);
		    storesids.setBackground(Color.BLACK);
		    storesids.setBounds(561, 210, 37, 22);
		    frmAdminControls.getContentPane().add(storesids);
		    
		    n = new JTextField();
		    n.setForeground(Color.ORANGE);
		    n.setColumns(10);
		    n.setBackground(Color.BLACK);
		    n.setBounds(598, 210, 112, 22);
		    frmAdminControls.getContentPane().add(n);
		    
		    a = new JTextField();
		    a.setForeground(Color.ORANGE);
		    a.setColumns(10);
		    a.setBackground(Color.BLACK);
		    a.setBounds(709, 210, 188, 22);
		    frmAdminControls.getContentPane().add(a);
		    
		    JSpinner opening = new JSpinner();
		    opening.setModel(new SpinnerNumberModel(8, 1, 12, 1));
		    opening.setForeground(Color.ORANGE);
		    opening.setBackground(Color.BLACK);
		    opening.setBounds(896, 210, 49, 22);
		    frmAdminControls.getContentPane().add(opening);
		    
		    JComboBox openingtag = new JComboBox();
		    openingtag.setModel(new DefaultComboBoxModel(new String[] {"AM", "PM"}));
		    openingtag.setSelectedIndex(0);
		    openingtag.setBounds(944, 210, 46, 22);
		    frmAdminControls.getContentPane().add(openingtag);
		    
		    JSpinner closing = new JSpinner();
		    closing.setModel(new SpinnerNumberModel(8, 1, 12, 1));
		    closing.setForeground(Color.ORANGE);
		    closing.setBackground(Color.BLACK);
		    closing.setBounds(988, 210, 57, 22);
		    frmAdminControls.getContentPane().add(closing);
		    
		    JComboBox closingtag = new JComboBox();
		    closingtag.setModel(new DefaultComboBoxModel(new String[] {"AM", "PM"}));
		    closingtag.setSelectedIndex(1);
		    closingtag.setBounds(1044, 210, 58, 22);
		    frmAdminControls.getContentPane().add(closingtag);
		    
		    JButton editstore = new JButton("Edit Store");
		    
		    editstore.setForeground(Color.ORANGE);
		    editstore.setBackground(Color.BLACK);
		    editstore.setBounds(697, 243, 138, 32);
		    frmAdminControls.getContentPane().add(editstore);
		    
		    JButton removestore = new JButton("Remove Store");
		    removestore.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		MaintainStore maintain = new MaintainStore();
		    		
		    		try {
						maintain.load(path4);
						
						int row = table2.getSelectedRow();
						
						
						if(row == -1) {
							JOptionPane.showMessageDialog(frmAdminControls, "Please Select A Store From The Table" , "Selection Error",
							        JOptionPane.ERROR_MESSAGE);
						}else  {
							int input = JOptionPane.showConfirmDialog(frmAdminControls, 
			                        "Are you sure you want to remove this store?", "Remove Store Confirmation", JOptionPane.OK_CANCEL_OPTION);
							if(input == 0) {
							int storeid = Integer.parseInt(tb2.getValueAt(row, 0).toString());
							for(Stores s: new ArrayList<>(maintain.stores)) {
								if(s.getstoreID() == storeid) {
									maintain.stores.remove(s);
								}
							}
							maintain.update(path4);
							tb2.removeRow(row);
							JOptionPane.showMessageDialog(frmAdminControls, "Store Successfully Removed" , "Removal Success",
							        JOptionPane.INFORMATION_MESSAGE);
							
							
							MaintainStore store = new MaintainStore();
			    		    try {
			    				store.load(path4);
			    			} catch (Exception e3) {
			    				// TODO Auto-generated catch block
			    				e3.printStackTrace();
			    			}
			    		    int storecount = store.stores.size();
			    		    storeidField.setModel(new SpinnerNumberModel(1, 1, storecount, 1));
							
						}
						}
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		
		    	}
		    });
		    removestore.setForeground(Color.ORANGE);
		    removestore.setBackground(Color.BLACK);
		    removestore.setBounds(833, 243, 138, 32);
		    frmAdminControls.getContentPane().add(removestore);
		    
		    JButton btnReset = new JButton("Reset");
		    btnReset.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		a.setText("");
		    		n.setText("");
		    		opening.setValue(8);
		    		closing.setValue(8);
		    		openingtag.setSelectedIndex(0);
		    		closingtag.setSelectedIndex(1);
		    		
		    		MaintainStore maintain2 = new MaintainStore();
				    try {
						maintain2.load(path4);
						
						for(Stores s: maintain2.stores) {
							int max = 0;
							
							if(max < s.getstoreID()) {
								max = s.getstoreID();
								storesids.setValue(max + 1);
							}
						}
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
		    	}
		    });
		    btnReset.setForeground(Color.ORANGE);
		    btnReset.setBackground(Color.BLACK);
		    btnReset.setBounds(969, 243, 133, 32);
		    frmAdminControls.getContentPane().add(btnReset);
		    
		    JLabel lblManageStores = new JLabel("Manage Stores");
		    lblManageStores.setHorizontalAlignment(SwingConstants.CENTER);
		    lblManageStores.setForeground(Color.ORANGE);
		    lblManageStores.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    lblManageStores.setBounds(561, 11, 541, 22);
		    frmAdminControls.getContentPane().add(lblManageStores);
		    
		    
		    
		    try {
		    	MaintainStore maintain2 = new MaintainStore();
				maintain2.load(path4);
				
				for(Stores s: maintain2.stores) {
					String data[] = {String.valueOf(s.getstoreID()), s.getName(), s.getAddress(), s.getOpening(), s.getClosing()};
					tb2.addRow(data);
					
				}
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		    
		    MaintainStore maintain2 = new MaintainStore();
		    try {
				maintain2.load(path4);
				
				for(Stores s: maintain2.stores) {
					int max = 0;
					
					if(max < s.getstoreID()) {
						max = s.getstoreID();
						storesids.setValue(max + 1);
					}
				}
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		    
		    addstore.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		boolean idgood = true;
		    		boolean timegood = true;
		    		boolean addygood = true;
		    		try {
		    			MaintainStore maintain = new MaintainStore();
						maintain.load(path4);
						
						ArrayList<Integer> storeids = new ArrayList<>();
						ArrayList<String> addresses = new ArrayList<>();
						for(Stores s: maintain.stores) {
							storeids.add(s.getstoreID());
							addresses.add(s.getAddress());
						}
						
						for(Stores s: maintain.stores) {
							
							if(n.getText().isEmpty() || a.getText().isEmpty()) {
				    			JOptionPane.showMessageDialog(frmAdminControls, "Please Complete All Fields." , "Add Error",
								        JOptionPane.ERROR_MESSAGE);
				    			break;
				    		}
							else if(storeids.contains(Integer.parseInt(storesids.getValue().toString()))) {
				    			JOptionPane.showMessageDialog(frmAdminControls, "Store ID Already Taken. Please Try Again." , "Store ID Error",
								        JOptionPane.ERROR_MESSAGE);
				    			//idgood = false;
				    			break;
				    		}else if(String.valueOf(openingtag.getSelectedItem()).equals("AM") && String.valueOf(closingtag.getSelectedItem()).equals("AM") && Integer.parseInt(opening.getValue().toString()) >= Integer.parseInt(closing.getValue().toString())) {
				    			JOptionPane.showMessageDialog(frmAdminControls, "Invalid opening and closing hours. Please try again.", "Hours Error",
								        JOptionPane.ERROR_MESSAGE);
				    			//timegood = false;
			    				break;
				    		}
				    		else if(String.valueOf(openingtag.getSelectedItem()).equals("PM") && String.valueOf(closingtag.getSelectedItem()).equals("PM") && Integer.parseInt(opening.getValue().toString()) >= Integer.parseInt(closing.getValue().toString())) {
				    			JOptionPane.showMessageDialog(frmAdminControls, "Invalid opening and closing hours. Please try again.", "Hours Error",
								        JOptionPane.ERROR_MESSAGE);
				    			//timegood = false;
			    				break;
				    		}else if(addresses.contains(a.getText())){
			    				JOptionPane.showMessageDialog(frmAdminControls, "Address is already used by another store. Please try again.", "Address Error",
								        JOptionPane.ERROR_MESSAGE);
			    				addygood = false;
			    				break;
			    			}else {

				    			String openHour = String.valueOf(opening.getValue().toString()) + String.valueOf(openingtag.getSelectedItem());
				    			String closingHour = String.valueOf(closing.getValue().toString()) + String.valueOf(closingtag.getSelectedItem());

				    				Stores newstore = new Stores();
					    			newstore.setName(n.getText());
					    			newstore.setAddress(a.getText());
					    			Random rn = new Random();
					    			
					    			newstore.setDistance(rn.nextFloat(10));
					    			newstore.setstoreID(Integer.parseInt(storesids.getValue().toString()));
					    			//storesids.setValue(Integer.parseInt(storesids.getValue().toString() + 1));
					    			newstore.setOpening(openHour);
					    			newstore.setClosing(closingHour);
					    			JOptionPane.showMessageDialog(frmAdminControls, "Store Successfully Added." , "Store Addition Success",
									        JOptionPane.INFORMATION_MESSAGE);
					    			maintain.stores.add(newstore);
					    			maintain.update(path4);
					    			String[] data = {String.valueOf(storesids.getValue()), n.getText(), a.getText(),String.valueOf(opening.getValue().toString()) + openingtag.getSelectedItem(), closing.getValue().toString() + closingtag.getSelectedItem()  };
					    			tb2.addRow(data);
					    			
					    			
					    			MaintainStore store = new MaintainStore();
					    		    try {
					    				store.load(path4);
					    			} catch (Exception e3) {
					    				// TODO Auto-generated catch block
					    				e3.printStackTrace();
					    			}
					    		    int storecount = store.stores.size() - 1;
					    		    storeidField.setModel(new SpinnerNumberModel(1, 1, storecount + 1, 1));
					    			
					    			
					    			
					    			break;
				    		}
						}
						maintain.load(path4);
						for(Stores s: maintain.stores) {
							int max = 0;
							
							if(max < s.getstoreID()) {
								max = s.getstoreID();
								storesids.setValue(max + 1);
							}
							
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		
		    		
		    		
		    	}
		    });
		    
		    
		    
		    table2.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseClicked(MouseEvent e) {
		    		int row = table2.getSelectedRow();
		    		
		    	
		    		int storeid = Integer.parseInt(tb2.getValueAt(row, 0).toString());
		    		String name = String.valueOf(tb2.getValueAt(row, 1));
		    		String addy = String.valueOf(tb2.getValueAt(row, 2));
		    		
		    		n.setText(name);
		    		a.setText(addy);
		    		storesids.setValue(storeid);
		    		
		    	}
		    });
		    
		    
		    
		    editstore.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		
						
						if(table2.getSelectedRow() == -1) {
			    			JOptionPane.showMessageDialog(frmAdminControls, "To Edit A Store, Please Select One From The Table." , "Store Edit Error",
							        JOptionPane.ERROR_MESSAGE);
			    		}else if(Integer.parseInt(tb2.getValueAt(table2.getSelectedRow(), 0).toString()) != Integer.parseInt(storesids.getValue().toString())) {
			    			JOptionPane.showMessageDialog(frmAdminControls, "Store ID cannot be changed after it has already been set." , "Store Edit Error",
							        JOptionPane.ERROR_MESSAGE);
			    		}else if(a.getText().isEmpty() || n.getText().isEmpty()) {
			    			JOptionPane.showMessageDialog(frmAdminControls, "Please complete all fields." , "Store Edit Error",
							        JOptionPane.ERROR_MESSAGE);
			    		}else if(String.valueOf(openingtag.getSelectedItem()).equals("AM") && String.valueOf(closingtag.getSelectedItem()).equals("AM") && Integer.parseInt(opening.getValue().toString()) >= Integer.parseInt(closing.getValue().toString())) {
			    			JOptionPane.showMessageDialog(frmAdminControls, "Invalid opening and closing hours. Please try again.", "Hours Error",
							        JOptionPane.ERROR_MESSAGE);
			    			//timegood = false;
		    				;
			    		}
			    		else if(String.valueOf(openingtag.getSelectedItem()).equals("PM") && String.valueOf(closingtag.getSelectedItem()).equals("PM") && Integer.parseInt(opening.getValue().toString()) >= Integer.parseInt(closing.getValue().toString())) {
			    			JOptionPane.showMessageDialog(frmAdminControls, "Invalid opening and closing hours. Please try again.", "Hours Error",
							        JOptionPane.ERROR_MESSAGE);
			    			//timegood = false;
		    				
			    		}
			    		else {
			    			
			    			try {
			    				MaintainStore maintain = new MaintainStore();
								maintain.load(path4);
								
								for(Stores s: new ArrayList<>(maintain.stores)) {
									if(s.getstoreID() == Integer.parseInt(tb2.getValueAt(table2.getSelectedRow(), 0).toString())) {
										s.setName(n.getText());
										s.setAddress(a.getText());
										s.setOpening(String.valueOf(opening.getValue()) + openingtag.getSelectedItem());
										s.setClosing(String.valueOf(closing.getValue()) + closingtag.getSelectedItem());
										maintain.update(path4);
										maintain.load(path4);
										int row = table2.getSelectedRow();
										tb2.setValueAt(n.getText(), row, 1);
										tb2.setValueAt(a.getText(), row, 2);
										tb2.setValueAt(String.valueOf(opening.getValue().toString() + openingtag.getSelectedItem()), row, 3);
										tb2.setValueAt(String.valueOf(closing.getValue().toString() + closingtag.getSelectedItem()), row, 4);
										JOptionPane.showMessageDialog(frmAdminControls, "Store Successfully Updated." , "Store Edit Success",
										        JOptionPane.INFORMATION_MESSAGE);
										break;
									}
								}
								
								
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			    		
					} 
		    		
		    	}
		    });
		    
		    
	}
}
