package com.kodigo.group4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    void testReadFile() {
        // Setup

        // Run the test
        excelFileUnderTest.readFile("filename");

        // Verify the results
        verify(excelFileUnderTest.flight).setFlightNumber("flightNumber");
        verify(excelFileUnderTest.flight).setAirline("airline");
        verify(excelFileUnderTest.flight).setAircraftType("aircraftType");
        verify(excelFileUnderTest.flight).setStatus("status");
        verify(excelFileUnderTest.flight).setOriginCountry("originCountry");
        verify(excelFileUnderTest.flight).setOriginCity("originCity");
        verify(excelFileUnderTest.flight).setDestinationCountry("destinationCountry");
        verify(excelFileUnderTest.flight).setDestinationCity("destinationCity");
        verify(excelFileUnderTest.flight).setDepartureDate("departureDate");
        verify(excelFileUnderTest.flight).setDepartureTime("departureTime");
        verify(excelFileUnderTest.flight).setArrivalDate("arrivalDate");
        verify(excelFileUnderTest.flight).setArrivalTime("arrivalTime");
        verify(excelFileUnderTest.flight).setIncident("incident");
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
