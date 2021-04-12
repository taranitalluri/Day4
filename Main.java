package DAY4;

public class Main {
	
	static Car arr[]=new Car[3];
	public static void main(String[] args) {
		
		Engine e1=new Engine(800);
		Engine e2 = new Engine(1800);
		
		//Car arr[]=new Car[3];
		
		Car obj1 = new Car(e1);
		obj1.setCarName("Honda");
		obj1.setCarPower(1000);
		Car obj2=new Car(e2);
		obj2.setCarName("Maruthi");
		obj2.setCarPower(1800);
		Car obj3 = new Car(e1);
		obj3.setCarName("Audi");
		obj3.setCarPower(1500);
		
		arr[0]=obj1;
		arr[1]=obj2;
		arr[2]=obj3;
		
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i].getCarName()+"-"+arr[i].getCarPower());
		}
		System.out.println("------------");
		for(Car car:arr) {
			System.out.println(car.getCarName()+"---"+car.getCarPower());
		}
		
		System.out.println("-------\ncars with power > 1500");
		for(int i=0;i<arr.length;i++) {
			if(arr[i].getCarPower()>1500) {
				System.out.println(arr[i].getCarName());
			}
		}
			
		}
	

	}
