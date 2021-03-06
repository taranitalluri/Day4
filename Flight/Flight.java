package DAY4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Flight {
	private String flightNumber;
	private String airliner;

	private String source;
	private LocalDateTime flyDateTime;

	private String destination;
	private LocalDateTime arrivalDateTime;

	private Hault[] hault; // can be null;

	private boolean flyType; // domestic (false) or international(true)
	private int internationFlyTax;

	private int baseFare; // always include 5% as airport surcharge and 30% as fuel cost
	private int finalCost;// based on Airliner calendar and other criteria's

	private double nonFriendlyCityTax;
	private double timeTax;
	private double holidayTax;
	private double airportSurcharge;
	private double fuelCost;

	public Flight(String flightNumber, String airliner, String source, LocalDateTime flyDateTime, String destination,
			LocalDateTime arrivalDateTime,  boolean flyType, int baseFare) {
		super();
		this.flightNumber = flightNumber;
		this.airliner = airliner;
		this.source = source;
		this.flyDateTime = flyDateTime;
		this.destination = destination;
		this.arrivalDateTime = arrivalDateTime;
		this.flyType = flyType;
		this.baseFare = baseFare;

	}


	public String getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}


	public String getAirliner() {
		return airliner;
	}


	public void setAirliner(String airliner) {
		this.airliner = airliner;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public LocalDateTime getFlyDateTime() {
		return flyDateTime;
	}


	public void setFlyDateTime(LocalDateTime flyDateTime) {
		this.flyDateTime = flyDateTime;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public LocalDateTime getArrivalDateTime() {
		return arrivalDateTime;
	}


	public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}


	public Hault[] getHault() {
		return hault;
	}


	public void setHault(Hault[] hault) {
		this.hault = hault;
	}


	public boolean isFlyType() {
		return flyType;
	}


	public void setFlyType(boolean flyType) {
		this.flyType = flyType;
	}


	public int getInternationFlyTax() {
		return internationFlyTax;
	}


	public void setInternationFlyTax(int internationFlyTax) {
		this.internationFlyTax = internationFlyTax;
	}


	public int getBaseFare() {
		return baseFare;
	}


	public void setBaseFare(int baseFare) {
		this.baseFare = baseFare;
	}


	public int getFinalCost() {
		return finalCost;
	}


	public void setFinalCost(int finalCost) {
		this.finalCost = finalCost;
	}


	public double getNonFriendlyCityTax() {
		return nonFriendlyCityTax;
	}


	public void setNonFriendlyCityTax(double nonFriendlyCityTax) {
		this.nonFriendlyCityTax = nonFriendlyCityTax;
	}


	public double getTimeTax() {
		return timeTax;
	}


	public void setTimeTax(double timeTax) {
		this.timeTax = timeTax;
	}


	public double getHolidayTax() {
		return holidayTax;
	}


	public void setHolidayTax(double holidayTax) {
		this.holidayTax = holidayTax;
	}


	public double getAirportSurcharge() {
		return airportSurcharge;
	}


	public void setAirportSurcharge(double airportSurcharge) {
		this.airportSurcharge = airportSurcharge;
	}


	public double getFuelCost() {	
		return fuelCost;
	}


	public void setFuelCost(double fuelCost) {
		this.fuelCost = fuelCost;
	}


	public double checkCalendar() {
		AirlineCalendar ac = new AirlineCalendar();
		double percentage = 0;
		LocalDate arrivalDate = arrivalDateTime.toLocalDate();
		int dayDifference;
		for(LocalDate lc : ac.listOfHolidays) {
			dayDifference = (int) ChronoUnit.DAYS.between(arrivalDate,lc);
			if(dayDifference == 0 || dayDifference == 1 || dayDifference == -1) {
				percentage = 0.50;
				break;
			} else if((dayDifference > 1 && dayDifference <= 10) || (dayDifference < -1 && dayDifference >= -10)) {
				percentage = 0.20;
				break;
			}
		}
		return percentage;
	}
	public double checkFriendlyCity() {
		FriendlyCountry fc = new FriendlyCountry();
		double percentage = 0.30;
		for(String country : fc.countries) {
			if(country == destination) {
				percentage = 0;
			}
		}
		return percentage;
	}
	public double checkTime() {
		double percentage = 0;
		LocalTime standardTime = LocalTime.parse("12:00:00");
		LocalTime arrivalTime = arrivalDateTime.toLocalTime();
		int timeDifference = (int) ChronoUnit.MINUTES.between(standardTime, arrivalTime);
		if(timeDifference >= -120 || timeDifference <= 120) {
			percentage = 0.10;
		}
		return percentage;
	}

	public int calculateCost() {
/*
* Cost of the flight will be decided by
* 1. arrival date. :-
* 1.a)  If 10 to 2 days prior to the AirlinerCalendar Date :- 20% extra
* 1.b)  If 1 to 0 day prior to the AirlinerCalendar Date :-  50% extra
* 2. arrival time.
* 2.a) If flight land time is 2 hr +/- to 12:00 Noon (Any Date) :- 10% extra
* 3. Non free travel countries (List of FriendlyCountry.java)
* 3.a) If destination belongs to non free travel, friendly country :- 30% extra
* */

		if(flyType) {
			internationFlyTax = 500;
		} else {
			internationFlyTax = 0;
		}
		nonFriendlyCityTax = baseFare * checkFriendlyCity();
		timeTax = baseFare * checkTime();
		holidayTax = baseFare * checkCalendar();
		airportSurcharge = baseFare * 0.05;
		fuelCost = baseFare * 0.3;

		double finalPrice = (baseFare + airportSurcharge +fuelCost +internationFlyTax +holidayTax +timeTax +nonFriendlyCityTax);
		finalCost = (int) finalPrice;
		return finalCost;
	}

}
