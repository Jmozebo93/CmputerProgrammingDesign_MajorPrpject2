
public class GasPoweredMower extends WalkBehindMower {
	private Engine engine; //Mower engine
	private boolean selfPropelled;   //is the mower self-propelled
	
	/*Default constructor*/
	public GasPoweredMower() {
		engine = new Engine();
		selfPropelled = false;
	}
	
	public GasPoweredMower(WalkBehindMower push) {
		super(push.getCutWidth(),push.getWheelDiameter());
	}
	/*Accessor and Mutator*/
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public void setSelfPropelled(boolean selfPropelled) {
		this.selfPropelled = selfPropelled;
	}
	
	public Engine getEngine() {
		return engine;
	}
	
	public boolean getSelfPropelled() {
		return selfPropelled;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		result = super.toString()+ "\n" +engine.toString() + "\n"+ selfPropelled;
		
		return result;
	}

	

}
