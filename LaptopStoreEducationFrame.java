/*Team 2,Daniel Iyere
 * -Sunday December 1st November 2024
 * 
 * 
 * -ICUS3U1
 * 
 * 
 * -Laptop Store Eudcation  Application
 * 
 * 
 * The purpose of this program is to make the code for the education window to work
 * And for all the buttons to be placed in the frame to tell the used and educate the user about the different parts of a computer
 * 
 * 
 * *****#DESCRPTION*****
 * This code has 5 different button which are shown at the top for the 5 navigation menus
 * 
 * I have added 4 images to the frame and have added an EducationTitle and a name for what the parts of the computers are
 * I have also commented throughout my code explaining why and how I used those codes for this EducationFrame
 * 
 * 
 * KeyThings
 * <html>-This is used for word wrapping when the text you are trying to write is not writing the full sentence this can help you by making it so 
 * java writes the full text without leaving out any words
 * 
 * set(Visible)- Set visible is a code that is used just to make the frame visible which can be a big problem if you do not have at the end of your code.
 * 
 * Refrences/Help
 * I had a lot of help from Derek Chen who helped me with my images telling me to switch them from jpg to png
 * and also helped me figure out how to use the word wrapping code to stop my words from not typing in the full text * 
 */

	import javax.swing.*;
	import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	public class LaptopStoreEducationFrame extends JFrame implements ActionListener{
	    public static void main(String[] args) {
	        // Create the frame window
	        JFrame frame = new JFrame("Education Panel");
	        frame.setSize(900, 650);//Size of the frame
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLayout(null); // postioning

	        //  Background 
	        // This is to load the background image
	        ImageIcon backgroundIcon = new ImageIcon("Performance/storeBeackground.png"); // Background Image File and where the background image is placed to show onto the frame
	        JLabel backgroundLabel = new JLabel(backgroundIcon);
	        backgroundLabel.setBounds(0, 0 , 900, 650 ); //  size of the background
	        frame.add(backgroundLabel);		// this to add the frame
	        String imageIcon = null;
			// Create a JLabel to hold the image
	        JLabel imageLabel = new JLabel(imageIcon);

	        // ********Top Navigation Buttons*******
	        
	        // Home Button
	        ImageIcon homeIcon = new ImageIcon("Performance/homeButton.png");//This is the image for the home button 
	        JButton homeButton = new JButton("", homeIcon);//This is the button for the Home Button 
	        homeButton.setBounds(20, 20, 76, 50);//The home button size and coordinates
	        frame.add(homeButton);
	        
	       

	        // Education Button
	        ImageIcon educationIcon = new ImageIcon("Performance/educationButton.png");//This is the education Image    		
	        JButton educationButton = new JButton("Education", educationIcon);   //This is the button used to click on the education image
	        educationButton.setBounds(140, 20, 88, 50);//The coordiantes and size
	        frame.add(educationButton);
	        

	        // Survey Button
	        ImageIcon surveryIcon = new ImageIcon("Performance/surveyButton.png");//This is for the survey Image
	        JButton surveyButton = new JButton("", surveryIcon);//This is the button used to click on the Survery Button to go back to the page
	        surveyButton.setBounds(260, 20, 88, 50);//The coordinates and the length and width of the Button and frame 
	        frame.add(surveyButton);

	        
	        // Store Button 
	        ImageIcon storeIcon = new ImageIcon("Performance/storeButton.png");// this is to place the image onto the frame
	        JButton storeButton = new JButton("", storeIcon);//this is the button that is used to help click on the Store Image
	        storeButton.setBounds(380, 20, 88, 50);//coordinates and size for the button and frame
	        frame.add(storeButton);//adding the frame 

	        // Cart Button
	        ImageIcon cartIcon = new ImageIcon("Performance/cartButton.png");	//This is the cart image 
	        JButton cartButton = new JButton("", cartIcon);	//This is the button used to help click on the Cart Image
	        cartButton.setBounds(520, 20, 89, 50);	//This is the coordinates and size for the cart button and cart frame
	        frame.add(cartButton);


	        
	        
	    
	        
	      
	        // **********Education Content ***********
	        JLabel educationTitle = new JLabel("Education");//This is the Header for the Window which is The Education
	        educationTitle.setFont(new Font("Arial", Font.BOLD, 30));//Thi sis the font,size and whether or not the text should be in bold
	        educationTitle.setBounds(300, 100, 200, 50);//This is the set bounds code and the code for telling the omputer what size and coordinat the text should be
	        frame.add(educationTitle);//This is to add the text to the frame
	        
	        JLabel partsTitle = new JLabel("<html>These are the parts of a computer</html>");//This is to try and tell the parts of the computer and the <html is for the word wrapping andto stop the the text from going into dots
	        partsTitle.setFont(new Font("Arial", Font.BOLD, 15));//This is the for the font of the text,the size and if it should be in bold or not
	        partsTitle.setBounds(200, 130, 300, 60); // Adjust width and height
	        partsTitle.setForeground(Color.BLACK);   // Set text color (optional)
	        frame.add(partsTitle);//This is to tell the computer to add this to the frame



	        // CPU Section 
	        JLabel cpuLabel = new JLabel("CPU");//This is for the CPU Text to show it on the frame
	        ImageIcon cpuIcon = new ImageIcon("Performance/CPU.png"); //  CPU image
	        JLabel cpuImage = new JLabel(cpuIcon);//This is to show the cpu Icon
	        cpuLabel.setBounds(100, 180, 100, 30);  //The coordinates and sizes for the label
	        cpuImage.setBounds(100, 220, 100, 100); //The coordinates and sizes for the Image
	        frame.add(cpuLabel);//This is to show the Cpu label to the frame
	        frame.add(cpuImage);

	        // GPU Section 
	        JLabel gpuLabel = new JLabel("GPU");//This is for the GPU Text to show it on the frame
	        ImageIcon gpuIcon = new ImageIcon("Performance/GPU.png"); //  GPU image
	        JLabel gpuImage = new JLabel(gpuIcon);//This is to show the GPU label icon
	        gpuLabel.setBounds(300, 180, 100, 30);//The coordinates and sizes for the label
	        gpuImage.setBounds(300, 220, 100, 65);//The coordinates and sizes for the Image
	        frame.add(gpuLabel);//This is to show the GPU label to the frame
	        frame.add(gpuImage);

	        // MEMORY Section 
	        JLabel memoryLabel = new JLabel("MEMORY");//This is for the Memory Text to show it on the frame
	        ImageIcon memoryIcon = new ImageIcon("Performance/Memory.png"); //  Memory image
	        JLabel memoryImage = new JLabel(memoryIcon);//This is to show the Memory Label ICon
	        memoryLabel.setBounds(500, 180, 100, 30);//The coordinates and sizes for the label
	        memoryImage.setBounds(500, 220, 100, 100);//The coordinates and sizes for the Image
	        frame.add(memoryLabel);
	        frame.add(memoryImage);

	        // Storage
	        JLabel storageLabel = new JLabel("Storage");//This is for the Storage Text 
	        ImageIcon storageIcon = new ImageIcon("Performance/Storage.png"); // Storage image
	        JLabel storageImage = new JLabel(storageIcon);//THis is to show the Storagr text Icon
	        storageLabel.setBounds(700, 180, 100, 30);//The coordinates and sizes for the label
	        storageImage.setBounds(700, 220, 100, 100);//The coordinates and sizes for the Image
	        frame.add(storageLabel);
	        frame.add(storageImage);

	        // Add background last so it doesn't cover other components
	        frame.add(backgroundLabel);

	        // Show the frame
	        frame.setVisible(true);
	    }

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}


