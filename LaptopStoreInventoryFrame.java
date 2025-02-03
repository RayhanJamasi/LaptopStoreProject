import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.*;

import java.util.*;
import java.util.Map.Entry;

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
 * Major Skills: swing GUI components, awt button handler, color, etc., arrays, HashMap, ArrayList
 * 
 * Added features: Background image (title frame)
 * 
 * Areas of concern: None
 * 
 * Contribution: LaptopStoreTitleFrame - Qianyi Ma
 *               LaptopStoreInventoryFrame - Qianyi Ma
 * 
 */

/**********************************************************************
 * This class creates the Store (Inventory Frame) of the laptop store *
 **********************************************************************/

public class LaptopStoreInventoryFrame extends JFrame implements ActionListener{
	//declare J components
	JButton homeButton, educationButton, surveyButton, cartButton;
	static JButton infoReturn;
	static JButton ratingReturn;
	static JButton ratingButton;
	JComboBox comboBox;
	JPanel scrollPanePanel, panel1, panel2, panel3, panel4, panel5;
	JScrollPane scrollPane;

	static Color color = new Color(52, 68, 68);
	
	//cart array
	static ArrayList<Laptop> cartArrayList = new ArrayList<Laptop>(); 
	
	//access the laptop array
	static Laptop[] laptopArray = LaptopStoreFileInput.getLaptopArray();
	
	//create 20 JButtons for 20 laptops
	JButton laptop1B, laptop2B, laptop3B, laptop4B, laptop5B, laptop6B, laptop7B,
		laptop8B, laptop9B, laptop10B, laptop11B, laptop12B, laptop13B, laptop14B, 
		laptop15B, laptop16B, laptop17B, laptop18B, laptop19B, laptop20B;
	
	//create a HashMap for JButtons
	static Map<Laptop, JButton> laptopButtonHM = new HashMap<Laptop, JButton>();
	
	//create a HashMap for ImageIcons
	static Map<Laptop, ImageIcon> laptopImageHM;
	
	//create HashMaps for ratings
	static Map<Laptop, double[]> laptopRatingNumberHM;
	static Map<Laptop, String> laptopRatingStringHM;
	
