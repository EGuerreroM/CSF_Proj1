package com.kodigo.group4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
