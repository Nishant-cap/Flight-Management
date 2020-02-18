package com.capgemini.flight.dao;

import java.util.Map;


import com.capgemini.flight.entity.Airport;
import com.capgemini.flight.entity.Flight;
import com.capgemini.flight.entity.Schedule;
import com.capgemini.flight.entity.ScheduledFlight;
import com.capgemini.flight.exceptions.IDException;
import com.capgemini.flight.exceptions.InvalidAirportException;
import com.capgemini.flight.util.FlightRepository;

/**
 * 
 * @author Nishant Shrivastav
 *
 */

public class FlightDaoImpl implements FlightDao {

	Flight flight = new Flight();
	public static Map<String, Schedule> schedulemap = FlightRepository.getSchedule();
	public static Map<Integer, ScheduledFlight> scheduledmap = FlightRepository.getSchedulefFlight();
	public static Map<Integer, Flight> flightmap = FlightRepository.getFlightmap();
	public static Map<String, Airport> airportmap = FlightRepository.getAirportmap();

	@Override
	public Flight addFlight(Flight flight) throws IDException {
		if (flightmap.containsKey(flight.getFlightNumber()))
			throw new IDException("Flight Already Exists");

		flightmap.put(flight.getFlightNumber(), flight);
		return flight;
	}

	@Override
	public Flight viewFlight(Integer flightId) throws IDException {
		if (!flightmap.containsKey(flightId))
			throw new IDException("Flight Not Found");
		return flightmap.get(flightId);

	}

	@Override
	public boolean addScheduled(ScheduledFlight schflight) throws IDException {
		if (scheduledmap.containsKey(schflight.getScheduledFlightId()))
			throw new IDException("Scheduled ID Already Exists");

		scheduledmap.put(schflight.getScheduledFlightId(), schflight);
		return true;
	}

	@Override
	public Airport getAirport(String airport) throws InvalidAirportException {

		if (!airportmap.containsKey(airport))
			throw new InvalidAirportException("No Such Airport Found!");

		return airportmap.get(airport);
	}

}
