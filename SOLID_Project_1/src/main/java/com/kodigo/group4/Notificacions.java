package com.kodigo.group4;

public class Notificacions {
    public static void success(String name){
        System.out.println("=======================================");
        System.out.println(name+": Action performed successfully...");
        System.out.println("=======================================");
    }

    public static void error(String name){
        System.out.println("=======================================");
        System.out.println(name+": Error performing action, please try again...");
        System.out.println("=======================================");
    }
}
