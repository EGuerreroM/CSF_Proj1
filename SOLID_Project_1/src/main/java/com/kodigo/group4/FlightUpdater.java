package com.kodigo.group4;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class FlightUpdater extends Flight{
    @Getter
    @Setter
    List<Flight> flightList_var = new ArrayList<Flight>();
    //version1
    void updateFlight(String flightName){
        //flightList_var.remove(flight_par);
        //test lists of flights
        FlightLister flightLister_var = new FlightLister();
        List<Flight> flightList = new ArrayList<Flight>(); //Object List
        flightList = flightLister_var.listFlights();

        Flight flight_par = new Flight();

        for (Flight flight:flightList){
            if (flight.getFlightNumber().equals(flightName)){
                System.out.println("Encontrado");
            }
            System.out.println("flightNumber: " + flight.getFlightNumber() +" status: " + flight.getStatus());
        }

        //flightList_var.remove(flight_par); //remove object of flight list
    }
}