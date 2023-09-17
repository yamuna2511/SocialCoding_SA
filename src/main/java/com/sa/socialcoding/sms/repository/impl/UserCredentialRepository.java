package com.sa.socialcoding.sms.repository.impl;

import com.sa.socialcoding.sms.model.User;
import com.sa.socialcoding.sms.model.UserCredentials;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserCredentialRepository {

    @Autowired
    private EntityManager entityManager;
    public UserCredentials findByUserName(String userName) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserCredentials> cq = builder.createQuery(UserCredentials.class);
        Root<UserCredentials> userCred = cq.from(UserCredentials.class);
        cq.where(builder.equal(userCred.get("userName"), userName));
        TypedQuery<UserCredentials> query = entityManager.createQuery(cq);
        return query.getResultList().get(0);
    }
}
