import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ShoppingCart {

	JFrame frame;
	//String path = "C:\\Users\\PC\\Desktop\\user.csv";
	//String path2 = "C:\\Users\\PC\\Desktop\\logins.csv";
	String path3 = "C:\\Users\\PC\\Desktop\\items.csv";
	//String path4 = "C:\\Users\\PC\\Desktop\\stores.csv";
	double totalPrice = 0;
	int totalItems = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingCart window = new ShoppingCart(new User());
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
	public ShoppingCart(User u) {
		initialize(u);
	}

	
	public static BigDecimal round(double totalPrice, int decimalPlace) {
	    BigDecimal bd = new BigDecimal(Double.toString(totalPrice));
	    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);       
	    return bd;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User u) {
		String cartpath = "C:\\Users\\PC\\Desktop\\" + u.getName()+".csv";
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 748, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		MaintainCart maintain = new MaintainCart();
		
		try {
			maintain.load(cartpath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DefaultListModel model = new DefaultListModel();
		//double totalPrice = 0;
		//int totalItems = 0;
		
		for (Cart c: maintain.cartitems) {
			
			totalPrice += c.getPrice() * c.getQuantity();
			totalItems += c.getQuantity();
		    model.addElement("<html>" + "<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + c.getName() + "  x" + c.getQuantity() + "<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "$ " + c.getPrice() +  "</html>" );
		    
		}
		JList list = new JList(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		list.setForeground(Color.WHITE);
		list.setFont(new Font("Tahoma", Font.PLAIN, 12));
		list.setBackground(Color.BLACK);
		list.setBounds(26, 5, 167, 367);
		frame.getContentPane().add(list);
		
		 JScrollPane scrollPane = new JScrollPane(list);
		 scrollPane.setBounds(0, 0, 176, 377);
		 Border border = BorderFactory.createLineBorder(Color.ORANGE, 5);
		 scrollPane.setBorder(border);
		 frame.getContentPane().add(scrollPane);
		 
		 
		 Button remove = new Button("X");
		 scrollPane.setRowHeaderView(remove);
		
		 remove.setForeground(Color.RED);
		 remove.setBackground(Color.DARK_GRAY);
		 
		 JPanel panel = new JPanel();
		 panel.setBackground(Color.BLACK);
		 panel.setBounds(0, 418, 732, 48);
		 frame.getContentPane().add(panel);
		 panel.setLayout(null);
		 
		 JLabel numitems = new JLabel("New label");
		 numitems.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 numitems.setHorizontalAlignment(SwingConstants.LEFT);
		 numitems.setForeground(Color.WHITE);
		 numitems.setBackground(Color.BLACK);
		 numitems.setBounds(27, 0, 40, 48);
		 panel.add(numitems);
		 
		 JLabel cost = new JLabel("New label");
		 cost.setFont(new Font("Tahoma", Font.BOLD, 13));
		 cost.setForeground(Color.GREEN);
		 cost.setBounds(65, 0, 137, 48);
		 panel.add(cost);
		 //Border border = BorderFactory.createLineBorder(Color.WHITE, 5);
		 panel.setBorder(border);
		 cost.setText(String.valueOf(round(totalPrice,2)));
		 numitems.setText(String.valueOf(totalItems));
		 
		 
		 Button button = new Button("Back");
		 button.setBounds(534, 10, 97, 28);
		 panel.add(button);
		 button.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		store1 store = new store1(u);
		 		store.frmSmartshoppers.setVisible(true);
		 		frame.dispose();
		 	}
		 });
		 button.setForeground(Color.ORANGE);
		 button.setBackground(Color.BLACK);
		 
		 Button recommended = new Button("Recommended");
		
		 recommended.setBounds(431, 10, 97, 28);
		 panel.add(recommended);
		 recommended.setForeground(Color.ORANGE);
		 recommended.setBackground(Color.BLACK);
		 
		 Button popular = new Button("Popular");
		 
		 popular.setBounds(328, 10, 97, 28);
		 panel.add(popular);
		 popular.setForeground(Color.ORANGE);
		 popular.setBackground(Color.BLACK);
		 
		 Button button_2 = new Button("Best Route");
		
		 button_2.setBounds(225, 10, 97, 28);
		 panel.add(button_2);
		 button_2.setForeground(Color.ORANGE);
		 button_2.setBackground(Color.BLACK);
		 
		 JLabel lblX = new JLabel("x");
		 lblX.setHorizontalAlignment(SwingConstants.LEFT);
		 lblX.setForeground(Color.WHITE);
		 lblX.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblX.setBackground(Color.BLACK);
		 lblX.setBounds(20, 0, 16, 48);
		 panel.add(lblX);
		 
		 Button button_2_1 = new Button("Refresh");
		 button_2_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		ShoppingCart refresh = new ShoppingCart(u);
		 		refresh.frame.setVisible(true);
		 		frame.dispose();
		 	}
		 });
		 button_2_1.setForeground(Color.RED);
		 button_2_1.setBackground(Color.BLACK);
		 button_2_1.setBounds(637, 10, 85, 28);
		 panel.add(button_2_1);
		 
		 Button edit = new Button("Edit");
		 
		 edit.setBounds(10, 383, 110, 29);
		 frame.getContentPane().add(edit);
		 edit.setForeground(Color.ORANGE);
		 edit.setBackground(Color.BLACK);
		 
		 JSpinner qu = new JSpinner();
		 qu.setModel(new SpinnerNumberModel(1, 0, 10, 1));
		 qu.setForeground(Color.ORANGE);
		 qu.setBackground(Color.BLACK);
		 qu.setBounds(126, 383, 42, 29);
		 frame.getContentPane().add(qu);
		 
		 JPanel panel1 = new JPanel();
		 panel1.setBackground(Color.DARK_GRAY);
		 panel1.setBounds(177, 0, 555, 418);
		 frame.getContentPane().add(panel1);
		
		 
		 
		 button_2.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		BestPath path = new BestPath();
			 		path.frame.setVisible(true);
			 		
			 		//bestpath.setIcon(i1);
			 		//bestpath.setVisible(true);
			 	}
			 });
		 
		 edit.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		
			 		MaintainCart maintain = new MaintainCart();
	 				try {
						maintain.load(cartpath);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			 		
			 		if(list.getSelectedIndex() == -1) {
			 			JOptionPane.showMessageDialog(frame, "Select an item to edit quantity", "Edit Error",
						        JOptionPane.ERROR_MESSAGE);
			 		}else {
			 			int quantity = Integer.parseInt(qu.getValue().toString());
			 			int selected = list.getSelectedIndex();
			 			if(quantity == 0) {
			 				double currentCost = Double.parseDouble(cost.getText());
				 			 BigDecimal newCost = round( currentCost - (maintain.cartitems.get(list.getSelectedIndex()).getPrice() * maintain.cartitems.get(list.getSelectedIndex()).getQuantity()), 2);
				 			cost.setText(String.valueOf(newCost));
				 			
				 			int currentQuantity = Integer.parseInt(numitems.getText().toString());
				 			int newQuantity = currentQuantity - maintain.cartitems.get(list.getSelectedIndex()).getQuantity();
				 			numitems.setText(String.valueOf(newQuantity));
			 				maintain.cartitems.remove(selected);
			 				model.remove(selected);
			 			}else {
			 				maintain.cartitems.get(selected).setQuantity(quantity);
			 				//double currentCost = 0;
			 				//int currentquant = 0;
			 				totalPrice = 0;
			 				totalItems = 0;
			 				for(Cart c: maintain.cartitems) {
			 					totalPrice += c.getPrice() * c.getQuantity();
			 					totalItems += c.getQuantity();
			 					BigDecimal newCost = round(totalPrice,2);
			 					cost.setText(String.valueOf(newCost));
			 					numitems.setText(String.valueOf(totalItems));
			 				}
			 				
			 				
			 				model.set(selected, "<html>" + "<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + maintain.cartitems.get(selected).getName() + "  x" + maintain.cartitems.get(selected).getQuantity() + "<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "$ " + maintain.cartitems.get(selected).getPrice() +  "</html>");
			 			}
			 		}
			 		
			 		try {
						maintain.update(cartpath);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			 	}
			 });
		 
		 remove.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		if(list.getSelectedIndex() == -1) {
			 			JOptionPane.showMessageDialog(frame, "Select an item to remove.", "Removal Error",
						        JOptionPane.ERROR_MESSAGE);
			 		}else {
			 			System.out.println(list.getSelectedValue());
			 			MaintainCart maintain = new MaintainCart();
			 			
			 			try {
							maintain.load(cartpath);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			 			double currentCost = Double.parseDouble(cost.getText());
			 			BigDecimal newCost = round(currentCost - (maintain.cartitems.get(list.getSelectedIndex()).getPrice() * maintain.cartitems.get(list.getSelectedIndex()).getQuantity()), 2);
			 			cost.setText(String.valueOf(newCost));
			 			
			 			int currentQuantity = Integer.parseInt(numitems.getText().toString());
			 			int newQuantity = currentQuantity - maintain.cartitems.get(list.getSelectedIndex()).getQuantity();
			 			numitems.setText(String.valueOf(newQuantity));
			 			
			 			maintain.cartitems.remove(list.getSelectedIndex());
			 			model.remove(list.getSelectedIndex());
			 			JOptionPane.showMessageDialog(frame, "Item Removed", "Item Successfully Removed",
						        JOptionPane.INFORMATION_MESSAGE);
			 			try {
							maintain.update(cartpath);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			 		}
			 	}
			 });
		 
		 
		 
		 popular.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		recommended.setEnabled(true);
			 		panel1.removeAll();
			 		MaintainItem maintain = new MaintainItem();
			 		
			 		try {
						maintain.load(path3);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			 		panel1.setLayout(new java.awt.FlowLayout(0, 25, 30));
			 		
			 		Collections.sort(maintain.items, (i1, i2) ->
			        Integer.compare(i1.getnumTimesViewed(), i2.getnumTimesViewed()));
			 		Collections.reverse(maintain.items);
			 		for(item i: maintain.items) {
			 			
			 			JButton b = new JButton(String.valueOf(i.getName()));
			 			b.setForeground(Color.ORANGE);
						b.setBackground(Color.BLACK);
						b.setPreferredSize(new Dimension(120,25));
						panel1.add(b);
						panel1.revalidate();
						panel1.repaint();
						popular.setEnabled(false);
						
						
						
						b.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
							
								int viewed = i.getnumTimesViewed();
								i.setnumTimesViewed(viewed + 1);
								
								try {
									//maintain.update(path3);
									
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								ItemInfo Info = new ItemInfo(i, u);
								Info.frame.setVisible(true);
								//frame.dispose();
							}
						});
			 		
			 		}
			 		
			 	
			 	}
			 });
		 
		 
		 
		 recommended.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		panel1.setLayout(new java.awt.FlowLayout(0,30,30));
			 		popular.setEnabled(true);
			 		panel1.removeAll();
			 		
			 		MaintainItem it = new MaintainItem();
			 		MaintainCart ct = new MaintainCart();
			 		
			 		try {
						it.load(path3);
						ct.load(cartpath);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			 		
			 		Collections.shuffle(it.items);
			 		
			 		List<item> recommendeditems = it.items.subList(0, 5);
			 		
			 		
			 		
			 		for(item i: recommendeditems) {
			 			JButton b = new JButton(String.valueOf(i.getName()));
			 			b.setForeground(Color.ORANGE);
						b.setBackground(Color.BLACK);
						b.setPreferredSize(new Dimension(120,25));
						panel1.add(b);
						panel1.revalidate();
						panel1.repaint();
						
						b.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								//item item = new item(c.getitemID(), c.getName(), c.getSize(), c.getCategory(), c.getPrice(), c.getisItemAvailable(), c.getnumTimesViewed(), c.getAisleNumber(), c.getonSale(), c.getDescription());
								
								ItemInfo Info = new ItemInfo(i, u);
								Info.frame.setVisible(true);
								//frame.dispose();
							}
						});
			 			
			 		}
			 		
			 		
			 			
			 		
			 		
			 		recommended.setEnabled(false);
			 		
			 	}
			 });
		 
		
	}
}
