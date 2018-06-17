package com.reaktorlabs.view;

import com.reaktorlabs.service.ClosestDonationService;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Viki
 */
@RequestScoped
@Named(value = "donationLocationController")
public class DonationLocationController {
    private ClosestDonationService closestDonationService;
    private String resultTable = "";
    private String location;

    public DonationLocationController() {
    }

    @Inject
    public DonationLocationController(ClosestDonationService closestDonationService) {
        this.closestDonationService = closestDonationService;
    }
    
    public String locationsInTable() throws ProtocolException, UnsupportedEncodingException, IOException {
        this.resultTable = closestDonationService.getClosestDonation(location);
        return "/user/closestDonation.xhtml";
    }

    public ClosestDonationService getClosestDonationService() {
        return closestDonationService;
    }

    public void setClosestDonationService(ClosestDonationService closestDonationService) {
        this.closestDonationService = closestDonationService;
    }

    public String getResultTable() {
        return resultTable;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    
}
