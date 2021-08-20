package com.kodigo.group4;

import javax.mail.Flags;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
    int userOption;

    Scanner scanner = new Scanner(System.in);

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
            System.out.println("5. Update a flight");
            System.out.println("6. Cancel a flight");
            System.out.println("7. Send email with list of flights");
            System.out.println("8. Exit menu.");
            try {
                System.out.print("Select and option: ");
                userOption = scanner.nextInt();
                flag = true;
            } catch (InputMismatchException e) {
                System.out.println("You must select an option.");

            }

        }

        return userOption;
    }



    public  boolean runMenu(int option){
        boolean flag = false;

        switch (option){

            case 1:
                System.out.println("Option 1");


                break;

            case 2:
                System.out.println("Option 2");

                break;
            case 3:
                System.out.println("Option 3");


                break;
            case 4:
                System.out.println("Option 3");


                break;
            case 5:
                System.out.println("Option 3");


                break;
            case 6:
                System.out.println("Option 3");


                break;
            case 7:
                System.out.println("Option 3");


                break;
            case 8:
                System.out.println("Option 8");
                flag = true;
                break;


        }

        return flag;



    }







}
