package com.kodigo.group4;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Email {
    @Setter @Getter
    private String recipientEmail;
    @Setter @Getter
    private String senderEmail;
    @Setter @Getter
    private String senderEmailPassword;
    @Setter @Getter
    private String subject;
    @Setter @Getter
    private String message;
    @Getter
    private FileFactory file;
    @Setter @Getter
    private Date date = new Date();

    public Email(FileFactory file){
        this.senderEmail = "aeropuertoelsalvador@outlook.com";
        this.senderEmailPassword = "aeropuerto123456";
        this.file = file;
    }
}
