package com.kodigo.group4;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Aircraft extends Airline  {
    private String model;
    private int passengerCapacity;
    private double range;
    private int manufacturingYear;

    public Aircraft(int code, String name, String model, int passengerCapacity, double range, int manufacturingYear) {
        super(code, name);
        this.model = model;
        this.passengerCapacity = passengerCapacity;
        this.range = range;
        this.manufacturingYear = manufacturingYear;
    }

    public String showInformation(){

        return "The Aircraft model is " + model + ", its passenger capacity is " + passengerCapacity + ", the range is " + range + " and the manufacturing year is " + manufacturingYear;

    }
}
