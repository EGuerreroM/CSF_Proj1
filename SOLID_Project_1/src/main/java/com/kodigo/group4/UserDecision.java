package com.kodigo.group4;


import lombok.AllArgsConstructor;

import java.util.Locale;


@AllArgsConstructor
public class UserDecision {

    public static boolean makeDecision(String userDecision){
        boolean flag = false;
        while (flag ==false){

            if (userDecision.toLowerCase() == "y"){
                flag = true;
                return false;

            }
            if (userDecision.toLowerCase() == "n"){
                flag =true;
                return true;
            }
            else{
                System.out.println("Choose a valid answer. ");
                flag = false;
            }
        }

        return true;
    }


}
