package com.kodigo.group4;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.PrimitiveIterator;

@Getter @Setter
public class Flight {
    private String flightNumber;
    private String status;
    private String originCountry;
    private String originCity;
    private String departureDate;
    private String departureTime;
    private String destinationCountry;
    private String destinationCity;
    private String arrivalDate;
    private String arrivalTime;
    private String planeStatus;
    private String incident;
    private String airline;
    private String aircraftType;

}