	LaptopStoreInventoryFrame() {
		//create a hashmap to store all the laptop images (ImageIcon)
		laptopImageHM = new HashMap();
		laptopImageHM.put(laptopArray[0], new ImageIcon("Laptop Images/Apple Macbook Pro 2024.png"));
		laptopImageHM.put(laptopArray[1], new ImageIcon("Laptop Images/ASUS Chromebook.png"));
		laptopImageHM.put(laptopArray[2], new ImageIcon("Laptop Images/Lenovo Thinkpad E14 G6.png"));
		laptopImageHM.put(laptopArray[3], new ImageIcon("Laptop Images/Dell XPS 14.5.png"));
		laptopImageHM.put(laptopArray[4], new ImageIcon("Laptop Images/ASUS ROG Zephyrus G14.png"));
		laptopImageHM.put(laptopArray[5], new ImageIcon("Laptop Images/HP OmniBook Ultra Flip Touchscreen.png"));
		laptopImageHM.put(laptopArray[6], new ImageIcon("Laptop Images/HP 15 Laptop.png"));
		laptopImageHM.put(laptopArray[7], new ImageIcon("Laptop Images/ASUS CX1.png"));
		laptopImageHM.put(laptopArray[8], new ImageIcon("Laptop Images/Acer Aspire Go.png"));
		laptopImageHM.put(laptopArray[9], new ImageIcon("Laptop Images/Apple Macbook Air 2024.png"));
		laptopImageHM.put(laptopArray[10], new ImageIcon("Laptop Images/Lenovo Yoga 7i.png"));
		laptopImageHM.put(laptopArray[11], new ImageIcon("Laptop Images/HP 17.3 Laptop.png"));
		laptopImageHM.put(laptopArray[12], new ImageIcon("Laptop Images/Lenovo Ideapad 1i.png"));
		laptopImageHM.put(laptopArray[13], new ImageIcon("Laptop Images/HP 15.6 Laptop.png"));
		laptopImageHM.put(laptopArray[14], new ImageIcon("Laptop Images/Dell Inspirion.png"));
		laptopImageHM.put(laptopArray[15], new ImageIcon("Laptop Images/Acer FHD IPS Laptop.png"));
		laptopImageHM.put(laptopArray[16], new ImageIcon("Laptop Images/HP Pavilion Plus.png"));
		laptopImageHM.put(laptopArray[17], new ImageIcon("Laptop Images/Dell Touchscreen 2-in-1.png"));
		laptopImageHM.put(laptopArray[18], new ImageIcon("Laptop Images/MSI Gaming Laptop.png"));
		laptopImageHM.put(laptopArray[19], new ImageIcon("Laptop Images/HP Victus.png"));
		
		//create 20 laptop JButtons
		//call the method to set the format
		laptop1B = createLaptopButton(0, laptopArray, laptopImageHM.get(laptopArray[0]));
		laptop2B = createLaptopButton(1, laptopArray, laptopImageHM.get(laptopArray[1]));
		laptop3B = createLaptopButton(2, laptopArray, laptopImageHM.get(laptopArray[2]));
		laptop4B = createLaptopButton(3, laptopArray, laptopImageHM.get(laptopArray[3]));
		laptop5B = createLaptopButton(4, laptopArray, laptopImageHM.get(laptopArray[4]));
		laptop6B = createLaptopButton(5, laptopArray, laptopImageHM.get(laptopArray[5]));
		laptop7B = createLaptopButton(6, laptopArray, laptopImageHM.get(laptopArray[6]));
		laptop8B = createLaptopButton(7, laptopArray, laptopImageHM.get(laptopArray[7]));
		laptop9B = createLaptopButton(8, laptopArray, laptopImageHM.get(laptopArray[8]));
		laptop10B = createLaptopButton(9, laptopArray, laptopImageHM.get(laptopArray[9]));
		laptop11B = createLaptopButton(10, laptopArray, laptopImageHM.get(laptopArray[10]));
		laptop12B = createLaptopButton(11, laptopArray, laptopImageHM.get(laptopArray[11]));
		laptop13B = createLaptopButton(12, laptopArray, laptopImageHM.get(laptopArray[12]));
		laptop14B = createLaptopButton(13, laptopArray, laptopImageHM.get(laptopArray[13]));
		laptop15B = createLaptopButton(14, laptopArray, laptopImageHM.get(laptopArray[14]));
		laptop16B = createLaptopButton(15, laptopArray, laptopImageHM.get(laptopArray[15]));
		laptop17B = createLaptopButton(16, laptopArray, laptopImageHM.get(laptopArray[16]));
		laptop18B = createLaptopButton(17, laptopArray, laptopImageHM.get(laptopArray[17]));
		laptop19B = createLaptopButton(18, laptopArray, laptopImageHM.get(laptopArray[18]));
		laptop20B = createLaptopButton(19, laptopArray, laptopImageHM.get(laptopArray[19]));
		
		//create a hashmap to store the 20 laptop JButton
		laptopButtonHM = new HashMap();
		laptopButtonHM.put(laptopArray[0], laptop1B);
		laptopButtonHM.put(laptopArray[1], laptop2B);
		laptopButtonHM.put(laptopArray[2], laptop3B);
		laptopButtonHM.put(laptopArray[3], laptop4B);
		laptopButtonHM.put(laptopArray[4], laptop5B);
		laptopButtonHM.put(laptopArray[5], laptop6B);
		laptopButtonHM.put(laptopArray[6], laptop7B);
		laptopButtonHM.put(laptopArray[7], laptop8B);
		laptopButtonHM.put(laptopArray[8], laptop9B);
		laptopButtonHM.put(laptopArray[9], laptop10B);
		laptopButtonHM.put(laptopArray[10], laptop11B);
		laptopButtonHM.put(laptopArray[11], laptop12B);
		laptopButtonHM.put(laptopArray[12], laptop13B);
		laptopButtonHM.put(laptopArray[13], laptop14B);
		laptopButtonHM.put(laptopArray[14], laptop15B);
		laptopButtonHM.put(laptopArray[15], laptop16B);
		laptopButtonHM.put(laptopArray[16], laptop17B);
		laptopButtonHM.put(laptopArray[17], laptop18B);
		laptopButtonHM.put(laptopArray[18], laptop19B);
		laptopButtonHM.put(laptopArray[19], laptop20B);
		
		//create a hashmap to store all the ratings 
		//{quality, speed, memory, display, overall}
		laptopRatingNumberHM = new HashMap();
		
		laptopRatingNumberHM.put(laptopArray[0], new double[]{8, 8.5, 8, 8.5, 8.5});
		laptopRatingNumberHM.put(laptopArray[1], new double[]{9, 7, 9, 8, 9});
		laptopRatingNumberHM.put(laptopArray[2], new double[]{6, 9, 9.5, 7, 7.5});
		laptopRatingNumberHM.put(laptopArray[3], new double[]{8, 8.5, 9, 8, 8});
		laptopRatingNumberHM.put(laptopArray[4], new double[]{8, 9, 9, 9, 9});
		laptopRatingNumberHM.put(laptopArray[5], new double[]{8, 8, 8.5, 8.5, 8});
		laptopRatingNumberHM.put(laptopArray[6], new double[]{6, 4, 2, 5, 4});
		laptopRatingNumberHM.put(laptopArray[7], new double[]{6, 2, 4, 4, 4});
		laptopRatingNumberHM.put(laptopArray[8], new double[]{6, 4, 2, 5, 4});
		laptopRatingNumberHM.put(laptopArray[9], new double[]{8, 8, 8.7, 8, 8});
		laptopRatingNumberHM.put(laptopArray[10], new double[]{6, 8, 8, 5, 8.5});
		laptopRatingNumberHM.put(laptopArray[11], new double[]{8, 5, 8, 7, 8.5});
		laptopRatingNumberHM.put(laptopArray[12], new double[]{5, 2, 2, 5, 4});
		laptopRatingNumberHM.put(laptopArray[13], new double[]{6, 4, 4, 5, 5});
		laptopRatingNumberHM.put(laptopArray[14], new double[]{8, 7, 7, 9, 7.5});
		laptopRatingNumberHM.put(laptopArray[15], new double[]{7, 4, 8, 5, 5.5});
		laptopRatingNumberHM.put(laptopArray[16], new double[]{6, 5, 8, 7, 7.5});
		laptopRatingNumberHM.put(laptopArray[17], new double[]{8, 3, 8, 7, 7.5});
		laptopRatingNumberHM.put(laptopArray[18], new double[]{5, 1, 4, 4, 3.5});
		laptopRatingNumberHM.put(laptopArray[19], new double[]{8, 7, 9, 6, 7.5});

		//Create a hashmap to store all the ratings
		laptopRatingStringHM = new HashMap();
		
		laptopRatingStringHM.put(laptopArray[0], "The new M4 chip is fast and quick, released in mid-2024. Although there are better CPUs, unless you are working with incredibly performance-demanding applications, it will be able to meet all your needs and more\n\n"
				+ "16 gigabytes of RAM, most computers have 4 - 8 GB of RAM, and 16 GB would be able to work with Microsoft Spreadsheets and other office applications at the same time\n\n"
				+ "Made out of Aluminum. The material is durable and light but can be damaged easily if you're not careful. The main benefit of aluminum is how light it is\n\n"
				+ "Liquid Retina XDR display that has a resolution of 3024 x 1964 with a nano-texture display option, although the integrated graphics prioritize battery life over the display\n\n"
				+ "All in all, this laptop is very high tier for a professional workspace\n\n"
				+ "\n\n");
		laptopRatingStringHM.put(laptopArray[1], "The Chromebook with touchscreen features is easy to use for students \n\n"
				+ "The quality is nice\n\n"
				+ "The speed is fine for students to have online lessons or doing assignments \n\n"
				+ "The screen size is perfect for watching YouTube or movies\n\n"
				+ "The battery can last for a long time \n\n"
				+ "The display is fine but it is overexposed when using dark mode\n\n");
		laptopRatingStringHM.put(laptopArray[2], "This is a good laptop with an affordable price. It has 32 GB RAM with a powerful Intel Core i7 processor which helps to do most of the tasks very smoothly.\n\n"
				+ "The speed for this computer is fantastic for work,video calls,school and some video games.\n\n"
				+ "The display for the computer could be better but It gets better the more you get used to it.\n\n"
				+ "\n\n");
		laptopRatingStringHM.put(laptopArray[3], "Intel Core Ultra 7 155H costs over 600 dollars Canadian, but its speed and efficiency make it worth the price\n\n"
				+ "32 GB of RAM means it can run many performance-demanding applications at the same time, incredibly rare for the average person to need more than 32 GB of RAM daily. The RAM type is also rather fast compared to other laptops in this price point\n\n"
				+ "NVIDIA GeForce RTX 4050 can create incredible displays with ease at 1080p, although anything above 1080p recommends an RTX 4060 at least\n\n"
				+ "Made out of Aluminum. Durable and light material, but can still be damaged if you are not careful\n\n"
				+ "High-tier laptop that would be great for working, but would also be a high-tier laptop for gaming due to its RTX card\n\n"
				+ "\n\n");
		laptopRatingStringHM.put(laptopArray[4], "AMD Ryzen 9 8945HS is a high-tier CPU that can run performance-demanding games with ease. Also able to run many office applications\n\n"
				+ " 32 GB of RAM is more than you need to play almost all types of games. Unless you are running shaders and intense graphic modes, 32 is very sufficient. This RAM type is incredibly fast compared to other types at this pricepoint\n\n"
				+ "The aluminum alloy is durable and lightweight, very sturdy, and has a great design as well, allowing for effective and efficient cooling\n\n"
				+ "The screen is incredible as it has an OLED screen that provides rich and vivid colors. The RTX card also helps with the display and ensures it looks incredible. Would be a 10 if it had a better graphics card.\n\n"
				+ "An incredibly high-tier gaming laptop that can also be used for demanding applications in a workspace\n\n"
				+ "\n\n");
		laptopRatingStringHM.put(laptopArray[5], "The Intel Core Ultra 7 258V is a great CPU that will meet all your daily needs. Although you can find laptops with better CPUs at this price point, it is still quite good\n\n"
				+ "32 GB of RAM which can complete almost every task that someone will need in the workspace, although if it is a job revolving around many demanding applications, there are better laptops in this price point with faster RAM\n\n"
				+ "The build quality is quite nice and has a sturdy structure, although it is built out of a mixture of recyclable metals and plastic, a Durable material\n\n"
				+ "incredible display as the OLED emphasizes the colors. Although the screen is great, the graphics card is lacking as it is Intel Arcs Graphics.\n\n"
				+ "High-tier working laptop, although there are faster laptops for games\n\n"
				+ "\n\n");
		laptopRatingStringHM.put(laptopArray[6], "4GB of RAM only for light tasks and everyday use like web browsing and document creation and does not provide efficient performance\n\n"
				+ "The display can give you good images but the integrated GPU is not good for gaming\n\n"
				+ "The battery can last for up to 7 hours and 30 minutes of mixed usage\n\n"
				+ "128GB solid-state drive does not provide a large space for storing files\n\n"
				+ "The laptop offers a wide range of options for connecting peripheral devices\n\n"
				+ "\n\n");
		laptopRatingStringHM.put(laptopArray[7], "The laptop can do well with leisurely tasks\n\n"
				+ "ChromeOS is very easy to use but it is not supported by many applications\n\n"
				+ "The integrated GPU will not give you good images\n\n"
				+ "8GB of RAM only for casual computer usage and internet browsing\n\n"
				+ "Up to 11 hours of battery life\n\n"
				+ "128GB solid-state drive does not provide a large space for storing files\n\n"
				+ "The laptop provides plenty of options for connecting external devices\n\n"
				+ "\n\n");
		laptopRatingStringHM.put(laptopArray[8], "The laptop is only for light tasks and does not provide efficient performance\n\n"
				+ "4GB of RAM is only for light computer usage and will slow down the laptop\n\n"
				+ "The display and the integrated GPU will not give you high-quality images\n\n"
				+ "Lithium-ion battery with 8.5 hours of approximate battery life\n\n"
				+ "128GB solid-state drive does not provide a large space for storing files\n\n"
				+ "The laptop offers multiple options for connecting external devices\n\n"
				+ "\n\n");
		laptopRatingStringHM.put(laptopArray[9], "The M3 is still a powerful chip and was released in 2023, although not as powerful as the M4, it will be able to deal with spreadsheets and most office applications\n\n"
				+ "24 GB of RAM is great and will allow it to run applications with ease, although very performance-demanding applications like large video games can have trouble at high graphics mode\n\n"
				+ "Made out of the same aluminum that Apple uses for most of its products and is durable and light at the same time\n\n"
				+ "2560-by-1664 native resolution at 224 pixels per inch allows for a great display as well, although it does not have a top-tier graphics card to help out\n\n"
				+ "Great laptop in a professional environment that is durable and can last a long time.\n\n"
				+ "\n\n");
		laptopRatingStringHM.put(laptopArray[10], "The quality for the Yoga 7i is fine for school and work but is not great for gaming.\n\n"
				+ "\n\n"
				+ "The speed for the computer is great when you buy it.With long lasting battery life and great for Video Calling.\n\n"
				+ "The Memory for the computer is fantastic having up to 16GB and has storage from 500GB which can be upgraded\n\n"
				+ "\n\n"
				+ "The computer has a weak display and could be better \n\n");
		laptopRatingStringHM.put(laptopArray[11], "The storage memory is larger with 1TB and 16 GB of RAM\n\n"
				+ "The laptop is easy to set up and fetch data from old laptops, the quality of the laptop is nice \n\n"
				+ "The screen size is large enough to use and the design is nice\n\n"
				+ "The speed of the laptop is fast , it can upload things very fast \n\n"
				+ "The laptop is easy to use in home, work, school etc and not too heavy to carry \n\n"
				+ "For the keyboard, the keystrokes like space bar sometimes don’t work \n\n"
				+ "\n\n");
		laptopRatingStringHM.put(laptopArray[12], "Intel Celeron N4500 processor combined with 4GB DDR4 RAM can only do well at light tasks and does not provide efficient performance\n\n"
				+ "Low-resolution and integrated GPU can not provide high-quality images\n\n"
				+ "128GB solid-state drive does not provide a large space for storing files\n\n"
				+ "The laptop offers a wide range of options for connecting peripheral devices\n\n"
				+ "\n\n");
		laptopRatingStringHM.put(laptopArray[13], "The laptop can do well with leisurely tasks\n\n"
				+ "512GB solid-state drive provides more space for storing files\n\n"
				+ "The display and integrated GPU can not provide high-quality images\n\n"
				+ "Battery with up to eight hours and 15 minutes (mixed usage) of battery life\n\n"
				+ "The laptop offers a wide range of options for connecting peripheral devices\n\n"
				+ "\n\n");
		laptopRatingStringHM.put(laptopArray[14], "The quality for the Dell Inspiron is amazing with the 2 in 1 deal and touchscreen ability.Made with so much care and very durable to carry around\n\n"
				+ "The speed for the computer is great and doesn't have any bad things about it.But the computer isn’t very compatible with video games.\n\n"
				+ "This computer offers a variety of choices when you go on the website to purchase it with multiple options for Windows 11 home and Windows 11 Pro,with an option to upgrade Storage Capacity for the computer.\n\n"
				+ "\n\n");
		laptopRatingStringHM.put(laptopArray[15], "The display of the laptop is weak, it has limited viewing angle \n\n"
				+ "The laptop is good to use for personal or business \n\n"
				+ "The speed is fine, it doesn’t have any problems \n\n");
		laptopRatingStringHM.put(laptopArray[16], "The quality of the computer isn’t that good. The keyboard is easy to remove,the screen can get damaged easily.But it is very durable and easy to carry around.\n\n"
				+ "The speed for the computer is not the best. While trying to run apps like Discord and Roblox on Chrome the Temperature started to get really hot.\n\n"
				+ "The Memory for the computer is what saves it having 16GB Ram for such a small computer.\n\n"
				+ "Then for the display it is very good and I wasn’t disappointed because of how clear I could see everything without having any problems  with the screen being too bright or too dark.\n\n"
				+ "\n\n");
		laptopRatingStringHM.put(laptopArray[17], "The laptop with touchscreen features within 2 in 1 is amazing, there no problem with it\n\n"
				+ "The speed is a bit slow, sometimes the screen freezes for a while \n\n"
				+ "The laptop can run nicely with 16 GB RAM\n\n");
		laptopRatingStringHM.put(laptopArray[18], "The screen is large enough to play games, but the speed is too slow, the games always lag\n\n"
				+ "It takes a lots of time to download the game \n\n"
				+ "The laptop is not suitable for professional gamer to use \n\n"
				+ "It is hard to play many games in the laptop \n\n"
				+ "8 GB RAM is not enough for gaming laptop\n\n");
		laptopRatingStringHM.put(laptopArray[19], "The HP Victus 15 is great for gaming. It's available with Intel 12th Gen. CPUs and NVIDIA discrete graphics, which are powerful enough to provide a smooth gaming experience\n\n"
				+ "This computer is really good for gaming with high speed and a really fast responding time.But can get overheated after a long time of using it.\n\n"
				+ "The Memory is fantastic with up to 32GB Ram which can hold and store almost all your files and all your video games.\n\n"
				+ "The Display for the computer is what is not the best with sometimes having the brightness being too low.\n\n"
				+ "But Overall it is a good computer for Gamers.\n\n");
		
		//set the layout of the inventory frame
		setLayout(new BorderLayout());
		
		//Create home button (not used in this frame)
		homeButton = new JButton();
		homeButton.addActionListener(this);
		//add image to the button
		ImageIcon homeButtonImage = new ImageIcon("images/homeButton.png");
		homeButton.setIcon(homeButtonImage);
		//set the background color
		homeButton.setBackground(color);
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
		educationButton.setBackground(color);
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
		surveyButton.setBackground(color);
		//set the size of the button
		surveyButton.setPreferredSize(new Dimension(surveyButtonImage.getIconWidth(),
				surveyButtonImage.getIconHeight()));
		
		//add cart button (when it is clicked, open cart frame) (TBD)
		cartButton = new JButton();
		cartButton.addActionListener(this);
		//add image to the button
		ImageIcon cartButtonImage = new ImageIcon("images/cartButton.png");
		cartButton.setIcon(cartButtonImage);
		//set background color
		cartButton.setBackground(color);
		//set the size of the button
		cartButton.setPreferredSize(new Dimension(cartButtonImage.getIconWidth(),
				cartButtonImage.getIconHeight()));
		
		//Create a panel for buttons
		JPanel buttonsPanel = new JPanel();
		//set the panel transparent
		buttonsPanel.setOpaque(false);
		//Add buttons to the panel
		buttonsPanel.add(homeButton);
		buttonsPanel.add(educationButton);
		buttonsPanel.add(surveyButton);
		buttonsPanel.add(cartButton);
		
		//create JPanel for the title ("STORE")
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		//set the panel transparent
		titlePanel.setOpaque(false);
		
		//create JLabel for the title ("STORE")
		JLabel titleLabel = new JLabel("STORE", JLabel.CENTER);
		//set the text color
		titleLabel.setForeground(new Color(180, 217, 240));
		//set the text font
		titleLabel.setFont(new Font("Gill Sans", Font.BOLD, 30));
		//add the title JLabel to the title JPanel
		titlePanel.add(titleLabel, BorderLayout.CENTER);
		
		//create JPanel for the button and the "STORE" title
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
		//set the panel transparent
		northPanel.setOpaque(false);
		//add the four buttons and the "STORE" title to this panel
		northPanel.add(buttonsPanel);
		northPanel.add(titlePanel);
		
		//add this panel to the frame
		add(northPanel, BorderLayout.NORTH);
		
		//Create a JPanel for the dropdown list (JComboBox)
		JPanel dropdownPanel = new JPanel();
		dropdownPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		//set the panel transparent
		dropdownPanel.setOpaque(false);
		
		//create a JLabel
		JLabel orderLabel = new JLabel("Sorting Order: ");
		//set the text color and font
		orderLabel.setForeground(new Color(228, 230, 235));
		orderLabel.setFont(new Font("Consolas", Font.BOLD, 20));
		//add the label to the panel
		dropdownPanel.add(orderLabel);
		
		//create a JComboBox (dropdown list)
		//https://www.geeksforgeeks.org/java-swing-jcombobox-examples/
		String[] comboBoxString = {"Original", "Alphabetically (Laptop Name)", 
				"Price: From Highest to Lowest", "Price: From Lowest to Highest"};
		comboBox = new JComboBox(comboBoxString);
		comboBox.addActionListener(this);
		//add the JComboBox to the panel
		dropdownPanel.add(comboBox);
		
		//add the dropdownPanel to the frame
		add(dropdownPanel, BorderLayout.CENTER);
      
        //Create a JScrollPane for showing the 20 laptop buttons
		//https://www.geeksforgeeks.org/java-jscrollpane/     
        scrollPane = new JScrollPane();
        //set the size
        scrollPane.setPreferredSize(new Dimension(1100, 380));
        //add the JScrollPane to the frame
        add(scrollPane, BorderLayout.SOUTH);
        
        //call the method to show to 20 Laptops
        createLaptopPanel(laptopArray);
        
        //Create a JScrollBar and set it to zero (at the top)
        JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
        verticalBar.setValue(0);
		
        //Set JFrame properties
        setTitle("BOSS Electronic Store");
        //set the window size
        setSize(1100, 610);
        //Close application on exit
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Center the frame on the screen
        setLocationRelativeTo(null);
        //set the background color
        getContentPane().setBackground(color);
        
		//make the frame visible
		setVisible(true);
	}
	
	
	//this method set the format of the 20 Laptop buttons
	private JButton createLaptopButton(int n, Laptop[] array, ImageIcon imageIcon) {
		//create a button
		JButton button = new JButton();
		button.setLayout(new BoxLayout(button, BoxLayout.Y_AXIS));
		button.addActionListener(this);
		
		//resize the image
		//https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
		Image image = imageIcon.getImage();
		image = image.getScaledInstance(220, 140, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JLabel imageLabel = new JLabel(imageIcon);
		//add image to the button
		button.add(imageLabel);
		//set background color
		button.setBackground(new Color(200, 224, 221));
		//set the size
		button.setPreferredSize(new Dimension(250, 200));
		
		//create three labels (Brand, Name, Price)
		JLabel label1 = new JLabel(array[n].getBrand(), JLabel.CENTER);
		JLabel label2 = new JLabel(array[n].getName(), JLabel.CENTER);
		JLabel label3 = new JLabel("$" + array[n].getPrice() + "\n", JLabel.CENTER);
		
		//set the price text to red color
		label3.setForeground(Color.red);
		
		//add the three labels to the button
		button.add(label1);
		button.add(label2);
		button.add(label3);
		
		//return the button that created
		return button;
	}
	
	
	//this method create the JScrollPanePanel for showing the 20 Laptop buttons
	private void createLaptopPanel(Laptop[] array) {
		//create a panel for the JScrollPane
		scrollPanePanel = new JPanel();
		scrollPanePanel.setLayout(new BoxLayout(scrollPanePanel, 
        		BoxLayout.Y_AXIS));
		
		// Create a JPanel to hold a list of labels.
		// Add buttons to the panel.
		JPanel panel = new JPanel();
		//4 laptops each row, 5 rows in total
		for (int i = 1; i <= 20; i++) {
			panel.add(laptopButtonHM.get(array[i-1]));
			
			//each row is a panel
			if (i%4 == 0) {
				scrollPanePanel.add(panel);
				panel = new JPanel();
			}
		}
		
		//update the JScrollPane
        scrollPane.setViewportView(scrollPanePanel);

	}
	
	
	//this method find the Laptop object by passing the laptop button in
	//find the keys by values in the laptopButtonHashMap
	//https://stackoverflow.com/questions/1383797/java-hashmap-how-to-get-key-from-value
	private Laptop getKeysByValues(JButton value) {
		for (Entry<Laptop, JButton> entry : laptopButtonHM.entrySet()) {
	        if (Objects.equals(value, entry.getValue())) {
	            return entry.getKey();
	        }
	    }
		return null;
	}
	
	
	//this method create a new frame that show the information and specifications of the laptop
	public static void detailInfo(Laptop laptop) {
		//create a new frame (window)
		JFrame info = new JFrame();
		//set the frame size
		info.setSize(900, 600);
		//set the title
		info.setTitle("Specifications");
		//set the layout
		info.setLayout(null);
		//set the background color
		info.getContentPane().setBackground(color);
		
		//create a return (back) button (for closing this window)
		infoReturn = new JButton(new ImageIcon("images/return.png"));
		infoReturn.setBounds(20, 20, 50, 50);
		//hide the background of the button
		//https://stackoverflow.com/questions/8367500/how-to-hide-background-of-jbutton-which-containt-icon-image
		infoReturn.setBorderPainted(false);
		infoReturn.setContentAreaFilled(false);
		infoReturn.setFocusPainted(false);
		infoReturn.setOpaque(false);
		//add the button to the frame
		info.add(infoReturn);
		
		//add action listener for the return button
		//https://stackoverflow.com/questions/18340256/java-swing-return-value-when-button-clicked
		infoReturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//when the button is clicked, close the specs window
				info.dispose();
			}
		});
		
		//resize the image
		//https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
		ImageIcon imageIcon = laptopImageHM.get(laptop);
		Image image = imageIcon.getImage();
		image = image.getScaledInstance(390, 250, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		JLabel imageLabel = new JLabel(imageIcon);
		imageLabel.setBounds(50, 150, 390, 250);
		//add the image to the frame
		info.add(imageLabel);
		
		//addToCart button
		JButton addToCart = new JButton("ADD TO CART");
		//set the position, text font, and color
		addToCart.setBounds(150, 450, 200, 40);
		addToCart.setFont(new Font("Arial", Font.BOLD, 16));
	    addToCart.setBackground(new Color(200, 230, 200));
	    addToCart.setForeground(Color.BLACK);
	    
	    info.add(addToCart);
		
	    //add action listener for the addToCart button
	  	//https://stackoverflow.com/questions/18340256/java-swing-return-value-when-button-clicked
		addToCart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//if the button is clicked, add the laptop object to the set
				cartArrayList.add(laptop);
			}
		});

		
		//create a panel for showing the specifications and the price label
		JPanel infoPanel = new JPanel();
		//set the layout, position, and background color
        infoPanel.setLayout(null);
        infoPanel.setBounds(500, 50, 350, 400);
        infoPanel.setBackground(new Color(240, 248, 255));
        //add the panel to the frame
        info.add(infoPanel);
		
        //create a panel for showing the specs
        JPanel specsPanel = new JPanel();
        //set the layout, background color, layout, and set it transparent
        specsPanel.setLayout(new BoxLayout(specsPanel, BoxLayout.Y_AXIS));
        specsPanel.setBackground(new Color(240, 248, 255));
        specsPanel.setBounds(20, 20, 310, 380);
        specsPanel.setOpaque(false);
        
        //Create a JTextArea for showing the laptop name
        //https://www.geeksforgeeks.org/java-swing-jtextarea/
		JTextArea nameTextArea = new JTextArea(laptop.getName());
		//enable line wrapping
		nameTextArea.setLineWrap(true);
	    nameTextArea.setWrapStyleWord(true);
	    //set not editable by the user
	    nameTextArea.setEditable(false);
	    //set text font and color
	    nameTextArea.setFont(new Font("Arial", Font.BOLD, 20));
	    nameTextArea.setForeground(new Color(50, 50, 100));
	    //remove the border
	    nameTextArea.setBorder(null);
	    //set transparent
	    nameTextArea.setOpaque(false);
	    //add the textArea to the panel
	    specsPanel.add(nameTextArea);
        
	    //create a String array to store all the specs of this laptop
        String[] specs = {"\n\nBrand: " + laptop.getBrand(), 
        		"Type: " + laptop.getType(),
                "Operating System: " + laptop.getOperatingSystem(),
                "CPU: " + laptop.getCPU(), "GPU: " + laptop.getGPU(),
                "SSD: " + laptop.getSSD() + " GB", "RAM: " + laptop.getRAM() + " GB",
                "Weight: " + laptop.getWeight() + " lbs", "USB Ports: " + laptop.getUSB(),
                "Display Size: " + laptop.getSize() + " inches",
                "Rating: " + laptopRatingNumberHM.get(laptop)[4]};
        
        //display every spec
        for (String spec: specs) {
        	//Create a JTextArea for showing the specifications
            //https://www.geeksforgeeks.org/java-swing-jtextarea/
        	JTextArea specTextArea = new JTextArea(spec);
        	//enable line wrapping
            specTextArea.setLineWrap(true);
            specTextArea.setWrapStyleWord(true);
            //set not editable by the user
            specTextArea.setEditable(false);
            //set text font
            specTextArea.setFont(new Font("Consolas", Font.BOLD, 14));
            //set background color
            specTextArea.setBackground(new Color(240, 248, 255));
            //remove the border
            specTextArea.setBorder(null);
            //set transparent
            specTextArea.setOpaque(false);
            //add the textarea to the panel
            specsPanel.add(specTextArea);
        }
		
        //add the specsPanel to the infoPanel
        infoPanel.add(specsPanel);
        
        //create a price label
		JLabel priceLabel = new JLabel("$" + laptop.getPrice());
		//set the font, text color, and position
		priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
		priceLabel.setForeground(new Color(255, 69, 0));
        priceLabel.setBounds(240, 70, 100, 30);
        //add the price label to the infoPanel
        infoPanel.add(priceLabel);
        //add the infoPanel to the frame
        info.add(infoPanel);
		
		//detailRating button
		ratingButton = new JButton("RATING");
		//set the position, font, background color, and text color
		ratingButton.setBounds(550, 500, 200, 40);
		ratingButton.setFont(new Font("Consolas", Font.BOLD, 15));
		ratingButton.setBackground(Color.WHITE);
        ratingButton.setForeground(Color.BLACK);
        //add action listener for the rating button
      	//https://stackoverflow.com/questions/18340256/java-swing-return-value-when-button-clicked
		ratingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//when the button is clicked, open the rating window
				detailRating(laptop);
			}
		});
		//add the button to the frame
		info.add(ratingButton); 
		
		//set the frame visible
		info.setVisible(true);
		
	}
	
	
	//this method create a new frame (window) showing the rating
	public static void detailRating(Laptop laptop) {
		//create a new frame (window)
		JFrame rating = new JFrame();
		//set the frame size, title, layout, and background color
		rating.setSize(600, 600);
		rating.setTitle("Rating");
		rating.setLayout(null);
		rating.getContentPane().setBackground(color);
		
		//create a return (back) button for closing this window
		ratingReturn = new JButton(new ImageIcon("images/return.png"));
		ratingReturn.setBounds(20, 20, 50, 50);
		//hide the background of the button
		//https://stackoverflow.com/questions/8367500/how-to-hide-background-of-jbutton-which-containt-icon-image
		ratingReturn.setBorderPainted(false);
		ratingReturn.setContentAreaFilled(false);
		ratingReturn.setFocusPainted(false);
		ratingReturn.setOpaque(false);
		//add action listener for the return button
		//https://stackoverflow.com/questions/18340256/java-swing-return-value-when-button-clicked
		ratingReturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//when the button is clicked, close the rating window
				rating.dispose();
			}
		});
		//add the return button to the frame
		rating.add(ratingReturn);
		
		//create a JPanel for showing the ratings
		JPanel panel = new JPanel();
		panel.setBounds(20, 20, 550, 550);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setOpaque(false);
		
		//Create rating labels
		//(Quality, Speed, Memory, Display, Overall)
		JLabel ratingLabel1 = new JLabel("Quality: " + laptopRatingNumberHM.get(laptop)[0]);
		JLabel ratingLabel2 = new JLabel("Speed: " + laptopRatingNumberHM.get(laptop)[1]);
		JLabel ratingLabel3 = new JLabel("Memory: " + laptopRatingNumberHM.get(laptop)[2]);
		JLabel ratingLabel4 = new JLabel("Display: " + laptopRatingNumberHM.get(laptop)[3]);
		JLabel ratingLabel5 = new JLabel("Overall: " + laptopRatingNumberHM.get(laptop)[4]);
		
		//set alignment to center
		//https://stackoverflow.com/questions/36971259/how-to-center-jlabel-and-jbutton-in-boxlayout
		ratingLabel1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		ratingLabel2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		ratingLabel3.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		ratingLabel4.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		ratingLabel5.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		//set the text font of the rating labels
		ratingLabel1.setFont(new Font("Consolas", Font.BOLD, 22));
		ratingLabel2.setFont(new Font("Consolas", Font.BOLD, 22));
		ratingLabel3.setFont(new Font("Consolas", Font.BOLD, 22));
		ratingLabel4.setFont(new Font("Consolas", Font.BOLD, 22));
		ratingLabel5.setFont(new Font("Consolas", Font.BOLD, 22));
		
		//set the text color of the rating labels
		ratingLabel1.setForeground(Color.LIGHT_GRAY);
		ratingLabel2.setForeground(Color.LIGHT_GRAY);
		ratingLabel3.setForeground(Color.LIGHT_GRAY);
		ratingLabel4.setForeground(Color.LIGHT_GRAY);
		ratingLabel5.setForeground(Color.LIGHT_GRAY);
		
		//Create a JTextArea for showing the detail rating
        //https://www.geeksforgeeks.org/java-swing-jtextarea/
		JTextArea ratingTextArea = new JTextArea("\n\n" + laptopRatingStringHM.get(laptop));
		//enable line wrapping
		ratingTextArea.setLineWrap(true);
	    ratingTextArea.setWrapStyleWord(true);
	    //set not editable by the user
	    ratingTextArea.setEditable(false);
	    //set text font and color
	    ratingTextArea.setFont(new Font("Arial", Font.BOLD, 15));
	    ratingTextArea.setForeground(Color.WHITE);
	    //remove the border
	    ratingTextArea.setBorder(null);
	    //set transparent
	    ratingTextArea.setOpaque(false);
		
	    //add rating labels and textArea to the panel
		panel.add(ratingLabel1);
		panel.add(ratingLabel2);
		panel.add(ratingLabel3);
		panel.add(ratingLabel4);
		panel.add(ratingLabel5);
		panel.add(ratingTextArea);
		
		//add the panel to the frame
		rating.add(panel);
				
		//set the rating frame visible
		rating.setVisible(true);
	}
	
	//rayhan - this method returns the laptop arraylist so other classes 
		//can access it
	public static ArrayList<Laptop> getCartArray() {
		return cartArrayList;
	}
	
	//button and comboBox handler
	@Override
	public void actionPerformed(ActionEvent e) {
		//if education button is clicked, terminate this window
		//and open education frame
		if (e.getSource() == educationButton) {
			dispose();
			new LaptopStoreEducationFrame();
		}
		//if survey button is clicked, terminate this window
		//and open survey frame
		else if (e.getSource() == surveyButton) {
			dispose();
			new LaptopStoreSurveyFrame();
		}
		//if home button is clicked, terminate this window
		//and open title frame
		else if (e.getSource() == homeButton) {
			dispose();
			new LaptopStoreTitleFrame();
		}
		//if cart button is clicked, terminate this window
		//and open cart frame
		else if (e.getSource() == cartButton) {
			dispose();
			new LaptopStoreCartFrame();
		}
		//if one of the laptop buttons is clicked, 
		//open a new frame and shows the corresponding specifications
		//(first, get the Laptop object by HashMap searching backwards (get keys by values))
		//(second, call the detailInfo() method to create the new frame)
		else if (e.getSource() == laptop1B) {
			Laptop laptop = getKeysByValues(laptop1B);
			detailInfo(laptop);
		}
		else if (e.getSource() == laptop2B) {
			Laptop laptop = getKeysByValues(laptop2B);
			detailInfo(laptop);
		}
		else if (e.getSource() == laptop3B) {
			Laptop laptop = getKeysByValues(laptop3B);
			detailInfo(laptop);
		}
		else if (e.getSource() == laptop4B) {
			Laptop laptop = getKeysByValues(laptop4B);
			detailInfo(laptop);
		}
		else if (e.getSource() == laptop5B) {
			Laptop laptop = getKeysByValues(laptop5B);
			detailInfo(laptop);
		}
		else if (e.getSource() == laptop6B) {
			Laptop laptop = getKeysByValues(laptop6B);
			detailInfo(laptop);
		}
		else if (e.getSource() == laptop7B) {
			Laptop laptop = getKeysByValues(laptop7B);
			detailInfo(laptop);
		}
		else if (e.getSource() == laptop8B) {
			Laptop laptop = getKeysByValues(laptop8B);
			detailInfo(laptop);
		}
		else if (e.getSource() == laptop9B) {
			Laptop laptop = getKeysByValues(laptop9B);
			detailInfo(laptop);
		}
		else if (e.getSource() == laptop10B) {
			Laptop laptop = getKeysByValues(laptop10B);
			detailInfo(laptop);
		}
		else if (e.getSource() == laptop11B) {
			Laptop laptop = getKeysByValues(laptop11B);
			detailInfo(laptop);
		}
		else if (e.getSource() == laptop12B) {
			Laptop laptop = getKeysByValues(laptop12B);
			detailInfo(laptop);
		}
		else if (e.getSource() == laptop13B) {
			Laptop laptop = getKeysByValues(laptop13B);
			detailInfo(laptop);
		}
		else if (e.getSource() == laptop14B) {
			Laptop laptop = getKeysByValues(laptop14B);
			detailInfo(laptop);
		}
		else if (e.getSource() == laptop15B) {
			Laptop laptop = getKeysByValues(laptop15B);
			detailInfo(laptop);
		}
		else if (e.getSource() == laptop16B) {
			Laptop laptop = getKeysByValues(laptop16B);
			detailInfo(laptop);
		}
		else if (e.getSource() == laptop17B) {
			Laptop laptop = getKeysByValues(laptop17B);
			detailInfo(laptop);
		}
		else if (e.getSource() == laptop18B) {
			Laptop laptop = getKeysByValues(laptop18B);
			detailInfo(laptop);
		}
		else if (e.getSource() == laptop19B) {
			Laptop laptop = getKeysByValues(laptop19B);
			detailInfo(laptop);
		}
		else if (e.getSource() == laptop20B) {
			Laptop laptop = getKeysByValues(laptop20B);
			detailInfo(laptop);
		}
		//if the state of comboBox is changed
		else if (e.getSource() == comboBox) {
			//get which state the comboBox currently is
			String selectedOption = (String) comboBox.getSelectedItem();
			if (selectedOption.equals("Original")) {
				//removing any components currently being displayed in the scrollPane
				scrollPane.setViewportView(null);
				
				//make a copy of the laptop array
				Laptop [] copiedLaptopArray = new Laptop[laptopArray.length];
				System.arraycopy(laptopArray, 0, copiedLaptopArray, 0, laptopArray.length);
				
				//call the method to update the scrollPane
				createLaptopPanel(copiedLaptopArray);
			}
			else if (selectedOption.equals("Alphabetically (Laptop Name)")) {
				//removing any components currently being displayed in the scrollPane
				scrollPane.setViewportView(null);
				
				//make a copy of the laptop array
				Laptop [] copiedLaptopArray = new Laptop[laptopArray.length];
				System.arraycopy(laptopArray, 0, copiedLaptopArray, 0, laptopArray.length);
				
				//sort the laptop array alphabetically
				Arrays.sort(copiedLaptopArray, Comparator.comparing(Laptop::getName));
				
				//call the method to update the scrollPane
				createLaptopPanel(copiedLaptopArray);

			}
			else if (selectedOption.equals("Price: From Lowest to Highest")) {
				////removing any components currently being displayed in the scrollPane
				scrollPane.setViewportView(null);
				
				//make a copy of the laptop array
				Laptop [] copiedLaptopArray = new Laptop[laptopArray.length];
				System.arraycopy(laptopArray, 0, copiedLaptopArray, 0, laptopArray.length);
				
				//sort the laptop array by price from low to high
				Arrays.sort(copiedLaptopArray, Comparator.comparing(Laptop::getPrice));
				
				//call the method to update the scrollPane
				createLaptopPanel(copiedLaptopArray);
			}
			else {
				////removing any components currently being displayed in the scrollPane
				scrollPane.setViewportView(null);
				
				//make a copy of the laptop array
				Laptop [] copiedLaptopArray = new Laptop[laptopArray.length];
				System.arraycopy(laptopArray, 0, copiedLaptopArray, 0, laptopArray.length);
				
				//sort the laptop array by price from high to low
				Arrays.sort(copiedLaptopArray, Comparator.comparing(Laptop::getPrice).reversed());
				
				//call the method to update the scrollPane
				createLaptopPanel(copiedLaptopArray);
			}
		}
	}

}