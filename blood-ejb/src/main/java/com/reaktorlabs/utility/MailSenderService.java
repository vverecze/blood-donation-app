package com.reaktorlabs.utility;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.logging.Level;
import java.util.logging.Logger;
 
@Stateless
public class MailSenderService {
    @Resource(name = "java:jboss/mail/gmail")
    private Session session;
 
    public void send(String addresses, String topic, String textMessage) {
 
        try {
 
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("myapp.blood.donation@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(addresses));
            message.setSubject(topic);
            message.setText(textMessage);
 
            Transport.send(message);
 
        } catch (MessagingException e) {
            Logger.getLogger(MailSenderService.class.getName()).log(Level.WARNING, "Cannot send mail", e);
        }
    }
}
