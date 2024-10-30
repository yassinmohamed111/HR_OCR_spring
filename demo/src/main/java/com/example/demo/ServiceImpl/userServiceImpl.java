package com.example.demo.ServiceImpl;

import com.example.demo.DTO.UserRequestDTO;
import com.example.demo.Mapper.adminMapper;
import com.example.demo.Mapper.userMapper;
import com.example.demo.Model.Users;
import com.example.demo.Service.UserService;
import com.example.demo.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Users> retriveAllUsers() {
        return userRepo.findAll();
    }
}
