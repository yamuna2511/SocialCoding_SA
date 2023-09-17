package com.sa.socialcoding.sms.assembler;

import com.sa.socialcoding.sms.dto.UserDTO;
import com.sa.socialcoding.sms.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserAssembler {

    public User fromDTOToEntity(UserDTO userDTO){
        User userEntity = new User();
        userEntity.setUserId(userDTO.getUserId());
        userEntity.setUserType(userDTO.getUserType());
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setMiddleName(userDTO.getMiddleName());
        userEntity.setLastName(userDTO.getLastName());

       // LocalDate dob = LocalDate.parse(userDTO.getDob());
      //  userEntity.setDob(dob);

        userEntity.setAddress1(userDTO.getAddress1());
        userEntity.setAddress2(userDTO.getAddress2());
        userEntity.setCity(userDTO.getCity());
        userEntity.setState(userDTO.getState());
        userEntity.setCountry(userDTO.getCountry());
        userEntity.setMobile(userDTO.getMobile());
        userEntity.setMailId(userDTO.getMailId());
        userEntity.setCreatedAt(userDTO.getCreatedAt());
        return userEntity;
    }

    public UserDTO fromEntityToDTO(User userEntity){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userEntity, userDTO);



        return userDTO;
    }
}
