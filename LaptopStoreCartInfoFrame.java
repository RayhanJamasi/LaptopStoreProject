import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * The purpose of this frame is to output the information
 * about the cart to the user. This includes telling the subtotal, 
 * tax, and price amount for their cart. It will display this using 
 * pannels and by accessing the cart ArrayList to calculate  
 */

public class LaptopStoreCartInfoFrame extends JFrame implements ActionListener {
	
	//declaring the widgets
	JButton homeButton;
	JButton educationButton;
	JButton surveyButton;
	JButton storeButton;
	JButton cartButton;
	JLabel titleLabel;
	JPanel infoPanel;
	JLabel subTotal;
	JLabel tax;
	JLabel total;
	
	//access to cart array
	static ArrayList<Laptop> cartArrayList = LaptopStoreInventoryFrame.getCartArray();
	
	//constructor that builds and designs how everything is going to look as
	//well as deal with the logic
	public LaptopStoreCartInfoFrame() {
		//creating image icon for the buttons
		ImageIcon cartImage = new ImageIcon("images/cartButton.png");
		ImageIcon educationImage = new ImageIcon("images/educationButton.png");
		ImageIcon homeImage = new ImageIcon("images/homeButton.png");
		ImageIcon storeImage = new ImageIcon("images/storeButton.png");
		ImageIcon surveyImage = new ImageIcon("images/surveyButton.png");
		
		//creating home button and action listener
		homeButton = new JButton(homeImage);
		homeButton.addActionListener(this);
		
		//creating education button and action listener
		educationButton = new JButton(educationImage);
		educationButton.addActionListener(this);
		
		//creating cart button and action listener
		cartButton = new JButton(cartImage);
		cartButton.addActionListener(this);
		
		//creating store button and action listener
		storeButton = new JButton(storeImage);
		storeButton.addActionListener(this);
		
		//creating survey button and action listener
		surveyButton = new JButton(surveyImage);
		surveyButton.addActionListener(this);
		
		//creating subtotal label
		subTotal = new JLabel();
		subTotal.setForeground(Color.WHITE);
		subTotal.setBackground(new Color(32, 96, 32));
		subTotal.setFont(new Font("Arial", Font.BOLD, 28));
		
		//creating tax label
		tax = new JLabel();
		tax.setForeground(Color.WHITE);
		tax.setBackground(new Color(32, 96, 32));
		tax.setFont(new Font("Arial", Font.BOLD, 28));
		
		//creating total label
		total = new JLabel();
		total.setForeground(Color.WHITE);
		total.setBackground(new Color(32, 96, 32));
		total.setFont(new Font("Arial", Font.BOLD, 28));
		
		
		//creating title Label
		titleLabel = new JLabel("CART INFO");
		titleLabel.setBounds(480, 80, 200, 200);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBackground(new Color(32, 96, 32));
		titleLabel.setFont(new Font("Arial", Font.BOLD, 35));
		
		//set the color of the buttons - awt color class
		//https://codegym.cc/groups/posts/java-awt-color-class
		Color buttonsColor = new Color(52, 68, 68);
		
		//set background color for the home bar buttons
		educationButton.setBackground(buttonsColor);
		homeButton.setBackground(buttonsColor);
		storeButton.setBackground(buttonsColor);
		surveyButton.setBackground(buttonsColor);
		cartButton.setBackground(buttonsColor);
		
		//set the size of the button
		educationButton.setPreferredSize(new Dimension(educationImage.
				getIconWidth(), educationImage.getIconHeight()));
		homeButton.setPreferredSize(new Dimension(homeImage.
				getIconWidth(), homeImage.getIconHeight()));
		cartButton.setPreferredSize(new Dimension(cartImage.
				getIconWidth(), cartImage.getIconHeight()));
		surveyButton.setPreferredSize(new Dimension(surveyImage.
				getIconWidth(), surveyImage.getIconHeight()));
		storeButton.setPreferredSize(new Dimension(storeImage.
				getIconWidth(), storeImage.getIconHeight()));
		
		//Create a panel for buttons
		JPanel buttonsPanel = new JPanel();
		//make the panel transparent
		buttonsPanel.setOpaque(false);
		//Add buttons to the panel
		buttonsPanel.add(educationButton);
		buttonsPanel.add(surveyButton);
		buttonsPanel.add(storeButton);
		buttonsPanel.add(cartButton);
		buttonsPanel.add(homeButton);
		
		//background image
		ImageIcon backgroundImage = new ImageIcon("images/storeBackground.jpg");
		
		//set the background of the window as an image
		//https://stackoverflow.com/questions/19125707/
		//simplest-way-to-set-image-as-jpanel-background
		JPanel backgroundPanel = new JPanel() {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawImage(backgroundImage.getImage(), 0, 0, backgroundImage.getIconWidth(), 
					backgroundImage.getIconHeight(), this);
			}
		};
		backgroundPanel.setPreferredSize(new Dimension(backgroundImage.getIconWidth(), 
		backgroundImage.getIconHeight()));
		backgroundPanel.setLayout(new BorderLayout());
		backgroundPanel.add(buttonsPanel, BorderLayout.NORTH);
		setContentPane(backgroundPanel);
		
		//Creating info panel and changing the color
		infoPanel = new JPanel();
		infoPanel.setBackground(new Color(29, 41, 62, 255));
		
		//calculating the subtotal using a for loop and updating the
		//subTotal label
		double subTotalPrice = 0;
		for (Laptop laptop : cartArrayList) {
			subTotalPrice += laptop.getPrice();
		}
		subTotal.setText("SUBTOTAL: $" + String.format("%,.2f", subTotalPrice) +
						"\n");
		
		//calculating the tax and updating tax label
		double taxPrice = subTotalPrice * 0.13;
		tax.setText("TAX $" + String.format("%,.2f", taxPrice) +
				"\n");
		
		//calculating the total and updating the total label
		double totalPrice = subTotalPrice + taxPrice;
		total.setText("TOTAL: $" + String.format("%,.2f", totalPrice) +
				"\n");
		
		//setting the dimensions, title, and other values for the frame
		this.setTitle("Cart Information");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1080, 610); 
		this.setLayout(new BorderLayout());
		//setting setVisible to true to allow the frame to be visible
		this.setVisible(true);
		//Center the frame on the screen
        setLocationRelativeTo(null);
		
		//adding three info labels to the panel
		infoPanel.add(subTotal, BorderLayout.NORTH);
		infoPanel.add(tax, BorderLayout.NORTH);
		infoPanel.add(total, BorderLayout.NORTH);
		
		infoPanel.setBounds(370, 230, 450, 150);
		
		//adding everything to the frame
		backgroundPanel.add(titleLabel);
		backgroundPanel.add(infoPanel);
		add(buttonsPanel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//calling classes for the home bar buttons
		if (e.getSource() == homeButton) {
			this.dispose();
			new LaptopStoreTitleFrame();
		}
		
		else if (e.getSource() == educationButton) {
				this.dispose();
				new LaptopStoreEducationFrame();
		}
		
		else if (e.getSource() == surveyButton) {
			this.dispose();
			new LaptopStoreSurveyFrame();
		}
		
		else if (e.getSource() == storeButton) {
			this.dispose();
			new LaptopStoreInventoryFrame();
		}
		
		else if (e.getSource() == cartButton) {
			this.dispose();
			new LaptopStoreCartFrame();
		}
		
	}

}
