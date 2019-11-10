package ru.openbank.service;

import ru.openbank.service.behavior.Sender;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * Created by Елена on 04.11.2019.
 */
@Service
public class MailSender implements Sender {
    private final String username = "open.coffee.bot@gmail.com";
    private final String password = "coffee-bot1987";

    private final String sender = "open.coffee.bot@gmail.com";

    private final String host = "smtp.gmail.com";
    private final String port = "465";

    Properties properties = System.getProperties();

    public MailSender() {
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", port);
        properties.put("mail.smtp.user", username);
        properties.put("mail.smtp.pwd", password);
    }


    public void send(String recipient, String text) {
        System.out.println(recipient + ":\n" + text);
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Приглашение");
            message.setText(text);

            Transport.send(message);
            System.out.println("Email Sent successfully....");
        } catch (MessagingException err) {
            err.printStackTrace();
        }
    }

    public void cancel() {

    }
}
