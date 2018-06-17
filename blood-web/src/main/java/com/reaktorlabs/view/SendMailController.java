package com.reaktorlabs.view;

import com.reaktorlabs.model.SentEmail;
import com.reaktorlabs.model.User;
import com.reaktorlabs.service.SentEmailInterface;
import com.reaktorlabs.service.UserDataInterface;
import com.reaktorlabs.utility.MailSenderService;
import java.time.LocalDate;
import java.util.Map;
import javax.ejb.Schedule;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Viki
 */
@RequestScoped
@Named(value = "sendMailController")
public class SendMailController {
    private UserDataInterface userDataService;
    private MailSenderService mail;
    private SentEmailInterface sentEmailService;

    @Inject
    public SendMailController(UserDataInterface userDataService, MailSenderService mail, SentEmailInterface sentEmailService) {
        this.userDataService = userDataService;
        this.mail = mail;
        this.sentEmailService = sentEmailService;
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
