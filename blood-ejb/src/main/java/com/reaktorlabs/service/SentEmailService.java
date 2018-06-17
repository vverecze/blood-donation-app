package com.reaktorlabs.service;

import com.reaktorlabs.model.SentEmail;
import com.reaktorlabs.repository.GenericRepository;
import javax.inject.Inject;

/**
 *
 * @author Viki
 */
public class SentEmailService implements SentEmailInterface {
    @Inject
    GenericRepository<Long, SentEmail> sentEmailRepository;

    @Override
    public void createSentEmail(SentEmail entity) {
        sentEmailRepository.create(entity);
    }
    
}
