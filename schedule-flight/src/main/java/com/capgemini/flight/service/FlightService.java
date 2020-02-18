package com.capgemini.flight.service;

import java.time.LocalDateTime;

import com.capgemini.flight.exceptions.IDException;
import com.capgemini.flight.exceptions.InvalidAirportException;
import com.capgemini.flight.exceptions.InvalidFlightNameException;
import com.capgemini.flight.exceptions.SeatException;
import com.capgemini.flight.exceptions.ValidateException;

public interface FlightService {

	public boolean addFlight(int flightNum, String flightName, int seat)
			throws IDException, InvalidFlightNameException, SeatException;

	public boolean addScheduled(int Id, int flightId, int seat, String src, String dest, LocalDateTime arr,
			long noOfhours) throws IDException, SeatException, InvalidAirportException, ValidateException;

}
