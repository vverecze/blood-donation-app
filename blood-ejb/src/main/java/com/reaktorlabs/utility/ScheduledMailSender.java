package com.reaktorlabs.utility;

import com.reaktorlabs.model.SentEmail;
import com.reaktorlabs.model.User;
import com.reaktorlabs.service.SentEmailInterface;
import com.reaktorlabs.service.UserDataInterface;
import java.time.LocalDate;
import java.util.Map;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Viki
 */
@Stateless
public class ScheduledMailSender {
    private UserDataInterface userDataService;
    private MailSenderService mail;
    private SentEmailInterface sentEmailService;
    
    public ScheduledMailSender(){}

    @Inject
    public ScheduledMailSender(UserDataInterface userDataService, MailSenderService mail, SentEmailInterface sentEmailService) {
        this.userDataService = userDataService;
        this.mail = mail;
        this.sentEmailService = sentEmailService;
    }
    
    @Schedule(hour = "0", minute = "5", second = "0")
    public void sendDonationMail() {
        Map<Long, String> mailMap = userDataService.getSendEmailToWho();
        
        for (Map.Entry<Long, String> address : mailMap.entrySet()) {
            mail.send(address.getValue(), "Értesítő véradásról", "Örömmel értesítünk, hogy mától újra adhatsz vért, és ezzel segíthetsz három betegen.");
            
            User user = userDataService.getUserByEmail(address.getValue());
            SentEmail sentEmail = new SentEmail();
            sentEmail.setUser(user);
            LocalDate today = LocalDate.now();
            sentEmail.setSentTime(today);
            
            sentEmailService.createSentEmail(sentEmail);
        }
    }

    public UserDataInterface getUserDataService() {
        return userDataService;
    }

    public void setUserDataService(UserDataInterface userDataService) {
        this.userDataService = userDataService;
    }

    public MailSenderService getMail() {
        return mail;
    }

    public void setMail(MailSenderService mail) {
        this.mail = mail;
    }

    public SentEmailInterface getSentEmailService() {
        return sentEmailService;
    }

    public void setSentEmailService(SentEmailInterface sentEmailService) {
        this.sentEmailService = sentEmailService;
    }
    
    
}
