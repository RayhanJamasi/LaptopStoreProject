/*
 * Project Header 
 * ======================
 * Group 2  Name:Edith Chan
 * Date: 25 - 11 - 2024
 * Course: ICS3U1 - survey frame 
 * Title: BOSS Electronic Store
 * Description: 
 * This project is to create a class template file for the Laptop objects 
 * The function of this class is to create the laptop objects 
 * Skills:
 * Declare the fields/ properties/ attributes of the laptop and generate the constructor, 
 * getters and setters and toString()
 * 
 */

//Create the Laptop template class 
public class Laptop {
	//declare fields/properties/attributes 
	//for the laptops 
	private String name;
	private String type;
	private String OperatingSystem;
	private String CPU;
	private String GPU;
	private int SSD;
	private int RAM;
	private double weight;
	private int USB;
	private double size;
	private double price;
	private String brand;
	
	//create the constructor 
	public Laptop(String name, String type, String operatingSystem, String CPU, String GPU, int SSD, int RAM,
			double weight, int USB, double size, double price, String brand) {
		super();
		this.name = name;
		this.type = type;
		OperatingSystem = operatingSystem;
		this.price = price;
		this.brand = brand;
		this.CPU = CPU;
		this.GPU = GPU;
		setSSD(SSD);
		setRAM(RAM);
		this.weight = weight;
		this.USB = USB;
		this.size = size;
	}

	//Getters and Setters 
	//name of the Laptop
	
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setName(String name) {
		this.name = name;
	}

	//Type of Laptop
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	//Operating System of the laptop 
	public String getOperatingSystem() {
		return OperatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		OperatingSystem = operatingSystem;
	}

	//CPU of the laptop 
	public String getCPU() {
		return CPU;
	}

	public void setCPU(String CPU) {
		this.CPU = CPU;
	}

	//GPU of the laptop 
	public String getGPU() {
		return GPU;
	}

	public void setGPU(String GPU) {
		this.GPU = GPU;
	}

	//SSD of the laptop 
	public int getSSD() {
		return SSD;
	}

	//valid SSD greater than 0 
	public void setSSD(int SSD) {
		if (SSD > 0)
			this.SSD = SSD;
		else {
			System.out.println("Please enter another SSD greater than 0.");
			this.SSD = SSD;
		}
	}

	//RAM of the laptop 
	public int getRAM() {
		return RAM;
	}
	
	//valid RAM greater than 0 
	public void setRAM(int RAM) {
		if (RAM > 0)
			this.RAM = RAM;
		else {
			System.out.println("Please enter another RAM greater than 0.");
			this.RAM = RAM;
		}
	}

	//the weight of the laptop 
	public double getWeight() {
		return weight;
	}

	//valid weight to be greater than 0 
	public void setWeight(double weight) {
		if (weight > 0)
			this.weight = weight;
		else {
			System.out.println("Please enter the weight to be greater than 0.");
			this.weight = weight;
		}
	}

	//USB ports the laptop can use 
	public int getUSB() {
		return USB;
	}

	//valid the number of USB ports to be greater than 0 
	public void setUSB(int USB) {
		if (USB > 0)
			this.USB = USB;
		else {
			System.out.println("Please enter the number to be greater than 0.");
			this.USB = USB;
		}
	}

	//size of the laptop 
	public double getSize() {
		return size;
	}

	//valid the size of the laptop  greater than 0 
	public void setSize(double size) {
		if (size > 0)
			this.size = size;
		else {
			System.out.println("Please enter the size to be greater than 0.");
			this.size = size;
		}
	}

	//Create toString 
	@Override
	public String toString() {
		return "Laptop [name=" + name + ", type=" + type + ", OperatingSystem=" + 
					OperatingSystem + ", CPU=" + CPU + ", GPU=" + GPU + ", SSD=" + SSD + ", "
						+ "RAM=" + RAM + ", weight=" + weight + ", USB=" + USB + ", size="
							+ size + ", price=" + price + ", brand=" + brand + "]";
	}	
	
}
