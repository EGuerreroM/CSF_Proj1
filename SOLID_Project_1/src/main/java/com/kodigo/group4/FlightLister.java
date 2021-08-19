package com.kodigo.group4;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlightLister extends Flight{
    @Getter
    @Setter
    List<Flight> flightList_var = new ArrayList<Flight>();

    //return a list of flights
    //version1
    /*List<Flight> listFlights(){
        for (Flight flight:flightList_var){
            flight.getFlightNumber();
            System.out.println(flight.getFlightNumber());
        }
        return flightList_var;
    }
    */
    //version2
    List<Flight> listFlights(){

        try {
            File myObj = new File("file_flights.txt");
            Scanner myReader = new Scanner(myObj);

            if (myObj.exists()) {
                System.out.println("File name: " + myObj.getName());
                /*System.out.println("Absolute path: " + myObj.getAbsolutePath());
                System.out.println("Writeable: " + myObj.canWrite());
                System.out.println("Readable " + myObj.canRead());
                System.out.println("File size in bytes " + myObj.length());*/
            } else {
                System.out.println("The file does not exist.");
            }

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();// get a line file (a flight)
                //System.out.println(line);
                String [] cutString = line.split(",");		//get flight data
                Flight flight_read = new Flight();	// create a object FLight

                //set attributes of fLight object
                flight_read.setFlightNumber(cutString[0]);
                flight_read.setStatus(cutString[1]);

                // add object Flight to ArrayList
                flightList_var.add(flight_read);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred during reading file.");
            e.printStackTrace();
        }

        return flightList_var;
    }

}