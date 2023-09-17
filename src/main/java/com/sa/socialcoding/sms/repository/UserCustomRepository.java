package com.sa.socialcoding.sms.repository;
import com.sa.socialcoding.sms.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserCustomRepository {
    List<User> getUsers(Integer userId, String userType, String firstName);
}
