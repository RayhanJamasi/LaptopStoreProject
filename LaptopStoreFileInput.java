import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/*
 * PROJECT HEADER
 * 
 * GROUP TEAM + NAME: Team 2, Rayhan Jamasi
 * DATE: Monday Nov 25 2024
 * COURSE CODE: ICS3U1-04/05 Mrs. Biswas
 * TITLE: BOSS Laptop Store
 * 
 * DESCRIPTION: 
 * ======================
 * This store has many features. This includes an education tab
 * where you can learn about the important parts of a computer. It goes into
 * detail about specific parts as well. There is a store where you can scroll
 * through a variety of computers and for many different uses. There is 
 * a filter button where it will reorder and re-display the laptops depending
 * on what filter was chosen. You can click on each Laptop to see more information
 * about its specifications and you can even click an add to cart button. There is 
 * also an information button where you can see the ratings of different parts of the
 * computer and some reasoning behind why the ratings were chosen. Another important
 * component is the survey where you can answer questions that help narrow down some
 * computers that you need. It will display 3 possible choices for you and you can click
 * a More Info button to see more information about the computers. There is also a cart feature
 * where you are able to see all the laptops that were added to cart. A cart info button
 * opens a new window which shows the subtotal, tax, and the total of your cart. 
 * 
 * MAJOR SKILLS:
 * ==================
 * 1) Java IO class
 * 		- allows to read the file
 * 		- ensures the FileNotFound error does not occur with the help of try and catch
 * 2) File reading
 * 		- allows us to read the information from the file and create objects for an array
 * 		- very important for inventory frame and the results frame
 * 3) Arrays and ArrayList
 * 		- allow us to put all the Laptop objects in an array that can be accessed throughout 
 * 						classes
 * 		- ArrayList as a possible idea where you can add laptops you like to an ArrayList
 * 				named cart which shows up in the cart window
 * 4) Swing GUI 
 * 		- allows us to create labels, buttons, panels, frames and more
 * 5) Acessing arrays accross different classes
 * 		- being able to access the same array across different classes
 * 		- this allows for multiple classes to have access to arrays like the 
 * 					laptopArray
 * 6) Loops and Enhanced For Loops
 * 		- allows us to go through every object in an array
 * 		- important for calculating results and displaying laptops in inventory frame
 *  
 * 
 * ADDED FEATURES: Hoping for the cart to be able to resize (with help of scroll pane)
 * 					- dynamically resize allowing for as many different laptops in the cart
 * AREAS OF CONCERN: none 
 * 
 * Contributors - Rayhan 
 */

public class LaptopStoreFileInput {
	
	//creating static laptopArray 
	static Laptop [] laptopArray = new Laptop[20];

	//main method, calls other important methods
	public static void main(String [] args) {
		displayTitle();
		fillLibrary();
		displayArray();
	}

	//this method displays the title for the Laptop store
	public static void displayTitle() {
		System.out.println("Laptop Information");
		System.out.println("===================");
		
	}

	//this method fills the laptopArray from reading through
	//the Laptops.txt file
	public static void fillLibrary() {
		//try method that makes a scanner object and reads from the 
		//txt file
		try {
			Scanner inputFile = new Scanner(new File ("File/Laptops.txt"));
			inputFile.useDelimiter(",|\r\n");
			
			//for loop that assigns the field to values from txt file
			for (int i = 0; i < laptopArray.length; i++) {	
				String brand = inputFile.next();
				String name = inputFile.next();
				String type = inputFile.next();
				double price = inputFile.nextDouble();
				String OperatingSystem = inputFile.next();
				String CPU = inputFile.next();
				String GPU = inputFile.next();
				int SSD = inputFile.nextInt();
				int RAM = inputFile.nextInt();
				double weight = inputFile.nextDouble();
				int USB = inputFile.nextInt();
				double size = inputFile.nextDouble();
				
				//creating Laptop object and assigning to laptopArray at index i 
				laptopArray[i] = new Laptop(name, type, OperatingSystem, CPU, GPU, 
											SSD, RAM, weight, USB, size, price, brand);
			}
			//closing the scanner object
			inputFile.close();
			
		//catch in case file does not exist
		} catch(FileNotFoundException e) {
			System.out.println("File Error");
		}
		
	}

	//this method returns the laptop array and allows other classes
	//to access it
	public static Laptop[] getLaptopArray() {
		return laptopArray; 
	}
	
	//this method uses an enhanced for loop to display the objects in 
	//the laptopArray
	public static void displayArray() {
		for (Laptop laptop : laptopArray) {
			System.out.println(laptop);
		}
		
	}

}
