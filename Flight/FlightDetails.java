package DAY4;

import java.time.format.DateTimeFormatter;

public class FlightDetails {
	public void printFlightDetails(Flight flight){

/* Write code to print the flight information and fare break up*/
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		System.out.println("The Flight Information\n:");
		System.out.println("Flight Number: " + flight.getFlightNumber());
		System.out.println("Airliner: " + flight.getAirliner());
		System.out.println("From: " + flight.getSource());
		System.out.println("Travel Date & Time: " + flight.getFlyDateTime().format(format));
		System.out.println("To: " + flight.getDestination());
		System.out.println("Arrival Date & Time: " + flight.getArrivalDateTime().format(format));
		System.out.println("Travel type (International = true, Domestic = false): " + flight.isFlyType());
		System.out.println("The Haults are: ");
		for(Hault hault : flight.getHault()) {
			System.out.println("Airport Name: " + hault.getAirportName());
			System.out.println("Duration (In Minutes): " + hault.getDuration());
		}
		System.out.println();
		System.out.println("The Flight costing is :\n");
		System.out.println("Base Fare: " + flight.getBaseFare());
		System.out.println("Airport Surcharge: " + flight.getAirportSurcharge());
		System.out.println("Fuel Cost: " + flight.getFuelCost());
		System.out.println("International Travel Tax: " + flight.getInternationFlyTax());
		System.out.println("Holiday Tax: " + flight.getHolidayTax());
		System.out.println("Time Tax: " + flight.getTimeTax());
		System.out.println("Non-Friendly Country Travel Tax: " + flight.getNonFriendlyCityTax());
		System.out.println("--------------------------------------------------------------");
		System.out.println("Final Cost: " + flight.getFinalCost());
	}
}