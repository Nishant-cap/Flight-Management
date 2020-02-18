package com.capgemini.flight.entity;

import java.time.LocalDateTime;

/***
 * 
 * @author Nishant Shrivastav
 *
 */

public class Schedule {

	private Airport sourceAirport = new Airport();
	private Airport destinationAirport = new Airport();
	private LocalDateTime arrivalTime;
	private LocalDateTime departureTime;

	public Schedule() {

	}

	public Schedule(Airport sourceAirport, Airport destinationAirport, LocalDateTime arrivalTime,
			LocalDateTime departureTime) {
		super();
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}

	public Airport getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public Airport getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	@Override
	public String toString() {

		return "\nSource Airport: " + sourceAirport + "\nDestination Airport: " + destinationAirport
				+ "\nArrival Time: " + arrivalTime + "\nDeparture Time: " + departureTime + "\n";
	}

}
