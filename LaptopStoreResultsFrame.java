import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;

/*
 * The purpose of this class is to calculate the results 
 * from the survey and display it. This means that it will
 * display the top 3 computers with the percentage match 
 * of how good they will be for the user. Each laptop has a more
 * info button which will link to a method of the inventory frame
 * which opens up a window talking about its specifics. This class
 * uses a percentage based system for calculating the match level 
 * for how good each laptop is based off the user. It will then find
 * the highest match values and display the corresponding laptops :)
 */

public class LaptopStoreResultsFrame extends JFrame implements ActionListener{
	
	//getting array of radio button values from survey frame
	static int [] radioButtonArray =
			LaptopStoreSurveyFrame.getRadioButtonArray();
	
	//accessing original laptopArray
	static Laptop [] laptopArray = 
				LaptopStoreFileInput.getLaptopArray();
	
	//variable used for the bestLaptops method to get the values
	//of the match rate of each laptop
	static int laptopMatchRateCounter = 0;
	
	//list that holds the highest match values
	static int [] highestMatch = new int[3];
	
	//list that holds the index of the best laptop
	static int [] laptopArrayIndex = new int[3];
	
	//variable that is used to ensure the hashmap is filled
	//before more results (more detail later on when it's used)
	static int openInventory = 0;
	
	
	//making a new array that will have a copy of original laptopArray. 
	//This is so I can make adjustments to the array when looking
	//for the best results. If I used the original array and altered 
	//that, it would affect all the classes
	//static Laptop [] findResultsArray = new Laptop[20];
	static int [] compatibleValueArray = new int[20];
	static String [] bestLaptopsArray = new String[3];
	
	//declaring the widgets
	JButton homeButton;
	JButton educationButton;
	JButton surveyButton;
	JButton storeButton;
	JButton cartButton;
	JButton moreInfoResult1Button;
	JButton moreInfoResult2Button;
	JButton moreInfoResult3Button;
	JLabel topPicksLabel;
	JLabel computerPictureResult1Label;
	JLabel computerPictureResult2Label;
	JLabel computerPictureResult3Label;
	JLabel computerNameResult1Label;
	JLabel computerNameResult2Label;
	JLabel computerNameResult3Label;
	JLabel computerMatchRate1Label;
	JLabel computerMatchRate2Label;
	JLabel computerMatchRate3Label;
	
