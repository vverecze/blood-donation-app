package com.reaktorlabs.service;

import com.reaktorlabs.model.BloodDonation;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Viki
 */
public interface BloodDonationInterface {
    BloodDonation getBloodDonationById(Long id);
    List<BloodDonation> getAllBloodDonationsOfUser(Long userId);
    void addBloodDonation(BloodDonation donation);
    BloodDonation updateBloodDonation(BloodDonation donation);
    BloodDonation updateBloodDonationById(Long id);
    BloodDonation deleteBloodDonationById(Long id);
    Integer countBloodDonationsOfUser(Long userId);
    Integer countSavedLifes(Long userId);
    LocalDate getLastDonationDate(Long userId);
    LocalDate nextDonationDate(Long userId);
    Integer daysToNextDonation(Long userId);
}
