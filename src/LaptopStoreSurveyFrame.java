import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
/*
 * PROJECT HEADER
 * =============================
 * Group 2  Name:Edith Chan
 * Date: 29 - 11 - 2024
 * Course: ICS3U1 - survey frame 
 * Title: BOSS Electronic Store
 * Description: 
 * This class is for the survey frame to let the user to find the laptop they want 
 * or giving some recommends for them
 * 
 * This is what codes will do and add in the survey form
 * ====================================
 * 1. import all the awt and swing 
 * 2. Initialize buttons, frame, labels, panels etc
 * 3. Constructor the survey frame 
 * 		3.1. set the JFrame properties 
 *        3.1.1 set title, size, close application on exit 
 *        3.1.2 set buttons, colours and background of the laptop store (from the Laptop Survey Title Frame)
 *        3.1.3 create the JPanel of the questions and radio buttons 
 *          3.1.3.1 create the questions using JLabel
 *          3.1.3.2 set the font size and color 
 *          3.1.3.3 set the opaque to false 
 *          3.1.3.2 set bounds for the labels
 *          3.1.3.3 create the radio buttons for the options for the questions 
 *            3.1.3.3.1 group the buttons together (budget, type, brand, ssd, ram)
 *          3.1.3.4 create the done button to go to the result frame
 *            3.1.3.4.1 add actionlistener to the button
 *          3.1.3.5 add the radio buttons and label to the panel
 *        3.1.3.4 add actionListener for each button
 *        
 */

public class LaptopStoreSurveyFrame extends JFrame implements ActionListener{
	//Initialize buttons, frames, labels, panels 
	private JLabel question1Label;
	private JLabel question2Label;
	private JLabel question3Label;
	private JLabel question4Label;
	private JLabel question5Label;
	private JButton doneButton;
	private JButton homeButton;
	private JButton educationButton;
	private JButton cartButton;
	private JButton storeButton;
	private JButton surveyButton;
	
	//RAYHAN - accessing list, so it radio button values can be passed 
	//later to the results frame when results frame calls the 
	//getRadioButtonArray method. This array will hold the values
	//for the survey results so that the results class
	//will be able to determine which options were chosen
	static int [] radioButtonArray = new int[5];
	