	//constructor that will be the template for the frame and holds all the logic
	//and components for the frame. 
	public LaptopStoreResultsFrame() {
		
		//creating image icon for the buttons
		ImageIcon cartImage = new ImageIcon("images/cartButton.png");
		ImageIcon educationImage = new ImageIcon("images/educationButton.png");
		ImageIcon homeImage = new ImageIcon("images/homeButton.png");
		ImageIcon storeImage = new ImageIcon("images/storeButton.png");
		ImageIcon surveyImage = new ImageIcon("images/surveyButton.png");
		ImageIcon moreInfoImage = new ImageIcon("images/moreInfoButton.png");
		
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
		
		//declaring Label for top picks and setting the bounds
		JLabel topPicksLabel = new JLabel("Your top picks");
		topPicksLabel.setBounds(413, 125, 290, 59);
		
		//declaring empty JLabels and computer name labels
		//and match rate labels
		JLabel computerNameResult1Label = new JLabel("");
		JLabel computerNameResult2Label = new JLabel("");
		JLabel computerNameResult3Label = new JLabel("");
		JLabel computerMatchRate1Label = new JLabel("");
		JLabel computerMatchRate2Label = new JLabel("");
		JLabel computerMatchRate3Label = new JLabel("");
				
		//setting bounds for the JLabels of computer name
		//and match result amount
		computerNameResult1Label.setBounds(80, 230, 300, 40);
		computerNameResult2Label.setBounds(460, 230, 300, 40);
		computerNameResult3Label.setBounds(815, 230, 300, 40);
		computerMatchRate1Label.setBounds(120, 185, 300, 40);
		computerMatchRate2Label.setBounds(485, 185, 300, 40);
		computerMatchRate3Label.setBounds(835, 185, 200, 40);
		
		//declaring variables used for matching and calculating the best
		//results
		int laptopBudget = 0;
		String laptopType = "";
		String laptopBrand = "";
		int laptopRAM = 0;
		int laptopSSD = 0;
		
		//if statements to find their budget based off of survey results
		if (radioButtonArray[0] == 1)
			laptopBudget = 500;
		else if (radioButtonArray[0] == 2)
			laptopBudget = 1000;
		else if (radioButtonArray[0] == 3)
			laptopBudget = 2000;
		else if (radioButtonArray[0] == 4)
			laptopBudget = 9999999;
		
		//if statements to find what type of computer their looking for
		if (radioButtonArray[1] == 1)
			laptopType = "Gaming";
		else if (radioButtonArray[1] == 2)
			laptopType = "Student";
		else if (radioButtonArray[1] == 3)
			laptopType = "Professional";
		
		//decision structure for finding their favorite brand
		if (radioButtonArray[2] == 1)
			laptopBrand = "Apple";
		else if (radioButtonArray[2] == 2)
			laptopBrand = "Asus";
		else if (radioButtonArray[2] == 3)
			laptopBrand = "Lenovo";
		else if (radioButtonArray[2] == 4)
			laptopBrand = "HP";
		else if (radioButtonArray[2] == 5)
			laptopBrand = "Dell";
		else if (radioButtonArray[2] == 6)
			laptopBrand = "Acer";
		
		//decision structure for finding their preferred SSD amount
		if (radioButtonArray[3] == 1) 
			laptopSSD = 128;
		else if (radioButtonArray[3] == 2) 
			laptopSSD = 256;
		else if (radioButtonArray[3] == 3) 
			laptopSSD = 512;
		else if (radioButtonArray[3] == 4) 
			laptopSSD = 1000;
		
		//decision structure for finding their preferred RAM amount
		if (radioButtonArray[4] == 1) 
			laptopSSD = 4;
		else if (radioButtonArray[4] == 2) 
			laptopSSD = 8;
		else if (radioButtonArray[4] == 3) 
			laptopSSD = 16;
		else if (radioButtonArray[4] == 4) 
			laptopSSD = 24;
		else if (radioButtonArray[4] == 5) 
			laptopSSD = 32;
		
		
		//variable for holding total compatibility 
		int compatible = 0;
		
		//for loop that calculates compatibility of each laptop
		//and adds it to the array that holds all the values.
		//Depending on what requirements are met, it will boost
		//the point systen. For example, price is very important
		//because if a budget is 1000 and their is a computer that is
		//2000 dollars, it is very unlikely for it to be 
		//bought 
		for (int i = 0; i < laptopArray.length; i++) {
			compatible = 0;
			if (laptopArray[i].getPrice() <= laptopBudget)
				compatible += 30;
			if (laptopArray[i].getType().equalsIgnoreCase(laptopType)) 
				compatible += 22;
			if (laptopArray[i].getBrand().equalsIgnoreCase(laptopBrand))
				compatible += 16;
			if (laptopArray[i].getRAM() > laptopRAM) 
				compatible += 16;
			if (laptopArray[i].getSSD() > laptopSSD) 
				compatible += 16;
					
				compatibleValueArray[i] = compatible;
		}
		
		//for loop that finds the best 3 laptop's and assigns them to
		//the bestLaptopsArray and calls the bestLaptops() method
		for (int i = 0; i < 3; i++) {
			bestLaptopsArray[i] = bestLaptops();
		}
		ImageIcon laptopPicture1 = new ImageIcon("Laptop Images/" + 
								bestLaptopsArray[0] + ".png");
		ImageIcon laptopPicture2 = new ImageIcon("Laptop Images/" + 
				bestLaptopsArray[1] + ".png");
		ImageIcon laptopPicture3 = new ImageIcon("Laptop Images/" + 
				bestLaptopsArray[2] + ".png");
		
		//updating the match rate labels to have the match value
		computerMatchRate1Label.setText(Integer.toString(highestMatch[0]) 
												+ "% match");
		computerMatchRate2Label.setText(Integer.toString(highestMatch[1]) 
												+ "% match");
		computerMatchRate3Label.setText(Integer.toString(highestMatch[2]) 
												+ "% match");
		
		//line of code told by a friend where the numbers (300, and 210) help
		//resize the image of the laptop file, allowing it to not be cut off like
		//it was originally
		ImageIcon laptopPictureScale1 = new ImageIcon(laptopPicture1.getImage().
							getScaledInstance(300, 210, Image.SCALE_DEFAULT));
		ImageIcon laptopPictureScale2 = new ImageIcon(laptopPicture2.getImage().
				getScaledInstance(300, 210, Image.SCALE_DEFAULT));
		ImageIcon laptopPictureScale3 = new ImageIcon(laptopPicture3.getImage().
				getScaledInstance(300, 210, Image.SCALE_DEFAULT));
		
		//Line of code used to re-scale the moreInfoButton size
		//as without this code, it would be too zoomed in
		ImageIcon moreInfoScale = new ImageIcon(moreInfoImage.getImage().
				getScaledInstance(200, 70, Image.SCALE_DEFAULT));

		//Creating JLabel with pictures for computer photos
		computerPictureResult1Label = new JLabel(laptopPictureScale1);
		computerPictureResult2Label = new JLabel(laptopPictureScale2);
		computerPictureResult3Label = new JLabel(laptopPictureScale3);
		
		//setting bounds of the picture JLabels
		computerPictureResult1Label.setBounds(24, 280, 300, 200);
		computerPictureResult2Label.setBounds(390, 280, 300, 200);
		computerPictureResult3Label.setBounds(756, 280, 300, 200);
		
		//Creating JButtons for moreInfoButtons
		moreInfoResult1Button = new JButton(moreInfoScale);
		moreInfoResult1Button.setBounds(70, 499, 200, 70);
		moreInfoResult1Button.addActionListener(this);
		
		moreInfoResult2Button = new JButton(moreInfoScale);
		moreInfoResult2Button.setBounds(440, 499, 200, 70);
		moreInfoResult2Button.addActionListener(this);
		
		moreInfoResult3Button = new JButton(moreInfoScale);
		moreInfoResult3Button.setBounds(810, 499, 200, 70);
		moreInfoResult3Button.addActionListener(this);
		
		//setting the dimensions, title, and other values for the frame
		this.setTitle("Laptop Results Frame");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1080, 610); 
		this.setLayout(new BorderLayout());
		//setting setVisible to true to allow the frame to be visible
		this.setVisible(true);
		//Center the frame on the screen
        setLocationRelativeTo(null);
		
