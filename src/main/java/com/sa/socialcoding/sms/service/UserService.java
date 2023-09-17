package com.sa.socialcoding.sms.service;

import com.sa.socialcoding.sms.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAllUsers();

    String submit(UserDTO userRequest);
}
