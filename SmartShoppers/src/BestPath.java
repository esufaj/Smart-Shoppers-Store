import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

public class BestPath {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BestPath window = new BestPath();
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
	public BestPath() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 560, 569);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel bestpath = new JLabel("");
		bestpath.setBounds(0, 0, 550, 530);
		frame.getContentPane().add(bestpath);
		ImageIcon i1 = new ImageIcon("C:\\Users\\PC\\Desktop\\layout.jpg");
		Image img = i1.getImage().getScaledInstance(550, 550, Image.SCALE_SMOOTH);
		ImageIcon n = new ImageIcon(img);
		bestpath.setIcon(n);
		
	}

}
