package com.example.demo.serviceImpl;

import com.example.demo.dto.UserDetailsRequestDTO;
import com.example.demo.dto.UserResponseDetailsDTO;
import com.example.demo.mapper.userDetailsMapper;
import com.example.demo.models.Users;
import com.example.demo.models.user_details;
import com.example.demo.services.UserDetailsService;
import com.example.demo.repository.UserDetailsRepo;
import com.example.demo.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceimpl implements UserDetailsService {
    private final com.example.demo.mapper.userDetailsMapper userDetailsMapper;
    private UserDetailsRepo userDetailsRepo;
    private userDetailsMapper mapper ;
    private UserRepo  userRepo;

    public UserDetailsServiceimpl(UserDetailsRepo userDetailsRepo, UserRepo userRepo , userDetailsMapper mapper, userDetailsMapper userDetailsMapper) {
        this.userDetailsRepo = userDetailsRepo;
        this.userRepo = userRepo;
        this.mapper = mapper;
        this.userDetailsMapper = userDetailsMapper;
    }


    @Transactional
    @Override
    public void createUserDetails(UserDetailsRequestDTO userDetailsRequestDTO) {
        user_details userDetails  = mapper.mapperToEntity(userDetailsRequestDTO);
        userDetailsRepo.save(userDetails);
        Users user = userRepo.findByEmail(userDetailsRequestDTO.getEmail());
        user.setUser_details(userDetails);
        userRepo.save(user);
    }

    @Override
    public List<UserResponseDetailsDTO> retrieveAllUsers() {
        List<user_details> users = userDetailsRepo.findAll();
        List<UserResponseDetailsDTO> userResponseDetailsDTOs = new ArrayList<>();
        for (user_details user : users) {
           UserResponseDetailsDTO userResponseDetailsDTO = userDetailsMapper.entityToDTO(user);
           userResponseDetailsDTOs.add(userResponseDetailsDTO);
        }
        return userResponseDetailsDTOs;
    }
}