		//updating all the values for the JLabels with the right info
		//to have the names of the laptops and their match rate
		computerNameResult1Label.setText(bestLaptopsArray[0]);
		computerNameResult2Label.setText(bestLaptopsArray[1]);
		computerNameResult3Label.setText(bestLaptopsArray[2]);
		
		//changing color of all the labels to white to look nicer
		//    https://stackoverflow.com/questions/2966334/how-do-i-set-the-colour-o
		//    f-a-label-coloured-text-in-java
		topPicksLabel.setForeground(Color.WHITE);
		computerNameResult1Label.setForeground(Color.WHITE);
		computerNameResult2Label.setForeground(Color.WHITE);
		computerNameResult3Label.setForeground(Color.WHITE);
		computerMatchRate1Label.setForeground(Color.WHITE);
		computerMatchRate2Label.setForeground(Color.WHITE);
		computerMatchRate3Label.setForeground(Color.WHITE);
		
		//changing font type and size of JLabel 
		// https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-the-maximum-size
		computerNameResult1Label.setFont(new Font("Arial", 20, 20));
		computerNameResult2Label.setFont(new Font("Arial", 20, 20));
		computerNameResult3Label.setFont(new Font("Arial", 20, 20));
		computerMatchRate1Label.setFont(new Font("Arial", Font.BOLD, 20));
		computerMatchRate2Label.setFont(new Font("Arial", Font.BOLD, 20));
		computerMatchRate3Label.setFont(new Font("Arial", Font.BOLD, 20));
		topPicksLabel.setFont(new Font("Arial", Font.BOLD, 40));
		
		
		//adding all the buttons and labels to the frame
		add(moreInfoResult1Button);
		add(moreInfoResult2Button);
		add(moreInfoResult3Button);
		add(topPicksLabel);
		add(computerPictureResult1Label);
		add(computerPictureResult2Label);
		add(computerPictureResult3Label);
		add(computerNameResult1Label);
		add(computerNameResult2Label);
		add(computerNameResult3Label);
		add(computerMatchRate1Label);
		add(computerMatchRate2Label);
		add(computerMatchRate3Label);
		add(buttonsPanel);
	}

	//This method will find the highest match laptop
	//out of the possible options and return the name
	//of which laptop it is. It ensures that it does not
	//repeat with multiple of the same laptop's as well
	public String bestLaptops() {
		//declaring a starting value for the max
		int max = compatibleValueArray[0];
		
		//declaring variables
		String bestLaptopName;
		int laptopChosen = 0;
		
		//for loop that goes through all compatible values and
		//finds the biggest. It will go through every match list 
		//and find the highest value match. It will also have laptopChosen
		//become the value of i so I know what index has the highest match
		//and can use it later to return the correct laptop
		for (int i = 0; i < compatibleValueArray.length; i++) {
			if (compatibleValueArray[i] > max) {
				max = compatibleValueArray[i];
				laptopChosen = i;
			}
		}
		
		//adding the highest laptop match ratings to an array
		if (laptopMatchRateCounter == 0) {
			highestMatch[0] = max;
			laptopArrayIndex[0] = laptopChosen;
		}
		else if (laptopMatchRateCounter == 1) {
			highestMatch[1] = max;
			laptopArrayIndex[1] = laptopChosen;
		}
		else if (laptopMatchRateCounter == 2) {
			highestMatch[2] = max;
			laptopArrayIndex[2] = laptopChosen;
		}
		
		//increasing laptopMatchRateCounter by 1 
		laptopMatchRateCounter++;
		
		//assigning bestLaptopName to the brand of the laptop
		//and the name
		bestLaptopName = laptopArray[laptopChosen].getBrand() + " " 
						+ laptopArray[laptopChosen].getName();
		
		//this will ensure that the same computer is not chosen
		//again when this method is called again as the match 
		//value is a negative
		compatibleValueArray[laptopChosen] = -1;
		System.out.println(bestLaptopName);
				
		//returning the laptop chosen
		return bestLaptopName;
		
	}

	//method for all the buttons and what they do
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
		
		//these methods are for the moreInfo buttons and display
		//more information for the laptop. Although their is an error
		//where if you click the more info button before ever opening
		//the inventory frame, it will say the hashmap for the detailedInfo
		//method is null. This is because the hashmap had its items added
		//into it in the inventory frame. So if you never open the frame, then those
		//lines never run and the hashmap is empty. Because of this, 
		//I open that frame briefly and close
		//it instantly if it is the first time the user is taking the 
		//survey. the openInventory variable is a fail-safe incase 
		//the user goes to the survey first before inventory frame. This
		//is through the use of creating a new frame that has its visible
		//set to false and closing it instantly. 
		else if (e.getSource() == moreInfoResult1Button) {
			if (openInventory == 0) {
				//making new frame
				JFrame hiddenFrame = new LaptopStoreInventoryFrame(); 
			    hiddenFrame.setVisible(false);
			    
			    // close the hidden frame immediately
			    hiddenFrame.dispose();
			    
			    //increasing openInventory by 1, so it doesn't 
			    //keep opening and closing a new frame each time
			    openInventory++;
			}
			    
			LaptopStoreInventoryFrame.detailInfo(laptopArray[laptopArrayIndex[0]]);
			
		}
		else if (e.getSource() == moreInfoResult2Button) {
			if (openInventory == 0) {
				//making new frame
				JFrame hiddenFrame = new LaptopStoreInventoryFrame(); 
			    hiddenFrame.setVisible(false);
			    
			    // close the hidden frame immediately
			    hiddenFrame.dispose();
			    
			    //increasing openInventory by 1, so it doesn't 
			    //keep opening and closing a new frame each time
			    openInventory++;
			}
			    
			LaptopStoreInventoryFrame.detailInfo(laptopArray[laptopArrayIndex[1]]);
			
		}
		else if (e.getSource() == moreInfoResult3Button) {
			if (openInventory == 0) {
				//making new frame and making it invisible
				JFrame hiddenFrame = new LaptopStoreInventoryFrame(); 
			    hiddenFrame.setVisible(false);
			    
			    // close the hidden frame immediately
			    hiddenFrame.dispose();
			    
			    //increasing openInventory by 1, so it doesn't 
			    //keep opening and closing a new frame each time
			    openInventory++;
			}
			    
			LaptopStoreInventoryFrame.detailInfo(laptopArray[laptopArrayIndex[2]]);
			
		}
		
	}
}

