package com.kodigo.group4;

import org.apache.xmlbeans.impl.store.Path;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Airport {

    public static void main(String[] args) {

        //EmailSender email = new EmailSender();
        //email.sendEmail("hectorjmon@hotmail.com","None");
        //WeatherApp weather = new WeatherApp();
        //System.out.println(weather.weatherInformationRetriever("Comalapa,sv"));
        boolean flag = false;
        int selectedOption;

        Menu airportMenu = new Menu();
        while (!flag){
            selectedOption=airportMenu.selectOption();
            flag=airportMenu.runMenu(selectedOption);
        }
    }
}
