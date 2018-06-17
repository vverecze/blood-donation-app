package com.reaktorlabs.service;

import com.reaktorlabs.model.BloodDonation;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import com.reaktorlabs.repository.BloodDonationRepositoryInterface;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Viki
 */
@Stateless
public class BloodDonationService implements BloodDonationInterface {
    @Inject
    private BloodDonationRepositoryInterface repository;

    @Override
    public BloodDonation getBloodDonationById(Long id) {
        return repository.read(id);
    }

    @Override
    public List<BloodDonation> getAllBloodDonationsOfUser(Long userId) {
        return repository.readAllDonationsByUserId(userId);
    }

    @Override
    public void addBloodDonation(BloodDonation donation) {
        repository.create(donation);
    }

    @Override
    public BloodDonation updateBloodDonation(BloodDonation donation) {
        return repository.update(donation);
    }

    @Override
    public BloodDonation updateBloodDonationById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BloodDonation deleteBloodDonationById(Long id) {
        return repository.deleteById(id);
    }

    @Override
    public Integer countBloodDonationsOfUser(Long userId) {
        return repository.countDonations(userId);
    }

    @Override
    public Integer countSavedLifes(Long userId) {
        return this.countBloodDonationsOfUser(userId) * 3;
    }

    @Override
    public LocalDate getLastDonationDate(Long userId) {
        return repository.readLastDonationDate(userId);
    }

    @Override
    public LocalDate nextDonationDate(Long userId) {
        return this.getLastDonationDate(userId).plus(Period.ofDays(56));
    }

    @Override
    public Integer daysToNextDonation(Long userId) {
        return Period.between(this.getLastDonationDate(userId), this.nextDonationDate(userId)).getDays();
    }
    
}
