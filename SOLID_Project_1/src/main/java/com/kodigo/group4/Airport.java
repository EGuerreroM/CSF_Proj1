package com.kodigo.group4;

public class Airport {

    public static void main(String[] args) {

        //EmailSender email = new EmailSender();
        //email.sendEmail("hectorjmon@hotmail.com","None");
        //WeatherApp weather = new WeatherApp();
        //System.out.println(weather.weatherInformationRetriever("Comalapa,sv"));
        boolean flag = false;
        int selectedOption;

        while (!flag){

            Menu airportMenu = new Menu();
            selectedOption=airportMenu.selectOption();
            flag=airportMenu.runMenu(selectedOption);

        }


    }


}
