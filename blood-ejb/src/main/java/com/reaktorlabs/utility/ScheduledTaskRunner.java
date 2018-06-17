package com.reaktorlabs.utility;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author Viki
 */
@Singleton
@Startup
public class ScheduledTaskRunner {
    private ScheduledMailSender sendingMail;
    
    public ScheduledTaskRunner(){}
    
    @Inject
    public ScheduledTaskRunner(ScheduledMailSender sendingMail) {
        this.sendingMail = sendingMail;
    }
    
    @PostConstruct
    public void init(){
        sendingMail.sendDonationMail();
    }

    public ScheduledMailSender getSendingMail() {
        return sendingMail;
    }

    public void setSendingMail(ScheduledMailSender sendingMail) {
        this.sendingMail = sendingMail;
    }
    
    
}
