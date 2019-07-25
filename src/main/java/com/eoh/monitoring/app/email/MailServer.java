package com.eoh.monitoring.app.email;

import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Dumisani
 */
public class MailServer {

    public MailServer() {
    }

    public static void sendMail(String to, String name, String surname, String generatedPassword, String role) {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        //get Session   
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("noreplytesting95@gmail.com", "dU1@940128");
            }
        });

        //compose message    
        try {

            MimeMultipart multipart = new MimeMultipart("related");

            // first part  (the html)
            BodyPart messageBodyPart = new MimeBodyPart();

            String systemUrl = ((role.equals("Admin")) ? "http://localhost:4200" : "http://localhost:4200");

            String htmlText = "<p>Hi " + name + " " + surname + ", </p>"
                    + "<hr>"
                    + "<p>You are invited to access the Device Monitor Application.</p>"
                    + "<p>Please use the link below to access the system</p>"
                    + "<p>" + systemUrl + "</p>"
                    + "<hr>"
                    + "<p><b>Login Credentials</b></p>"
                    + "<p><b>Username:</b> " + to + "</p>"
                    + "<p><b>Password:</b> " + generatedPassword + "</p>"
                    + "<hr>"
                    + "<p>Sincerly.</p>"
                    + "<p>EOH Digital Team.</p>";
            messageBodyPart.setContent(htmlText, "text/html");
            multipart.addBodyPart(messageBodyPart);

            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Asset Monitor Login Credentials");
            message.setContent(multipart);

            //send message  
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }catch (NullPointerException e) {
            throw new RuntimeException("No internet access");
        }

    }

	public static void sendRequest(String subject, String userMessage, String email, String name, String surname) {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        //get Session   
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("noreplytesting95@gmail.com", "dU1@940128");
            }
        });

        //compose message    
        try {

            MimeMultipart multipart = new MimeMultipart("related");

            BodyPart messageBodyPart = new MimeBodyPart();

            String htmlText = "<p>Hi " + name + " " + surname + ", </p>"
                    + "<hr>"
                    + "<p>"+userMessage+".</p>"
                    + "<hr>"
                    + "<p>From: "+email
                    +".</p>"
                    + "<p>Sincerly.</p>"
                    + "<p>EOH Digital Team.</p>";
            messageBodyPart.setContent(htmlText, "text/html");
            multipart.addBodyPart(messageBodyPart);

            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("dumisa4ndhlovu@gmail.com"));
            message.setSubject(subject);
            message.setContent(multipart);

            //send message  
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }catch (NullPointerException e) {
            throw new RuntimeException("No internet access");
        }
	}

}
