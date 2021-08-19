package com.kodigo.group4;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlightManualAdder extends Flight{
    @Getter
    @Setter
    List<Flight> flightList_var = new ArrayList<Flight>();

    //adds a flight in a list of flights. version 1
    /*
    void addFlight(Flight flight_par){
        flightList_var.add(flight_par);
    }
    */
    //version2
    void addFlight(Flight flight_par){
        flightList_var.add(flight_par);

        //create file
        /*try {
            File myObj = new File("file_flights.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred during creation of file.");
            e.printStackTrace();
        }
         */

        try {
            FileWriter myWriter = new FileWriter("file_flights.txt",true);
            myWriter.write("\n" +flight_par.getFlightNumber()+","+flight_par.getStatus());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred during writing file.");
            e.printStackTrace();
        }
    }

}