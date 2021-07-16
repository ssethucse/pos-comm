package com.pos.comm.poscomm.service;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Service
public class EmailService {
    public String sendMail(String to, String message) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("posmailers@gmail.com", "Pos@1234");
                }
            });
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("posmailers@gmail.com", false));

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject("Recovered Email Password");
            msg.setContent("Temporary Password=" + message, "text/html");
            msg.setSentDate(new Date());
            Transport.send(msg);
            return "Mail Sent Successfully";
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Mail Failed";
        }
    }
}
