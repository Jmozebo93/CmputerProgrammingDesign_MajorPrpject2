
public class CommercialMower extends LawnTractor {
	private double operatingHours; //points earned on the assignment
	private boolean zeroTurnRadius; //Maximum points
	
	public CommercialMower() {
		operatingHours = 0.0;
		zeroTurnRadius = false;
	}
	
	public CommercialMower(double operatingHours, boolean zeroTurnRadius) {
		this.operatingHours = operatingHours;
		this.zeroTurnRadius = zeroTurnRadius;
	}
	
	/*Accessor and Mutators*/
	public void setOperatingHours(double operatingHours) {
		this.operatingHours = operatingHours;
	}
	
	public void setZeroTurnRadius(boolean zeroTurnRadius) {
		this.zeroTurnRadius = zeroTurnRadius;
	}
	
	public double getOperatinghours() {
		return operatingHours;
	}
	
	public boolean getZeroTurnRadius() {
		return zeroTurnRadius;
	}
	
	//toString method
	@Override
	public String toString() {
		String result = "";
		
		result = operatingHours + " \n" + zeroTurnRadius;
		
		return result;
	}

}
