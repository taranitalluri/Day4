package DAY4;

public class MainRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Engine : ");
		
		Engine tataEngine=new Engine(1);
		Engine hondaEngine = new Engine(1000);
		
		Car car1=new Car(hondaEngine);
		car1.moveCarForward();
		
		Engine e=car1.getEngine();
		e.setBasePower(e.getBasePower()+1);
		
		car1.setEngine(tataEngine);
		car1.moveCarForward();
		
		
		System.out.println("\nMusic System : ");
		
		MusicSystem ms1 = new MusicSystem(50);
		MusicSystem ms2 = new MusicSystem(25);
		MusicSystem ms3 = new MusicSystem(100);
		
		Car c1=new Car(ms1);
		c1.musicSound();
		MusicSystem ms = c1.getMs();
		ms.setMusicSound(ms.getMusicSound());
		
		Car c2=new Car(ms2);
		c2.musicSound();
		MusicSystem m = c2.getMs();
		m.setMusicSound(m.getMusicSound());
		
		c1.setMs(ms3);
		c1.musicSound();
		
		
		
		
	}

}
