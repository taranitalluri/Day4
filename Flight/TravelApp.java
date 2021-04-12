package DAY4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TravelApp {
	public static void main(String[] args) {
/* Write code to call Flight constructor and Flight class setter methods*/
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		Flight flight = new Flight("101","KINGFISHER","India",LocalDateTime.parse("2021-04-10 12:30", format),"Nepal",LocalDateTime.parse("2021-04-11 16:30", format),false,10000);
		System.out.println("Enter number of Halts:");
		Scanner sc = new Scanner(System.in);
		int haltCount = sc.nextInt();
		sc.nextLine();
		Hault[] hault = new Hault[haltCount];
		for(int i = 0; i < haltCount; i++) {
			Hault h = new Hault();
			System.out.println("Enter Airport Name");
			h.setAirportName(sc.nextLine());
			System.out.println("Enter duration (In Minutes)");
			h.setDuration(sc.nextInt());
			sc.nextLine();
			hault[i] = h;
		}
		sc.close();
		flight.setHault(hault);
		flight.calculateCost();

		FlightDetails flightDetails = new FlightDetails();
		flightDetails.printFlightDetails(flight);



	}
}