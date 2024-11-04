package com.example.demo.serviceImpl;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.mapper.adminMapper;
import com.example.demo.mapper.userMapper;
import com.example.demo.models.Users;
import com.example.demo.repository.UserRepo;
import com.example.demo.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class userServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final userMapper userMapper;
    private final adminMapper adminMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

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


}
