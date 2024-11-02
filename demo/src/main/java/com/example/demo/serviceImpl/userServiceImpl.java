package com.example.demo.serviceImpl;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.mapper.adminMapper;
import com.example.demo.mapper.userMapper;
import com.example.demo.models.Users;
import com.example.demo.services.UserService;
import com.example.demo.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements UserService {
    UserRepo userRepo;
    userMapper userMapper;
    adminMapper adminMapper;

    public userServiceImpl(userMapper userMapper, UserRepo userRepo , adminMapper adminMapper) {
        this.userMapper = userMapper;
        this.userRepo = userRepo;
        this.adminMapper = adminMapper;
    }

    @Transactional
    @Override
    public void createUser(UserRequestDTO userRequestDTO) {
        Users Users = userMapper.mapperToEntity(userRequestDTO);

        userRepo.save(Users);
    }

    public void createAdmin(UserRequestDTO userRequestDTO) {

        Users Users = adminMapper.mapperTOentity(userRequestDTO);
        userRepo.save(Users);
    }


}
