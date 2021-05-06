public class LawnTractor extends Mower {
	private Engine engine;
	private String model;
	private double deckWidth;
	private Mower mow;
	
	public LawnTractor() {
		engine = new Engine();
		model = "None";
		deckWidth = 0.0;
	}
	
	public LawnTractor(Engine engine, String model, double deckWidth, Mower mow) {
		super(mow.getManufacturer(),mow.getYear(), mow.getSerialNumber(), mow.getMowerType());
		this.engine = engine;
		this.model = model;
		this.deckWidth = deckWidth;
	}
	
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setDeckWidth(double deckWidth) {
		this.deckWidth = deckWidth;
	}
	
	public Engine getEngine() {
		return engine;
	}
	
	public String getModel() {
		return model;
	}
	
	public double getDeckWidth() {
		return deckWidth;
	}

	public void setM(CommercialMower m) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		String result = "";
		
		
		
		if (super.getMowerType().equals("G") || super.getMowerType().equals("P")) {
			result = super.toString();
			return result;
			
		}
		else {
			result =  super.toString()+ "\n" + engine.toString()+ "\n" + model + "\n" + deckWidth;
			return result;
		}
		
		
		
		
		
		
	}
	
}