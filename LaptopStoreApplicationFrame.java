/*
 * -Team 2,Daniel Iyere
 * -Monday 25 November 2024
 * -ICUS3U1
 * -Laptop Store Eudcation  Application
 * -The point of this application class is to make the Frame for my laptop store
 * And to make sure that I am in charge of making the Main class frame and  the main method that runs the application
 * -Main Title Frame applicatin
 * -I want to make people notice how I added the setResiable which 
 * Prevents the user from resizing the window, which helps maintain the layout.
 */

//Import Swing class for GUI
import java.util.ArrayList;

import javax.swing.*;  

public class LaptopStoreApplicationFrame {
    public static void main(String[] args) {
        // Create a new frame
    	LaptopStoreFileInput.fillLibrary();
        new LaptopStoreTitleFrame();

//        // Make the  basic frame properties
//        frame.setSize(800, 600); 		 // Set the frame size (
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close the window when clicked
//        frame.setResizable(false);  //make it so the user is not able to resize the frame
//        frame.setVisible(true);  		// Make the frame visible
    }
}