	//Constructor 
	public LaptopStoreSurveyFrame(){
		
		//set JFrame properties 
		setTitle("Survey"); //set title
		setSize(1084, 610); //set size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set close application on exit
		
		//set the color of the buttons - awt color class
		//https://codegym.cc/groups/posts/java-awt-color-class
		Color buttonsColor = new Color(52, 68, 68);
		
		//Create home button (not used in this frame)
		homeButton = new JButton();
		homeButton.addActionListener(this);
		//add image to the button
		ImageIcon homeButtonImage = new ImageIcon("images/homeButton.png");
		homeButton.setIcon(homeButtonImage);
		//set the background color
		homeButton.setBackground(buttonsColor);
		//set the size of the button
		//https://www.daniweb.com/programming/software-development/threads/444105/problem-setting-preferredsize-for-jbutton
		homeButton.setPreferredSize(new Dimension(homeButtonImage.getIconWidth(),
						homeButtonImage.getIconHeight()));
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
		buttonsPanel.add(homeButton);
		buttonsPanel.add(educationButton);
		buttonsPanel.add(surveyButton);
		buttonsPanel.add(storeButton);
		buttonsPanel.add(cartButton);
				
		//background image
		ImageIcon backgroundImage = new ImageIcon("images/storeBackground.jpg");
				
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
		
		//create the label panel 
		//to put all questions and radio buttons and the done button together 
		JPanel labelpanel = new JPanel();
		labelpanel.setOpaque(false);
		//set layout to be null
		labelpanel.setLayout(null);
		//create the first question label and set bounds
		//set Opaque to false 
		//set the font and color
		//This is where I learn it 
		//https://stackoverflow.com/questions/2966334/how-do-i-set-the-colour-of-a-label-coloured-text-in-java
		//Q1 budget 
		question1Label = new JLabel("What is your budget?");
		question1Label.setBounds(350, 20, 150, 50);
		question1Label.setForeground(Color.WHITE);
		question1Label.setFont(new Font("Arial", 15, 15));
		question1Label.setOpaque(false);
		
		//create the second question label and set bounds 
		//set font size and color
		//set Opaque to false 
		//Q2 type 
		question2Label = new JLabel("What type of laptop do you want?");
	    question2Label.setBounds(350, 70, 250, 50);
	    question2Label.setForeground(Color.WHITE);
		question2Label.setFont(new Font("Arial", 15, 15));
	    question2Label.setOpaque(false);
	    
	    //create the third question and set bounds
	    //set font size and color
	    //set Opaque to false 
	    //Q3 brand
	    question3Label = new JLabel("What type of brand do you perfer?");
	    question3Label.setBounds(350, 130, 255, 50);
	    question3Label.setForeground(Color.WHITE);
		question3Label.setFont(new Font("Arial", 15, 15));
	    question3Label.setOpaque(false);
	    
	    //create the fourth question and set bounds
	    //set font size and color
	    //set Opaque to false 
	    //Q4 SSD (GB)
	    question4Label = new JLabel("How much SSD (GB) do you want?");
	    question4Label.setBounds(350, 190, 280, 50);
	    question4Label.setForeground(Color.WHITE);
		question4Label.setFont(new Font("Arial", 15, 15));
	    question4Label.setOpaque(false);
	    
	    //create the fifth question and set bounds 
	    //set font size and color
	    //set Opaque to false 
	    //Q5 RAM (GB)
	    question5Label = new JLabel("How much RAM (GB) do you want?");
	    question5Label.setBounds(350, 240, 280, 50);
	    question5Label.setForeground(Color.WHITE);
		question5Label.setFont(new Font("Arial", 15, 15));
	    question5Label.setOpaque(false);
	    
		
	    //create the radio buttons for the budget 
	    JRadioButton budgetbutton = new JRadioButton("0-500");
	    JRadioButton midpricebutton = new JRadioButton("500 - 1000");
	    JRadioButton highendbutton = new JRadioButton("1000 - 2000");
	    JRadioButton ultrabutton = new JRadioButton("2000++");
	    
	    //set bounds for each radio buttons
	    budgetbutton.setBounds(350, 50, 60, 30);
	    midpricebutton.setBounds(420, 50, 90, 30);
	    highendbutton.setBounds(510, 50, 90, 30);
	    ultrabutton.setBounds(610, 50, 100, 30);
	    
	    //set Opaque to false 
	    budgetbutton.setOpaque(false);
	    midpricebutton.setOpaque(false);
	    highendbutton.setOpaque(false);
	    ultrabutton.setOpaque(false);
	    
	    //create the radio buttons for the type 
	    JRadioButton gamingbutton = new JRadioButton("Gaming");
	    JRadioButton studentbutton = new JRadioButton("Student");
	    JRadioButton professionalbutton = new JRadioButton("Professional");
	    
	    //set bounds for each radio buttons 
	    gamingbutton.setBounds(350, 100, 70, 30);
	    studentbutton.setBounds(430, 100, 80, 30);
	    professionalbutton.setBounds(507, 100, 100, 30);
	    
	    //set Opaque to false 
	    gamingbutton.setOpaque(false);
	    studentbutton.setOpaque(false);
	    professionalbutton.setOpaque(false);
	    
	    //create the radio button for the brand 
	    JRadioButton applebutton = new JRadioButton("Apple");
	    JRadioButton HPbutton = new JRadioButton("HP");
	    JRadioButton asusbutton = new JRadioButton("ASUS");
	    JRadioButton dellbutton = new JRadioButton("Dell");
	    JRadioButton acerbutton = new JRadioButton("Acer");
	    JRadioButton Lanvovbutton = new JRadioButton("Lenovo");
	    
	    //set bounds for each radio buttons 
	    applebutton.setBounds(350, 150, 60, 50);
	    HPbutton.setBounds(420, 150, 50, 50);
	    asusbutton.setBounds(470, 150, 60, 50);
	    dellbutton.setBounds(540, 150, 50, 50);
	    acerbutton.setBounds(590, 150, 60, 50);
	    Lanvovbutton.setBounds(650, 150, 75, 50);
	    
	    //set Opaque to false 
	    applebutton.setOpaque(false);
	    HPbutton.setOpaque(false);
	    asusbutton.setOpaque(false);
	    dellbutton.setOpaque(false);
	    acerbutton.setOpaque(false);
	    Lanvovbutton.setOpaque(false);
	    
	    //create the radio button for the SSD(GB)
	    JRadioButton ssd1button = new JRadioButton("128GB");
	    JRadioButton ssd2button = new JRadioButton("256GB");
	    JRadioButton ssd3button = new JRadioButton("512GB");
	    JRadioButton ssd4button = new JRadioButton("1000+GB");
	    
	    //set bounds for each radio buttons
	    ssd1button.setBounds(350, 210, 80, 50);
	    ssd2button.setBounds(429, 210, 80, 50);
	    ssd3button.setBounds(505, 210, 80, 50);
	    ssd4button.setBounds(585, 210, 80, 50);
	    
	    //set Opaque to false 
	    ssd1button.setOpaque(false);
	    ssd2button.setOpaque(false);
	    ssd3button.setOpaque(false);
	    ssd4button.setOpaque(false);
	    
	    //create the radio buttons for RAM(GB)
	    JRadioButton ram1button = new JRadioButton("4");
	    JRadioButton ram2button = new JRadioButton("8");
	    JRadioButton ram3button = new JRadioButton("16");
	    JRadioButton ram4button = new JRadioButton("24");
	    JRadioButton ram5button = new JRadioButton("32");
	    
	    //set bounds for each radio buttons
	    ram1button.setBounds(350, 260, 50, 50);
	    ram2button.setBounds(410, 260, 50, 50);
	    ram3button.setBounds(470, 260, 50, 50);
	    ram4button.setBounds(530, 260, 50, 50);
	    ram5button.setBounds(590, 260, 50, 50);
	    
	    //set Opaque to false 
	    ram1button.setOpaque(false);
	    ram2button.setOpaque(false);
	    ram3button.setOpaque(false);
	    ram4button.setOpaque(false);
	    ram5button.setOpaque(false);
	    
	    //https://www.tutorialspoint.com/swingexamples/using_radiobutton_group.htm
	    //I learn how to create a button group 
	    //and add the radio buttons to a group in this website 
	    
	    //group the budget buttons
	    //name the group groupPrice
	    ButtonGroup groupPrice = new ButtonGroup();
	    //add the budget buttons to the group 
	    groupPrice.add(budgetbutton);
	    groupPrice.add(midpricebutton);
	    groupPrice.add(highendbutton);
	    groupPrice.add(ultrabutton);
	    
	    //group the type buttons
	    //name the group groupType
	    ButtonGroup groupType = new ButtonGroup();
	    //add the type buttons to the group 
	    groupType.add(gamingbutton);
	    groupType.add(studentbutton);
	    groupType.add(professionalbutton);
	    
	    //group the brand buttons together 
	    //name the group groupbrand
	    ButtonGroup groupbrand = new ButtonGroup();
	    //add the brand buttons to the group 
	    groupbrand.add(applebutton);
	    groupbrand.add(HPbutton);
	    groupbrand.add(asusbutton);
	    groupbrand.add(dellbutton);
	    groupbrand.add(acerbutton);;
	    groupbrand.add(Lanvovbutton);
	    
	    //group the buttons together 
	    //name the group groupSSD
	    ButtonGroup groupSSD = new ButtonGroup();
	    //add the SSD buttons to the group 
	    groupSSD.add(ssd1button);
	    groupSSD.add(ssd2button);
	    groupSSD.add(ssd3button);
	    groupSSD.add(ssd4button);
	    
	    //group the buttons together
	    ButtonGroup groupRAM = new ButtonGroup();
	    //add RAM buttons to the group 
	    groupRAM.add(ram1button);
	    groupRAM.add(ram2button);
	    groupRAM.add(ram3button);
	    groupRAM.add(ram4button);
	    groupRAM.add(ram5button);
	    
	    //add the buttons and label to the panel 
		//add the budget buttons and first question
		//Explain:
		//The question label is add first
		//which let the label print out first 
	    labelpanel.add(question1Label);
	    labelpanel.add(budgetbutton);
	    labelpanel.add(midpricebutton);
	    labelpanel.add(highendbutton);
	    labelpanel.add(ultrabutton);
	    
	    //add the type buttons and second question 
	    labelpanel.add(question2Label);
	    labelpanel.add(gamingbutton);
	    labelpanel.add(studentbutton);
	    labelpanel.add(professionalbutton);
	    
	    //add the brand buttons and third question
	    labelpanel.add(question3Label);	   
	    labelpanel.add(applebutton);
	    labelpanel.add(HPbutton);
	    labelpanel.add(asusbutton);
	    labelpanel.add(dellbutton);
	    labelpanel.add(acerbutton);
	    labelpanel.add(Lanvovbutton);
	    
	    //add SSD buttons and fourth question 
	    labelpanel.add(question4Label);
	    labelpanel.add(ssd1button);
	    labelpanel.add(ssd2button);
	    labelpanel.add(ssd3button);
	    labelpanel.add(ssd4button);
	    
	    //add RAM buttons and fifth question 
	    labelpanel.add(question5Label); 
	    labelpanel.add(ram1button); 
	    labelpanel.add(ram2button);
	    labelpanel.add(ram3button);
	    labelpanel.add(ram4button);
	    labelpanel.add(ram5button);
	    
	    //The done button is to let the user press it 
	    //when they finish the form 
	    //Then it will go to the result frame to show the result 
	    doneButton = new JButton("Done"); //Create the done button at the bottom of the form 
	    doneButton.addActionListener(this);  //add actionListener to the button 
		doneButton.setBounds(450, 350, 70, 40);//set bounds for the done button
		
	    //add the done button to the panel 
	    labelpanel.add(doneButton);
	    //add the label panel to the background panel and set borderLayout 
	    backgroundPanel.add(labelpanel, BorderLayout.CENTER);
		
		setLocationRelativeTo(null);//set location relative to null
		setVisible(true); //set the visibility to true
		
		//rayhan - doing all the ActionCommand and assigning of values in the index
		//for the radioButtonArray as well as adding radioButtonListener to all the buttons
		// https://stackhowto.com/how-to-get-value-of-selected-jradiobutton-in-java/
		//This website tells how to get the values of a radio button by setting an 
		//action command and you can make it have a string value. 
		//I also used this website to confirm / help with some things I was still confused on:
		//https://www.codejava.net/java-se/swing/jradiobutton-basic-tutorial-and-examples
		//Then you can make a new object from ActionListener class. 
		//After in the override actionPerformed (ActionEvent e), you 
		//can use Integer.parseInt (e.getActionCommand) to get the value
		//of the radio button chosen and convert it to an integer. I had a general idea
		//of what the getActionCommand now did and I checked with stackOverFlow link
		////https://stackoverflow.com/questions/8214958/the-getsource-and-getactioncommand
		
		//setting action commands for the buttons
		budgetbutton.setActionCommand("1");
		midpricebutton.setActionCommand("2");
		highendbutton.setActionCommand("3");
		ultrabutton.setActionCommand("4");
		
		gamingbutton.setActionCommand("1");
		studentbutton.setActionCommand("2");
		professionalbutton.setActionCommand("3");
		
		applebutton.setActionCommand("1");
		HPbutton.setActionCommand("2");
		asusbutton.setActionCommand("3");
		dellbutton.setActionCommand("4");
		acerbutton.setActionCommand("5");
		Lanvovbutton.setActionCommand("6");
	    
		ssd1button.setActionCommand("1");
		ssd2button.setActionCommand("2");
		ssd3button.setActionCommand("3");
		ssd4button.setActionCommand("4");
	
		ram1button.setActionCommand("1");
		ram2button.setActionCommand("2");
		ram3button.setActionCommand("3");
		ram4button.setActionCommand("4");
		ram5button.setActionCommand("5");
		
		//creating new instance of the actionListener class
		ActionListener radioButtonListener = new ActionListener() {

			public void actionPerformed(ActionEvent event) {
		        // Get the action command from the JRadio button and set it 
				//as a string, also makes it so i dont have to type
				//event.getActionCommand each time I assign a value to an index
		        String actionCommand = event.getActionCommand();

		        // Update the radioButtonArray based on the source of the event
		        if (event.getSource() == budgetbutton || event.getSource() == 
		        			midpricebutton || event.getSource() == 
		        				highendbutton || event.getSource() == ultrabutton) {
		            radioButtonArray[0] = Integer.parseInt(actionCommand);
		        } 
		        else if (event.getSource() == gamingbutton || event.getSource() 
		        			== studentbutton || event.getSource() == professionalbutton) {
		            radioButtonArray[1] = Integer.parseInt(actionCommand);
		        }
		        
		        else if (event.getSource() == applebutton || event.getSource() 
		        			== HPbutton || event.getSource() == asusbutton || 
		        				event.getSource() == dellbutton || event.getSource() 
		        					== acerbutton || event.getSource() == Lanvovbutton) {
		            radioButtonArray[2] = Integer.parseInt(actionCommand);
		        }
		        
		        else if (event.getSource() == ssd1button || event.getSource() 
		        			== ssd2button || event.getSource() == ssd3button 
		        				|| event.getSource() == ssd4button) {
		            radioButtonArray[3] = Integer.parseInt(actionCommand);
		        }
		        else if (event.getSource() == ram1button || event.getSource() 
		        			== ram2button || event.getSource() == ram3button 
		        				|| event.getSource() == ram4button || 
		        					event.getSource() == ram5button) {
		            radioButtonArray[4] = Integer.parseInt(actionCommand);
		        }
		    }
		};
		
		// rayhan - adding the radioButtonListener to all of the radio buttons 
		budgetbutton.addActionListener(radioButtonListener);
		midpricebutton.addActionListener(radioButtonListener);
		highendbutton.addActionListener(radioButtonListener);
		ultrabutton.addActionListener(radioButtonListener);

		gamingbutton.addActionListener(radioButtonListener);
		studentbutton.addActionListener(radioButtonListener);
		professionalbutton.addActionListener(radioButtonListener);

		applebutton.addActionListener(radioButtonListener);
		HPbutton.addActionListener(radioButtonListener);
		asusbutton.addActionListener(radioButtonListener);
		dellbutton.addActionListener(radioButtonListener);
		acerbutton.addActionListener(radioButtonListener);
		Lanvovbutton.addActionListener(radioButtonListener);

		ssd1button.addActionListener(radioButtonListener);
		ssd2button.addActionListener(radioButtonListener);
		ssd3button.addActionListener(radioButtonListener);
		ssd4button.addActionListener(radioButtonListener);

		ram1button.addActionListener(radioButtonListener);
		ram2button.addActionListener(radioButtonListener);
		ram3button.addActionListener(radioButtonListener);
		ram4button.addActionListener(radioButtonListener);
		ram5button.addActionListener(radioButtonListener);
		
	}
	
