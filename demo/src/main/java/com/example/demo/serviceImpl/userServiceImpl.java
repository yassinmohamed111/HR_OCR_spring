package com.example.demo.serviceImpl;

import com.example.demo.dto.ChangePasswordDTO;
import com.example.demo.dto.UserDetailsRequestDTO;
import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDetailsDTO;
import com.example.demo.mapper.adminMapper;
import com.example.demo.mapper.userMapper;
import com.example.demo.models.Users;
import com.example.demo.models.user_details;
import com.example.demo.repository.UserDetailsRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

@Service

public class userServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final userMapper userMapper;
    private final adminMapper adminMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserDetailsRepo userDetailsRepo;
    @Autowired
    private com.example.demo.mapper.userDetailsMapper userDetailsMapper;
    @Autowired
    private View error;

    public userServiceImpl(userMapper userMapper, UserRepo userRepo, adminMapper adminMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userMapper = userMapper;
        this.userRepo = userRepo;
        this.adminMapper = adminMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Transactional
    @Override
    public void createUser(UserRequestDTO userRequestDTO) {
        Users users = userMapper.mapperToEntity(userRequestDTO);
        users.setPassword(bCryptPasswordEncoder.encode(userRequestDTO.getPassword()));

        userRepo.save(users);
    }

    public void createAdmin(UserRequestDTO userRequestDTO) {

        Users Users = adminMapper.mapperTOentity(userRequestDTO);
        userRepo.save(Users);
    }

    @Override
    public UserResponseDetailsDTO getUser(String email) {
        Users user = userRepo.findByEmail(email);
        user_details userDetails = user.getUser_details();
        UserResponseDetailsDTO userResponseDetailsDTO =  userDetailsMapper.entityToDTO(userDetails);
        return userResponseDetailsDTO;

    }

    @Override
    public void changePassword(ChangePasswordDTO changePasswordDTO) {
        Users user = userRepo.findById(changePasswordDTO.getUserid())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        if (bCryptPasswordEncoder.matches(changePasswordDTO.getOldPassword(), user.getPassword())) {
            user.setPassword(bCryptPasswordEncoder.encode(changePasswordDTO.getNewPassword()));
            userRepo.save(user);
        } else {
            throw new IllegalArgumentException("Old password is incorrect");
        }
    }



}
