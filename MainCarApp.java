package DAY4;
import java.util.*;
public class MainCarApp {

	static Scanner sc=new Scanner(System.in);
	Car carsInfo[]=new Car[1000];
	int index=0; //for car count
	
	public static void main(String[] args) {
		MainCarApp obj = new MainCarApp();
		while(true) { 
			System.out.println("1. Add Car");
			System.out.println("2. View Car By Cost");
			System.out.println("3. View Car By Power");
			System.out.println("4. search car");
			
			int option = Integer.parseInt(sc.nextLine());
			switch(option) {
			case 1: obj.insertCarByUser();
				break;
				
			case 2:
				System.out.println("enter cost limit");
				int costLimit = Integer.parseInt(sc.nextLine());
				obj.viewCarsByCost(costLimit);
			case 3: 
				System.out.println("enter the power limit");
				int powerLimit = Integer.parseInt(sc.nextLine());
				obj.viewCarsByPower(powerLimit);
				break;
			case 4:
				System.out.println("enter element to be searched");
				String searchData = sc.nextLine();
				int  p = obj.searchElement(searchData);
				if(p!=-1) {
					System.out.println(searchData +" is found at "+(p+1));
				}else {
					System.out.println(searchData +" is not found");
				}
			}
		}
	}
	private int searchElement(String searchData) {
		// TODO Auto-generated method stub
		for(int i=0;i<index;i++) {
			if(carsInfo[i].getCarName() == searchData) {
				return i;
			}
		}
		return -1;
		
	}
	private void viewCarsByCost(int costLimit) {
		// TODO Auto-generated method stub
		for(int i=0;i<index;i++) {
			if(carsInfo[i].getCost()<=costLimit) {
				System.out.println(carsInfo[i]);
			}
		}
		
	}
	private void viewCarsByPower(int powerLimit) {
		for(int i=0;i<index;i++) {
			if(carsInfo[i].getEngine().getBasePower()<=powerLimit) {
				System.out.println(carsInfo[i]);
			}
		}
	}

	public void insertCarByUser() {
		System.out.println("Enter Car Name");
		String carName = sc.nextLine();
		
		System.out.println("enter cost");
		int cost=Integer.parseInt(sc.nextLine());
		
		System.out.println("enter engine power");
		int enginePower = Integer.parseInt(sc.nextLine());
		
		Engine e=new Engine(enginePower);
		Car obj = new Car(e);
		obj.setCarName(carName);
		obj.setCost(cost);
		
		addCar(obj);
	}
	
	public boolean addCar(Car car) {
		boolean isInserted=true;
		carsInfo[index] = car;
		index++;
		return isInserted;
	}
	
	public void displayCarInfo(Car car) {
		System.out.println("---car information---");
		System.out.println(" Car Name"+car.getCarName());
		System.out.println(" Car cost"+car.getCost());
		System.out.println(" Car Power"+car.getEngine().getBasePower());
		
	}
	

}
