package com.sa.socialcoding.sms.service.impl;

import com.sa.socialcoding.sms.assembler.UserAssembler;
import com.sa.socialcoding.sms.dto.ParentDetailDTO;
import com.sa.socialcoding.sms.dto.UserDTO;
import com.sa.socialcoding.sms.model.ParentDetail;
import com.sa.socialcoding.sms.model.User;
import com.sa.socialcoding.sms.model.UserCredentials;
import com.sa.socialcoding.sms.repository.UserRepository;
import com.sa.socialcoding.sms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAssembler userAssembler;

    @Override
    public List<UserDTO> findAllUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for(User user : users){
            UserDTO userDTO = userAssembler.fromUserEntityToDTO(user);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public String submit(UserDTO userRequest) {
        log.info("Creating new user");
        User user = userAssembler.fromUserDTOToEntity(userRequest);
        user.setCreatedOn(new Date());

        String email = userRequest.getMailId();
        String[] arr = email.split("@");
        //setting user credential
        UserCredentials userCredential = new UserCredentials();
        userCredential.setUserName(arr[0].toUpperCase());
        userCredential.setPassword("abcd");
        userCredential.setUserStatus("NEW");
        userCredential.setUser(user);
        user.setUserCredential(userCredential);

        userRepository.save(user);
        return "Submitted successfully";
    }
}
