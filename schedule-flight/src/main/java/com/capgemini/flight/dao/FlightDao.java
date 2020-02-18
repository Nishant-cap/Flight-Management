package com.capgemini.flight.dao;

import com.capgemini.flight.entity.Airport;
import com.capgemini.flight.entity.Flight;
import com.capgemini.flight.entity.ScheduledFlight;
import com.capgemini.flight.exceptions.IDException;
import com.capgemini.flight.exceptions.InvalidAirportException;

/**
 * 
 * @author Nishant Shrivastav
 *
 */
public interface FlightDao {
	/**
	 * 
	 * @param flight
	 * @return
	 * @throws IDException InvalidAirportException
	 */

	public Flight addFlight(Flight flight) throws IDException;
	
	public Flight viewFlight(Integer flightId) throws IDException;

	public boolean addScheduled(ScheduledFlight schflight) throws IDException;

	public Airport getAirport(String airport) throws InvalidAirportException;
	

}
