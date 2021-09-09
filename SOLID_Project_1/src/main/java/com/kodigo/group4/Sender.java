package com.kodigo.group4;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class Sender {
    private Email email;

    public Sender(Email email){
        this.email = email;
        this.email.setSubject("Flight(s) information");
        this.email.setMessage("Greetings, Dear Client. \n" +
                "As you selected, attached you can find a file which " +
                "contains information about the flight/day you chosen. \n" +
                "Thanks for using the Airport of El Salvador System.");
    }

    public void sendEmail(){
        System.out.println("Initializing email...");
        createEmailBody();
    }

    public Properties setEmailProperties(){
        Properties props = null;
        if (props == null) {
            props = new Properties();
            props.put("mail.smtp.auth", true);
            props.put("mail.smtp.starttls.enable", true);
            props.put("mail.smtp.ssl.protocols", "TLSv1.2");
            props.put("mail.smtp.host", "smtp.live.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.user", email.getSenderEmail());
            props.put("mail.smtp.pwd", email.getSenderEmailPassword());
        }
        return props;
    }

    public Session getEmailSession(){
        Session session = Session.getInstance(setEmailProperties(),
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email.getSenderEmail(), email.getSenderEmailPassword());
                    }
                });
        return session;
    }

    public void createEmailBody(){
        try{
            Message message = new MimeMessage(getEmailSession());
            message.setFrom(new InternetAddress(email.getSenderEmail()));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email.getRecipientEmail()));
            message.setSubject(email.getSubject());
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(email.getMessage());
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            String filename = "GeneratedFiles/" + email.getFile().getFileName() + ".xlsx";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            Transport.send(message);
            Notificacions.success("Email");
        }catch (MessagingException e){
            Notificacions.error("Email");
        }
    }

}
