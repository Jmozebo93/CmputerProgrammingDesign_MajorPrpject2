import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MowerWareHouse {
	private String storeName;   //Name of the mower store
	private ArrayList<Mower> mowers;  //Array List of object mower
	
	
	/*Default constructor*/
	public MowerWareHouse() {
		storeName = "None";
		mowers = new ArrayList<Mower>();
	}
	
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	public void setMowers(ArrayList<Mower> mowers) {
		this.mowers = mowers;
		
	}
	
	public String getStoreName() {
		return storeName;
	}
	
	public ArrayList<Mower> getMowers(){
		return mowers;
	}
	/*Return the number of items in the ArrayList of object Mower*/
	public int getNumMower() {
		return mowers.size();
	}
	/*Return the object Mower at location i in ArrayList of type Mower*/
	public Mower getMower(int i){
		return mowers.get(i);
	}
	/*Store item at location index in the ArrayList Mower*/
	public void setMower(int j, Mower redox) {
		mowers.add(j, redox);
	}
	/*Append an object Mower to the ArrayList*/
	public void addMower(Mower mad) {
		mowers.add(mad);
	}
	/*Remove and return the Mower at location */
	public Mower removeMower(int k) {
		return mowers.remove(k);
	}
	
	@Override
	public String toString() {
		String res = "";
		
		res = storeName + "\n";
		for(int i = 0; i < getNumMower(); i++) {
			res += mowers.get(i).toString() + "\n";
		}
		
		return res;
	}
	
	public void readMowerData(String inputFileName) throws IOException{
		FileInputStream fn = new FileInputStream(inputFileName);
		
		Scanner scnr = new Scanner(fn);
		
		storeName = scnr.nextLine();
		
		
		
		
		while(scnr.hasNext()) {
			LawnTractor mowed = new LawnTractor();
			mowed.setManufacturer(scnr.nextLine());
			int year = Integer.parseInt(scnr.nextLine());
			mowed.setYear(year);
			mowed.setSerialNumber(scnr.nextLine());
			String mowerType = scnr.nextLine();
			mowed.setMowerType(mowerType);
			this.addMower(mowed);
			
			if(mowerType.equals("L")) {
				Engine Motor = new Engine();
				Motor.setManufacturer(scnr.nextLine());
				double horsePow = Double.parseDouble(scnr.nextLine());
				Motor.setHorsePower(horsePow);
				int cyl = Integer.parseInt(scnr.nextLine());
				Motor.setCylinders(cyl);
				mowed.setEngine(Motor);
				mowed.setModel(scnr.nextLine());
				double deckW = Double.parseDouble(scnr.nextLine());
				mowed.setDeckWidth(deckW);
			
			}
			if(mowerType.equals("C")) {
				Engine Motor = new Engine();
				Motor.setManufacturer(scnr.nextLine());
				double horsePow = Double.parseDouble(scnr.nextLine());
				Motor.setHorsePower(horsePow);
				int cyl = Integer.parseInt(scnr.nextLine());
				Motor.setCylinders(cyl);
				mowed.setEngine(Motor);
				mowed.setModel(scnr.nextLine());
				double deckW = Double.parseDouble(scnr.nextLine());
				mowed.setDeckWidth(deckW);
				CommercialMower m = new CommercialMower();
				Double op = Double.parseDouble(scnr.nextLine());
				m.setOperatingHours(op);
				boolean ZRadius = Boolean.parseBoolean(scnr.nextLine());
				m.setZeroTurnRadius(ZRadius);
				mowed.setM(m);
				
				
			}
			
			if(mowerType.equals("G")) {
				GasPoweredMower push = new GasPoweredMower();
				int cutW = Integer.parseInt(scnr.nextLine());
				push.setCutWidth(cutW);
				int WheelD = Integer.parseInt(scnr.nextLine());
				push.setWheelDiameter(WheelD);
				Engine Motor = new Engine();
				Motor.setManufacturer(scnr.nextLine());
				double horsePow = Double.parseDouble(scnr.nextLine());
				Motor.setHorsePower(horsePow);
				int cyl = Integer.parseInt(scnr.nextLine());
				Motor.setCylinders(cyl);
				push.setEngine(Motor);
				boolean selfP = Boolean.parseBoolean(scnr.nextLine());
				push.setSelfPropelled(selfP);
				this.addMower(push);
				
			}
			
			if(mowerType.equals("P")) {
				PushReelMower push = new PushReelMower();
				int cutW = Integer.parseInt(scnr.nextLine());
				push.setCutWidth(cutW);
			    double WheelD = Double.parseDouble(scnr.nextLine());
				push.setWheelD(WheelD);
				int numW = Integer.parseInt(scnr.nextLine());
				push.setNumWheels(numW);
				this.addMower(push);
			}
			
		}
		scnr.close();
			
	}
	
	public void saveMowertData(String fileName) throws IOException{
		FileOutputStream file = new FileOutputStream(fileName);
		PrintWriter p = new PrintWriter(file);
		p.println(this.toString());
		p.close();
	}
	

}
