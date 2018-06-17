package com.reaktorlabs.repository;

import com.reaktorlabs.model.SentEmail;
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
public class SentEmailRepository implements GenericRepository<Long, SentEmail> {
    @PersistenceContext(name = "blood-PU")
    private EntityManager entityManager;
    
    @Override
    public void create(SentEmail entity) {
        entityManager.persist(entity);
    }

    @Override
    public SentEmail read(Long id) {
        return entityManager.find(SentEmail.class, id);
    }

    @Override
    public List<SentEmail> readAll() {
        final TypedQuery<SentEmail> findAllEmails 
                = entityManager.createQuery("SELECT s FROM SentEmail s", SentEmail.class);
        return findAllEmails.getResultList();
    }

    @Override
    public SentEmail update(SentEmail entity) {
        return entityManager.merge(entity);
    }

    @Override
    public SentEmail delete(SentEmail entity) {
        entityManager.remove(entity);
        return entity;
    }

    @Override
    public SentEmail deleteById(Long id) {
        final SentEmail sentEmail = read(id);
        if(null != sentEmail) {
            entityManager.remove(sentEmail);
            return sentEmail;
        }
        throw new RuntimeException("Can not find sent email with id: " + id);
    }
    
}
