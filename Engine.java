package DAY4;

public class Engine {
	private int basepower;

	public Engine() {

	}
	
	public Engine(int basepower) {
		this.basepower=basepower;
	}
	
	public int getBasePower() {
		return basepower;
	}
	public void setBasePower(int basepower) {
		this.basepower=basepower;
	}
	
	
	public int doStartEngine(String fuelType) {
		if(fuelType.equals("petrol"))
			return basepower*100;
		else if(fuelType.equals("diesel"))
			return basepower*250;
		else if(fuelType.equals("cng"))
			return basepower*50;
		else
			return basepower*90;
	}

}
