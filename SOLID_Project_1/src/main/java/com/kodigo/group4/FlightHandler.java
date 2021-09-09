package com.kodigo.group4;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class FlightHandler implements IAddFlight, IShowFlight, IUpdateFlight, ICancelFlight{
    //WeatherApp weatherApp = new WeatherApp();
    Scanner scanner = new Scanner(System.in);
    //FlightList flightDB = new FlightList();
    //List<Flight> flightList = flightDB.getFlightList();
    Headers header = new Headers();
    String flightNumber;

    @Override
    public void addFlight() {
        header.showAddFlightHeader();
        Flight flight = new Flight();
        System.out.print("Flight Number: ");
        flight.setFlightNumber(scanner.nextLine());
        System.out.print("Airline: ");
        flight.setAirline(scanner.nextLine());
        System.out.print("Aircraft Type: ");
        flight.setAircraftType(scanner.nextLine());
        System.out.print("Flight status: ");
        flight.setStatus(scanner.nextLine());
        System.out.print("Country of origin: ");
        flight.setOriginCountry(scanner.nextLine());
        System.out.print("City of origin: ");
        flight.setOriginCity(scanner.nextLine());
        System.out.print("Departure date: (dd/mm/yyyy) ");
        flight.setDepartureDate(scanner.nextLine());
        System.out.print("Departure time: (hh:mm:ss)");
        flight.setDepartureTime(scanner.nextLine());
        System.out.print("Country of destination: ");
        flight.setDestinationCountry(scanner.nextLine());
        System.out.print("City of destination: ");
        flight.setDestinationCity(scanner.nextLine());
        System.out.print("Arrival date: (dd/mm/yyyy) ");
        flight.setArrivalDate(scanner.nextLine());
        System.out.print("Arrival time: (hh:mm:ss)");
        flight.setArrivalTime(scanner.nextLine());
        System.out.print("Any incident?: ");
        flight.setIncident(scanner.nextLine());
        FlightList.addFlightToList(flight);
    }

    @Override
    public void showFlight() {
        header.showFlightsHeader();
        Iterator<Flight> iterator = FlightList.getFlightList().iterator();
        while(iterator.hasNext()){
            Flight flight1 = iterator.next();
            System.out.println(
                    flight1.getFlightNumber() + " - "
                    + flight1.getAirline() + " - "
                    + flight1.getAircraftType() + " - "
                    + flight1.getStatus() + " - "
                    + flight1.getOriginCountry()+ "/"
                    + flight1.getOriginCity() + " - "
                    + flight1.getDestinationCountry()+ "/"
                    + flight1.getDestinationCity() + " - "
                    + flight1.getDepartureDate()+ "/"
                    + flight1.getDepartureTime()+ " - "
                    + flight1.getArrivalDate()+ "/"
                    + flight1.getArrivalTime() + " - "
                    + flight1.getIncident()
            );
        }
    }

    @Override
    public boolean verifyIfExist(List<Flight> otherList,String find) {
        boolean flag = false;
        Iterator<Flight> iterator = otherList.iterator();
        while (iterator.hasNext()) {
            Flight flight1 = iterator.next();
            if (flight1.getFlightNumber().equals(find)) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void updateFlight() {
        Flight flight = new Flight();
        header.showUpdateFlightHeader();
        flightNumber = scanner.next();
        if (verifyIfExist(FlightList.getFlightList(), flightNumber)) {
            System.out.print("Type the new status: ");
            flight.setStatus(scanner.next());
            System.out.print("Type the new Arrival date (dd/mm/yyyy): ");
            flight.setArrivalDate(scanner.next());
            System.out.print("Type the new Arrival time (hh:mm:ss): ");
            flight.setArrivalTime(scanner.next());
        } else {
            System.out.println("Error: Can not find the flight...");
        }
        Iterator<Flight> iterator = FlightList.getFlightList().iterator();
        while (iterator.hasNext()) {
            Flight flight1 = iterator.next();
            if (flight1.getFlightNumber().equals(flightNumber)) {
                flight1.setStatus(flight.getStatus());
                flight1.setArrivalDate(flight.getArrivalDate());
                flight1.setArrivalTime(flight.getArrivalTime());
                Notificacions.success("Flight Update");
            }
        }
    }

    @Override
    public void cancelFlight() {
        header.showCancelFlightHeader();
        flightNumber = scanner.next();
        String reason="";
        if (verifyIfExist(FlightList.getFlightList(), flightNumber)) {
            System.out.println("Write the reason to cancel: ");
            scanner.nextLine();
            reason = scanner.nextLine();
        } else {
            System.out.println("Can not find the flight...");
        }
        Iterator<Flight> iterator = FlightList.getFlightList().iterator();
        while (iterator.hasNext()) {
            Flight flight1 = iterator.next();
            if (flight1.getFlightNumber().equals(flightNumber)) {
                flight1.setStatus("CANCELED");
                flight1.setArrivalDate("--/--/----");
                flight1.setArrivalTime("--:--:--");
                flight1.setIncident(reason);
            }
        }
        System.out.println("Flight canceled successfully...");
    }
}
