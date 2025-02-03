/*
 * The purpose of this class is to be the template
 * for the cart frame. This will have a JPanel that 
 * displays the cart ArrayList and have a scroll bar
 * so you can scroll and see all the computers that 
 * are in the cart. You are also able to click a check out
 * button which will lead you to a new window with cart information 
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class LaptopStoreCartFrame extends JFrame implements ActionListener{
	
	//access to laptop object array
	static Laptop [] laptopArray = LaptopStoreFileInput.getLaptopArray();
	
	//access to cart array
	static ArrayList<Laptop> cartArrayList = LaptopStoreInventoryFrame.getCartArray();
	
	//Declare components / widgets
	JScrollPane scrollBar;
	JPanel cartPanel;
	JButton checkOutButton;
	JButton homeButton;
	JButton educationButton;
	JButton surveyButton;
	JButton storeButton;
	JButton cartButton;
	JLabel cartTitle;

	//Constructor of the frame that controls the logic and how the widgets
	//and other components will be placed
	public LaptopStoreCartFrame() { 
		
		//creating image icon for the buttons
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
		
		//creating store button and action listener
		storeButton = new JButton(storeImage);
		storeButton.addActionListener(this);
		
		//creating survey button and action listener
		surveyButton = new JButton(surveyImage);
		surveyButton.addActionListener(this);
		
		//creating title for cart frame
		cartTitle = new JLabel("Your Cart!");
		cartTitle.setBounds(350, 50, 200, 200);
		cartTitle.setForeground(Color.WHITE);
		cartTitle.setFont(new Font("Arial", Font.BOLD, 25));
		
		//set the color of the buttons - awt color class
		//https://codegym.cc/groups/posts/java-awt-color-class
		Color buttonsColor = new Color(52, 68, 68);
		
		//set background color for the home bar buttons
		educationButton.setBackground(buttonsColor);
		homeButton.setBackground(buttonsColor);
		storeButton.setBackground(buttonsColor);
		surveyButton.setBackground(buttonsColor);
		
		//Nav bar code taken from Survey class (Edith) so that
		//the nav bar will be consistent and the same between
		//multiple frames
		educationButton.setPreferredSize(new Dimension(educationImage.
				getIconWidth(), educationImage.getIconHeight()));
		homeButton.setPreferredSize(new Dimension(homeImage.
				getIconWidth(), homeImage.getIconHeight()));
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
			
			g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this); 
					//backgroundImage.getIconHeight(), this);
			}
		};
		backgroundPanel.setPreferredSize(new Dimension(backgroundImage.getIconWidth(), 
		backgroundImage.getIconHeight()));
		backgroundPanel.setLayout(new BorderLayout());
		backgroundPanel.add(buttonsPanel, BorderLayout.NORTH);
		setContentPane(backgroundPanel);
		
		//creating the JPanel 
		cartPanel = new JPanel();
		
		//creating imageIcon for checkOutButton
		ImageIcon checkOutPicture = new ImageIcon("images/checkOutButton.png");
		
		//creating imageIcon for the picture on checkoutButton and 
		//scaling the dimensions
		ImageIcon scaledCheckOutPicture = new ImageIcon(checkOutPicture.getImage().
				getScaledInstance(200, 100, Image.SCALE_DEFAULT));

		//creating the checkOutButton and its bounds and adding
		//an action Listener
		checkOutButton = new JButton(scaledCheckOutPicture);
		checkOutButton.setBounds(800, 240, 200, 100);
		checkOutButton.addActionListener(this);
				
		//creating the layout and using Y-AXIS so it is vertical
		//https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/javax/swing/BoxLayout.html
		cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));		
		
		//For loop that creates a new JPanel as each row and contains
		//the laptop picture and and its name. This will dynamically update
		//and allow you to scroll down depending on the number of items
		//in the array

		for (int i = 0; i < cartArrayList.size(); i++) {
			JPanel laptopRow = new JPanel();
			//https://docs.oracle.com/javase/8/docs/api/javax/swing/BorderFactory.html
			//the empty border will give space between each laptop row so it 
			//is not clumped up 
			laptopRow.setLayout(new BorderLayout());
			laptopRow.setBorder(BorderFactory.createEmptyBorder(10, 4, 10, 10));
			laptopRow.setPreferredSize(new Dimension(700, 200));
			laptopRow.setMaximumSize(new Dimension(700, 200));
			laptopRow.setMinimumSize(new Dimension(700, 200));
			
			//creating image icon for picture of laptop
			ImageIcon laptopPictureImage = new ImageIcon("Laptop Images/" + 
					cartArrayList.get(i).getBrand() + 
					" " + cartArrayList.get(i).getName() + ".png");
			
			//scaling the imageIcon size
			ImageIcon laptopPicture = new ImageIcon(laptopPictureImage.getImage().
							getScaledInstance(320, 200, Image.SCALE_SMOOTH));
			
			//creating JLabel with the image
			JLabel laptopPictureLabel = new JLabel(laptopPicture);
			
			//https://docs.oracle.com/javase/8/docs/api/javax/swing/JComponent.html
			//this prevents the panel from shrinking the images when adding
			//more things to the cart panel
			laptopPictureLabel.setPreferredSize(new Dimension(320, 200));
		    laptopPictureLabel.setMaximumSize(new Dimension(320, 200));
		    laptopPictureLabel.setMinimumSize(new Dimension(320, 200));
			
			//adding image to the panel on the left-hand side
			// https://docs.oracle.com/javase/8/docs/api///?java/awt/BorderLayout.html
			//used the link above to determine the border layout (image in the link
			//if helpful for visualization)
			laptopPictureLabel.setBounds(0, 0, 100, 100);
			laptopRow.add(laptopPictureLabel, BorderLayout.WEST);
			
			//adding the laptopName and quantity to the row as well as 
			//making the font look nicer with color and size
			JLabel laptopNameLabel = new JLabel(cartArrayList.get(i).getName());
			laptopNameLabel.setForeground(Color.WHITE);
			laptopNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
			
			//putting the laptop name in the middle of the row
			laptopNameLabel.setBounds(200, 0, 100, 100);
			laptopRow.add(laptopNameLabel, BorderLayout.CENTER);
			
			laptopRow.setBackground(new Color (29, 41, 62, 255));
			
			//adding row to the cart JPanel
			cartPanel.add(laptopRow);
		}
				
		//setting the dimensions, title, and other values for the frame
		this.setTitle("Laptop Cart Frame");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1080, 610); 
		this.setLayout(new BorderLayout());
		//setting setVisible to true to allow the frame to be visible
		this.setVisible(true);
		//Center the frame on the screen
        setLocationRelativeTo(null);
	
		scrollBar = new JScrollPane(cartPanel);
		scrollBar.setBounds(50, 200, 700, 300);

		//specifications about scrollBar like making it vertical
		//https://stackoverflow.com/questions/5527487/make-a-java-jscrollpane-only-scroll-vertically
		scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//changing the colors to look nicer
		cartPanel.setBackground(new Color(29, 41, 62, 255));
		scrollBar.setBackground(new Color(29,41,62,255));
		
		//adding components 
		scrollBar.setViewportView(cartPanel);
		backgroundPanel.add(scrollBar, BorderLayout.CENTER);
		backgroundPanel.add(cartTitle);
		backgroundPanel.add(checkOutButton);
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
		
		else if (e.getSource() == checkOutButton) {
			this.dispose();
			new LaptopStoreCartInfoFrame();
		}
		
	}
	

}
