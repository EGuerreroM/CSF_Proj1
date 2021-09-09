package com.kodigo.group4;

import java.util.Scanner;

public class EmailHandler {
    Headers header = new Headers();
    Scanner scanner = new Scanner(System.in);
    Email email;

    public EmailHandler(Email email){
        this.email = email;
    }

    public Email requestEmailInformation(){
        header.showRequestEmailInformationHeader();
        System.out.println("Write the email address (xxxx@gmail.com): ");
        email.setRecipientEmail(scanner.next());
        System.out.println("Write the excel file name (no extension): ");
        email.getFile().setFileName(scanner.next());
        return email;
    }

}
