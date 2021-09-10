package com.kodigo.group4;

import lombok.Getter;
import lombok.Setter;

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
    private FileObject file;

    public Email(FileObject file){
        this.senderEmail = "aeropuertoelsalvador@outlook.com";
        this.senderEmailPassword = "aeropuerto123456";
        this.file = file;
    }
}
