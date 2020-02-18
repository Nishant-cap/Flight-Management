package com.capgemini.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import com.capgemini.flight.dao.FlightDao;
import com.capgemini.flight.dao.FlightDaoImpl;
import com.capgemini.flight.entity.Airport;
import com.capgemini.flight.entity.Flight;
import com.capgemini.flight.entity.Schedule;
import com.capgemini.flight.entity.ScheduledFlight;
import com.capgemini.flight.exceptions.IDException;
import com.capgemini.flight.exceptions.InvalidFlightNameException;
import com.capgemini.flight.exceptions.SeatException;
import com.capgemini.flight.exceptions.ValidateException;
import com.capgemini.flight.service.FlightService;
import com.capgemini.flight.service.FlightServiceImpl;
import com.capgemini.flight.util.FlightRepository;

/*******
 * 
 * @author Nishant Shrivastav
 *
 */

public class TestFlight {
	FlightDao dao = new FlightDaoImpl();
	FlightService ser = new FlightServiceImpl();

	public static Map<String, Airport> airportmap = FlightRepository.getAirportmap();

	@Test
	@DisplayName("Test case 1")
	public void testAddFlight1() throws IDException {
		assertAll("Add Flight", () -> assertThrows(IDException.class, () -> {
			ser.addFlight(12345, "Air India", 700);
		}), () -> assertThrows(IDException.class, () -> {
			ser.addFlight(1005, "Indigo", 400);
		}));

	}


	@Test
	@DisplayName("Test Case 2")
	public void testAddFlight2() {
		assertThrows(SeatException.class, () -> {
			ser.addFlight(1007, "Air India", 900);
		});
	}

	@Test
	@DisplayName("Test Case 3")
	public void testAddFlight3()  {

		assertThrows(InvalidFlightNameException.class, () -> {
			ser.addFlight(1006, "", 300);
		});
	}

	@Test
	@DisplayName("Test case 4")
	public void testAddFlight4() throws InvalidFlightNameException, SeatException, IDException {
		Flight flight = new Flight(1006, "Air India", 300);
		assertEquals(dao.addFlight(flight).toString(), dao.viewFlight(1006).toString());
	}

	@Test
	@DisplayName("Test case 5")
	public void testAddSchedule1() {
		assertThrows(IDException.class, () -> {
			ser.addScheduled(53232, 1005, 120, "Mysore Airport", "Pune Airport",
					LocalDate.parse("2020-05-13").atTime(LocalTime.parse("06:30")), 1);
		});
	}

	@Test
	@DisplayName("Test case 6")
	public void testAddSchedule2() {
		assertThrows(ValidateException.class, () -> {
			ser.addScheduled(2006, 1005, 120, "Mysore Airport", "Pune Airport",
					LocalDate.parse("2019-05-05").atTime(LocalTime.parse("06:30")), 1);
		});
	}

	@Test
	@DisplayName("Test case 7")
	public void testAddSchedule3() {

		assertThrows(SeatException.class, () -> {
			ser.addScheduled(2006, 1005, 1200, "Mysore Airport", "Pune Airport",
					LocalDate.parse("2020-05-03").atTime(LocalTime.parse("07:30")), 1);
		});
	}

	@Test
	@DisplayName("Test case 8")
	public void testAddSchedule4() throws SeatException, IDException, InvalidFlightNameException {
		Flight flight = new Flight(1006, "Air India", 300);
		LocalDateTime ltd = LocalDate.parse("2020-05-03").atTime(LocalTime.parse("07:30"));

		Schedule schedule = new Schedule(airportmap.get("Pune Airport"), airportmap.get("Mysore Airport"), ltd,
				ltd.plusHours(Long.parseLong("1")));
		ScheduledFlight sflight = new ScheduledFlight(2006, flight, 120, schedule);
		assertTrue(dao.addScheduled(sflight));
		assertTrue(ser.addFlight(1007, "Air India", 300));
	}
}
