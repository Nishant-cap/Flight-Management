package com.capgemini.flight.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import com.capgemini.flight.entity.Airport;
import com.capgemini.flight.entity.Flight;
import com.capgemini.flight.entity.Schedule;
import com.capgemini.flight.entity.ScheduledFlight;

public class FlightRepository {

	public static Map<Integer, ScheduledFlight> map = new HashMap<Integer, ScheduledFlight>();

	public static Map<Integer, Flight> flightmap = new HashMap<>();

	public static Map<String, Airport> airportmap = new HashMap<>();

	public static Map<String, Schedule> schedulemap = new HashMap<>();

	public static Map<String, ScheduledFlight> scheduledflightmap = new HashMap<>();

	static {
		Flight flight1 = new Flight(1001, "Air India", 300);
		Flight flight2 = new Flight(1002, "Speice Jet", 250);
		Flight flight3 = new Flight(1003, "Indigo", 350);
		Flight flight4 = new Flight(1004, "Vistara", 300);
		Flight flight5 = new Flight(1005, "Air Asia", 500);

		flightmap.put(flight1.getFlightNumber(), flight1);
		flightmap.put(flight2.getFlightNumber(), flight2);
		flightmap.put(flight3.getFlightNumber(), flight3);
		flightmap.put(flight4.getFlightNumber(), flight4);
		flightmap.put(flight5.getFlightNumber(), flight5);

		Airport airport1 = new Airport("Indra Gandhi International Airport", "Delhi", "DEL");
		Airport airport2 = new Airport("Mysore Airport", "Mysore", "MYQ");
		Airport airport3 = new Airport("Pune Airport", "Pune", "PNQ");
		Airport airport4 = new Airport("Bengaluru International Airport", "Bengalore", "BLR");
		Airport airport5 = new Airport("Jai Prakash Narayan Airport", "Patna", "PAT");

		airportmap.put(airport1.getAirportName(), airport1);
		airportmap.put(airport2.getAirportName(), airport2);
		airportmap.put(airport3.getAirportName(), airport3);
		airportmap.put(airport4.getAirportName(), airport4);
		airportmap.put(airport5.getAirportName(), airport5);

		Schedule schedule1 = new Schedule(airport1, airport2,
				LocalDate.parse("2020-05-13").atTime(LocalTime.parse("06:30")),
				LocalDate.parse("2020-05-13").atTime(LocalTime.parse("08:30")));
		Schedule schedule2 = new Schedule(airport3, airport4,
				LocalDate.parse("2020-06-14").atTime(LocalTime.parse("10:30")),
				LocalDate.parse("2020-06-14").atTime(LocalTime.parse("12:30")));
		Schedule schedule3 = new Schedule(airport4, airport5,
				LocalDate.parse("2020-03-15").atTime(LocalTime.parse("17:30")),
				LocalDate.parse("2020-03-15").atTime(LocalTime.parse("20:00")));

		schedulemap.put(airport1.getAirportName(), schedule1);
		schedulemap.put(airport3.getAirportName(), schedule3);
		schedulemap.put(airport4.getAirportName(), schedule3);

		ScheduledFlight sf1 = new ScheduledFlight(2001, flight1, 120, schedule1);
		ScheduledFlight sf2 = new ScheduledFlight(2002, flight2, 200, schedule2);
		ScheduledFlight sf3 = new ScheduledFlight(2003, flight3, 120, schedule3);
		ScheduledFlight sf4 = new ScheduledFlight(2004, flight4, 200, schedule2);
		ScheduledFlight sf5 = new ScheduledFlight(2005, flight5, 140, schedule2);

		map.put(sf1.getScheduledFlightId(), sf1);
		map.put(sf2.getScheduledFlightId(), sf2);
		map.put(sf3.getScheduledFlightId(), sf3);
		map.put(sf4.getScheduledFlightId(), sf4);
		map.put(sf5.getScheduledFlightId(), sf5);

	}

	public static Map<Integer, ScheduledFlight> getSchedulefFlight() {
		return map;

	}

	public static Map<Integer, Flight> getFlightmap() {
		return flightmap;
	}
	
	public static Map<String, Airport> getAirportmap() {
		return airportmap;
	}
	
	public static Map<String,Schedule> getSchedule(){
		return schedulemap;
	}
}
