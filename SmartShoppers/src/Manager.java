import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class Manager {

	JFrame frmManagerControls;
	//String path = "C:\\Users\\PC\\Desktop\\user.csv";
	//String path2 = "C:\\Users\\PC\\Desktop\\logins.csv";
	String path3 = "C:\\Users\\PC\\Desktop\\items.csv";
	String path4 = "C:\\Users\\PC\\Desktop\\stores.csv";
	private JTextField Name;
	private JTextField Size;
	private JTextField Price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager window = new Manager(new User());
					window.frmManagerControls.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Manager(User user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User user) {
		frmManagerControls = new JFrame();
		frmManagerControls.getContentPane().setForeground(Color.WHITE);
		frmManagerControls.setTitle("Manager | Controls");
		frmManagerControls.getContentPane().setBackground(Color.DARK_GRAY);
		frmManagerControls.getContentPane().setLayout(null);
		frmManagerControls.setResizable(false);
		
		JComboBox itemslist = new JComboBox();
		
		//itemslist.setModel(new DefaultComboBoxModel(new String[] {"this"}));
		itemslist.setForeground(Color.ORANGE);
		itemslist.setBackground(Color.BLACK);
		itemslist.setBounds(125, 41, 120, 22);
		frmManagerControls.getContentPane().add(itemslist);
		
		JLabel name = new JLabel("Name");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setForeground(Color.ORANGE);
		name.setFont(new Font("Tahoma", Font.PLAIN, 13));
		name.setBounds(255, 26, 120, 14);
		frmManagerControls.getContentPane().add(name);
		
		JLabel itemid = new JLabel("Item ID");
		itemid.setHorizontalAlignment(SwingConstants.CENTER);
		itemid.setForeground(Color.ORANGE);
		itemid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		itemid.setBounds(385, 26, 120, 14);
		frmManagerControls.getContentPane().add(itemid);
		
		JLabel size = new JLabel("Size");
		size.setHorizontalAlignment(SwingConstants.CENTER);
		size.setForeground(Color.ORANGE);
		size.setFont(new Font("Tahoma", Font.PLAIN, 13));
		size.setBounds(125, 74, 120, 14);
		frmManagerControls.getContentPane().add(size);
		
		JLabel category = new JLabel("Category");
		category.setHorizontalAlignment(SwingConstants.CENTER);
		category.setForeground(Color.ORANGE);
		category.setFont(new Font("Tahoma", Font.PLAIN, 13));
		category.setBounds(255, 74, 120, 14);
		frmManagerControls.getContentPane().add(category);
		
		JLabel price = new JLabel("Price");
		price.setHorizontalAlignment(SwingConstants.CENTER);
		price.setForeground(Color.ORANGE);
		price.setFont(new Font("Tahoma", Font.PLAIN, 13));
		price.setBounds(385, 121, 120, 14);
		frmManagerControls.getContentPane().add(price);
		
		JLabel availability = new JLabel("Availability");
		availability.setHorizontalAlignment(SwingConstants.CENTER);
		availability.setForeground(Color.ORANGE);
		availability.setFont(new Font("Tahoma", Font.PLAIN, 13));
		availability.setBounds(385, 74, 120, 14);
		frmManagerControls.getContentPane().add(availability);
		
		JLabel aislenumber = new JLabel("Aisle");
		aislenumber.setHorizontalAlignment(SwingConstants.CENTER);
		aislenumber.setForeground(Color.ORANGE);
		aislenumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		aislenumber.setBounds(255, 121, 120, 14);
		frmManagerControls.getContentPane().add(aislenumber);
		
		JLabel sale = new JLabel("Sale");
		sale.setHorizontalAlignment(SwingConstants.CENTER);
		sale.setForeground(Color.ORANGE);
		sale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sale.setBounds(125, 121, 120, 14);
		frmManagerControls.getContentPane().add(sale);
		
		JLabel description = new JLabel("Description");
		description.setHorizontalAlignment(SwingConstants.CENTER);
		description.setForeground(Color.ORANGE);
		description.setFont(new Font("Tahoma", Font.PLAIN, 13));
		description.setBounds(125, 169, 241, 14);
		frmManagerControls.getContentPane().add(description);
		
		Name = new JTextField();
		Name.setForeground(Color.WHITE);
		Name.setBackground(Color.BLACK);
		Name.setBounds(255, 41, 120, 22);
		frmManagerControls.getContentPane().add(Name);
		Name.setColumns(10);
		
		Size = new JTextField();
		Size.setForeground(Color.WHITE);
		Size.setBackground(Color.BLACK);
		Size.setColumns(10);
		Size.setBounds(125, 88, 120, 22);
		frmManagerControls.getContentPane().add(Size);
		
		JSpinner ItemID = new JSpinner();
		ItemID.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		ItemID.setForeground(Color.WHITE);
		ItemID.setBackground(Color.BLACK);
		ItemID.setBounds(385, 41, 120, 22);
		frmManagerControls.getContentPane().add(ItemID);
		
		JComboBox Category = new JComboBox();
		Category.setForeground(Color.WHITE);
		Category.setBackground(Color.BLACK);
		Category.setModel(new DefaultComboBoxModel(new String[] {"Food", "Accessories", "Appliances", "Electronics", "Cleaning", "Office", "Clothes"}));
		Category.setBounds(255, 87, 120, 22);
		frmManagerControls.getContentPane().add(Category);
		
		JSpinner Aisle = new JSpinner();
		Aisle.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		Aisle.setForeground(Color.WHITE);
		Aisle.setBackground(Color.BLACK);
		Aisle.setBounds(255, 135, 120, 22);
		frmManagerControls.getContentPane().add(Aisle);
		
		JComboBox Sale = new JComboBox();
		Sale.setForeground(Color.WHITE);
		Sale.setBackground(Color.BLACK);
		Sale.setModel(new DefaultComboBoxModel(new String[] {"true", "false"}));
		Sale.setSelectedIndex(0);
		Sale.setBounds(125, 135, 120, 22);
		frmManagerControls.getContentPane().add(Sale);
		
		JTextArea Description = new JTextArea();
		Description.setWrapStyleWord(true);
		Description.setLineWrap(true);
		Description.setForeground(Color.WHITE);
		Description.setBackground(Color.BLACK);
		Description.setBounds(125, 184, 250, 114);
		frmManagerControls.getContentPane().add(Description);
		
		JComboBox Availability = new JComboBox();
		Availability.setModel(new DefaultComboBoxModel(new String[] {"true", "false"}));
		Availability.setSelectedIndex(0);
		Availability.setForeground(Color.WHITE);
		Availability.setBackground(Color.BLACK);
		Availability.setBounds(385, 88, 120, 22);
		frmManagerControls.getContentPane().add(Availability);
		
		JButton additem = new JButton("Add Item");
		
		additem.setForeground(Color.ORANGE);
		additem.setBackground(Color.BLACK);
		additem.setBounds(385, 184, 120, 32);
		frmManagerControls.getContentPane().add(additem);
		
		JButton removeitem = new JButton("Remove Item");
		removeitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaintainItem maintain = new MaintainItem();
				
				try {
					maintain.load(path3);
					
					if(itemslist.getSelectedIndex() == -1) {
						JOptionPane.showMessageDialog(frmManagerControls, "To remove an item, please choose an item from the item list.", "Removal Error",
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
						int input = JOptionPane.showConfirmDialog(frmManagerControls, 
		                        "Are you sure you want to remove this item?", "Remove Item Confirmation", JOptionPane.OK_CANCEL_OPTION);
						
						for(item items: new ArrayList<item>(maintain.items)) {
							if(items.getName().equals(itemslist.getSelectedItem()) && input == 0) {
								maintain.items.remove(items);
								maintain.update(path3);
								JOptionPane.showMessageDialog(frmManagerControls, "Item Successfully Removed.", "Item Removal Success",
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
		removeitem.setBounds(385, 266, 120, 32);
		frmManagerControls.getContentPane().add(removeitem);
		
		JButton edititem = new JButton("Edit Item");
		edititem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaintainItem maintain = new MaintainItem();
				
				try {
					maintain.load(path3);
					//boolean immut = false;
					for(int i = 0; i < maintain.items.size(); i++) {
					if(itemslist.getSelectedIndex() == -1) {
						JOptionPane.showMessageDialog(frmManagerControls, "To edit an item, please select an item from the list.", "Item Selection Error",
						        JOptionPane.ERROR_MESSAGE);
						break;
					}else if(Name.getText().isEmpty() || Size.getText().isEmpty() || Category.getSelectedIndex() == -1 ||
					   Availability.getSelectedIndex() == -1 || Sale.getSelectedIndex() == -1 || Description.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frmManagerControls, "Please complete all fields to edit item.", "Fields Empty Error",
						        JOptionPane.ERROR_MESSAGE);
						break;
					}else if(!Price.getText().matches("[0-9]{1,13}(\\.[0-9]*)?")) {
						JOptionPane.showMessageDialog(frmManagerControls, "Price is not a valid price. Please insert a valid price like: 5.36.", "Price Error",
						        JOptionPane.ERROR_MESSAGE);
						break;
					}else if(!Name.getText().equals(itemslist.getSelectedItem())) {
						JOptionPane.showMessageDialog(frmManagerControls, "Name cannot be edited. You may create a new items with the desired name.", "Name Error",
						        JOptionPane.ERROR_MESSAGE);
						break;
					}else if(maintain.items.get(i).getName().equals(itemslist.getSelectedItem().toString()) && maintain.items.get(i).getitemID() != Integer.parseInt(ItemID.getValue().toString())) {
						JOptionPane.showMessageDialog(frmManagerControls, "Item ID cannot be changed. You may create a new item with a valid item ID", "Item ID Error",
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
						JOptionPane.showMessageDialog(frmManagerControls, "Item Successfully Updated.", "Update Success",
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
		edititem.setBounds(385, 225, 120, 32);
		frmManagerControls.getContentPane().add(edititem);
		
		JLabel lblSelectItem = new JLabel("Select Item");
		lblSelectItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectItem.setForeground(Color.ORANGE);
		lblSelectItem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelectItem.setBounds(125, 26, 120, 14);
		frmManagerControls.getContentPane().add(lblSelectItem);
		
		Price = new JTextField();
		Price.setForeground(Color.GREEN);
		Price.setBackground(Color.BLACK);
		Price.setBounds(385, 135, 120, 22);
		frmManagerControls.getContentPane().add(Price);
		Price.setColumns(10);
		
		JButton reset = new JButton("Reset");
		
		reset.setForeground(Color.ORANGE);
		reset.setBackground(Color.BLACK);
		reset.setBounds(125, 309, 120, 32);
		frmManagerControls.getContentPane().add(reset);
		
		JButton view = new JButton("View Store");
		view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				store1 store = new store1(user);
				store.frmSmartshoppers.setVisible(true);
				frmManagerControls.dispose();
			}
		});
		view.setForeground(Color.ORANGE);
		view.setBackground(Color.BLACK);
		view.setBounds(205, 614, 120, 32);
		frmManagerControls.getContentPane().add(view);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.frmLoginSmartshoppers.setVisible(true);
				frmManagerControls.dispose();
			}
		});
		logout.setForeground(Color.ORANGE);
		logout.setBackground(Color.BLACK);
		logout.setBounds(10, 614, 120, 32);
		frmManagerControls.getContentPane().add(logout);
		frmManagerControls.setBounds(100, 100, 674, 711);
		frmManagerControls.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
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
								JOptionPane.showMessageDialog(frmManagerControls, "Item already exists, please change item Name.", "Item Name Error",
								        JOptionPane.ERROR_MESSAGE);
								name = true;
							}else if(ItemID.getValue().equals(i.getitemID())){
								int goodids = maintain.items.get(maintain.items.size() - 1).getitemID();
								JOptionPane.showMessageDialog(frmManagerControls, "Item ID is already in use, please choose another ID. IDs after " + goodids + " are valid", "Item Error",
								        JOptionPane.ERROR_MESSAGE);
								id = true;
							}else if(!Price.getText().matches("[0-9]{1,13}(\\.[0-9]*)?")) {
								JOptionPane.showMessageDialog(frmManagerControls, "Price given is not valid. Please input a valid price", "Price Error",
								        JOptionPane.ERROR_MESSAGE);
								break;
							}else if(Category.getSelectedIndex() == -1 || Availability.getSelectedIndex() == -1 || Sale.getSelectedIndex() == -1 || Description.getText().isEmpty() || Size.getText().isEmpty() || Name.getText().isEmpty()) {
								JOptionPane.showMessageDialog(frmManagerControls, "Please ensure all field are completed", "Add Item Error",
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
								JOptionPane.showMessageDialog(frmManagerControls, "Item Successfully Added.", "Item Success",
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
		    		"Store ID", "Name", "Address", "Opening", "Closing"
		    	}
		    ));
		    table.setBackground(Color.BLACK);
		    table.setForeground(Color.ORANGE);
		    DefaultTableModel tb1 = (DefaultTableModel) table.getModel();
		    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 // ScrollPane
		    JScrollPane scrollPane = new JScrollPane(table);
		    scrollPane.setBounds(10, 389, 639, 216);
		    frmManagerControls.getContentPane().add(scrollPane);
		    table.setFillsViewportHeight(true); 
		    
		    
		    
		    try {
		    	MaintainStore maintain = new MaintainStore();
				maintain.load(path4);
				
				for(Stores s: maintain.stores) {
					if(s.getstoreID() == user.getstoreID()) {
					String data[] = {String.valueOf(s.getstoreID()), s.getName(), s.getAddress(), String.valueOf(s.getOpening()), String.valueOf(s.getClosing())};
					tb1.addRow(data);
					}
				}
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		    
		    JSpinner opening = new JSpinner();
		    opening.setForeground(Color.ORANGE);
		    opening.setBackground(Color.BLACK);
		    opening.setModel(new SpinnerNumberModel(8, 1, 12, 1));
		    opening.setBounds(447, 614, 48, 32);
		    frmManagerControls.getContentPane().add(opening);
		    
		    JSpinner closing = new JSpinner();
		    closing.setForeground(Color.ORANGE);
		    closing.setBackground(Color.BLACK);
		    closing.setModel(new SpinnerNumberModel(8, 1, 12, 1));
		    closing.setBounds(547, 614, 48, 32);
		    frmManagerControls.getContentPane().add(closing);
		    
		    JComboBox openingtag = new JComboBox();
		    openingtag.setModel(new DefaultComboBoxModel(new String[] {"AM", "PM"}));
		    openingtag.setSelectedIndex(0);
		    openingtag.setBounds(494, 614, 55, 32);
		    frmManagerControls.getContentPane().add(openingtag);
		    
		    JComboBox closingtag = new JComboBox();
		    closingtag.setModel(new DefaultComboBoxModel(new String[] {"AM", "PM"}));
		    closingtag.setSelectedIndex(1);
		    closingtag.setBounds(594, 614, 55, 32);
		    frmManagerControls.getContentPane().add(closingtag);
		    
		    JButton time = new JButton("Edit Hours");
		    time.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		
		    		if(table.getSelectedRow() == -1) {
		    			JOptionPane.showMessageDialog(frmManagerControls, "Please Select A Store From Table.", "Edit Error",
						        JOptionPane.ERROR_MESSAGE);
		    		}else {
		    			String openHour = String.valueOf(opening.getValue().toString()) + String.valueOf(openingtag.getSelectedItem());
		    			String closingHour = String.valueOf(closing.getValue().toString()) + String.valueOf(closingtag.getSelectedItem());
		    			
		    			int open = Integer.parseInt(opening.getValue().toString());
		    			int close = Integer.parseInt(closing.getValue().toString());
		    			String am = String.valueOf(openingtag.getSelectedItem());
		    			String pm = String.valueOf(closingtag.getSelectedItem());
		    			
		    			if(am.equals("AM") && pm.equals("AM") && open >= close) {
		    				JOptionPane.showMessageDialog(frmManagerControls, "Invalid opening and closing hours. Please try again.", "Hours Error",
							        JOptionPane.ERROR_MESSAGE);
		    			}else if(am.equals("PM") && pm.equals("PM") && open >= close) {
		    				JOptionPane.showMessageDialog(frmManagerControls, "Invalid opening and closing hours. Please try again.", "Hours Error",
							        JOptionPane.ERROR_MESSAGE);
		    			}else {
		    				MaintainStore store = new MaintainStore();
		    				try {
								store.load(path4);
								int row = table.getSelectedRow();
								//String data = tb1.getValueAt(row, 0).
								for(Stores s: store.stores) {
									if(s.getstoreID() == user.getstoreID()) {
										s.setOpening(openHour);
										s.setClosing(closingHour);
										tb1.removeRow(row);
										String[] data = {String.valueOf(s.getstoreID()), s.getName(), s.getAddress(), s.getOpening(), s.getClosing() };
										tb1.addRow(data);
										store.update(path4);
										JOptionPane.showMessageDialog(frmManagerControls, "Store Hours Successfully Updated.", "Store Hours Update Success",
										        JOptionPane.INFORMATION_MESSAGE);
									}
								}
								
								
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		    			}
		    			
		    			
		    		}
		    	}
		    });
		    time.setForeground(Color.ORANGE);
		    time.setBackground(Color.BLACK);
		    time.setBounds(335, 614, 102, 32);
		    frmManagerControls.getContentPane().add(time);
		    
		    JLabel lblManageStoreHours = new JLabel("Manage Store Hours");
		    lblManageStoreHours.setHorizontalAlignment(SwingConstants.CENTER);
		    lblManageStoreHours.setForeground(Color.ORANGE);
		    lblManageStoreHours.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    lblManageStoreHours.setBounds(10, 374, 609, 14);
		    frmManagerControls.getContentPane().add(lblManageStoreHours);
	
	
			
	}
}
