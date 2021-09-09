package com.kodigo.group4;

import jdk.swing.interop.SwingInterOpUtils;

import javax.mail.Flags;
import java.io.File;
import java.util.*;

public class Menu {
    //List<Flight> list = new ArrayList<>();
    int userOption;
    Scanner scanner = new Scanner(System.in);
    String flightNumber;
    FlightHandler flightHandler = new FlightHandler();
    FileHandler fileHandler = new FileHandler();


    public int selectOption() {
        boolean flag = false;

        System.out.println("===============================");
        System.out.println("---------Flight System---------");
        System.out.println("===============================");

        while (!flag) {

            System.out.println("1. Enter flights manually");
            System.out.println("2. Enter flights through excel file");
            System.out.println("3. Show list of flights");
            System.out.println("4. Export list of flights into a excel file");
            System.out.println("5. Update status/arrival date-time of a flight");
            System.out.println("6. Cancel a flight");
            System.out.println("7. Send email with list of flights");
            System.out.println("8. Exit menu.");
            try {
                System.out.print("Select and option: ");
                userOption = scanner.nextInt();
                flag = true;
            } catch (InputMismatchException e) {
                System.out.println("You must select an option. ");
                scanner.next();
            }
        }
        return userOption;
    }

    public boolean runMenu(int option) {
        boolean flag = false;
        switch (option) {
            case 1:
                flightHandler.addFlight();
                break;
            case 2:
                FileHandler fileHandler = new FileHandler();
                fileHandler.requestInformation();
                break;
            case 3:
                flightHandler.showFlight();
                break;
            case 4:
                //fileHandler.createExcelFile(list);
                break;
            case 5:
                flightHandler.updateFlight();
                break;
            case 6:
                flightHandler.cancelFlight();
                break;
            case 7:
                EmailHandler handler = new EmailHandler(new Email(new FileFactory()));
                Sender sender = new Sender(handler.requestEmailInformation());
                sender.sendEmail();
                break;
            case 8:
                System.out.println("Closing system...");
                flag = true;
                break;
        }
        return flag;

    }

}
