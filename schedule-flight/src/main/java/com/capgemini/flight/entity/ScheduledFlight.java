package com.capgemini.flight.entity;

/**
 * 
 * @author Nishant Shrivastav
 *
 */

public class ScheduledFlight {

	private Integer scheduledFlightId;
	private Flight flight = new Flight();
	private Integer availableSeats;
	private Schedule schedule = new Schedule();

	public ScheduledFlight(Integer scheduledFlightId ,Flight flight, Integer availableSeats, Schedule schedule) {
		super();
		this.scheduledFlightId=scheduledFlightId;
		this.flight = flight;
		this.availableSeats = availableSeats;
		this.schedule = schedule;
	}

	
	public ScheduledFlight() {
		
	}


	public Integer getScheduledFlightId() {
		return scheduledFlightId;
	}


	public void setScheduledFlightId(Integer scheduledFlightId) {
		this.scheduledFlightId = scheduledFlightId;
	}


	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {

		return "\nFlight: " + flight + "\nAvailable Seats: " + availableSeats + "\nSchedule: " + schedule + "";
	}

}
