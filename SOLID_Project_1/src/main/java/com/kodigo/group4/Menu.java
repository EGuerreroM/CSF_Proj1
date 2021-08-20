package com.kodigo.group4;

import jdk.swing.interop.SwingInterOpUtils;

import javax.mail.Flags;
import java.io.File;
import java.util.*;

public class Menu {
    List<Flight> list = new ArrayList<>();
    int userOption;
    Scanner scanner = new Scanner(System.in);
    String word;
    FlightHandler flightHandler = new FlightHandler();
    FileHandler fileHandler = new FileHandler();

    public int selectOption(){
        boolean flag  = false;

        System.out.println("===============================");
        System.out.println("---------Flight System---------");
        System.out.println("===============================");

        while (!flag){

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

    public  boolean runMenu(int option){
        boolean flag = false;
        switch (option){
            case 1:
                list.add(flightHandler.addFlight());
                break;
            case 2:
                System.out.println("Write the file name (no extension): ");
                String fileName = scanner.next() + ".xlsx";
                list = fileHandler.openFile(fileName);
                //flightHandler.addFlightFromFile(list,fileName);
                break;
            case 3:
                flightHandler.showFlight(list);
                break;
            case 4:
                fileHandler.createExcelFile(list);
                break;
            case 5:
                System.out.println("=======================================");
                System.out.print("Please write the flight number to Update: ");
                System.out.println("=======================================");
                word = scanner.next();
                if (flightHandler.verifyIfExist(list,word)){
                    System.out.print("Type the new status: ");
                    String status = scanner.next();
                    System.out.print("Type the new Arrival date (dd/mm/yyyy): ");
                    String arrivalDate = scanner.next();
                    System.out.print("Type the new Arrival time (hh:mm:ss): ");
                    String arrivalTime = scanner.next();
                    flightHandler.updateFlight(list,word,status,arrivalDate,arrivalTime);
                }else {
                    System.out.println("Can not find the flight...");
                }
                break;
            case 6:
                System.out.println("=======================================");
                System.out.println("Please write the flight number to cancel: ");
                word = scanner.next();
                if (flightHandler.verifyIfExist(list,word)){
                    System.out.println("Write the reason to cancel: ");
                    scanner.nextLine();
                    String reason = scanner.nextLine();
                    flightHandler.cancelFlight(list,word,reason);
                }else {
                    System.out.println("Can not find the flight...");
                }
                break;
            case 7:
                System.out.println("========================");
                System.out.println("Send email.");
                System.out.println("========================");
                System.out.println("Write the email address (xxxx@gmail.com): ");
                String email = scanner.next();
                System.out.println("Write the excel file name (no extension): ");
                String file = scanner.next();
                EmailSender emailSender = new EmailSender();
                emailSender.sendEmail(email,file);
                break;
            case 8:
                System.out.println("Closing system...");
                flag = true;
                break;
        }
        return flag;
    }

}
