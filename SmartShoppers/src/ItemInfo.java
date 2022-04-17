import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSeparator;

public class ItemInfo {

	JFrame frame;
	String path = "C:\\Users\\PC\\Desktop\\user.csv";
	String path2 = "C:\\Users\\PC\\Desktop\\logins.csv";
	String path3 = "C:\\Users\\PC\\Desktop\\items.csv";
	
	Map<item,Integer> cart = new HashMap<item,Integer>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemInfo window = new ItemInfo(new item(), new User());
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
	public ItemInfo(item item, User user) {
		initialize(item, user, cart);
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(item item, User user, Map<item,Integer> cart) {
		String cartpath = "C:\\Users\\PC\\Desktop\\" + user.getName()+".csv";
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setTitle("Item Details");
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel name = new JLabel("name");
		name.setFont(new Font("Tahoma", Font.BOLD, 20));
		name.setForeground(Color.ORANGE);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(11, 11, 289, 37);
		frame.getContentPane().add(name);
		
		JTextArea description = new JTextArea();
		description.setWrapStyleWord(true);
		description.setLineWrap(true);
		description.setEditable(false);
		description.setText("description");
		description.setForeground(Color.WHITE);
		description.setBackground(Color.DARK_GRAY);
		description.setBounds(55, 69, 204, 67);
		frame.getContentPane().add(description);
		
		JLabel itemidlabel = new JLabel("Item ID");
		itemidlabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		itemidlabel.setHorizontalAlignment(SwingConstants.CENTER);
		itemidlabel.setForeground(Color.ORANGE);
		itemidlabel.setBounds(11, 147, 289, 14);
		frame.getContentPane().add(itemidlabel);
		
		JLabel categorylabel = new JLabel("Category");
		categorylabel.setHorizontalAlignment(SwingConstants.CENTER);
		categorylabel.setForeground(Color.ORANGE);
		categorylabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		categorylabel.setBounds(11, 197, 289, 14);
		frame.getContentPane().add(categorylabel);
		
		JLabel itemid = new JLabel("Item ID");
		itemid.setHorizontalAlignment(SwingConstants.CENTER);
		itemid.setForeground(Color.WHITE);
		itemid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		itemid.setBounds(11, 172, 289, 14);
		frame.getContentPane().add(itemid);
		
		JLabel category = new JLabel("Category\r\n");
		category.setHorizontalAlignment(SwingConstants.CENTER);
		category.setForeground(Color.WHITE);
		category.setFont(new Font("Tahoma", Font.PLAIN, 13));
		category.setBounds(11, 222, 289, 14);
		frame.getContentPane().add(category);
		
		JLabel sizelabel = new JLabel("Size");
		sizelabel.setHorizontalAlignment(SwingConstants.CENTER);
		sizelabel.setForeground(Color.ORANGE);
		sizelabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sizelabel.setBounds(11, 247, 289, 14);
		frame.getContentPane().add(sizelabel);
		
		JLabel size = new JLabel("size");
		size.setHorizontalAlignment(SwingConstants.CENTER);
		size.setForeground(Color.WHITE);
		size.setFont(new Font("Tahoma", Font.PLAIN, 13));
		size.setBounds(11, 272, 289, 14);
		frame.getContentPane().add(size);
		
		JLabel aislenumberlabel = new JLabel("Aisle Number");
		aislenumberlabel.setHorizontalAlignment(SwingConstants.CENTER);
		aislenumberlabel.setForeground(Color.ORANGE);
		aislenumberlabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		aislenumberlabel.setBounds(11, 297, 289, 14);
		frame.getContentPane().add(aislenumberlabel);
		
		JLabel aislenumber = new JLabel("aislenumber");
		aislenumber.setHorizontalAlignment(SwingConstants.CENTER);
		aislenumber.setForeground(Color.WHITE);
		aislenumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		aislenumber.setBounds(11, 322, 289, 14);
		frame.getContentPane().add(aislenumber);
		
		JLabel timesviewed = new JLabel("times");
		timesviewed.setHorizontalAlignment(SwingConstants.CENTER);
		timesviewed.setForeground(Color.LIGHT_GRAY);
		timesviewed.setFont(new Font("Tahoma", Font.PLAIN, 10));
		timesviewed.setBounds(119, 446, 99, 14);
		frame.getContentPane().add(timesviewed);
		
		JLabel price = new JLabel("price");
		price.setHorizontalAlignment(SwingConstants.CENTER);
		price.setForeground(Color.GREEN);
		price.setFont(new Font("Tahoma", Font.BOLD, 15));
		price.setBounds(55, 362, 204, 14);
		frame.getContentPane().add(price);
		frame.setBounds(100, 100, 331, 499);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		name.setText(item.getName());
		itemid.setText(String.valueOf(item.getitemID()));
		description.setText(item.getDescription());
		category.setText(item.getCategory());
		size.setText(item.getSize());
		aislenumber.setText(String.valueOf(item.getAisleNumber()));
		price.setText("$ " + String.valueOf(item.getPrice()));
		timesviewed.setText("Times Viewed: " + String.valueOf(item.getnumTimesViewed()));
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaintainLogins logins = new MaintainLogins();
				try {
					logins.load(path2);
					
						store1 store1 = new store1(user);
						store1.frmSmartshoppers.setVisible(true);
						frame.dispose();
			
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.ORANGE);
		btnNewButton.setBounds(0, 437, 89, 23);
		frame.getContentPane().add(btnNewButton);
		//btnNewButton.setVisible(false);
		JButton btnAddToCart = new JButton("ADD TO CART\r\n");
		
		btnAddToCart.setBackground(Color.BLACK);
		btnAddToCart.setForeground(Color.ORANGE);
		btnAddToCart.setBounds(97, 402, 133, 23);
		frame.getContentPane().add(btnAddToCart);
		
		JSpinner quantity = new JSpinner();
		quantity.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		quantity.setForeground(Color.ORANGE);
		quantity.setBackground(Color.BLACK);
		quantity.setBounds(229, 402, 47, 23);
		frame.getContentPane().add(quantity);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.ORANGE);
		separator.setBounds(115, 95, 341, -12);
		frame.getContentPane().add(separator);
		//System.out.println(item.getName() + item.getitemID() + user.getName());
		
		
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MaintainCart maintain = new MaintainCart();
				
				try {
					int quantityitems = Integer.parseInt(quantity.getValue().toString());
					maintain.load(cartpath);
					
					Cart cartitem = new Cart();
					cartitem.setAisleNumber(item.getAisleNumber());
					cartitem.setCategory(item.getCategory());
					cartitem.setDescription(item.getDescription());
					cartitem.setItemAvailability(item.getisItemAvailable());
					cartitem.setitemID(item.getitemID());
					cartitem.setName(item.getName());
					cartitem.setnumTimesViewed(item.getnumTimesViewed());
					cartitem.setonSale(item.getonSale());
					cartitem.setPrice(item.getPrice());
					cartitem.setSize(item.getSize());
					cartitem.setQuantity(quantityitems);
					boolean itemincart = false;
					
					for(Cart c: new ArrayList<>(maintain.cartitems)) {
						if(c.getitemID() == item.getitemID()) {
							c.setQuantity(quantityitems + c.getQuantity());
							itemincart = true;
						}
					}
					
					if(itemincart == false){
						maintain.cartitems.add(cartitem);
					}
				
					maintain.update(cartpath);
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(frame, "Item Added to Cart", "Add Item Success",
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}
