
public class Engine  {
	private String manufacturer;    //Engine manufacturer
	private double horsePower;       //Horse power of engine
	private int cylinders; //Number of cylinders
	
	
	//default constructor
	public Engine() {
		manufacturer = "None";
		horsePower = 0.0;
		cylinders = 0;
		
	}
	
	//constructor with all engine properties
	public Engine(String manufacturer, double horsePower, int cylinders) {
		this.manufacturer = manufacturer;
		this.horsePower = horsePower;
		this.cylinders = cylinders;
		
	}
	
	/*Accessor and Mutators*/
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public void setHorsePower(double horsePower) {
		this.horsePower = horsePower;
	}
	
	public void setCylinders(int cylinders) {
		this.cylinders = cylinders;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public double getHorsePower() {
		return horsePower;
	}
	
	public int getCylinders() {
		return cylinders;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		result = manufacturer + " \n" + horsePower + " \n" + cylinders;
		
		return result;
	}

}
