package com.example.demo.Mapper;

import com.example.demo.DTO.UserDetailsRequestDTO;
import com.example.demo.Model.user_details;
import org.springframework.stereotype.Component;

@Component
public class userDetailsMapper {

    public user_details mapperToEntity(UserDetailsRequestDTO userDetailsRequestDTO) {
        user_details user_details = new user_details();
        user_details.setAddress(userDetailsRequestDTO.getAddress());
        user_details.setDob(userDetailsRequestDTO.getDob());
        user_details.setGender(userDetailsRequestDTO.getGender());
        user_details.setMartial_status(userDetailsRequestDTO.getMartial_status());
        user_details.setPhone(userDetailsRequestDTO.getPhone());
        user_details.setName(userDetailsRequestDTO.getName());
        user_details.setPob(userDetailsRequestDTO.getPob());
        user_details.setMilitary_status(userDetailsRequestDTO.getMilitary_status());
        user_details.setSSN(userDetailsRequestDTO.getSSN());
        return user_details;
    }
}
