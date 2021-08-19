package com.kodigo.group4;


import lombok.AllArgsConstructor;

import java.util.InputMismatchException;
import java.util.Scanner;

@AllArgsConstructor
public class Menu {



    public static void runMenu(){
        int userInput;
        boolean flag = false;
        String userDecision;

        Scanner scanner = new Scanner(System.in);
        UserDecision newDecision = new UserDecision();

        System.out.println("===============================");
        System.out.println("---------Flight System---------");
        System.out.println("===============================");

        while (flag == false){

            System.out.println("1. Enter flights manually");
            System.out.println("2. Enter flights through excel file");
            System.out.println("3. Show list of flights");
            System.out.println("4. Export list of flights into a excel file");
            System.out.println("5. Update a flight");
            System.out.println("6. Cancel a flight");
            System.out.println("7. Send email with list of flights");

            try {
                System.out.print("Select and option: ");
                userInput = scanner.nextInt();

                switch ( userInput){
                    case 1:
                        System.out.println("Caso 1");

                        System.out.println("Whould you like to make another operation");
                        System.out.println("Y:yes \n N:No");
                        userDecision = scanner.nextLine();

                        flag=newDecision.makeDecision(userDecision);

                        break;
                    case 2:
                        System.out.println("Caso 2");

                        System.out.println("Whould you like to make another operation");
                        System.out.println("Y:yes \n N:No");
                        userDecision = scanner.nextLine();

                        flag=newDecision.makeDecision(userDecision);

                        break;
                    case 3:
                        System.out.println("Caso 3");

                        System.out.println("Whould you like to make another operation");
                        System.out.println("Y:yes \n N:No");
                        userDecision = scanner.nextLine();

                        flag=newDecision.makeDecision(userDecision);
                        break;
                    case 4:
                        System.out.println("Caso 4");

                        System.out.println("Whould you like to make another operation");
                        System.out.println("Y:yes \n N:No");
                        userDecision = scanner.nextLine();

                        flag=newDecision.makeDecision(userDecision);
                        break;
                    case 5:
                        System.out.println("Caso 5");

                        System.out.println("Whould you like to make another operation");
                        System.out.println("Y:yes \n N:No");
                        userDecision = scanner.nextLine();

                        flag=newDecision.makeDecision(userDecision);
                        break;
                    case 6:
                        System.out.println("Caso 6");

                        System.out.println("Whould you like to make another operation");
                        System.out.println("Y:yes \n N:No");
                        userDecision = scanner.nextLine();

                        flag=newDecision.makeDecision(userDecision);
                        break;
                    case 7:
                        System.out.println("Caso 7");

                        System.out.println("Whould you like to make another operation");
                        System.out.println("Y:yes \n N:No");
                        userDecision = scanner.nextLine();

                        flag=newDecision.makeDecision(userDecision);
                        break;
                    default:
                        System.out.println("Select a correct option");
                }

            } catch (InputMismatchException e) {
                System.out.println("You must select an option.");

            }


        }

    }







}
