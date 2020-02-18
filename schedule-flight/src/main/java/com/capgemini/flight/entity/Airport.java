package com.capgemini.flight.entity;

/***
 * 
 * 
 * @author Nishant Shrivastav
 *
 */

public class Airport {

	private String airportName;
	private String airportLocation;
	private String airportCode;

	public Airport(String airportName, String airportLocation, String airportCode) {
		super();
		this.airportName = airportName;
		this.airportLocation = airportLocation;
		this.airportCode = airportCode;
	}

	public Airport() {

	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportLocation() {
		return airportLocation;
	}

	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	@Override
	public String toString() {

		return "\nAirport Name: " + airportName + "\nAirport Location: " + airportLocation + "\nAirport Code: "
				+ airportCode + "";
	}

}
