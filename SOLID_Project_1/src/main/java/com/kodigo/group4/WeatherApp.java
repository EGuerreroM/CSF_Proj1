package com.kodigo.group4;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class WeatherApp {

    private String apiUrl;
    private URLConnection apiConnection;
    @Getter
    private String weatherForecast;


    public WeatherApp() {
        this.apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=Comalapa,sv&appid=f67eee1617ff9f66cb0b6e2cddff552c&units=metric";
        this.apiConnection = connectToApi();
        this.weatherForecast = weatherInformation();
    }

    public URLConnection connectToApi() {
        URL url;
        URLConnection apiConnection = null;

        try {
            url = new URL(apiUrl);
            apiConnection = url.openConnection();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return apiConnection;
    }

    public String weatherInformation() {
        StringBuilder result = new StringBuilder();
        Map<String, Object> windMap;
        Map<String, Object> mainMap;
        Map<String, Object> resMap;
        String weatherDescription;
        BufferedReader reader;
        String readLine;

        try {
            reader = new BufferedReader(new InputStreamReader(apiConnection.getInputStream()));

            while ((readLine = reader.readLine()) != null) {
                result.append(readLine);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        resMap = JsonConverter.jsonToMap(result.toString());
        mainMap = JsonConverter.jsonToMap(resMap.get("main").toString());
        windMap = JsonConverter.jsonToMap(resMap.get("wind").toString());
        weatherDescription = resMap.get("weather").toString().split(",")[2].split("=")[1];

        return weatherDescription + " temperature: " + mainMap.get("temp") + " C° and " + windMap.get("deg") + "° wind";
    }

}