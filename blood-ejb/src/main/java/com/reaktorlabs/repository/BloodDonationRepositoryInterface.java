package com.reaktorlabs.repository;

import com.reaktorlabs.model.BloodDonation;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Viki
 */
public interface BloodDonationRepositoryInterface extends GenericRepository<Long, BloodDonation> {
    List<BloodDonation> readAllDonationsByUserId(Long userId);
    Integer countDonations(Long userId);
    LocalDate readLastDonationDate(Long userId);
    BloodDonation updateById(Long id);
}