	//rayhan - this method returns the survey results so that the results 
	//class can use it
	public static int [] getRadioButtonArray() {
		return radioButtonArray;
	}

	//Handles button click events.
	//event is the ActionEvent triggered by buttons
	//close window: https://www.tutorialspoint.com/how-to-close-jframe-on-the-click-of-a-button-in-java
	@Override
	public void actionPerformed(ActionEvent event) {
		//if done button is called, terminate this window 
		//and open the result frame 
		if (event.getSource() == doneButton) {
			this.dispose();
			new LaptopStoreResultsFrame();
		}
		//if education button is clicked, terminate this window
		//and open education frame
		else if (event.getSource() == educationButton) {
			this.dispose();
			new LaptopStoreEducationFrame();
		}
		//if store button is clicked, terminate this window
		//and open store frame
		else if (event.getSource() == storeButton) {
			this.dispose();
			new LaptopStoreInventoryFrame();
		}
			
		//if cart button is called, terminate this window
		//and open cart frame
		else if (event.getSource() == cartButton) {
			this.dispose();
			new LaptopStoreCartFrame();
		}
		
		//if home button is called, terminate this window
		//and open title frame
		else if (event.getSource() == homeButton) {
			this.dispose();
			new LaptopStoreTitleFrame();
		}
	}	
	//main frame 
	public static void main(String[] args) {
		new LaptopStoreSurveyFrame();
	}
		
}


		