package ru.openbank.service;

import ru.openbank.service.behavior.Sender;

import javax.mail.*;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Елена on 04.11.2019.
 */
@Service
public class MailSender implements Sender {
    private final String username="leptidia";
    private final String password="od8nbld5d";

    private final String sender = "leptidia@mail.ru";

    private final String host = "smtp.mail.ru";
    private final String port = "465";
    private final String savingPath = "D:/invitation";
    private String recipient;
    Properties properties = System.getProperties();

    public MailSender()
    {
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", port);
        properties.put("mail.smtp.user", username);
        properties.put("mail.smtp.pwd", password);
    }


    public void send(String recipient, String text) {
        System.out.println(recipient+":\n"+text);

        this.recipient=recipient;

//        Session session = Session.getInstance(properties, new Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//        });
//
//        try {
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(sender));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
//            message.setSubject("Приглашение");
//            message.setText(text);
////
////            String fileName = "Invitation.ics";
////            DataSource source = new FileDataSource(createAttach());
////            MimeBodyPart messageBodyPart = new MimeBodyPart();
////            Multipart multipart = new MimeMultipart();
////            messageBodyPart.setDataHandler(new DataHandler(source));
////            messageBodyPart.setFileName(fileName);
////            multipart.addBodyPart(messageBodyPart);
////
////            message.setContent(multipart);
//
//            Transport.send(message);
//            System.out.println("Email Sent successfully....");
//
//            removeFile();
//        }
//        catch (MessagingException err){
//            err.printStackTrace();
//        }
    }


    public File createAttach() {

        String sendTo = recipient.substring(recipient.indexOf('@'));
        File file = new File(savingPath+recipient+".ics");
        try
        {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            String text = "BEGIN:VCALENDAR\n" +
                    "BEGIN:VEVENT\n" +
                    "SUMMARY:Meeting invitation\n" +
                    "DTSTART;VALUE=DATE-TIME:"+(new Date().getTime()+80000)+"\n" +
                    "UID:"+sendTo+"\n" +
                    "LOCATION:Conference room\n" +
                    "ORGANIZER:MAILTO:"+sender+"\n" +
                    "END:VEVENT\n" +
                    "END:VCALENDAR";
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return file;
    }


    public void cancel() {

    }
    private void removeFile()
    {
        File file = new File(savingPath+recipient+".ics");
        file.delete();
    }
}
