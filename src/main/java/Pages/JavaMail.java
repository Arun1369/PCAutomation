package Pages;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import BasePackage.DriverClass;

public class JavaMail extends DriverClass{
	
	

public static void main(String[] args) {

    final String username = "arun.nichi@gmail.com";
    final String password = "Password_";

    Properties props = new Properties();
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

    try {
    	Date date = new Date();
    	
    	
    	
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("arun.nichi@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("arun.pv@nichi.com"));
        message.setRecipients(Message.RecipientType.CC,
                InternetAddress.parse("ramanna.hemareddy1@nichi.com"));
        message.setRecipients(Message.RecipientType.BCC,
                InternetAddress.parse("smacteamnichi@gmail.com"));
        message.setSubject("PepperCloud CRM - Automation Test Report" + " " +date.toGMTString());
        message.setText("PFA");

        MimeBodyPart messageBodyPart = new MimeBodyPart();

        Multipart multipart = new MimeMultipart();

        messageBodyPart = new MimeBodyPart();
        String file = "D:\\PepperCloud Automation\\PCAutomationScript\\test-output\\emailable-report.html";
        String fileName = "PC Automation Test Report";
        DataSource source = new FileDataSource(file);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(fileName);
        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);

        System.out.println("Sending");

        Transport.send(message);

        System.out.println("Done");

    } catch (MessagingException e) {
        e.printStackTrace();
    }
  }
}
	

