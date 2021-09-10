package com.kodigo.group4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExcelFileTest {


    private ExcelFile excelFileUnderTest;

    @BeforeEach
    void setUp() {
        excelFileUnderTest = new ExcelFile();
        excelFileUnderTest.weatherApp = mock(WeatherApp.class);
        excelFileUnderTest.flight = mock(Flight.class);
        excelFileUnderTest.separator = "separator";
    }


    @Test
    void testCreateFile() {
        // Setup
        final Flight flight = new Flight();
        flight.setFlightNumber("flightNumber");
        flight.setStatus("status");
        flight.setOriginCountry("originCountry");
        flight.setOriginCity("originCity");
        flight.setDepartureDate("departureDate");
        flight.setDepartureTime("departureTime");
        flight.setDestinationCountry("destinationCountry");
        flight.setDestinationCity("destinationCity");
        flight.setArrivalDate("arrivalDate");
        flight.setArrivalTime("arrivalTime");
        final List<Flight> list = List.of(flight);
        when(excelFileUnderTest.weatherApp.getWeatherForecast()).thenReturn("result");

        // Run the test
        excelFileUnderTest.createFile(list);

        // Verify the results
    }
}