package com.kodigo.group4;

import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class WeatherApp {

    public static String weatherInformationRetriever(String currentLocation){

        final String API_KEY ="f67eee1617ff9f66cb0b6e2cddff552c";
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q="+currentLocation+"&appid="+API_KEY+"&units=metric";


        try {
            // API connection section
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            //starting the connection with the Open Weather Map API by passing  the URL
            URLConnection urlConnection = url.openConnection();

            //Getting the Json output from the API
            //Reading all lines and adding them to String
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String readLine;
            while ((readLine = reader.readLine())!=null){
                result.append(readLine);

            }
            reader.close();

            // String to Map section
            resMap = mapConverter.jsonToMap(result.toString());
            mainMap = mapConverter.jsonToMap(resMap.get("main").toString());
            windMap = mapConverter.jsonToMap(resMap.get("wind").toString());

            weatherDescription=resMap.get("weather").toString().split(",")[2].split("=")[1];

            return weatherDescription+" temperature: "+ mainMap.get("temp")+" C° and "+windMap.get("deg")+"° wind";



        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return weatherDescription+" temperature: "+ mainMap.get("temp")+" C° and "+windMap.get("deg")+"° wind";
    }

    @Getter
    @Setter
    private static Map<String, Object> weatherMap;
    @Getter
    @Setter
    private static String airportWeatherStatus;
    @Getter
    @Setter
    private static Map<String, Object> windMap;
    @Getter
    @Setter
    private static Map<String, Object> mainMap;
    @Getter
    @Setter
    private static Map<String, Object> resMap;
    private static JsonConverter mapConverter;
    private static String weatherDescription;



}

