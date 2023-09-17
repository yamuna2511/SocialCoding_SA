package com.sa.socialcoding.sms.repository.impl;


import com.sa.socialcoding.sms.dto.UserDTO;
import com.sa.socialcoding.sms.model.User;
import com.sa.socialcoding.sms.repository.UserCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class UserCustomRepoImpl implements UserCustomRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getUsers(Integer userId, String userType, String firstName) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = builder.createQuery(User.class);
        Root<User> user = cq.from(User.class);
        List<Predicate> predicates = new ArrayList<>();
        if(Objects.nonNull(userId)){
            predicates.add(builder.equal(user.get("userId"), userId));
        }
        if(Objects.nonNull(userType)){
            predicates.add(builder.equal(user.get("userType"), userType));
        }
        if(Objects.nonNull(firstName)){
            predicates.add(builder.equal(user.get("firstName"), firstName));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        TypedQuery<User> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
