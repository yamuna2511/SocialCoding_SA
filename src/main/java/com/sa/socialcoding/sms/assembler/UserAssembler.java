package com.sa.socialcoding.sms.assembler;

import com.sa.socialcoding.sms.dto.UserDTO;
import com.sa.socialcoding.sms.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;
@Slf4j
@Component
public class UserAssembler {

    public User fromDTOToEntity(UserDTO userDTO){
        User userEntity = new User();
        BeanUtils.copyProperties(userDTO, userEntity);
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            java.util.Date date = formatter.parse(userDTO.getDob());
            java.sql.Date dob = new java.sql.Date(date.getTime());
            userEntity.setDob(dob);
        }catch(Exception e){
            log.error("Exception in date conversion", e);
        }
        return userEntity;
    }

    public UserDTO fromEntityToDTO(User userEntity){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userEntity, userDTO);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        userDTO.setDob(formatter.format(userEntity.getDob()));
        return userDTO;
    }
}
