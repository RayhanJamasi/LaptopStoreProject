import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * Team 2, Qianyi Ma
 * 
 * Date: Nov. 25, 2024
 * 
 * Course Code: ICS3U1-03 Mrs. Biswas
 * 
 * Project: BOSS Electronic Store - LaptopStoreTitleFrame & LaptopStoreInventoryFrame 
 * 
 * Description: 
 * 			This class creates a main title window(frame). 
 * 			This class creates buttons for opening different
 * 			frames(education, survey, store, cart), labels for showing
 * 			the title and images, and ImageIcons. 
 * 			This class sets configurations and properties of components and the JFrame. 
 * 			When the one of the button is clicked, the program will close this frame
 * 			and open the corresponding frame of the button. 
 * 
 * 			The inventory class create a store window(frame).
 * 			It created buttons for opening different frames(education, survey, store, cart),
 * 			buttons for showing detail information of the laptop, a drop down list 
 * 			for sorting the laptop array in different order, a scroll pane, and a JLabel
 * 			for displaying the title. 
 * 			In the detailed info of laptop window, there is an image of the laptop, an
 * 			"add to cart" button, and a JLabel showing all the specifications. 
 * 			Click the return button will close the window
 * 			Click the showinfo button beside the overall rating, 
 * 			will open a new window of detailed rating (JLabel)
 * 			Click the return button will close the window
 * 			
 * 
 * Major Skills: swing GUI components, awt button handler and color, arrays, map
 * 
 * Added features: Background image
 * 
 * Areas of concern: no button handler for cart button for now
 * 
 * Contribution: LaptopStoreTitleFrame - Qianyi Ma
 *               LaptopStoreInventoryFrame - Qianyi Ma
 * 
 */

public class LaptopStoreTitleFrame extends JFrame implements ActionListener{
	//declare JButtons
	JButton educationButton, surveyButton, storeButton, cartButton;
	
	
	//Constructor
	LaptopStoreTitleFrame(){
		//Set JFrame properties
		setTitle("BOSS Electronic Store Main Title");
		//set the window size
		setSize(1084, 610);
		//Close application on exit
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Center the frame on the screen
		setLocationRelativeTo(null);
		
		//set the color of the buttons - awt color class
		//https://codegym.cc/groups/posts/java-awt-color-class
		Color buttonsColor = new Color(52, 68, 68);
		
		//Create education button (when it is clicked, open education frame)
		educationButton = new JButton();
		educationButton.addActionListener(this);
		//add image to the button
		ImageIcon educationButtonImage = new ImageIcon("images/educationButton.png");
		educationButton.setIcon(educationButtonImage);
		//set background color
		educationButton.setBackground(buttonsColor);
		//set the size of the button
		educationButton.setPreferredSize(new Dimension(educationButtonImage.getIconWidth(),
				educationButtonImage.getIconHeight()));
		
		//create survey button (when it is clicked, open survey frame)
		surveyButton = new JButton();
		surveyButton.addActionListener(this);
		//add image to the button
		ImageIcon surveyButtonImage = new ImageIcon("images/surveyButton.png");
		surveyButton.setIcon(surveyButtonImage);
		//set background color
		surveyButton.setBackground(buttonsColor);
		//set the size of the button
		surveyButton.setPreferredSize(new Dimension(surveyButtonImage.getIconWidth(),
				surveyButtonImage.getIconHeight()));
		
		//create store/inventory button (when it is clicked, open store frame)
		storeButton = new JButton();
		storeButton.addActionListener(this);
		//add image to the button
		ImageIcon storeButtonImage = new ImageIcon("images/storeButton.png");
		storeButton.setIcon(storeButtonImage);
		//set background color
		storeButton.setBackground(buttonsColor);
		//set the size of the button
		storeButton.setPreferredSize(new Dimension(storeButtonImage.getIconWidth(),
				storeButtonImage.getIconHeight()));
		
		//add cart button (when it is clicked, open cart frame) (TBD)
		cartButton = new JButton();
		cartButton.addActionListener(this);
		//add image to the button
		ImageIcon cartButtonImage = new ImageIcon("images/cartButton.png");
		cartButton.setIcon(cartButtonImage);
		//set background color
		cartButton.setBackground(buttonsColor);
		//set the size of the button
		cartButton.setPreferredSize(new Dimension(cartButtonImage.getIconWidth(),
				cartButtonImage.getIconHeight()));
		
		//Create a panel for buttons
		JPanel buttonsPanel = new JPanel();
		//make the panel transparent
		buttonsPanel.setOpaque(false);
		//Add buttons to the panel
		buttonsPanel.add(educationButton);
		buttonsPanel.add(surveyButton);
		buttonsPanel.add(storeButton);
		buttonsPanel.add(cartButton);
		
		//background image
		ImageIcon backgroundImage = new ImageIcon("images/titleBackground.jpg");
		
		//set the background of the window as an image
		//https://stackoverflow.com/questions/19125707/simplest-way-to-set-image-as-jpanel-background
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
		
		//make the frame visible
		setVisible(true);
	}
	
	//Handles button click events.
	//e is the ActionEvent triggered by buttons
	//close window: https://www.tutorialspoint.com/how-to-close-jframe-on-the-click-of-a-button-in-java
	@Override
	public void actionPerformed(ActionEvent e) {
		//if education button is clicked, terminate this window
		//and open education frame
		if (e.getSource() == educationButton) {
			dispose();
//			new LaptopStoreEducationFrame();
		}
		//if store button is clicked, terminate this window
		//and open store frame
		else if (e.getSource() == storeButton) {
			dispose();
			new LaptopStoreInventoryFrame();
		}
		//if survey button is clicked, terminate this window
		//and open survey frame
		else if (e.getSource() == surveyButton) {
			dispose();
			new LaptopStoreSurveyFrame();
		}
		//if cart button is clicked, terminate this window
		//and open cart frame
		else if (e.getSource() == cartButton) {
			dispose();
			new LaptopStoreCartFrame();
		}
	}
	
	
}