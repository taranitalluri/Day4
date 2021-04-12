package DAY4;

public class Car {
	private int cost;
	private String carName;
	private Engine engine;
	private int carPower;
	private int sound;
	private MusicSystem ms;
	
	public Car() {
		super();
	}
	

	public Engine getEngine() {
		// TODO Auto-generated method stub
		return engine;
	}
	
	public void setEngine(Engine engine) {
		this.engine=engine;
	}
	
	public Car(Engine engine) {
		this.engine=engine;
	}

	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost=cost;
	}
	
	

	public String getCarName() {
		return carName;
	}


	public void setCarName(String carName) {
		this.carName = carName;
	}


	public int getCarPower() {
		return carPower;
	}


	public void setCarPower(int carPower) {
		this.carPower = carPower;
	}

	
	
	public void doStartCar() {
		carPower=engine.doStartEngine("petrol")+100;
	}

	public void moveCarForward() {
		doStartCar();
		if(carPower>1000)
			System.out.println("car speed is high");
		if(carPower<1000)
			System.out.println("car spped is low");
		if(carPower>2000)
			System.out.println("this must be truck");
		
	}
	
	

	public Car(MusicSystem ms) {
		this.ms=ms;
	}

	
	public MusicSystem getMs() {
		return ms;
	}


	public void setMs(MusicSystem ms) {
		this.ms = ms;
	}


	public void playMusic() {
		sound=ms.checkMusicSound("Flat");
	}
	public void musicSound() {
		playMusic();
		if(sound>50) {
			System.out.println("sound is high");
		}
		if(sound<50) {
			System.out.println("sound is low");
		}
		if(sound==50) {
			System.out.println("sound is normal");
		}
		if(sound>=100) {
			System.out.println("ears will damage");
		}
	}


	
	

	
}
