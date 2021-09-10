package com.kodigo.group4;

import org.apache.xmlbeans.impl.store.Path;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Airport {

    public static void main(String[] args) {

        boolean isExitOption = false;
        int selectedOption;

        Menu airportMenu = new Menu();
        while (!isExitOption){
            selectedOption=airportMenu.selectOption();
            isExitOption=airportMenu.runMenu(selectedOption);
        }
    }
}
