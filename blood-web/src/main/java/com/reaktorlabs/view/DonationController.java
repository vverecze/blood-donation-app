package com.reaktorlabs.view;

import com.reaktorlabs.model.BloodDonation;
import com.reaktorlabs.model.User;
import com.reaktorlabs.service.BloodDonationInterface;
import com.reaktorlabs.service.UserDataInterface;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Viki
 */
@RequestScoped
@Named(value = "donationController")
public class DonationController {
    private List<BloodDonation> donations;
    private BloodDonation donation;
    private BloodDonationInterface donationService;
    private UserDataInterface userDataService;
    
    @Inject
    private HttpServletRequest servletRequest;
    
    @Inject
    public DonationController(BloodDonationInterface donationService, UserDataInterface userDataService) {
        this.donations = new ArrayList<>();
        this.donation = new BloodDonation();
        this.donationService = donationService;
        this.userDataService = userDataService;
    }
    
    @PostConstruct
    public void setDonationsAndDonation() {
        this.setDonationsByUserId();
        this.setDonationUserId();
    }
    
    private void setDonationsByUserId() {
        List<BloodDonation> myDonations = donationService.getAllBloodDonationsOfUser(this.getMyUser().getId());
        donations = myDonations;
    }
    
    private void setDonationUserId() {
        donation.setUser(this.getMyUser());
    }
    
    public User getMyUser() {
        User myUser = userDataService.getUserByEmail(this.getUserEmailFromSession());
        HttpSession mySession = servletRequest.getSession();
        mySession.setAttribute("myUser", myUser);
        return myUser;
    }
    
    private String getUserEmailFromSession() {
        HttpSession mySession = servletRequest.getSession();
        return (String)mySession.getAttribute("user_email");
    }
    
    public String updateDonation(BloodDonation myDonation) {
        donationService.updateBloodDonation(myDonation);
        return "/user/donations.xhtml";
    }
    
    public String updateDonationById(Long id) {
        return "/user/donations.xhtml";
    }
    
    public String createDonation() {
        donationService.addBloodDonation(donation);
        return "/user/donations.xhtml?faces-redirect=true";
    }
    
    public String deleteDonation(Long id) {
        donationService.deleteBloodDonationById(id);
        return "/user/donations.xhtml?faces-redirect=true";
    }

    public List<BloodDonation> getDonations() {
        return donations;
    }
    
    private void refreshPage() {
        FacesContext context = FacesContext.getCurrentInstance();
        String viewId = context.getViewRoot().getViewId();
        ViewHandler handler = context.getApplication().getViewHandler();
        UIViewRoot root = handler.createView(context, viewId);
        root.setViewId(viewId);
        context.setViewRoot(root);
    }

    public void setDonations(List<BloodDonation> donations) {
        this.donations = donations;
    }

    public BloodDonationInterface getDonationService() {
        return donationService;
    }

    public void setDonationService(BloodDonationInterface donationService) {
        this.donationService = donationService;
    }

    public UserDataInterface getUserDataService() {
        return userDataService;
    }

    public void setUserDataService(UserDataInterface userDataService) {
        this.userDataService = userDataService;
    }

    public HttpServletRequest getServletRequest() {
        return servletRequest;
    }

    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }

    public BloodDonation getDonation() {
        return donation;
    }

    public void setDonation(BloodDonation donation) {
        this.donation = donation;
    }
    
}
