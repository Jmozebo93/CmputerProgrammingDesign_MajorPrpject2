public abstract class Mower{
	private String manufacturer;
	private int year;
	private String serialNumber;
	private String mowerType;
	
	public Mower() {
		manufacturer = "None";
		year = 0;
		serialNumber = "None";
		mowerType = "None";
	}
	
	public Mower(String manufacturer, int year, String serialNumber, String mowerType) {
		this.manufacturer = manufacturer;
		this.year = year;
		this.serialNumber = serialNumber;
		this.mowerType = mowerType;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public void setMowerType(String mowerType) {
		this.mowerType = mowerType;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}
	
	public String getMowerType() {
		return mowerType;
	}
	
	public String toString() {
		String result = "";
		
		result = manufacturer + "\n" + year + "\n" + serialNumber + "\n" + mowerType;
		
		return result;
	}
	
}