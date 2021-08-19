package com.kodigo.group4;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
public class FlightAutomaticAdder extends Flight{
    @Getter
    @Setter
    List<Flight> flightList = new ArrayList<Flight>();

    //adds a lot of flights a list of flights
    /*void importFlight(Flight flight_parameter, int quantity){
        for(int i = 0;i<quantity;i++) {
            flightList.add(flight_parameter);
        }
    }

    public void importFile(){
        FildeHandler f=new FildeHandler();
        f.openFile();
    }

     */
}
