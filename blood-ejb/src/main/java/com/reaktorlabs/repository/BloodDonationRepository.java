package com.reaktorlabs.repository;

import com.reaktorlabs.model.BloodDonation;
import java.time.LocalDate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Viki
 */
@Stateless
public class BloodDonationRepository implements BloodDonationRepositoryInterface {
    @PersistenceContext(name = "blood-PU")
    private EntityManager entityManager;

    @Override
    public void create(BloodDonation entity) {
        entityManager.persist(entity);
    }

    @Override
    public BloodDonation read(Long id) {
        return entityManager.find(BloodDonation.class, id);
    }

    @Override
    public List<BloodDonation> readAll() {
        final TypedQuery<BloodDonation> findAllDonations 
                = entityManager.createQuery("SELECT b FROM BloodDonation b", BloodDonation.class);
        return findAllDonations.getResultList();
    }

    @Override
    public List<BloodDonation> readAllDonationsByUserId(Long userId) {
        final TypedQuery<BloodDonation> foundDonations
                = entityManager.createQuery("SELECT b FROM BloodDonation b WHERE b.user.id = :userId", BloodDonation.class);
        foundDonations.setParameter("userId", userId);
        
        return foundDonations.getResultList();
    }

    @Override
    public BloodDonation update(BloodDonation entity) {
        return entityManager.merge(entity);
    }

    @Override
    public BloodDonation updateById(Long id) {
        final BloodDonation donation = read(id);
        if(null != donation) {
            entityManager.merge(donation);
            return donation;
        }
        throw new RuntimeException("Can not find donation with id: " + id);
    }
    
    

    @Override
    public BloodDonation delete(BloodDonation entity) {
        entityManager.remove(entity);
        return entity;
    }

    @Override
    public BloodDonation deleteById(Long id) {
        final BloodDonation donation = read(id);
        if(null != donation) {
            entityManager.remove(donation);
            return donation;
        }
        throw new RuntimeException("Can not find donation with id: " + id);
    }

    @Override
    public Integer countDonations(Long userId) {
        TypedQuery<Long> query = entityManager.createQuery(
            "SELECT COUNT(1) FROM BloodDonation b WHERE b.user = :userId", Long.class);
        query.setParameter("userId", userId);
        if(query.getResultList().size() == 1) {
            Integer donationCount = (int) (long)query.getSingleResult();
            return donationCount;
        } else {
            return 0;
        }
    }

    @Override
    public LocalDate readLastDonationDate(Long userId) {
        TypedQuery<LocalDate> lastDonationDate = entityManager.createQuery(
            "SELECT b.donationDate FROM BloodDonation b WHERE b.user = :userId ORDER BY b.donationDate DESC LIMIT 1", LocalDate.class);
        lastDonationDate.setParameter("userId", userId);
        
        return lastDonationDate.getSingleResult();
    }
    
}
