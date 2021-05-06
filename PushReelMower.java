
public class PushReelMower extends WalkBehindMower {
	private int numWheels;  //Number of wheels on the mower
	
	/*Default constructor*/
	public PushReelMower() {
		numWheels = 0;
	}
	
	public PushReelMower(WalkBehindMower push) {
		super(push.getCutWidth(),push.getWheelD());
	}
	
	/*Accessor and Mutators*/
	public void setNumWheels(int numWheels) {
		this.numWheels = numWheels;
	}
	
	public int getNumWheels() {
		return numWheels;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		result = super.toString() + "\n" + numWheels;
		
		return result;
	}

	

	
}
