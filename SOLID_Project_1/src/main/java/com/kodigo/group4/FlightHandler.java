package com.kodigo.group4;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FlightHandler implements IAddFlight, IShowFlight, IUpdateFlight, ICancelFlight{
    WeatherApp weatherApp = new WeatherApp();
    Scanner scanner = new Scanner(System.in);

    @Override
    public Flight addFlight() {
        System.out.println("===================================");
        System.out.println("Please type the flight information:");
        System.out.println("===================================");
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

        return flight;
    }

    @Override
    public void showFlight(List<Flight> otherList) {
        System.out.println("==================================================================================================================================");
        System.out.println("*************************************************  showing flight data   **********************************************************");
        System.out.println("==================================================================================================================================");
        System.out.println();
        System.out.println("Weather conditions of the airport: " + weatherApp.weatherInformationRetriever("Comalapa,sv"));
        System.out.println();
        System.out.println("==================================================================================================================================");
        System.out.println("Flight Number - Airline - Aircraft - Status - Origin (Country/City) - Destination (Country/City) - Departure Date/Time - Arrival Date/Time - Incidents -");
        Iterator<Flight> iterator = otherList.iterator();
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
    public void updateFlight(List<Flight> otherList,String find,String status, String arrivalDate, String arrivalTime) {
        Iterator<Flight> iterator = otherList.iterator();
        while (iterator.hasNext()) {
            Flight flight1 = iterator.next();
            if (flight1.getFlightNumber().equals(find)) {
                flight1.setStatus(status);
                flight1.setArrivalDate(arrivalDate);
                flight1.setArrivalTime(arrivalTime);
            }
        }
        System.out.println("Flight updated successfully...");
    }

    @Override
    public void cancelFlight(List<Flight> otherList, String find, String reason) {
        Iterator<Flight> iterator = otherList.iterator();
        while (iterator.hasNext()) {
            Flight flight1 = iterator.next();
            if (flight1.getFlightNumber().equals(find)) {
                flight1.setStatus("CANCELED");
                flight1.setArrivalDate("--/--/----");
                flight1.setArrivalTime("--:--:--");
                flight1.setIncident(reason);
            }
        }
        System.out.println("Flight canceled successfully...");
    }
}
