package com.sa.socialcoding.sms.service.impl;

import com.sa.socialcoding.sms.assembler.UserAssembler;
import com.sa.socialcoding.sms.dto.UserDTO;
import com.sa.socialcoding.sms.model.User;
import com.sa.socialcoding.sms.repository.UserRepository;
import com.sa.socialcoding.sms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

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
            UserDTO userDTO = userAssembler.fromEntityToDTO(user);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public String submit(UserDTO userRequest) {
        User user = userAssembler.fromDTOToEntity(userRequest);
        user.setCreatedOn(new Date());
        userRepository.save(user);
        return "submitted successfully";
    }
}
