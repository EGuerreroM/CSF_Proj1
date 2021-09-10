package com.kodigo.group4;

public class Header {

    public void showMenuHeader(){
        System.out.println("===============================");
        System.out.println("---------Flight System---------");
        System.out.println("===============================");
    }

    public void showAddFlightHeader(){
        System.out.println("===================================");
        System.out.println("Please type the flight information:");
        System.out.println("===================================");
    }

    public void showFlightsHeader(){
        WeatherApp weatherApp = new WeatherApp();
        System.out.println("==================================================================================================================================");
        System.out.println("*************************************************  showing flight data   **********************************************************");
        System.out.println("==================================================================================================================================");
        System.out.println();
        System.out.println("Weather conditions of the airport: " + weatherApp.getWeatherForecast());
        System.out.println();
        System.out.println("==================================================================================================================================");
        System.out.println("Flight Number - Airline - Aircraft - Status - Origin (Country/City) - Destination (Country/City) - Departure Date/Time - Arrival Date/Time - Incidents -");
    }

    public void showUpdateFlightHeader(){
        System.out.println("=======================================");
        System.out.println("Please write the flight number to Update: ");
        System.out.println("=======================================");
    }

    public void showCancelFlightHeader(){
        System.out.println("=======================================");
        System.out.println("Please write the flight number to cancel: ");
    }

    public void showRequestEmailInformationHeader(){
        System.out.println("========================");
        System.out.println("Send email.");
        System.out.println("========================");
    }

    public void showAddInformationFileHeader(){
        System.out.println("========================");
        System.out.println("Upload a file.");
        System.out.println("========================");
    }
    public void showExportFileHeader(){
        System.out.println("========================");
        System.out.println("Export flights to File.");
        System.out.println("========================");
    }

}
