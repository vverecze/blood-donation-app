package com.reaktorlabs.view;

import com.reaktorlabs.model.User;
import com.reaktorlabs.service.UserDataInterface;
import com.reaktorlabs.utility.MailSenderService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Viki
 */
@RequestScoped
@Named(value = "userDataController")
public class UserDataController {
    private User user;
    private UserDataInterface userDataService;
    private MailSenderService mail;
    private String alert;
    
    @Inject
    private HttpServletRequest servletRequest;

    @Inject
    public UserDataController(UserDataInterface userDataService, MailSenderService mail) {
        this.user = new User();
        this.mail = mail;
        this.userDataService = userDataService;
    }
    
    public String updateUserData() {
        userDataService.updateUser(user);
        return "/user/main.xhtml";
    }

    @PostConstruct
    public void setUserById() {
        User myUser = userDataService.getUserByEmail(this.getUserEmailFromSession());
        user = myUser;
        this.sendAlert();
    }
    
    private String getUserEmailFromSession() {
        HttpSession mySession = servletRequest.getSession();
        return (String)mySession.getAttribute("user_email");
    }
    
    private void sendAlert() {
        String userEmail = this.getUserEmailFromSession();
        List<String> emailList = userDataService.getSendAlertToWho();
        
        for (int i = 0; i < emailList.size(); i++) {
            if(emailList.get(i).equals(userEmail)) {
                this.setAlert("<div class='donation-alert'>Már újra adhatsz vért és segíthetsz három betegen!</div>");
            }
        }
    }
    
    /*
    public void sendMailToUser() {
        mail.send("holdacska.c02a@gmail.com", "tesztmail", "proba blood2");
    }
    */

    public void sendMailToUsers() {
        userDataService.getSendEmailToWho();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public HttpServletRequest getServletRequest() {
        return servletRequest;
    }

    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }
    
    
}
