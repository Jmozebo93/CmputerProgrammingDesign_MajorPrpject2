
public abstract class WalkBehindMower extends Mower {
	private int cutWidth;   //Blade width of mower
	private int wheelDiameter; //Diameter of the mower wheels
	private double wheelD;
	
	
	/*Default construct*/
	public WalkBehindMower() {
		cutWidth = 0;
		wheelDiameter = 0;
		
	}
	
	
	
	
	public WalkBehindMower(double cutWidth2, double wheelDiameter2) {
		// TODO Auto-generated constructor stub
	}
	
	public WalkBehindMower(int cutWidth3, double wheelDiameter3) {
		
	}


	/*Accessor and Mutators*/
	public void setCutWidth(int cutW) {
		this.cutWidth = cutW;
	}
	
	public void setWheelDiameter(int wheelDiameter) {
		this.wheelDiameter = wheelDiameter;
	}
	
	public void setWheelD(double wheelD) {
		this.wheelD = wheelD;
	}
	
	public int getCutWidth() {
		return cutWidth;
	}
	
	public int getWheelDiameter() {
		return wheelDiameter;
	}
	
	public double getWheelD() {
		return wheelD;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		result = cutWidth + " \n" + wheelDiameter;
		
		if(wheelDiameter == 0) {
			result = cutWidth + "\n" + wheelD;
			return result;
		}
		
		else {
			return result;
		}
		
	}

	
}
