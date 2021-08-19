package com.kodigo.group4;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class FlightRemover extends Flight{
    @Getter
    @Setter
    List<Flight> flightList_var = new ArrayList<Flight>();

    //adds a flight in a list of flights. version1
    void cancelFlight(Flight flight_par){
        flightList_var.remove(flight_par);
    }
    //version2
    /*void cancelFlight(String flightName){
        //flightList_var.remove(flight_par);
        //test lists of flights
        FlightLister flightLister_var = new FlightLister();
        List<Flight> flightList = new ArrayList<Flight>(); //Object List
        flightList = flightLister_var.listFlights();
        Flight flight_par = new Flight();
        flightList_var.remove(flight_par); //remove object of flight list, luego
    }
     */
}
