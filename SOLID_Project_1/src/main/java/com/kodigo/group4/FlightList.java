package com.kodigo.group4;

import java.util.ArrayList;
import java.util.List;

public class FlightList {
    private static List<Flight> flightList = new ArrayList<>();

    public static List<Flight> getFlightList() {
        return flightList;
    }

    public static void addFlightToList(Flight flight){
        flightList.add(flight);
    }

}
