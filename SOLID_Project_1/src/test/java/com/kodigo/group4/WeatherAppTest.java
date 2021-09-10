package com.kodigo.group4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URLConnection;

import static org.junit.jupiter.api.Assertions.*;

class WeatherAppTest {

    private WeatherApp weatherAppUnderTest;

    @BeforeEach
    void setUp() {
        weatherAppUnderTest = new WeatherApp();
    }

    @Test
    void testConnectToApi() {
        // Setup

        // Run the test
        final URLConnection result = weatherAppUnderTest.connectToApi();

        // Verify the results
    }

}