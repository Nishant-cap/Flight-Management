package com.capgemini.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import com.capgemini.flight.exceptions.IDException;
import com.capgemini.flight.exceptions.InvalidAirportException;
import com.capgemini.flight.exceptions.InvalidFlightNameException;
import com.capgemini.flight.exceptions.SeatException;
import com.capgemini.flight.exceptions.ValidateException;
import com.capgemini.flight.service.FlightService;
import com.capgemini.flight.service.FlightServiceImpl;
import com.capgemini.flight.util.Cgutil;

public class Source {

	public static void main(String[] args)
			throws IDException, InvalidFlightNameException, SeatException, InvalidAirportException, ValidateException {

		FlightService obj = new FlightServiceImpl();

		System.out.println("----------Welcome TO Flight Management System-------------------------");
		String opt = null;
		System.out.println("***************Enter Your Flight Details******************************");
		do {
			try {
				
				System.out.println("Enter FlightId");
				String Id = Cgutil.scan.nextLine();
				int id = Integer.parseInt(Id);
				System.out.println("Enter Flight Name");
				String fname = Cgutil.scan.nextLine();
				System.out.println("Enter seat capacity");
				String Seatcap = Cgutil.scan.nextLine();
				int seatcap = Integer.parseInt(Seatcap);
				obj.addFlight(id, fname, seatcap);

				System.out.println("Flight successfully added");

				System.out.println("-----------------------------------------------------------------------------");
				
				System.out.println("******************Enter Details for Schedule Flight**************************");
				System.out.println("Enter schedule ID");
				String Scid = Cgutil.scan.nextLine();
				int scid = Integer.parseInt(Scid);
				System.out.println("Enter available seats");
				String Seat = Cgutil.scan.nextLine();
				int seat = Integer.parseInt(Seat);

				System.out.println("Enter source name");
				String src = Cgutil.scan.nextLine();
				System.out.println("Enter destination name");
				String dest = Cgutil.scan.nextLine();
				System.out.println("Enter arrival date");
				String date = Cgutil.scan.nextLine();
				System.out.println("Enter time");
				String time = Cgutil.scan.nextLine();
				LocalDateTime ltd = LocalDate.parse(date).atTime(LocalTime.parse(time));
				System.out.println("Enter time interval of departure");
				String hours = Cgutil.scan.nextLine();
				long hour = Long.parseLong(hours);

				obj.addScheduled(scid, id, seat, src, dest, ltd, hour);

				System.out.println("Success fully addded!");

			} catch (IDException | SeatException | InvalidFlightNameException | InvalidAirportException
					| ValidateException | DateTimeParseException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Press y to continue: ");
			opt = Cgutil.scan.nextLine();
		} while (opt.equals("y"));

	}

}
